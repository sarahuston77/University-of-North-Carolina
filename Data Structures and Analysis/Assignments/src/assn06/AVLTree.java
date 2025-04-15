package assn06;
import java.lang.Math;

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
            _left = new AVLTree<>();
        }
        return _left;
    }

    @Override
    public SelfBalancingBST<T> getRight() {
        if (isEmpty()) {
            _right = new AVLTree<>();
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
        y._size = _size;
        _right = _right._left;
        y._left = this;

        if (_left.isEmpty() && _right.isEmpty()) {
            _height = 0;
            _size = 1;
        } else if (_right.isEmpty()) {
            _height = _left._height + 1;
            _size = _left._size + 1;
        } else if (_left.isEmpty()) {
            _height = _right._height + 1;
            _size = _right._size + 1;
        } else {
            _height = Math.max(_left._height, _right._height) + 1;
            _size = _right._size + _left._size + 1;
        }

        if (y._right.isEmpty()) {
            y._height = y._left._height + 1;
        } else {
            y._height = Math.max(y._left._height, y._right._height) + 1;
        }

        return y;
    }

    /**
     * Rotates the tree right and returns
     * AVLTree root for rotated result.
     */
    private AVLTree<T> rotateRight() {
        // You should implement right rotation and then use this
        // method as needed when fixing imbalances.

        AVLTree<T> y = _left;
        y._size = _size;
        _left = _left._right;
        y._right = this;

        if (_left.isEmpty() && _right.isEmpty()) {
            _height = 0;
            _size = 1;
        } else if (_right.isEmpty()) {
            _height = _left._height + 1;
            _size = _left._size + 1;
        } else if (_left.isEmpty()) {
            _height = _right._height + 1;
            _size = _right._size + 1;
        } else {
            _height = Math.max(_left._height, _right._height) + 1;
            _size = _right._size + _left._size + 1;
        }

        if (y._left.isEmpty()) {
            y._height = y._right._height + 1;
        } else {
            y._height = Math.max(y._left._height, y._right._height) + 1;
        }

        return y;
    }

    @Override
    public SelfBalancingBST<T> insert(T element) {
        if (isEmpty()) { // Tree is empty
            _value = element;
        } else if (_value.compareTo(element) > 0) { // Element is smaller than root
            if (_left == null) {
                AVLTree<T> new_tree = new AVLTree<>();
                new_tree._value = element;
                _left = new_tree;
                _left._size++;
                _left._height++;
            } else {
                _left = (AVLTree<T>) _left.insert(element);
            }
        } else { // Element is larger than root
            if (_right == null) {
                AVLTree<T> new_tree = new AVLTree<>();
                new_tree._value = element;
                _right = new_tree;
                _right._size++;
                _right._height++;
            } else {
                _right = (AVLTree<T>) _right.insert(element);
            }
        }

        if (_left == null) {
            _left = new AVLTree<>();
        }
        if (_right == null) {
            _right = new AVLTree<>();
        }
        _size++;

        if (_right.isEmpty() && _left.isEmpty()) {
            _height++;
            return this;
        } // leaf
        else if (_left.isEmpty()) {
            _height = _right.height() + 1;
        } // Right height is larger by default
        else if (_right.isEmpty()) {
            _height = _left.height() + 1;
        } // Left height is larger by default
        else {
            _height = Math.max(_right._height, _left._height) + 1;
        } // Height is max of two children's heights

        if (_left.isEmpty()) {
            if (_height > 1) { // Right imbalance
                if (_right._left != null && _right._right != null) {
                    if (_right._left._height > _right._right._height) // RL
                        _right = _right.rotateRight();
                } else if (_right._right == null) { // RL
                    _right = _right.rotateRight();
                }
                return rotateLeft();
            }
        } else if (_right.isEmpty()) {
            if (_height > 1) { // Left imbalance
                if (_left._right != null && _left._left != null) {
                    if (_left._right._height > _left._left._height) // lR
                        _left = _left.rotateLeft();
                } else if (_left._left == null) { // LR
                    _left = _left.rotateLeft();
                }
                return rotateRight();
            }
        } else if (Math.abs(_right._height - _left._height) > 1) { // tree is imbalanced
            if (_right._height > _left._height) { // Right imbalance
                if (_right._left != null && _right._right != null) {
                    if (_right._left._height > _right._right._height) // RL
                        _right = _right.rotateRight();
                } else if (_right._right == null) { // RL
                    _right = _right.rotateRight();
                }
                return rotateLeft();
            } else if (_left._right != null && _left._left != null) {
                if (_left._right._height > _left._left._height) // LR
                    _left = _left.rotateLeft();
                return rotateRight();
            } else if (_left._left == null) { // LR
                _left = _left.rotateLeft();
                return rotateRight();
            }
        }
        return this;
    }

    @Override
    public SelfBalancingBST<T> remove(T element) {
        if (isEmpty()){return new AVLTree<>();} // return an empty tree if empty
        if (_value.compareTo(element) > 0){ // value is larger than element
            if (getLeft().isEmpty()){
                return this; // no element found
            }else
                _left = (AVLTree<T>) _left.remove(element);
        }
        else if (_value.compareTo(element) < 0){ // value is larger than element
            if (getRight().isEmpty()){
                return this; // no element found
            }else
                _right = (AVLTree<T>) _right.remove(element);
        }
        else { // value matches element
            if (_left.isEmpty() && _right.isEmpty()){ // leaf
                return new AVLTree<>();
            } else if (_left.isEmpty()){ // move right up
                return _right;
            } else if (_right.isEmpty()){ // move left up
                return _left;
            } else { // successor node from left tree
                _value = _right.findMin();
                _right = _right.deleteMin();
                return this;
            }
        }

        _size--;

        if (_left.isEmpty() && _right.isEmpty()) {
            _height = 0;
        }else if (_left.isEmpty()){
            _height = _right._height + 1;
        }else if (_right.isEmpty()){
            _height = _left._height + 1;
        }else
            _height = Math.max(_left._height, _right._height) + 1;

        if (_left.isEmpty()) {
            if (_height > 1) { // Right imbalance
                if (_right._left != null && _right._right != null) {
                    if (_right._left._height > _right._right._height) // RL
                        _right = _right.rotateRight();
                } else if (_right._right == null) { // RL
                    _right = _right.rotateRight();
                }
                return rotateLeft();
            }
        } else if (_right.isEmpty()) {
            if (_height > 1) { // Left imbalance
                if (_left._right != null && _left._left != null) {
                    if (_left._right._height > _left._left._height) // lR
                        _left = _left.rotateLeft();
                } else if (_left._left == null) { // LR
                    _left = _left.rotateLeft();
                }
                return rotateRight();
            }
        } else if (Math.abs(_right._height - _left._height) > 1) { // tree is imbalanced
            if (_right._height > _left._height) { // Right imbalance
                if (_right._left != null && _right._right != null) {
                    if (_right._left._height > _right._right._height) // RL
                        _right = _right.rotateRight();
                } else if (_right._right == null) { // RL
                    _right = _right.rotateRight();
                }
                return rotateLeft();
            } else if (_left._right != null && _left._left != null) {
                if (_left._right._height > _left._left._height) // LR
                    _left = _left.rotateLeft();
                return rotateRight();
            } else if (_left._left == null) { // LR
                _left = _left.rotateLeft();
                return rotateRight();
            }
        }
        return this;
    }

    @Override
    public T findMin() {
        if (isEmpty()) {
            throw new RuntimeException("Illegal operation on empty tree");
        }
        if (!_left.isEmpty()) {
            return _left.findMin();
        }
        return _value;
    }

    @Override
    public T findMax() {
        if (isEmpty()) {
            throw new RuntimeException("Illegal operation on empty tree");
        }
        if (!_right.isEmpty()) {
            return _right.findMax();
        }
        return _value;
    }

    public AVLTree<T> deleteMin() {
        if (isEmpty()) {
            throw new RuntimeException("Illegal operation on empty tree");
        }
        _size --;
        if (_left.isEmpty()){ // root exception case
            return new AVLTree<>();
        }
        if (!_left._left.isEmpty()) {
            _left = _left.deleteMin();
        }else {
            _left = _left._right;
        }

        if (_left.isEmpty() && _right.isEmpty()) {
            _height = 0;
        }else if (_left.isEmpty()){
            _height = _right._height + 1;
        }else if (_right.isEmpty()){
            _height = _left._height + 1;
        }else
            _height = Math.max(_left._height, _right._height) + 1;

        return this;
    }

    @Override
    public boolean contains(T element) {
        if (_value.compareTo(element) == 0) {
            return true;
        } // value match
        if (_value.compareTo(element) > 0) { // value larger than root
            if (_left.isEmpty()) {
                return false; // no values in left tree
            } else return _left.contains(element);
        } // search left tree further
        if (_value.compareTo(element) < 0) { // value larger than root
            if (_right.isEmpty()) {
                return false; // no values in left tree
            } else return _right.contains(element);
        } // search right tree further
        return false;
    }

    @Override
    public boolean rangeContain(T start, T end) {

        return false;
    }
}