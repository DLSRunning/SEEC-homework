package vjvm.interpreter.instruction.stack;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.var;
import vjvm.interpreter.instruction.Instruction;
import vjvm.runtime.JThread;
import vjvm.runtime.ProgramCounter;
import vjvm.runtime.classdata.MethodInfo;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class POPX extends Instruction {
  private final int right;
  private final String name;

  public static POPX POP(ProgramCounter pc,MethodInfo method){
    return new POPX(1,"pop");
  }

  public static POPX POP2(ProgramCounter pc, MethodInfo method){
    return new POPX(2,"pop2");
  }

  @Override
  public void run(JThread thread){
    var stack = thread.top().stack();
    stack.popSlots(right);
  }

  @Override
  public String toString(){
    return name;
  }
}
