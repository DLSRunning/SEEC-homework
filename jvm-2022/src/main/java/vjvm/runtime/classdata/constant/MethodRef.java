package vjvm.runtime.classdata.constant;

import lombok.Getter;
import lombok.SneakyThrows;
import vjvm.runtime.JClass;
import vjvm.runtime.classdata.MethodInfo;

import java.io.DataInput;

public class MethodRef extends Constant{
  @Getter
  private final JClass self;
  private final int classIndex;
  private final int nameAndTypeIndex;

  private final boolean judge;

  private ClassRef classRef;

  private NameAndTypeConstant nameAndType;

  private MethodInfo method;

  @SneakyThrows
  MethodRef(DataInput input, JClass self, boolean judge){
    classIndex = input.readUnsignedShort();
    nameAndTypeIndex = input.readUnsignedShort();
    this.self = self;
    this.judge = judge;
  }

  public JClass jClass(){return classRef().value();}

  private ClassRef classRef(){
    if (classRef == null){
      classRef = (ClassRef) self.constantPool().constant(classIndex);
    }
    return classRef;
  }

  private NameAndTypeConstant nameAndType(){
    if (nameAndType == null){
      nameAndType = (NameAndTypeConstant) self.constantPool().constant(nameAndTypeIndex);
    }
    return nameAndType;
  }

  public MethodInfo value(){
    if ((method != null)){
      return method;
    }
    method = jClass().findMethod(nameAndType().name(),nameAndType().type());
    return method;
  }

  public String toString() {
    if (judge) {
      return String.format("InterfaceMethodref: %s.%s.%s", classRef().name(), nameAndType().name(), nameAndType().type());
    }
    return String.format("Methodref: %s.%s.%s",classRef().name(), nameAndType().name(), nameAndType().type());
  }

}
