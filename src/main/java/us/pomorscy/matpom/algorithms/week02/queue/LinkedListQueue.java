package us.pomorscy.matpom.algorithms.week02.queue;

public class LinkedListQueue<T> implements Queue<T> {

  private Node<T> first, last;

  @Override
  public void enqueue(T item) {
    Node<T> oldLast = last;
    last = new Node<>(item, null);
    if (isEmpty()) {
      first = last;
    } else {
      oldLast.next = last;
    }
  }

  @Override
  public T dequeue() {
    T item = first.item;
    first = first.next;
    if (isEmpty()) {
      last = null;
    }
    return item;
  }

  @Override
  public boolean isEmpty() {
    return first == null;
  }

  private class Node<E> {
    E item;
    Node<E> next;

    private Node(E item, Node<E> next) {
      this.item = item;
      this.next = next;
    }
  }
}
