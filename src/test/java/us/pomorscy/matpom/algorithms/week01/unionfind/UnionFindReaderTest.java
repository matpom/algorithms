package us.pomorscy.matpom.algorithms.week01.unionfind;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mockito;


class UnionFindReaderTest {

  private static final String FILE_NAME = "tinyUF.txt";

  private final UnionFindFactory unionFindFactoryMock = Mockito.mock(UnionFindFactory.class);


  @AfterEach
  void init() {
    reset(unionFindFactoryMock);
  }

  @Test
  void shouldThrowUnionFindExceptionIfFileDoesNotExist() {
    //given
    UnionFindReader reader = new UnionFindReader("file_does_not_exist.txt", unionFindFactoryMock);
    //when
    Executable readUnionFind = () -> reader.readUnionFind(UnionFindType.QUICK_FIND);
    //then
    assertThrows(UnionFindException.class, readUnionFind);
    verify(unionFindFactoryMock, never()).createUnionFind(any(), anyInt());
  }

  @Test
  void shouldReadFileAndReturnUnionFindCreatedByFactory() {
    //given
    UnionFindReader reader = new UnionFindReader(FILE_NAME, unionFindFactoryMock);
    int expectedSize = 10;
    UnionFind expectedUnionFind = new QuickFind(expectedSize);
    when(unionFindFactoryMock.createUnionFind(UnionFindType.QUICK_FIND, expectedSize)).thenReturn(expectedUnionFind);
    //when
    UnionFind actualUnionFind = reader.readUnionFind(UnionFindType.QUICK_FIND);
    //then
    assertEquals(expectedUnionFind, actualUnionFind);
  }

  @Test
  void shouldCallConnectedAndConnectForEveryPair() {
    //given
    UnionFindReader reader = new UnionFindReader(FILE_NAME, unionFindFactoryMock);
    UnionFind unionFindMock = Mockito.mock(UnionFind.class);
    when(unionFindMock.connected(anyInt(), anyInt())).thenReturn(false);
    when(unionFindFactoryMock.createUnionFind(any(), anyInt())).thenReturn(unionFindMock);
    //when
    reader.readUnionFind(UnionFindType.QUICK_FIND);
    //then
    verify(unionFindMock, times(11)).connected(anyInt(), anyInt());
    verify(unionFindMock, times(11)).union(anyInt(), anyInt());
  }

}
