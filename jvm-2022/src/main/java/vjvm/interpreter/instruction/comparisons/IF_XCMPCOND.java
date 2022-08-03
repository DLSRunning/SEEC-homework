package vjvm.interpreter.instruction.comparisons;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.var;
import vjvm.interpreter.instruction.Instruction;
import vjvm.runtime.JThread;
import vjvm.runtime.ProgramCounter;
import vjvm.runtime.classdata.MethodInfo;

import java.util.Objects;
import java.util.function.BiFunction;

@AllArgsConstructor(access = AccessLevel.PRIVATE)

public class IF_XCMPCOND extends Instruction {
  private final String name;
  private final BiFunction<Integer, Integer, Boolean> comFunc;
  private final int offset;

  public static IF_XCMPCOND IF_ACMPEQ(ProgramCounter pc, MethodInfo method){
    return new IF_XCMPCOND("if_acmpeq", (x, y) -> x.intValue() == y.intValue(), pc.short_() - 3);
  }

  public static IF_XCMPCOND IF_ACMPNE(ProgramCounter pc, MethodInfo method){
    return new IF_XCMPCOND("if_acmpne",(x, y) -> x.intValue() != y.intValue(), pc.short_() - 3);
  }

  public static IF_XCMPCOND IF_ICMPEQ(ProgramCounter pc, MethodInfo method){
    return new IF_XCMPCOND("if_icmpeq", (x, y) -> x.intValue() == y.intValue(), pc.short_() - 3);
  }

  public static IF_XCMPCOND IF_ICMPNE(ProgramCounter pc, MethodInfo method){
    return new IF_XCMPCOND("if_icmpne",(x, y) -> x.intValue() != y.intValue(), pc.short_() - 3);
  }

  public static IF_XCMPCOND IF_ICMPLT(ProgramCounter pc, MethodInfo method){
    return new IF_XCMPCOND("if_icmplt",(x, y) -> x < y, pc.short_() - 3);
  }

  public static IF_XCMPCOND IF_ICMPLE(ProgramCounter pc, MethodInfo method){
    return new IF_XCMPCOND("if_icmple",(x, y) -> x <= y, pc.short_() - 3);
  }

  public static IF_XCMPCOND IF_ICMPGE(ProgramCounter pc, MethodInfo method){
    return new IF_XCMPCOND("if_icmpge",(x, y) -> x >= y, pc.short_() - 3);
  }

  public static IF_XCMPCOND IF_ICMPGT(ProgramCounter pc, MethodInfo method){
    return new IF_XCMPCOND("if_icmpgt",(x, y) -> x > y, pc.short_() - 3);
  }


  @Override
  public void run(JThread thread){
    var stack = thread.top().stack();
    var left = stack.popInt();
    var right = stack.popInt();
    var pc = thread.pc();
    if (comFunc.apply(right,left)){
      pc.move(offset);
    }
  }

  @Override
  public String toString(){
    return name;
  }
}
