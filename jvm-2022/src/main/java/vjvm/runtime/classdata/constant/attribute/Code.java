package vjvm.runtime.classdata.constant.attribute;

import lombok.Getter;
import lombok.SneakyThrows;
import vjvm.runtime.classdata.ConstantPool;

import java.io.DataInput;

@Getter
public class Code extends Attribute {
  private final int maxStack;
  private final int maxLocals;
  private final byte[] code; // the bytecode represented as raw bytes
  private final Attribute[] attributes;

  @SneakyThrows
  Code(DataInput input, ConstantPool constantPool) {
    maxStack = input.readUnsignedShort();
    maxLocals = input.readUnsignedShort();

    int codeLength = input.readInt();
    code = new byte[codeLength];
    input.readFully(code);

    int exceptionTableLength = input.readUnsignedShort();
    byte[] ignore = new byte[8];
    for (int i = 0;i < exceptionTableLength;i++){
      input.readFully(ignore);
    }

    int attributeCount = input.readUnsignedShort();
    attributes = new Attribute[attributeCount];
    for (int i = 0;i < attributeCount;i++){
      attributes[i] = constructFromData(input,constantPool);
    }

  }
}
