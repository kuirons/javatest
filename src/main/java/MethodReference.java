import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author WuGYu
 * @date 2018/2/2 11:16
 */
public class MethodReference {
  public static void consumerMR(List<String> sl, Consumer<String> c) {
    for (String s : sl) {
      c.accept(s);
    }
  }

  public static void main(String[] args) {
    MethodReference.consumerMR(Arrays.asList("test", "string"), System.out::print);
  }
}
