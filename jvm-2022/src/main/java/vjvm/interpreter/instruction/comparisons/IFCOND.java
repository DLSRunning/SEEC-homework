package vjvm.interpreter.instruction.comparisons;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.var;
import vjvm.interpreter.instruction.Instruction;
import vjvm.runtime.JThread;
import vjvm.runtime.ProgramCounter;
import vjvm.runtime.classdata.MethodInfo;

import java.util.function.Function;

@AllArgsConstructor(access = AccessLevel.PRIVATE)

public class IFCOND extends Instruction {
  private final int offset;
  private final String name;
  private final Function<Integer, Boolean> conFunc;

  public static IFCOND IFEQ(ProgramCounter pc, MethodInfo method){
    return new IFCOND(pc.short_() - 3,"ifeq",x -> x == 0);
  }

  public static IFCOND IFNE(ProgramCounter pc, MethodInfo method){
    return new IFCOND(pc.short_() - 3,"ifne",x -> x != 0);
  }

  public static IFCOND IFLT(ProgramCounter pc, MethodInfo method){
    return new IFCOND(pc.short_() - 3,"iflt",x -> x < 0);
  }

  public static IFCOND IFLE(ProgramCounter pc, MethodInfo method){
    return new IFCOND(pc.short_() - 3,"ifle",x -> x <= 0);
  }

  public static IFCOND IFGT(ProgramCounter pc, MethodInfo method){
    return new IFCOND(pc.short_() - 3,"ifgt",x -> x > 0);
  }

  public static IFCOND IFGE(ProgramCounter pc, MethodInfo method){
    return new IFCOND(pc.short_() - 3,"ifge",x -> x >= 0);
  }

  @Override
  public void run(JThread thread){
    var stack = thread.top().stack();
    var right = stack.popInt();
    if(conFunc.apply(right)){
      thread.pc().move(offset);
    }
  }

  @Override
  public String toString(){
    return name;
  }
}
