import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author WuGYu
 * @date 2018/2/2 20:19
 */
public class StreamTest {
  // filter
  public static void filterTest(List<Apple> appleList, Predicate<Apple> p) {
    appleList.stream().filter(p).map(Apple::getAppleName).forEach(System.out::println);
  }
  // limit
  public static void limitTest(List<Apple> apples) {
    apples.stream().limit(2).map(Apple::getAppleName).forEach(System.out::println);
  }
  // skip
  public static void skipTest(List<Apple> apples) {
    apples.stream().skip(2).map(Apple::getAppleName).forEach(System.out::println);
  }
  // allMatch
  public static void allMatchTest(List<Apple> apples, Predicate<Apple> p) {
    boolean flag = apples.stream().allMatch(p);
    System.out.println(flag);
  }
  // noneMatch
  public static void noneMatchTest(List<Apple> apples, Predicate<Apple> p) {
    boolean flag = apples.stream().noneMatch(p);
    System.out.println(flag);
  }
  // anyMatch
  public static void anyMatchTest(List<Apple> apples, Predicate<Apple> p) {
    boolean flag = apples.stream().anyMatch(p);
    System.out.println(flag);
  }
  // findAny
  public static void findAnyTest(List<Apple> apples, Predicate<Apple> p) {
    Optional<Apple> optional = apples.stream().filter(p).findAny();
    try {
      System.out.println(optional.get().getAppleName());
    } catch (NoSuchElementException e) {
      System.out.println("can not find");
    }
  }
  // findFirst
  public static void findFirstTest(List<Apple> apples, Predicate<Apple> p) {
    Optional<Apple> optional = apples.stream().filter(p).findFirst();
    try {
      System.out.println(optional.get().getAppleName());
    } catch (NoSuchElementException e) {
      System.out.println("can not find");
    }
  }
  // reduce
  public static void reduceTest(List<Apple> apples, BinaryOperator<Integer> binaryOperator) {
    Integer i = apples.stream().map(Apple::getWeight).reduce(0, binaryOperator);
    System.out.println(i);
  }
  // IntStream
  public static void intStreamTest(List<Apple> apples) {
    OptionalDouble result = apples.stream().mapToInt(Apple::getWeight).average();
    System.out.println(result.orElse(0));
  }
  // summary
  public static void summaryTest(List<Apple> apples) {
    IntSummaryStatistics result =
        apples.stream().collect(Collectors.summarizingInt(Apple::getWeight));
    System.out.println(result);
  }
  // join
  public static void joinTest(List<Apple> apples) {
    String result = apples.stream().map(Apple::getAppleName).collect(Collectors.joining(" "));
    System.out.println(result);
  }
  // groupBy
  public static void groupByTest(List<Apple> apples) {
    Map<Integer, Map<String, List<String>>> result =
        apples
            .stream()
            .collect(
                Collectors.groupingBy(
                    Apple::getWeight,
                    Collectors.groupingBy(
                        Apple::getColor,
                        Collectors.mapping(Apple::getAppleName, Collectors.toList()))));
    System.out.println(result);
  }

  public static void main(String[] args) {
    List<Apple> testList = new ArrayList<>();
    testList.add(new Apple("red", 400, "FirstApple"));
    testList.add(new Apple("red", 600, "SecondApple"));
    testList.add(new Apple("green", 400, "ThirdApple"));
    testList.add(new Apple("green", 600, "FourthApple"));
    // filter过滤出重量大于500的苹果
    StreamTest.filterTest(testList, a -> a.getWeight() > 500);
    // limit获取前两个苹果的信息
    StreamTest.limitTest(testList);
    // skip前两个苹果
    StreamTest.skipTest(testList);
    // 验证所有苹果重量是否都大于300
    StreamTest.allMatchTest(testList, a -> a.getWeight() > 300);
    // 验证是否没有苹果重量大于500的
    StreamTest.noneMatchTest(testList, a -> a.getWeight() > 500);
    // 验证是否由重量小于300的苹果
    StreamTest.anyMatchTest(testList, a -> a.getWeight() < 300);
    // 寻找任何一个颜色为红色的苹果
    StreamTest.findAnyTest(testList, a -> "red".equals(a.getColor()));
    // 寻找第一个重量小于300的苹果
    StreamTest.findFirstTest(testList, a -> a.getWeight() < 300);
    // 计算所有苹果的重量
    StreamTest.reduceTest(testList, (a, b) -> a + b);
    // 计算所有苹果的平均重量
    StreamTest.intStreamTest(testList);
    // 获取苹果的相关属性
    StreamTest.summaryTest(testList);
    // 将苹果的名字组合成一个字符串并用空格分隔
    StreamTest.joinTest(testList);
    // 先按照苹果的重量分组，然后安装苹果的颜色分组，最后用苹果的名字来表示分组的结果
    StreamTest.groupByTest(testList);
  }
}
