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
    quickSort.partition(array, 0, array.length - 1);
    //then
    assertArrayEquals(expected, array);
  }

}
