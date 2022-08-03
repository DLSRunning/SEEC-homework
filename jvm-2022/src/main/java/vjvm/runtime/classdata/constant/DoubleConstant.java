package vjvm.runtime.classdata.constant;

import lombok.var;
import lombok.SneakyThrows;

import java.io.DataInput;
import java.io.IOException;

public class DoubleConstant extends Constant {
  private final double value;
  @SneakyThrows
  DoubleConstant(DataInput input) throws IOException {
    value = input.readDouble();
  }

  public Double value(){
    return value;
  }
  @Override
  public String toString(){
    return String.format("Double: %a", value);
  }
}
