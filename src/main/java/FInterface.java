import java.util.function.Predicate;

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

  public static void main(String[] args) {
    System.out.println(
        FInterface.predicateTest(
            5, ((Predicate<Integer>) integer -> integer > 3).and(integer -> integer < 5)));
  }
}
