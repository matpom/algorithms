package us.pomorscy.matpom.algorithms.week03.utils;

/**
 * Extremely ugly.
 */
public class SortingUtils {

  public static void exchange(Comparable[] a, int j, int i) {
    Comparable tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
  }

  public static boolean less(Comparable a, Comparable b) {
    // to make some of the algorithms stable its better to treat left operand as lesser when equals
    return a.compareTo(b) <= 0;
  }
}
