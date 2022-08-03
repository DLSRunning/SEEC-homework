package vjvm.runtime.classdata.constant;
import lombok.var;
import lombok.SneakyThrows;

import java.io.DataInput;
import java.io.IOException;
public class FloatConstant extends Constant{
  private final float value;
  @SneakyThrows
  FloatConstant(DataInput input) throws IOException {
    value = input.readFloat();
  }

  public Float value(){
    return value;
  }
  @Override
  public String toString(){
    return String.format("Float: %a", value);
  }
}
