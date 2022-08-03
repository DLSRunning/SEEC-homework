## Constant.java 
```Java
      case CONSTANT_Long:
        result = new UnknownConstant(input, 8);
        count = 2;
        break;
```
## ClassSearchPath.java 
```Java
  public static ClassSearchPath[] constructSearchPath(String path) {
    String sep = System.getProperty("path.separator");
    return Arrays.stream(path.split(sep)).map(searchPath -> {
      if (searchPath.endsWith(".jar") || searchPath.endsWith(".JAR"))
        return new JarSearchPath(searchPath);
      return new DirSearchPath(searchPath);
    }).toArray(ClassSearchPath[]::new);
  }
```
## JClass.java 
```Java
    fields = null;
    methods = null;
    attributes = null;
//    throw new UnimplementedError(
//        "TODO: you need to construct thisClass, superClass, interfaces, fields, "
//        + "methods, and attributes from dataInput in lab 1.2; remove this for lab 1.1");
```

## JClassLoader.java 
```Java
 public JClass loadClass(String descriptor) {
    // ordinary class
    assert descriptor.charAt(descriptor.length() - 1) == ';';

    // find in parent first
    JClass jClass;
    if (parent != null
      && (jClass = parent.loadClass(descriptor)) != null) {
      return jClass;
    }

    // find in loaded classes
    if ((jClass = definedClass.get(descriptor)) != null)
      return jClass;

    // not loaded
    var name = descriptor.substring(1, descriptor.length() - 1);
    for (var p : searchPaths) {
      var iStream = p.findClass(name);
      // if the class was found
      if (iStream != null)
        return defineNonarrayClass(descriptor, iStream);
    }

    return null;
```

## Main.java 
```Java

private void dump(JClass clazz) {
//    throw new UnimplementedError("TODO: dump clazz in lab 1.2; remove this for 1.1");
  }
```

## DirSearchPath.java 
```Java

package vjvm.classloader.searchpath;

import lombok.var;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class DirSearchPath extends ClassSearchPath {
  private final Path searchPath;

  public DirSearchPath(String path) {
    searchPath = FileSystems.getDefault().getPath(path);
    assert !searchPath.toFile().exists() || searchPath.toFile().isDirectory();
  }

  @Override
  public InputStream findClass(String name) {
    try {
      return new FileInputStream(searchPath.resolve(name + ".class").toFile());
    } catch (FileNotFoundException e) {
      return null;
    }
  }

  @Override
  public void close() {
    // there is nothing to close
  }

}

```

## JarSearchPath.java 
```Java

package vjvm.classloader.searchpath;

import lombok.var;
import lombok.SneakyThrows;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.jar.JarFile;

public class JarSearchPath extends ClassSearchPath {
  // might be null if the file doesn't exist.
  private JarFile file;

  @SneakyThrows
  public JarSearchPath(String name) {
    try {
      file = new JarFile(name);
    } catch (FileNotFoundException e) {
      file = null;
    }
  }

  @Override
  @SneakyThrows
  public InputStream findClass(String name) {
    if (file == null)
      return null;

    var entry = file.getEntry(name + ".class");
    return entry == null ? null : file.getInputStream(entry);
  }

  @Override
  @SneakyThrows
  public void close() {
    if (file != null)
      file.close();
  }

}


```
