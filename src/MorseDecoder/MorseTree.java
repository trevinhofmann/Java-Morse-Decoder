package MorseDecoder;

/**
 * Created with IntelliJ IDEA.
 * User: hofmannt
 * Date: 5/2/14
 * Time: 9:21 AM
 * This class is a Tree for converting morse code to plain characters. It contains each character, and
 * is traversed by going left for a dot and right for a dash.
 */

public class MorseTree<E extends Comparable<E>> {

	/**
	 * The tree's root Node
	 */
	private Node root;

	/**
	 * A Node in the tree
	 * @param <E>
	 */
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

	/**
	 * Adds a character to the tree
	 * @param symbol character to be added
	 * @param code morse code corresponding to the symbol
	 */
	public void add(String symbol, String code){
		Node current = root;
		for (int i=0; i<code.length(); i++){
			if (code.substring(i, i+1) == "."){
				if (current.left == null){
					current.left = new Node(null, null, null);
				}
				current = current.left;
			}
			else if (code.substring(i, i+1) == "-"){
				if (current.right == null){
					current.right = new Node(null, null, null);
				}
				current = current.right;
			}
		}
		current.value = symbol;
	}



}