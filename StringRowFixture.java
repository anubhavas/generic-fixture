import java.lang.reflect.Array;

import fit.Fixture;

public class StringRowFixture extends fit.RowFixture {
  @Override
  public Object[] query() throws Exception {
    String[] args = getArgs();
    if (args == null || args.length == 0)
      return null;
    Object val = Fixture.getSymbol(args[0]);
    if (val == null || !val.getClass().isArray())
      return null;

    int length = Array.getLength(val);
    Object[] obj = new Object[length];
    for (int i=0; i<length; i++)
      obj[i] = Array.get(val, i);
    return obj;
  }

  @Override
  public Class<?> getTargetClass() {
    return Object.class;
  }
}
