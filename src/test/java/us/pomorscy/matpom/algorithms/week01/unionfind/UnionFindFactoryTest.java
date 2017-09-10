package us.pomorscy.matpom.algorithms.week01.unionfind;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class UnionFindFactoryTest {

  private final UnionFindFactory unionFindFactory = new UnionFindFactory();

  @Test
  void shouldReturnNewInstanceOfUnionFind() {
    //given
    int expectedSize = 123;
    UnionFind expectedUnionFind = new UnionFind(expectedSize);
    //when
    UnionFind actualUnionFind = unionFindFactory.createUnionFind(expectedSize);
    //then
    assertEquals(expectedUnionFind, actualUnionFind);
  }
}
