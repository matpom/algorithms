package us.pomorscy.matpom.algorithms.week01.unionfind;

import java.util.Arrays;

/**
 * Lazy approach.
 * id[i] is parent of i
 * Root of i is id[id[id[...[id[i]...]]]
 * Find: p and q have the same root
 * Union: set the id of p's root to the id of q's root
 * Maintain extra size array.
 * Union complexity: O(lg(n)), (max depth of a weighted tree)
 * Find complexity: O(lg(n), worst case
 */
public class WeightedQuickUnion implements UnionFind {

  private int[] ids;
  private int[] sizes;

  WeightedQuickUnion(int size) {
    ids = new int[size];
    sizes = new int[size];
    for (int i = 0; i < size; i++) {
      ids[i] = i;
      sizes[i] = 1;
    }
  }

  private int root(int i) {
    int root = i;
    while (ids[root] != root) {
      root = ids[root];
    }
    return root;
  }

  @Override
  public void union(int p, int q) {
    int i = root(p);
    int j = root(q);
    if (i == j) {
      return;
    }
    if (sizes[i] < sizes[j]) {
      ids[i] = j;
      sizes[i] += sizes[j];
    } else {
      ids[j] = i;
      sizes[j] += sizes[i];
    }
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

    WeightedQuickUnion that = (WeightedQuickUnion) o;

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
