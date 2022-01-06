import java.util.NoSuchElementException;

/**
 * Queue implemented with a circular array
 * @author sophiareiner
 *
 */
public class CircularQueue {
  
  int capacity;     // total capacity of the array
  int front;        // index of front of array
  int back;         // index of back of array
  Integer[] arr;    // array of integers
  int size;         // number of initialized elemets in array
  
  /**
   * Creates an empty circular array
   * @param capacity size of the array initialized
   */
  public CircularQueue(int capacity) {
    if (capacity <= 0) {
      throw new IllegalArgumentException("capacity must be a positive integer");
    }
    this.capacity = capacity;
    this.front = -1;
    this.back = -1;
    this.arr = new Integer[capacity];
    this.size = 0;
  }
  
  /**
   * Get the number of the initialized elements in the array
   * @return size
   */
  public int size() {
    return this.size;
  }
  
  /**
   * Determine if array is empty
   * @return true if array is empty
   */
  public boolean isEmpty() {
    return size == 0;
  }
  
  /**
   * Look at front element in the array
   * @return integer at front of array
   */
  public int peek() {
    if (isEmpty()) {
      throw new NoSuchElementException("This queue is empty");
    }
    return arr[front];
  }
  
  /**
   * Add element to the back of the circular array
   * @param element
   */
  public void enqueue(int element) {
    if (size == 0) {
      front = 0;
      back = 0;
      arr[0] = element;
    }
    else {
      if (size == arr.length) {
        throw new IllegalArgumentException("Queue full");
      }
      back++;
      back = back % arr.length;
      arr[back] = element;
    }
    size++;  
  }
  
  /**
   * Remove element from front of circular array
   * @return the element that was removed
   */
  public int dequeue() {
    if (isEmpty()) {
      throw new IllegalArgumentException("Empty Queue");
    }
    int val = arr[front];
    if (size == 1) {
      front = -1;
      back = -1;
    }
    else {
      front++;
      front = front % arr.length; 
    }
    size--;
    return val;   
  }
  
  /**
   * String representation of the circular array with for each loop
   */
  public String toString() {
    String output = "";
    for (Integer val : arr) {
      output += val + " ";
    }
    return output;
  }

}
