package Structures;

import java.lang.module.FindException;
import java.util.ArrayList;

import javax.naming.InvalidNameException;

/*
 * Lower number -> higher priority
 */
public class Heap<T> {

  private class HeapItem {
    T item;
    int priority;

    public HeapItem(T item, int priority) {
      this.item = item;
      this.priority = priority;
    }

  }

  private ArrayList<HeapItem> internalHeap;

  public Heap(int capacity) {
    internalHeap = new ArrayList<>(capacity);
  }

  public void ChangeKey() {

  }

  private void fixFromBottom(int index) {
    var fixed = true;
    while (fixed) {
      fixed = false;
      var current = internalHeap.get(index);
      var fatherIndex = getFather(index);
      var father = internalHeap.get(fatherIndex);
      if (father.priority > current.priority) {
        swap(index, fatherIndex);
        fixed = true;
      }
      index = fatherIndex;
    }
  }

  private void fixFromTop(int index) {
    var fixed = false;
    while (fixed) {
      fixed = true;
      int lChildIndex = getLChild(index);
      int rChildIndex = getRChild(index);
      HeapItem lChild = internalHeap.get(lChildIndex);
      HeapItem rChild = internalHeap.get(rChildIndex);
      int indexToChage;
      if (lChild.priority < rChild.priority) {
        indexToChage = lChildIndex;
      } else {
        indexToChage = rChildIndex;
      }

      if (internalHeap.get(index).priority > internalHeap.get(indexToChage).priority) {
        swap(index, indexToChage);
        fixed = true;
      }
      index = indexToChage;
    }
  }

  private void fix(int index) {

  }

  private int getLChild(int fatherIndex) {
    int childIndex = 2 * fatherIndex + 1;
    if (childIndex > size())
      throw new IllegalArgumentException("There is no left child for the node");
    return childIndex;
  }

  private int getRChild(int fatherIndex) {
    int childIndex = 2 * fatherIndex + 2;
    if (childIndex > size())
      throw new IllegalArgumentException("There is no left child for the node");
    return childIndex;
  }

  private int getFather(int childIndex) {
    if (childIndex > size())
      throw new ArrayIndexOutOfBoundsException("The child index is not in the heap");
    return childIndex / 2; // TODO check this
  }

  public void addElement(T element, int priority) {
    internalHeap.add(new HeapItem(element, priority));
  }

  public T peek() {
    return internalHeap.get(0).item;
  }

  public T removeFirst() {
    HeapItem res = internalHeap.get(0);

    internalHeap.set(0, internalHeap.get(size() - 1));
    internalHeap.remove(size() - 1);
    fixFromTop(0);

    return res.item;
  }

  public void remove(T item) {

    for (var a : internalHeap) {

    }
  }

  public int size() {
    return internalHeap.size();
  }

  @Override
  public String toString() {
    return internalHeap.toString();
  }

  private void swap(int index1, int index2) {
    var temp = internalHeap.get(index1);
    internalHeap.set(index1, internalHeap.get(index2));
    internalHeap.set(index2, temp);
  }

}