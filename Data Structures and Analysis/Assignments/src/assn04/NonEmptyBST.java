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

		if (!_left.isEmpty()){
			_left.printInOrderTraversal();
		}

		System.out.print(_element + " ");

		if (!_right.isEmpty()){
			_right.printInOrderTraversal();


//		if (!_left.isEmpty()){
//			_left.printInOrderTraversal();
//		}
//		else {
//			System.out.print(_element + " ");
//		}
//
//		if (!_right.isEmpty()){
//			_right.printInOrderTraversal();
//		} else if (!_left.isEmpty()) {
//			System.out.print(_element + " ");
//		}

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

	}

	// TODO: remove
	@Override
	public BST<T> remove(T element) {
		if (_element.compareTo(element) == 0) {  // remove (3 initial cases):
			if (_left.isEmpty() && _right.isEmpty()) // leaf
				return new EmptyBST<>();
			// TODO

		}
		return this; // change such default lines as necessary
	}

	// TODO: findMin
	@Override
	public T findMin() {

		return null; // change such default lines as necessary
	}

	// TODO: replaceRange
	@Override
	public BST<T> replaceRange(T start, T end, T newValue) {

		return this; // change such default lines as necessary
	}

	public BST<T> removeRange(T start, T end) {

		return this; // change such default lines as necessary
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
