package us.pomorscy.matpom.algorithms.week01.unionfind;

class UnionFindFactory {

  UnionFind createUnionFind(UnionFindType type, int size) {
    switch (type) {
      case QUICK_FIND:
        return new QuickFind(size);
      default:
        throw new IllegalArgumentException("Unrecognised union find type: " + type);
    }
  }
}
