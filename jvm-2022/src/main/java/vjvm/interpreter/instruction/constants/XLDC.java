package vjvm.interpreter.instruction.constants;

import lombok.AccessLevel;
import lombok.var;
import vjvm.interpreter.instruction.Instruction;
import vjvm.runtime.JThread;
import lombok.AllArgsConstructor;
import vjvm.runtime.ProgramCounter;
import vjvm.runtime.classdata.ConstantPool;
import vjvm.runtime.classdata.MethodInfo;
import vjvm.runtime.classdata.constant.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class XLDC extends Instruction {
  private final int idx;
  private final String value;
  private final ConstantPool cp;

  public static XLDC LDC(ProgramCounter pc, MethodInfo method) {
    return new XLDC(pc.ubyte(), "ldc",method.jClass().constantPool());
  }

  public static XLDC LDC_W(ProgramCounter pc, MethodInfo method) {
    var right = pc.ubyte();
    var left = pc.ubyte();
    return new XLDC((right << 8) | left,"ldc_w",method.jClass().constantPool());
  }

  public static XLDC LDC2_W(ProgramCounter pc, MethodInfo method){
    int right = pc.ubyte();
    int left = pc.ubyte();
    return new XLDC((right << 8) | left,"ldc2_w",method.jClass().constantPool());
  }


  @Override
  public void run(JThread thread) {
    var stack = thread.top().stack();
    if(cp.constant(idx) instanceof IntegerConstant){
      stack.pushInt(((IntegerConstant) cp.constant(idx)).value());
    }
    else if(cp.constant(idx) instanceof FloatConstant){
      stack.pushFloat(((FloatConstant) cp.constant(idx)).value());
    }
    else if(cp.constant(idx) instanceof LongConstant){
      stack.pushLong(((LongConstant) cp.constant(idx)).value());
    }
    else if(cp.constant(idx) instanceof DoubleConstant){
      stack.pushDouble(((DoubleConstant) cp.constant(idx)).value());
    }
  }

  @Override
  public String toString() {
    return value;
  }
}
