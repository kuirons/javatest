package guava.comparechain;

import com.google.common.collect.ComparisonChain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CompareChain {
  List<Comparator> comparators = new ArrayList<>();

  public CompareChain getInstance() {
    return new CompareChain();
  }

  // 排序主次对象根据添加顺序确定
  public CompareChain append(Comparator comparator) {
    this.comparators.add(comparator);
    return this;
  }

  private <T> int compare(T left,T right){
    return ComparisonChain.start().
  }

  public <T> List<T> result(List<T> objs){
    List<T> result = new ArrayList<>();
    objs.stream().sorted()
  }
}
