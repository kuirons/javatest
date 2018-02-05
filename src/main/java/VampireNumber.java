import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.IntStream;

/**
 * @author WuGYu
 * @date 2018/2/5 21:02
 */
public class VampireNumber implements Collector<Integer, List<Integer>, List<Integer>> {

  private boolean judgeTheNumWhetherVampireNum(int i) {
    if (!judgeTheNumWhetherEndWithTwoZero(i)) {
      ArrayList<Integer> num = SplitTheNumIntoTwoPart(i);
      return whetherExistTwoNumMeetTheRequirement(num, i);
    }
    return false;
  }

  private boolean judgeTheNumWhetherEndWithTwoZero(int i) {
    String s = Integer.toString(i);
    String s1 = s.substring(s.length() - 2, s.length());
    return s1.equals("00");
  }

  private boolean whetherExistTwoNumMeetTheRequirement(ArrayList<Integer> num, int i) {
    for (Integer j : num) {
      for (Integer k : num) {
        if (j.intValue() != k.intValue() ? i == (j.intValue() * k.intValue()) : false) {
          return true;
        }
      }
    }
    return false;
  }

  private ArrayList<Integer> SplitTheNumIntoTwoPart(int i) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    String s = Integer.toString(i);
    for (int j = 0; j < s.length(); j++) {
      for (int k = 0; k < s.length(); k++) {
        if (k != j) {
          result.add(Integer.valueOf("" + s.charAt(j) + s.charAt(k)));
        }
      }
    }
    return result;
  }

  @Override
  public Supplier<List<Integer>> supplier() {
    return () -> new ArrayList<Integer>();
  }

  @Override
  public BiConsumer<List<Integer>, Integer> accumulator() {
    return (List<Integer> list, Integer i) -> {
      if (judgeTheNumWhetherVampireNum(i)) list.add(i);
    };
  }

  @Override
  public BinaryOperator<List<Integer>> combiner() {
    return (List<Integer> list1, List<Integer> list2) -> {
      list1.addAll(list2);
      return list1;
    };
  }

  @Override
  public Function<List<Integer>, List<Integer>> finisher() {
    return Function.identity();
  }

  @Override
  public Set<Characteristics> characteristics() {
    return Collections.unmodifiableSet(
        EnumSet.of(
            Characteristics.IDENTITY_FINISH,
            Characteristics.CONCURRENT,
            Characteristics.UNORDERED));
  }

  public static void main(String[] args) {
    List<Integer> result = IntStream.range(1000, 9999).boxed().collect(new VampireNumber());
    for (Integer i : result) {
      System.out.println(i);
    }
  }
}
