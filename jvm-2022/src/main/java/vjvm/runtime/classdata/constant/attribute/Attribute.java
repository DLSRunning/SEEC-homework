package vjvm.runtime.classdata.constant.attribute;

import lombok.var;
import lombok.SneakyThrows;
import vjvm.runtime.classdata.ConstantPool;
import vjvm.runtime.classdata.constant.UTF8Constant;

import java.io.DataInput;

public abstract class Attribute {

  @SneakyThrows
  public static Attribute constructFromData(DataInput input, ConstantPool constantPool) {
    var nameIndex = input.readUnsignedShort();
    String name = ((UTF8Constant) constantPool.constant(nameIndex)).value();
    var attrLength = Integer.toUnsignedLong(input.readInt());

    switch (name){
      case "Code":
        return new Code(input, constantPool);
      default:
        return new UnknownAttribute(input, attrLength);
    }
  }
}
