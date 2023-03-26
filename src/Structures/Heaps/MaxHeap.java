package Structures.Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaxHeap<T> extends PriorityQueue<T> {
  
  public MaxHeap() {
    super(Collections.reverseOrder());
  }

}
