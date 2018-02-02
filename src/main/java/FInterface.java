import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author WuGYu
 * @date 2018/2/1 16:06
 */
public class FInterface {
  // Predicate
  public static <T> String predicateTest(T t, Predicate<T> p) {
    if (p.test(t)) return "yes";
    return "no";
  }

  // Consumer
  public static <T> void consumerTest(List<T> listT, Consumer<T> c) {
    for (T t : listT) {
      c.accept(t);
    }
  }

  // Function
  public static <T, R> R functionTest(T t, Function<T, R> f) {
    return f.apply(t);
  }

  // Supplier
  public static <T> T supplierTest(Supplier<T> s) {
    return s.get();
  }

  public static void main(String[] args) {
    System.out.println(
        FInterface.predicateTest(
            5, ((Predicate<Integer>) integer -> integer > 3).and(integer -> integer < 5)));
    FInterface.consumerTest(Arrays.asList(1, 2, 3, 4), integer -> System.out.println(integer));
    // 银魂废材王子的叫声~~~~~
    System.out.println(FInterface.functionTest("啊~~~~~", (String s) -> s + "哦~~~~~~"));
    System.out.println(FInterface.supplierTest(() -> "test"));
  }
}
