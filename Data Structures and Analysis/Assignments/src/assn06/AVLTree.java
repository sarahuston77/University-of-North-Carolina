package assn06;

public class AVLTree<T extends Comparable<T>> implements SelfBalancingBST<T> {
    // Fields
    private T _value;
    private AVLTree<T> _left;
    private AVLTree<T> _right;
    private int _height;
    private int _size;
    
    public AVLTree() {
        _value = null;
        _left = null;
        _right = null;
        _height = -1;
        _size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int height() {
        return _height;
    }

    @Override
    public int size() {
        return _size;
    }

    @Override
    public T getValue() {
        return _value;
    }

    @Override
    public SelfBalancingBST<T> getLeft() {
        if (isEmpty()) {
            return null;
        }
        return _left;
    }

    @Override
    public SelfBalancingBST<T> getRight() {
        if (isEmpty()) {
            return null;
        }
        return _right;
    }

    //==================================================================
    // The methods below need to be completed.
    // Refer to the SelfBalancingTree interface for the descriptions.
    //==================================================================

    /**
     * Rotates the tree left and returns
     * AVLTree root for rotated result.
     */
     public AVLTree<T> rotateLeft() {
         // You should implement left rotation and then use this 
         // method as needed when fixing imbalances.
         AVLTree<T> y = _right;
         _left = _right._left;
         y._left = this;
         return y;
     }
    
    /**
     * Rotates the tree right and returns
     * AVLTree root for rotated result.
     */
     private AVLTree<T> rotateRight() {
         // You should implement right rotation and then use this 
         // method as needed when fixing imbalances.
    	 // TODO

         return null;
     }

    @Override
    public SelfBalancingBST<T> insert(T element) {
        if (_value == null) { // Tree is empty
            _value = element;
        } else if (_value.compareTo(element) > 0) { // Element is smaller than root
            if (_left == null) {
                AVLTree<T> new_tree = new AVLTree<>();
                new_tree._value = element;
                _left = new_tree;
            } else {
                _left.insert(element);
            }
        } else { // Element is larger than root
            if (_right == null) {
                AVLTree<T> new_tree = new AVLTree<>();
                new_tree._value = element;
                _right = new_tree;
            } else {
                _right.insert(element);
            }
        }

        _size++;
        return this;
    }

    @Override
    public SelfBalancingBST<T> remove(T element) {

        return null;
    }

    @Override
    public T findMin() {
        if (isEmpty()) {
            throw new RuntimeException("Illegal operation on empty tree");
        }
        // TODO

        return null;
    }

    @Override
    public T findMax() {
        if (isEmpty()) {
            throw new RuntimeException("Illegal operation on empty tree");
        }
        // TODO

        return null;
    }

    @Override
    public boolean contains(T element) {
    	// TODO

        return false;
    }

    @Override
    public boolean rangeContain(T start, T end) {
        // TODO

        return false;
    }

}
