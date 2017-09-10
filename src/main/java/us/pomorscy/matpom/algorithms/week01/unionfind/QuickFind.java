package us.pomorscy.matpom.algorithms.week01.unionfind;

import java.util.Arrays;

/**
 * Eager approach.
 * p and q are connected iff they have the same id.
 * Union complexity: O(n), Find complexity: O(1)
 */
public class QuickFind implements UnionFind {

  private int[] ids;

  QuickFind(int size) {
    ids = new int[size];
    for (int i = 0; i < size; i++) {
      ids[i] = i;
    }
  }

  @Override
  public void union(int p, int q) {
// My improvement:
//    if (connected(p, q)) {
//      return;
//    }
    int pid = ids[p];
    int qid = ids[q];

    for (int i = 0; i < ids.length; i++) {
      if (ids[i] == pid) {
        ids[i] = qid;
      }
    }
// Equivalent of:
// IntStream.range(0, ids.length).filter(i -> ids[i] == pid).forEach(i -> ids[i] = qid)
  }

  @Override
  public boolean connected(int p, int q) {
    return ids[p] == ids[q];
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    QuickFind that = (QuickFind) o;

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
