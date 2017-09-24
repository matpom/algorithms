package us.pomorscy.matpom.algorithms.week03.insertionsort;


import static us.pomorscy.matpom.algorithms.week03.utils.SortingUtils.exchange;
import static us.pomorscy.matpom.algorithms.week03.utils.SortingUtils.less;

/**
 * Stable
 * O(n^2)
 */
public class InsertionSort {

  public void sort(Comparable[] a) {
    int N = a.length;
    for (int i = 0; i < N; i++) {
      for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
        exchange(a, j, j - 1);
      }
    }
  }


}
