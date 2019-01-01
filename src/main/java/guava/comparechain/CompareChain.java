package guava.comparechain;

import com.google.common.collect.ComparisonChain;

import java.util.Comparator;
import java.util.List;

public class CompareChain {
  private ComparisonChain comparisonChain;

  private CompareChain() {
    this.comparisonChain = ComparisonChain.start();
  }

  public CompareChain getInstance() {
    return new CompareChain();
  }

  // 排序主次对象根据添加顺序确定
  public <T> CompareChain append(T left, T right, Comparator comparator) {
    this.comparisonChain.compare(left, right, comparator);
    this.comparisonChain.result();
    return this;
  }

  public <T> List<T> result(List<T> objCompare) {
    objCompare.stream().sorted();
  }
}
