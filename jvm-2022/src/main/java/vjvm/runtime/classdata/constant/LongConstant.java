package vjvm.runtime.classdata.constant;

import lombok.var;
import lombok.SneakyThrows;

import java.io.DataInput;
import java.io.IOException;

public class LongConstant extends Constant{
  private final long value;
@SneakyThrows
  LongConstant(DataInput input) throws IOException{
    value = input.readLong();
  }

  public Long value(){
    return value;
  }
@Override
  public String toString(){
    return String.format("Long: %d", value);
  }
}
