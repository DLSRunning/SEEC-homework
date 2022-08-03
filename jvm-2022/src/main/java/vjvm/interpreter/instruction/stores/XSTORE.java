package vjvm.interpreter.instruction.stores;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.var;
import vjvm.interpreter.instruction.Instruction;
import vjvm.runtime.JThread;
import vjvm.runtime.ProgramCounter;
import vjvm.runtime.classdata.MethodInfo;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class XSTORE extends Instruction {
  private final int index;
  private final String name;

  public static XSTORE ISTORE(ProgramCounter pc, MethodInfo method){
    return new XSTORE(pc.ubyte(), "istore");
  }

  public static XSTORE ISTORE_0(ProgramCounter pc, MethodInfo method){
    return new XSTORE(0, "istore");
  }

  public static XSTORE ISTORE_1(ProgramCounter pc, MethodInfo method){
    return new XSTORE(1, "istore");
  }

  public static XSTORE ISTORE_2(ProgramCounter pc, MethodInfo method){
    return new XSTORE(2, "istore");
  }

  public static XSTORE ISTORE_3(ProgramCounter pc, MethodInfo method){
    return new XSTORE(3, "istore");
  }

  public static XSTORE LSTORE(ProgramCounter pc, MethodInfo method){
    return new XSTORE(pc.ubyte(), "lstore");
  }

  public static XSTORE LSTORE_0(ProgramCounter pc, MethodInfo method){
    return new XSTORE(0, "lstore");
  }

  public static XSTORE LSTORE_1(ProgramCounter pc, MethodInfo method){
    return new XSTORE(1, "lstore");
  }

  public static XSTORE LSTORE_2(ProgramCounter pc, MethodInfo method){
    return new XSTORE(2, "lstore");
  }

  public static XSTORE LSTORE_3(ProgramCounter pc, MethodInfo method){
    return new XSTORE(3, "lstore");
  }

  public static XSTORE FSTORE(ProgramCounter pc, MethodInfo method){
    return new XSTORE(pc.ubyte(), "fstore");
  }

  public static XSTORE FSTORE_0(ProgramCounter pc, MethodInfo method){
    return new XSTORE(0, "fstore");
  }

  public static XSTORE FSTORE_1(ProgramCounter pc, MethodInfo method){
    return new XSTORE(1, "fstore");
  }

  public static XSTORE FSTORE_2(ProgramCounter pc, MethodInfo method){
    return new XSTORE(2, "fstore");
  }

  public static XSTORE FSTORE_3(ProgramCounter pc, MethodInfo method){
    return new XSTORE(3,"fstore");
  }

  public static XSTORE DSTORE(ProgramCounter pc, MethodInfo method){
    return new XSTORE(pc.ubyte(), "dstore");
  }

  public static XSTORE DSTORE_0(ProgramCounter pc, MethodInfo method){
    return new XSTORE(0, "dstore");
  }

  public static XSTORE DSTORE_1(ProgramCounter pc, MethodInfo method){
    return new XSTORE(1, "dstore");
  }

  public static XSTORE DSTORE_2(ProgramCounter pc, MethodInfo method){
    return new XSTORE(2, "dstore");
  }

  public static XSTORE DSTORE_3(ProgramCounter pc, MethodInfo method){
    return new XSTORE(3, "dstore");
  }

  @Override
  public void run(JThread thread){
    var stack = thread.top().stack();
    var var = thread.top().vars();
    if(name.charAt(0) == 'i'){
      var.int_(index, stack.popInt());
    }
    else if(name.charAt(0) == 'l'){
      var.long_(index,stack.popLong());
    }
    else if(name.charAt(0) == 'f'){
      var.float_(index,stack.popFloat());
    }
    else if(name.charAt(0) == 'd'){
      var.double_(index,stack.popDouble());
    }
  }

  @Override
  public String toString(){
    return name;
  }



}
