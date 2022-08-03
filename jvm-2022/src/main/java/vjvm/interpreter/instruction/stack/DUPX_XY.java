package vjvm.interpreter.instruction.stack;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.var;
import vjvm.interpreter.instruction.Instruction;
import vjvm.runtime.JThread;
import vjvm.runtime.ProgramCounter;
import vjvm.runtime.classdata.MethodInfo;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class DUPX_XY extends Instruction{
  private final int right;
  private final int left;
  private final String name;

  public static DUPX_XY DUP_X1(ProgramCounter pc, MethodInfo method){
    return new DUPX_XY(1,1,"dup_x1");
  }

  public static DUPX_XY DUP_X2(ProgramCounter pc, MethodInfo method){
    return new DUPX_XY(1,2,"dup_x2");
  }

  public static DUPX_XY DUP2_X1(ProgramCounter pc, MethodInfo method){
    return new DUPX_XY(2,1,"dup2_x1");
  }

  public static DUPX_XY DUP2_X2(ProgramCounter pc, MethodInfo method){
    return new DUPX_XY(2,2,"dup2_x2");
  }

  @Override
  public void run(JThread thread){
    var stack = thread.top().stack();
    var s1 = stack.popSlots(right);
    var s2 = stack.popSlots(left);
    stack.pushSlots(s1);
    stack.pushSlots(s2);
    stack.pushSlots(s1);
  }

  @Override
  public String toString(){
    return name;
  }
}
