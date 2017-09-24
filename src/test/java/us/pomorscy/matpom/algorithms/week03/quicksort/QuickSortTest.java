package us.pomorscy.matpom.algorithms.week03.quicksort;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QuickSortTest {

  private QuickSort quickSort = new QuickSort();

  @Test
  void shouldCorrectlyPartitionAnArray() {
    //given
    String[] array = {"K", "R", "A", "T", "E", "L", "E", "P", "U"};
    String[] expected = {"E", "E", "A", "K", "T", "L", "R", "P", "U"};
    //when
    QuickSort.partition(array, 0, array.length - 1);
    //then
    assertArrayEquals(expected, array);
  }

  @Test
  void shouldSortTheArrayUsingQuickSortAlgorithm() {
    //given
    Integer[] notSorted = {4, 2, 4, 1, 6, 7, 8, 3, 6, 0};
    Integer[] expected = {0, 1, 2, 3, 4, 4, 6, 6, 7, 8};
    //when
    quickSort.sort(notSorted);
    //then
    assertArrayEquals(expected, notSorted);
  }

  @Test
  void shouldSortTheArrayUsingThreeWayDijkstraQuickSortAlgorithm() {
    //given
    Integer[] notSorted = {4, 2, 4, 1, 6, 7, 8, 3, 6, 0};
    Integer[] expected = {0, 1, 2, 3, 4, 4, 6, 6, 7, 8};
    //when
    quickSort.sortThreeWay(notSorted);
    //then
    assertArrayEquals(expected, notSorted);
  }

}
