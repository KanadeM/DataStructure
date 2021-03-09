public class ArrayQueue<E> implements Queue<E> {

  Array<E> arr;

  public ArrayQueue() {
    this.arr = new Array<>();
  }

  public ArrayQueue(int capacity) {
    this.arr = new Array<>(capacity);
  }

  @Override
  public void enqueue(E e) {
    arr.addLast(e);
  }

  @Override
  public E dequeue() {
    return arr.deleteFirst();
  }

  @Override
  public E getFirst() {
    return arr.getFirst();
  }

  @Override
  public int getSize() {
    return arr.getSize();
  }

  public int getCapacity(){
    return arr.getCapacity();
  }


  @Override
  public boolean isEmpty() {
    return arr.isEmpty();
  }

  @Override
  public String toString(){
    StringBuilder res = new StringBuilder();
    res.append("Queue: ");
    res.append("front [");
    for(int i = 0 ; i < arr.getSize() ; i ++){
      res.append(arr.get(i));
      if(i != arr.getSize() - 1)
        res.append(", ");
    }
    res.append("] tail");
    return res.toString();
  }

  public static void main(String[] args) {

    ArrayQueue<Integer> queue = new ArrayQueue<>();
    for(int i = 0 ; i < 10 ; i ++){
      queue.enqueue(i);
      System.out.println(queue);
      if(i % 3 == 2){
        queue.dequeue();
        System.out.println(queue);
      }
    }
  }
}
