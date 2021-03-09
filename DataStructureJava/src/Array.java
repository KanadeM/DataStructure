/**
 * getCapacity()
 * getSize()
 * isEmpty()
 */
public class Array<E>{
  private E[] data;
  private int size;

  public Array(){
    this(10);
  }

  public Array(int size) {
    data = (E[]) new Object[size];
    this.size = 0;
  }

  public int getCapacity() {
    return data.length;
  }

  public int getSize() {
    return size;
  }

  public boolean isEmpty(){
    return size == 0;
  }

  public void add(int index, E e){

    if(index < 0 || index > size)
      throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");

    if(size == data.length)
      resize(2 * data.length);

    for(int i = size - 1; i >= index; --i){
      data[i + 1] = data[i];
    }
    data[index] = e;
    size++;

  }

  public void addLast(E e){
    add(size, e);
  }

  public void addFirst(E e){
    add(0, e);
  }

  public E get(int index){
    if(index < 0 || index >= size)
      throw new IllegalArgumentException("Get failed. Index is illegal.");
    return data[index];
  }

  public E getFirst(){
    return get(0);
  }
  public E getLast(){
    return get(size - 1);
  }

  public void set(int index, E e){
    if(index < 0 || index >= size)
      throw new IllegalArgumentException("Get failed. Index is illegal.");
    data[index] = e;
  }

  public boolean contains(E e){
    for(int i = 0; i < size; ++i){
      if(data[i] == e) return true;
    }
    return false;
  }

  public int search(E e){
    for(int i = 0; i < size; ++i){
      if(data[i] == e) return i;
    }
    return -1;
  }

  public E delete(int index){

    if(index < 0 || index >= size)
      throw new IllegalArgumentException("Delete failed. Index is illegal.");

    E del = data[index];
    for(int i = index; i < size - 1; ++i){
      data[i] = data[i + 1];
    }
    data[size - 1] = null;
    size--;
    if(size == data.length / 2)
      resize(data.length/2);
    return del;
  }

  public E deleteFirst(){
    return delete(0);
  }

  public E deleteLast(){
    return delete(size - 1);
  }

  public int deleteElement(E e, int times){
    for(int i = 0; i < times; ++i){
      int index = search(e);
      if(index != -1)
        delete(index);
      else
        return 1;
    }
    return 1;
  }








  private void resize(int newCapacity){
    E[] newData = (E[])new Object[newCapacity];
    for(int i = 0; i < size; i++)
      newData[i] = data[i];
    data = newData;
  }


  @Override
  public String toString() {
    StringBuilder res = new StringBuilder();
    res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
    res.append('[');
    for (int i = 0; i < size; i++) {
      res.append(data[i]);
      if (i != size - 1)
        res.append(", ");
    }
    res.append(']');
    return res.toString();
  }


}
