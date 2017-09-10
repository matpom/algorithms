package us.pomorscy.matpom.algorithms.week01.unionfind;

import java.util.Arrays;

/**
 * Lazy approach.
 * id[i] is parent of i
 * Root of i is id[id[id[...[id[i]...]]]
 * Find: p and q have the same root
 * Union: set the id of p's root to the id of q's root
 * Union complexity: O(n*), includes cost of finding root (trees could be too tall)
 * Find complexity: O(n), worst case
 */
public class QuickUnion implements UnionFind {

  private int[] ids;

  QuickUnion(int size) {
    ids = new int[size];
    for (int i = 0; i < size; i++) {
      ids[i] = i;
    }
  }

  private int root(int i) {
    int root = i;
    while (ids[root] != root) {
      root = ids[root];
    }
    return root;
  }

//  Recursive equivalent
//  private int root(int i){
//    if(ids[i] == i){
//      return i;
//    }
//    return root(ids[i]);
//  }

  @Override
  public void union(int p, int q) {
    ids[root(p)] = root(q);
  }

  @Override
  public boolean connected(int p, int q) {
    return root(p) == root(q);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    QuickUnion that = (QuickUnion) o;

    return Arrays.equals(ids, that.ids);
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(ids);
  }

  @Override
  public String toString() {
    return "QuickFind{" +
        "ids=" + Arrays.toString(ids) +
        '}';
  }
}
