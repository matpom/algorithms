package us.pomorscy.matpom.algorithms.week01.unionfind;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PathCompressionPathCompressionWeightedQuickUnionTest {

  @Test
  void shouldCreateAUnionWithoutAnyConnections() {
    //given
    int size = 10;
    UnionFind unionFind = new PathCompressionWeightedQuickUnion(size);
    //then
    for (int p = 0; p < size; p++) {
      for (int q = p + 1; q < size; q++) {
        assertFalse(unionFind.connected(p, q));
      }
    }
  }

  @Test
  void eachElementShouldBeConnectedToItself() {
    //given
    int size = 10;
    UnionFind unionFind = new PathCompressionWeightedQuickUnion(size);
    //then
    for (int p = 0; p < size; p++) {
      assertTrue(unionFind.connected(p, p));
    }
  }

  @Test
  void shouldSolveSampleUnion() {
    //given
    UnionFind unionFind = new PathCompressionWeightedQuickUnion(5);
    //when
    unionFind.union(0, 1);
    unionFind.union(3, 4);
    unionFind.union(2, 3);
    //then
    assertTrue(unionFind.connected(0, 1));
    assertTrue(unionFind.connected(2, 3));
    assertTrue(unionFind.connected(3, 2));
    assertTrue(unionFind.connected(3, 4));
    assertTrue(unionFind.connected(4, 2));
    assertTrue(unionFind.connected(2, 4));

    assertFalse(unionFind.connected(1, 2));
  }


}
