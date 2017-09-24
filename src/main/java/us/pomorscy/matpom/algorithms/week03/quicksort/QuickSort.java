package us.pomorscy.matpom.algorithms.week03.quicksort;

import static us.pomorscy.matpom.algorithms.week03.utils.SortingUtils.exchange;
import static us.pomorscy.matpom.algorithms.week03.utils.SortingUtils.less;

import us.pomorscy.matpom.algorithms.week03.utils.StdRandom;

/**
 * Shuffle the array.
 * ・Partition so that, for some j
 * – entry a[j] is in place
 * – no larger entry to the left of j
 * – no smaller entry to the right of j
 * ・Sort each piece recursively.
 */
public class QuickSort {

  public static int partition(Comparable[] a, int lo, int hi) {
    int i = lo;
    int j = hi + 1;
    while (true) {
      while (less(a[++i], a[lo])) {
        if (i == hi) {
          break;
        }
      }
      while (less(a[lo], a[--j])) {
        if (j == lo) {
          break;
        }
      }

      if (i >= j) {
        break;
      }
      exchange(a, i, j);
    }
    exchange(a, lo, j);
    return j;
  }

  public void sort(Comparable[] a) {
    StdRandom.shuffle(a);
    sort(a, 0, a.length - 1);
  }

  private void sort(Comparable[] a, int lo, int hi) {
    if (hi <= lo) {
      return;
    }
    int j = partition(a, lo, hi);
    sort(a, lo, j - 1);
    sort(a, j + 1, hi);
  }

  /**
   * Much better when considerable amount of duplicated keys. (even linear, entropy optimal)
   * Worst case - all distinct keys - N lg N
   * Partition array into 3 parts so that:
   * ・Entries between lt and gt equal to partition item v.
   * ・No larger entries to left of lt.
   * ・No smaller entries to right of gt.
   */
  public void sortThreeWay(Comparable[] a) {
    StdRandom.shuffle(a);
    sortThreeWayDijkstra(a, 0, a.length - 1);
  }

  private void sortThreeWayDijkstra(Comparable[] a, int lo, int hi) {
    if (hi <= lo) {
      return;
    }
    int lt = lo;
    int gt = hi;
    Comparable v = a[lo];
    int i = lo;
    while (i <= gt) {
      int cmp = a[i].compareTo(v);
      if (cmp < 0) {
        exchange(a, lt++, i++);
      } else if (cmp > 0) {
        exchange(a, i, gt--);
      } else {
        i++;
      }
    }
    sortThreeWayDijkstra(a, lo, lt - 1);
    sortThreeWayDijkstra(a, gt + 1, hi);
  }
}
