package us.pomorscy.matpom.algorithms.week02.stack;

/**
 * Strong typed
 * Avoids loitering
 * Amortized push O(1) (N worst)
 * Amortized pop O(1) (N worst)
 * Memory usage ( ~8N when full, ~ 32N when 1/4 full)
 * Fast individual operations
 */
public class ArrayStack<T> implements Stack<T> {

  private T[] items;  //8 bytes + 24 bytes array overhead + 8 * N array size
  private int size;   //4 bytes

  //4 bytes padding

  @SuppressWarnings("unchecked")
  public ArrayStack(int initialCapacity) {
    items = (T[]) new Object[initialCapacity];
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public void push(T item) {
    if (isFull()) {
      resize(2 * items.length);
    }
    items[size++] = item;
  }

  private boolean isFull() {
    return items.length == size;
  }

  @SuppressWarnings("unchecked")
  private void resize(int newCapacity) {
    T[] copy = (T[]) new Object[newCapacity];
    for (int i = 0; i < size; i++) {
      copy[i] = items[i];
    }
    items = copy;
  }

  @Override
  public T pop() {
    if (isEmpty()) {
      throw new IllegalStateException("Popping from empty stack");
    }

    T item = items[size--];
    items[size] = null;
    if (size > 0 && size == items.length / 4) {
      resize(items.length / 2);
    }
    return item;
  }
}
