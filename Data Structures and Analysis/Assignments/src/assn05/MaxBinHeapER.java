package assn05;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MaxBinHeapER  <V, P extends Comparable<P>> implements BinaryHeap<V, P> {

    private List<Prioritized<V,P>> _heap;

    /**
     * 1st constructor that creates an empty max heap of prioritized elements.
     */
    public MaxBinHeapER() {
        _heap = new ArrayList<>();
    }

    /**
     * @return size of heap
     */
    @Override
    public int size() {
        return _heap.size();
    }

    /**
     * TODO (Task 2A): enqueue using value and priority
     * @param value
     * @param priority
     */
    @Override
    public void enqueue(V value, P priority) {
        Prioritized<V,P> pt = new Patient<>(value, priority);
        _heap.add(pt);
        bubble_up_rec(_heap.size()-1);
    }

    private void bubble_up_rec(int idx){
        if (idx == 0) return; // parent is root

        int parent_idx = (idx - 1)/2;
        Prioritized<V,P> parent = _heap.get(parent_idx);
        Prioritized<V,P> child = _heap.get(idx);

        if (parent.getPriority().compareTo(child.getPriority()) < 0) { // parent is less than child
            _heap.set(parent_idx, child);
            _heap.set(idx, parent);
            bubble_up_rec(parent_idx);
        }
    }

    /**
     * TODO (Task 2A): enqueue (overloaded) using only value
     * @param value
     */
    public void enqueue(V value) {
        Prioritized<V,P> pt = new Patient<>(value);
        _heap.add(pt);
        bubble_up_rec(_heap.size()-1);
    }

    /**
     * TODO (Task 2A): dequeue from maxBinHeapER
     * @return element with highest priority
     */
    @Override
    public V dequeue() {
        if (_heap.size() == 0) return null; // queue is empty
        V hp = _heap.get(0).getValue();
        _heap.set(0, _heap.get(_heap.size()-1));
        _heap.remove(_heap.size()-1);
        bubble_down_rec(0);
        return hp;
    }

    private void bubble_down_rec(int idx) {
        int left_child_idx = (idx * 2) + 1;
        int right_child_idx = (idx * 2) + 2;
        if (left_child_idx >= _heap.size() && right_child_idx >= _heap.size()) return; // parent is a leaf

        Prioritized<V, P> parent = _heap.get(idx);
        if (left_child_idx >= _heap.size()) { // left child doesn't exist
            Prioritized<V, P> right_child = _heap.get(right_child_idx);
            if (parent.getPriority().compareTo(right_child.getPriority()) < 0){
                _heap.set(right_child_idx, parent);
                _heap.set(idx, right_child);
            }
            return;
        }

        if (right_child_idx >= _heap.size()) { // right child doesn't exist
            Prioritized<V, P> left_child = _heap.get(left_child_idx);
            if (parent.getPriority().compareTo(left_child.getPriority()) < 0){
                _heap.set(left_child_idx, parent);
                _heap.set(idx, left_child);
            }
            return;
        }

        Prioritized<V, P> left_child = _heap.get(left_child_idx);
        Prioritized<V, P> right_child = _heap.get(right_child_idx);

        if (parent.getPriority().compareTo(left_child.getPriority()) < 0 || parent.getPriority().compareTo(right_child.getPriority()) < 0) { // parent is less than child
            if (left_child.getPriority().compareTo(right_child.getPriority()) > 0) { // left child is larger than right child
                _heap.set(left_child_idx, parent);
                _heap.set(idx, left_child);
                bubble_down_rec(left_child_idx);
            } else {
                _heap.set(right_child_idx, parent);
                _heap.set(idx, right_child);
                bubble_down_rec(right_child_idx);
            }
        }
    }

    /**
     * TODO (Task 2A): getMax
     * @return return value of element with the highest priority
     */
    @Override
    public V getMax() {
        if (_heap.size() == 0) return null; // empty queue
        return (_heap.get(0).getValue());
    }

    /**
     * TODO (Task 2B): updatePriority
     * Change the priority of the patient with the given value.
     * if newPriority is <0 then remove the element with given value
     * (In case value is not matching and existing Priority < 0, nothing is to be done.)
     * @param value
     * @param newPriority
     */
    public void updatePriority(V value, P newPriority) {

    }

    /**
     * TODO (Task 3): MaxBinHeapER
     * 2nd constructor that builds a heap given an initial array of prioritized elements.
     * @param initialEntries This is an initial ArrayList of patients
     */
    public MaxBinHeapER(Prioritized<V, P>[] initialEntries ) {
    }

    /**
     * Retrieves contents of heap as an array.
     * @return array of Prioritized elements in the order stored in the heap
     */
    @Override
    public Prioritized<V, P>[] getAsArray() {
        Prioritized<V,P>[] result = (Prioritized<V, P>[]) Array.newInstance(Prioritized.class, size());
        return _heap.toArray(result);
    }
}

