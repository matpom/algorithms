package us.pomorscy.matpom.algorithms.week03.mergesort;

import static us.pomorscy.matpom.algorithms.week03.utils.SortingUtils.less;

/**
 * O(N lg N)
 * Stable as long the less comparision will take the left one if equal.
 */

public class MergeSort {

  void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int high) {
    //assert isSorted(a, lo, mid)
    //assert isSorted(b, mid, high)
    for (int i = lo; i <= high; i++) {
      aux[i] = a[i];
    }

    int i = lo;
    int j = mid + 1;
    for (int k = lo; k <= high; k++) {
      if (i > mid) {
        a[k] = aux[j++];
      } else if (j > high) {
        a[k] = aux[i++];
      } else if (less(aux[i], aux[j])) {
        a[k] = aux[i++];
      } else {
        a[k] = aux[j++];
      }
    }
  }

  /**
   * Classic Merge Sort implementation
   */
  public void sort(Comparable[] arrayToSort) {
    Comparable[] aux = new Comparable[arrayToSort.length];
    sort(arrayToSort, aux, 0, arrayToSort.length - 1);
  }

  private void sort(Comparable[] array, Comparable[] aux, int low, int high) {
    if (high <= low) {
      return;
    }
    int mid = low + (high - low) / 2;
    sort(array, aux, low, mid);
    sort(array, aux, mid + 1, high);
    //possible optimisation
    //if (!less(array[mid+1], array[mid])) return;
    merge(array, aux, low, mid, high);
  }

  /**
   * Simple and non-recursive version of mergesort.
   * about 10% slower than recursive,
   *
   * Pass through array, merging subarrays of size 1.
   * Repeat for subarrays of size 2, 4, 8, 16, ....
   */
  public void sortBottomUp(Comparable[] a) {
    int N = a.length;
    Comparable[] aux = new Comparable[N];
    for (int sz = 1; sz < N; sz = sz + sz) {
      for (int lo = 0; lo < N - sz; lo += sz + sz) {
        merge(a, aux, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
      }
    }
  }


}
