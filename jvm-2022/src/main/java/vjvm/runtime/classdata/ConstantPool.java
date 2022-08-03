package vjvm.runtime.classdata;

import lombok.var;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import vjvm.runtime.JClass;
import vjvm.runtime.classdata.constant.Constant;

import java.io.DataInput;

public class ConstantPool {
  private final Constant[] constants;
  @Getter
  @Setter
  private JClass jClass;

  @SneakyThrows
  public ConstantPool(DataInput dataInput, JClass jClass) {
    this.jClass = jClass;
    var count = dataInput.readUnsignedShort();
    constants = new Constant[count];
    for (int i = 1; i < count; ) {
      var r = Constant.constructFromData(dataInput, jClass);
      constants[i] = r.getLeft();
      i += r.getRight();
    }
  }

  public Constant constant(int index) {
    return constants[index];
  }

  public void constant(int index, Constant constant) {
    constants[index] = constant;
  }

  public int size() {
    return constants.length;
  }
}
