package us.pomorscy.matpom.algorithms.week03.insertionsort;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InsertionSortTest {

  private InsertionSort insertionSort = new InsertionSort();

  @Test
  void shouldSortTheArrayUsingMergeSortAlgorithm() {
    //given
    Integer[] notSorted = {4, 2, 4, 1, 6, 7, 8, 3, 6, 0};
    Integer[] expected = {0, 1, 2, 3, 4, 4, 6, 6, 7, 8};
    //when
    insertionSort.sort(notSorted);
    //then
    assertArrayEquals(expected, notSorted);
  }

}
