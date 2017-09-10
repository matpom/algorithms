package us.pomorscy.matpom.algorithms.week01.unionfind;

import java.io.File;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

class UnionFindReader {

  private static final Logger LOGGER = Logger.getLogger(UnionFindReader.class.getName());

  private final String fileName;
  private final UnionFindFactory unionFindFactory;

  UnionFindReader(String fileName, UnionFindFactory unionFindFactory) {
    this.fileName = fileName;
    this.unionFindFactory = unionFindFactory;
  }

  UnionFind readUnionFind(UnionFindType type) {
    try (Scanner scanner = new Scanner(
        new File(getClass().getClassLoader().getResource(fileName).getFile()))) {
      UnionFind unionFind = unionFindFactory.createUnionFind(type, scanner.nextInt());
      while (scanner.hasNext()) {
        int p = scanner.nextInt();
        int q = scanner.nextInt();
        if (!unionFind.connected(p, q)) {
          unionFind.union(p, q);
        }
      }
      return unionFind;
    } catch (Exception ex) {
      LOGGER.log(Level.SEVERE, "Unable to read the UnionFind file: " + fileName, ex);
      throw new UnionFindException();
    }
  }
}
