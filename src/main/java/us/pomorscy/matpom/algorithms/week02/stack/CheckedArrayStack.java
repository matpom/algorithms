package us.pomorscy.matpom.algorithms.week02.stack;

/**
 * Strong typed
 * Fixed capacity
 * Avoids loitering
 */
public class CheckedArrayStack<T> implements Stack<T> {

  private T[] items;
  private int size;

  @SuppressWarnings("unchecked")
  public CheckedArrayStack(int capacity) {
    items = (T[]) new Object[capacity];
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public void push(T item) {
    items[size++] = item;
  }

  @Override
  public T pop() {
    if (isEmpty()) {
      throw new IllegalStateException("Popping from empty stack");
    }

    T item = items[size--];
    items[size] = null;
    return item;
  }
}
