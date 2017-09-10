package us.pomorscy.matpom.algorithms.week01.unionfind;

public class UnionFind {

  private int size;

  UnionFind(int size) {
    this.size = size;
  }

  void union(int p, int q) {
    //TODO
  }

  boolean connected(int p, int q) {
    //TODO
    return false;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    UnionFind unionFind = (UnionFind) o;

    return size == unionFind.size;
  }

  @Override
  public int hashCode() {
    return size;
  }

  @Override
  public String toString() {
    return "UnionFind{" +
        "size=" + size +
        '}';
  }
}
