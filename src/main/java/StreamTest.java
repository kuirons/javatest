import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author WuGYu
 * @date 2018/2/2 20:19
 */
public class StreamTest {
  // filter
  public static void filterTest(List<Apple> appleList, Predicate<Apple> p) {
    appleList.stream().filter(p).map(Apple::getAppleName).forEach(System.out::println);
  }

  public static void main(String[] args) {
    List<Apple> testList = new ArrayList<>();
    testList.add(new Apple("red", 400, "FirstApple"));
    testList.add(new Apple("red", 600, "SecondApple"));
    testList.add(new Apple("green", 400, "ThirdApple"));
    testList.add(new Apple("green", 600, "FourthApple"));
    // filter过滤出重量大于500的苹果
    StreamTest.filterTest(testList, a -> a.getWeight() > 500);
  }
}
