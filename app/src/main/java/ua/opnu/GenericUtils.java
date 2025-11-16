package ua.opnu;
import java.lang.reflect.Array;

public class GenericUtils {

    public static <T> T[] filter(T[] input, Predicate<T> p) {
        int counter = 0;
        for (T element : input) {
            if (p.test(element)) {
                counter++;
            }
        }

        @SuppressWarnings("unchecked")
        T[] result = (T[]) Array.newInstance(
                input.getClass().getComponentType(),
                counter
        );

        int idx = 0;
        for (T element : input) {
            if (p.test(element)) {
                result[idx++] = element;
            }
        }

        return result;
    }


    public static <T extends Comparable<T>, V extends T> boolean contains(T[] array, V element) {
        for (T item : array) {
            if (item.compareTo(element) == 0) {
                return true;
            }
        }
        return false;
    }
}
