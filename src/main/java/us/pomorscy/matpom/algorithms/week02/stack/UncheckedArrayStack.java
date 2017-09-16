package us.pomorscy.matpom.algorithms.week02.stack;

/**
 * Weak typed
 * Fixed capacity
 * Loitering
 */
public class UncheckedArrayStack<T> implements Stack<T> {

  private Object[] items;
  private int size;

  public UncheckedArrayStack(int capacity) {
    items = new Object[capacity];
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
  @SuppressWarnings("unchecked")
  public T pop() {
    if (isEmpty()) {
      throw new IllegalStateException("Popping from empty stack");
    }
    return (T) items[size--];
  }
}
