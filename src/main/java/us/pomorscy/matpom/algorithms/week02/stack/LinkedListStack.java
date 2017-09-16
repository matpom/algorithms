package us.pomorscy.matpom.algorithms.week02.stack;

/**
 * Every operation O(1)
 * 40 bytes overhead per each stack node
 * (16 object + 8 inner class + 8 each reference)
 */
public class LinkedListStack<T> implements Stack<T> {

  private Node<T> first = null;

  @Override
  public boolean isEmpty() {
    return first == null;
  }

  @Override
  public void push(T item) {
    Node<T> oldFirst = first;
    first = new Node<>(item, oldFirst);
  }

  @Override
  public T pop() {
    if (isEmpty()) {
      throw new IllegalStateException("Popping from empty stack");
    }
    T item = first.item;
    first = first.next;
    return item;
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
