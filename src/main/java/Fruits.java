import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author WuGYu
 * @date 2018/2/1 11:37
 */
public class Fruits {
  // 决策
  public static <T> List<T> predicateFruit(List<T> fruits, FruitsPredicate<T> predicate) {
    List<T> resultList = new ArrayList<>();
    for (T t : fruits) {
      if (predicate.test(t)) resultList.add(t);
    }
    return resultList;
  }

  public static void main(String[] args) {
    List result = new ArrayList();
    List<Apple> appleList = new ArrayList<>();
    appleList.add(new Apple("red", 200));
    appleList.add(new Apple("green", 600));
    // 判断苹果重量
    result = Fruits.predicateFruit(appleList, apple -> apple.getWeight() > 500 ? true : false);
    for (Object a : result) {
      System.out.println(((Apple) a).getWeight());
    }
    // 判断苹果颜色
    result =
        Fruits.predicateFruit(appleList, apple -> "red".equals(apple.getColor()) ? true : false);
    for (Object a : result) {
      System.out.println(((Apple) a).getColor());
    }
    // 判断香蕉重量......
    // 判断香蕉颜色.....(都是套路~~~~)
  }
}

interface FruitsPredicate<T> {
  boolean test(T t);
}

class Apple {
  private String color;
  private int weight;

  Apple(String color, int weight) {
    this.color = color;
    this.weight = weight;
  }

  Apple() {}

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public String getColor() {

    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }
}

class Banana {
  private String color;
  private int weight;

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public String getColor() {

    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }
}
