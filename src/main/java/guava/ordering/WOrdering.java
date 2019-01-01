package guava.ordering;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;

import java.util.ArrayList;
import java.util.List;

public class WOrdering {
  public void test1(List<OrderElement> orderElements) {
    Ordering<OrderElement> orderElementOrdering =
        Ordering.natural().nullsLast().onResultOf(OrderElement::getOrderBy);
    ImmutableList<OrderElement> immutableList =
        orderElementOrdering.immutableSortedCopy(orderElements);
    immutableList.forEach(e -> System.out.println(e.getOrderBy()));
  }

  public static void main(String[] args) {
    ArrayList<OrderElement> arrayList = new ArrayList<>();
    arrayList.add(new OrderElement(6));
    arrayList.add(new OrderElement(2));
    arrayList.add(new OrderElement(1));
    arrayList.add(new OrderElement(3));
    arrayList.add(new OrderElement(4));
    arrayList.add(new OrderElement(4));
    WOrdering wOrdering = new WOrdering();
    wOrdering.test1(arrayList);
  }
}
