import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author WuGYu
 * @date 2018/2/3 13:43
 */
public class FlatMap {
  public static void main(String[] args) {
    Stream<String> ss = Arrays.asList("this","is","a","test").stream().map(s->s.split("")).flatMap(Arrays::stream);
    ss.forEach(System.out::println);
  }
}
