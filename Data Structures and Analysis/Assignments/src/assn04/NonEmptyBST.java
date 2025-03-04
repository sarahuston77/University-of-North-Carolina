package assn04;

public class NonEmptyBST<T extends Comparable<T>> implements BST<T> {
	private T _element;
	private BST<T> _left;
	private BST<T> _right;

	public NonEmptyBST(T element) {
		_left = new EmptyBST<T>();
		_right = new EmptyBST<T>();
		_element = element;
	}

	@Override
	public BST<T> insert(T element){
		if (element.compareTo(_element) < 0){
			if (_left.isEmpty()){
				_left = new NonEmptyBST<>(element);
			}
			else
				_left.insert(element);
		}
		if (element.compareTo(_element) > 0){
			if (_right.isEmpty()){
				_right = new NonEmptyBST<>(element);
			}
			else
				_right.insert(element);
		}

		return this;
	}

	// Left -> Right -> Root
	@Override
	public void printInOrderTraversal() {
		if (!_left.isEmpty()) {
			_left.printInOrderTraversal();
		}

		System.out.print(_element + " ");

		if (!_right.isEmpty()) {
			_right.printInOrderTraversal();
		}
	}

	// Root -> Left -> Right
	@Override
	public void printPreOrderTraversal() {
		System.out.print(_element + " ");

		if (!_left.isEmpty()){
			_left.printPreOrderTraversal();
		}

		if (!_right.isEmpty()){
			_right.printPreOrderTraversal();
		}
	}

	// Left -> Right -> Root
	@Override
	public void printPostOrderTraversal() {
		if (!_left.isEmpty()){
			_left.printPostOrderTraversal();
		}

		if (!_right.isEmpty()){
			_right.printPostOrderTraversal();
		}

		System.out.print(_element + " ");
	}

	// Remove an element and replace it with the smallest from the right
	@Override
	public BST<T> remove(T element) {

		if (_element.compareTo(element) == 0) {  // remove (3 initial cases):

			// Case 1: leaf
			if (_left.isEmpty() && _right.isEmpty())
				return new EmptyBST<>();

			// Case 2: Left or right is empty; not both
			if (_left.isEmpty()) {
				return _right;
			} else if (_right.isEmpty())
				return _left;
			else
			// Case 3: Replace value with successor using getMin();
				_element = _right.findMin();
				_right = _right.remove(_element);

		} else if (_element.compareTo(element) > 0){
			if (_left.isEmpty())
				return this;
			_left = _left.remove(element);

		} else if (_element.compareTo(element) < 0){
			if (_right.isEmpty())
				return this;
			_right = _right.remove(element);
		}

        return this;
    }

	// Finds the smallest value in a subtree
	@Override
	public T findMin() {
		if (!_left.isEmpty()){
			return _left.findMin();
		}
		return _element;
    }

	// Replaces a range of values and adds a new value
	@Override
	public BST<T> replaceRange(T start, T end, T newValue) {
		return removeRange(start, end).insert(newValue);
	}

	public BST<T> removeRange(T start, T end) {
		if (start.compareTo(_element) <= 0 && (end.compareTo(_element) >= 0)){
			return remove(_element).removeRange(start, end);
		}
		else if (start.compareTo(_element) > 0){
			if (!_right.isEmpty()){
				_right = _right.removeRange(start, end);
			}
		}else if (end.compareTo(_element) < 0){
			if (!_left.isEmpty()) {
				_left = _left.removeRange(start, end);
			}
		}
		return this;
	}

	//====================================================================
	// Do not change the methods below
	@Override
	public int getHeight() {
		   return Math.max(_left.getHeight(), _right.getHeight())+1;
	}

	@Override
	public BST<T> getLeft() {
		return _left;
	}

	@Override
	public BST<T> getRight() {
		return _right;
	}

	@Override
	public T getElement() {
		return _element;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

}
