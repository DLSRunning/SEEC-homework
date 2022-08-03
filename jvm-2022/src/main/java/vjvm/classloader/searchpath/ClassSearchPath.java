package vjvm.classloader.searchpath;

import java.io.*;
import java.util.Arrays;
import lombok.var;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import lombok.SneakyThrows;
import java.util.jar.JarFile;
/**
 * Represents a path to search class files in.
 * A search path may hold resources, such as jar files, so it must implement the Closeable interface.
 * If a subclass doesn't hold any resources, then just do nothing.
 */
public abstract class ClassSearchPath implements Closeable {
  /**
   * Construct search path objects with a given path.
   */



  public static ClassSearchPath[] constructSearchPath(String path) {
    String sep = System.getProperty("path.separator");
    return Arrays.stream(path.split(sep)).map(searchPath -> {
      if (searchPath.endsWith(".jar") || searchPath.endsWith(".JAR"))
        return new JarSearchPath(searchPath);
      return new DirSearchPath(searchPath);
    }).toArray(ClassSearchPath[]::new);

  }

  /**
   * Find a class with specified name.
   *
   * @param name name of the class to find.
   * @return Returns a stream containing the binary data if such class is found, or null if not.
   */
  public abstract InputStream findClass(String name);
}
class JarSearchPath extends ClassSearchPath {
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

class DirSearchPath extends ClassSearchPath {
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
