public class ArrayStack<E> implements Stack<E> {

  Array<E> arr;

  public ArrayStack() {
    this.arr = new Array(10);
  }

  public ArrayStack(int capacity) {
    this.arr = new Array(capacity);
  }

  @Override
  public void push(E e) {
    arr.addLast(e);
  }

  @Override
  public E pop() {
    return arr.deleteLast();
  }

  @Override
  public E peek(E e) {
    return arr.getLast();
  }

  @Override
  public boolean isEmpty() {
    return arr.isEmpty();
  }

  @Override
  public int getSize() {
    return arr.getSize();
  }

  public int getCapacity(){
    return arr.getCapacity();
  }

  @Override
  public String toString(){
    StringBuilder res = new StringBuilder();
    res.append("Stack: ");
    res.append('[');
    for(int i = 0 ; i < arr.getSize() ; i ++){
      res.append(arr.get(i));
      if(i != arr.getSize() - 1)
        res.append(", ");
    }
    res.append("] top");
    return res.toString();
  }

  public static void main(String[] args) {
    Stack<String> stack = new ArrayStack<>();
    stack.push("Hello");
    stack.push("World");
    stack.push("This");
    stack.push("IS");
    stack.push("Data");
    stack.push("Structure");
    System.out.println(stack);
    System.out.println(stack.pop());
    System.out.println(stack);
    System.out.println(stack.getSize());
  }
}
