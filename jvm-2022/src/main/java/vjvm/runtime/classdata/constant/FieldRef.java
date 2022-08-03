package vjvm.runtime.classdata.constant;

import lombok.Getter;
import lombok.SneakyThrows;
import vjvm.runtime.JClass;

import java.io.DataInput;

public class FieldRef extends Constant{
  @Getter
  private final JClass self;
  private final int nameIndex;
  private final int nameAndTypeIndex;

  private String classname;
  private String matename;
  private String nameAndType;

  @SneakyThrows
  FieldRef(DataInput input, JClass self){
    nameIndex = input.readUnsignedShort();
    nameAndTypeIndex = input.readUnsignedShort();
    this.self = self;
  }

  public String classname() {
    if (classname == null) {
      int tmp = ((ClassRef) self.constantPool().constant(nameIndex)).nameIndex();
      classname = ((UTF8Constant)self.constantPool().constant(tmp)).value();
    }
    return classname;
  }

  public String matename(){
    if(matename == null){
      matename = ((NameAndTypeConstant) self.constantPool().constant(nameAndTypeIndex)).name();
    }
    return matename;
  }
  public String nameAndType() {
    if (nameAndType == null) {
      nameAndType = ((NameAndTypeConstant) self.constantPool().constant(nameAndTypeIndex)).type();
    }
    return nameAndType;
  }

  public String toString(){
    return String.format("Fieldref: %s.%s.%s",classname(),matename(),nameAndType());
  }
}
