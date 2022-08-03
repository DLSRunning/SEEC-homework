package vjvm.interpreter.instruction.constants;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.var;
import vjvm.interpreter.instruction.Instruction;
import vjvm.runtime.JThread;
import vjvm.runtime.ProgramCounter;
import vjvm.runtime.classdata.MethodInfo;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class NOP extends Instruction{
  public NOP (ProgramCounter pc, MethodInfo method){
  }

  @Override
  public void run(JThread thread){

  }

  @Override
  public String toString(){
    return "NOP";
  }
}
