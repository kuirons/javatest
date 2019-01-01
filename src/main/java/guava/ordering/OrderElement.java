package guava.ordering;

import javax.annotation.Nullable;

public class OrderElement {
  @Nullable private int orderBy;

  OrderElement(int number) {
    this.orderBy = number;
  }

  @Nullable
  public int getOrderBy() {
    return orderBy;
  }
}
