package MorseDecoder;

/**
 * Created with IntelliJ IDEA.
 * User: hofmannt
 * Date: 5/2/14
 * Time: 9:21 AM
 * This class is a Tree for converting morse code to plain characters. It contains each character, and
 * is traversed by going left for a dot and right for a dash.
 */

public class MorseTree<E> {

	/**
	 * The tree's root Node
	 */
	private Node root;

	private class Node<E>{

		/**
		 * Left child
		 */
		private Node left;

		/**
		 * Right child
		 */
		private Node right;

		/**
		 * Value of the Node
		 */
		private E value;

		/**
		 * Construct a Node
		 * @param left left child
		 * @param right right child
		 * @param value stored value
		 */
		private Node(Node left, Node right, E value){
			this.left = left;
			this.right = right;
			this.value = value;
		}

	}

	public MorseTree(){
		root = new Node(null, null, null);
	}

}
