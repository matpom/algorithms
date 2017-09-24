package us.pomorscy.matpom.algorithms.week03.mergesort;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MergeSortTest {

  private final MergeSort mergeSort = new MergeSort();

  @Test
  void shouldMergeSortedArrayParts() {
    //given
    Integer[] semiSorted = {1, 3, 6, 8, 2, 2, 4, 5, 9};
    Integer[] aux = new Integer[semiSorted.length];
    Integer[] expected = {1, 2, 2, 3, 4, 5, 6, 8, 9};
    //when
    mergeSort.merge(semiSorted, aux, 0, 3, semiSorted.length - 1);
    //then
    assertArrayEquals(expected, semiSorted);
  }

  @Test
  void shouldSortTheArrayUsingMergeSortAlgorithm() {
    //given
    Integer[] notSorted = {4, 2, 4, 1, 6, 7, 8, 3, 6, 0};
    Integer[] expected = {0, 1, 2, 3, 4, 4, 6, 6, 7, 8};
    //when
    mergeSort.sort(notSorted);
    //then
    assertArrayEquals(expected, notSorted);
  }

  @Test
  void shouldSortTheArrayUsingBottomUpMergeSortAlgorithm() {
    //given
    Integer[] notSorted = {4, 2, 4, 1, 6, 7, 8, 3, 6, 0};
    Integer[] expected = {0, 1, 2, 3, 4, 4, 6, 6, 7, 8};
    //when
    mergeSort.sortBottomUp(notSorted);
    //then
    assertArrayEquals(expected, notSorted);
  }
}
