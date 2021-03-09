public interface Queue<E> {
  void enqueue(E e);
  E dequeue();
  E getFirst();
  int getSize();
  boolean isEmpty();
}
