package us.pomorscy.matpom.algorithms.week03.selection;

import us.pomorscy.matpom.algorithms.week03.quicksort.QuickSort;
import us.pomorscy.matpom.algorithms.week03.utils.StdRandom;

/**
 * Goal. Given an array of N items, find a kth smallest item.
 * Based on partitioning.
 * Quick-select takes linear time on average.
 */
public class QuickSelect {

  public Comparable select(Comparable[] a, int k) {
    StdRandom.shuffle(a);
    int lo = 0;
    int hi = a.length - 1;
    while (hi > lo) {
      int j = QuickSort.partition(a, lo, hi);
      if (j < k) {
        lo = j + 1;
      } else if (j > k) {
        hi = j - 1;
      } else {
        return a[k];
      }
    }
    return a[k];
  }
}
