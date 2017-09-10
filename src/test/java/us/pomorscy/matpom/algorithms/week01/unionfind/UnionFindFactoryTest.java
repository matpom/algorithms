package us.pomorscy.matpom.algorithms.week01.unionfind;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class UnionFindFactoryTest {

  private final UnionFindFactory unionFindFactory = new UnionFindFactory();

  @Test
  void shouldReturnNewInstanceOfQuickFindUnionFind() {
    //given
    int expectedSize = 123;
    UnionFind expectedUnionFind = new QuickFind(expectedSize);
    //when
    UnionFind actualUnionFind = unionFindFactory.createUnionFind(UnionFindType.QUICK_FIND, expectedSize);
    //then
    assertEquals(expectedUnionFind, actualUnionFind);
  }
}
