package vjvm.classloader;

import lombok.var;
import lombok.Getter;
import lombok.SneakyThrows;
import vjvm.classloader.searchpath.ClassSearchPath;
import vjvm.runtime.JClass;
import vjvm.vm.VMContext;
import java.io.Closeable;
import java.io.DataInputStream;
import java.util.HashMap;

public class JClassLoader implements Closeable {
  private final JClassLoader parent;
  private final ClassSearchPath[] searchPaths;
  private final HashMap<String, JClass> definedClass = new HashMap<>();
  @Getter
  private final VMContext context;

  public JClassLoader(JClassLoader parent, ClassSearchPath[] searchPaths, VMContext context) {
    this.context = context;
    this.parent = parent;
    this.searchPaths = searchPaths;
  }


  public JClass loadClass(String descriptor) {
    assert descriptor.charAt(descriptor.length() - 1) == ';';

    if(definedClass.get(descriptor) != null){
      return definedClass.get(descriptor);
    } else if (parent != null && parent.loadClass(descriptor) != null) {
      return parent.loadClass(descriptor);
    }

    var name = descriptor.substring(1, descriptor.length() - 1);

    for (var son : searchPaths){
      var test = son.findClass(name);

      if(test != null){
        var ret = new JClass(new DataInputStream(test), this);
        definedClass.put(descriptor, ret);
        return ret;
      }
    }

    return null;

  }

  @Override
  @SneakyThrows
  public void close() {
    for (var s : searchPaths)
      s.close();
  }
}
