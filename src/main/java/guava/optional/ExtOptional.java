package guava.optional;

import com.google.common.base.Preconditions;

public class ExtOptional {
    public static void main(String[] args) {
        int i = 1;
        int j = 2;
        Preconditions.checkArgument(i > j, "i > j,但是%s < %s", i, j);
    }
}
