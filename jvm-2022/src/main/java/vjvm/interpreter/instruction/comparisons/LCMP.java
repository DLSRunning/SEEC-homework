package vjvm.interpreter.instruction.comparisons;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.var;
import vjvm.interpreter.instruction.Instruction;
import vjvm.runtime.JThread;
import vjvm.runtime.ProgramCounter;
import vjvm.runtime.classdata.MethodInfo;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class LCMP extends Instruction{


  public LCMP(ProgramCounter pc, MethodInfo method){
  }

  @Override
  public void run(JThread thread){
    var stack = thread.top().stack();
    var right = stack.popLong();
    var left = stack.popLong();
    var res = 0;
    if(right > left){
      res = -1;
    }
    else if(right < left){
      res = 1;
    }
    stack.pushInt(res);
  }

  @Override
  public String toString(){
    return "lcmp";
  }
}
