package us.pomorscy.matpom.algorithms.week02.queue;

public interface Queue<T> {

  void enqueue(T item);

  T dequeue();

  boolean isEmpty();
}
