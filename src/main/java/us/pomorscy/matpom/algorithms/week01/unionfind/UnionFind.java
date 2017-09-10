package us.pomorscy.matpom.algorithms.week01.unionfind;

interface UnionFind {

  void union(int p, int q);

  boolean connected(int p, int q);
}
