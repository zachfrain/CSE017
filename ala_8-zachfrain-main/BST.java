
public class BST<E extends Comparable<E>> {
	private TreeNode root;
	private int size;

	private class TreeNode {
		E value;
		TreeNode left;
		TreeNode right;

		TreeNode(E val) {
			value = val;
			left = right = null;
		}
	}

	BST() {
		root = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public void clear() {
		root = null;
	}

	public int contains(E item) { //O(n)
		int iterations = 0;
		TreeNode node = root;
		while (node != null) {
			iterations++;
			if (item.compareTo(node.value) < 0) {
				node = node.left;
			} else if (item.compareTo(node.value) > 0) {
				node = node.right;
			} else {
				return iterations;
			}
		}
		return iterations;
	}

	public int add(E item) { //O(n)
		int iterations = 0;
		if (root == null) {
			root = new TreeNode(item);
		} else {
			TreeNode parent, node;
			parent = null;
			node = root;
			while (node != null) {
				iterations++;
				parent = node;
				if (item.compareTo(node.value) < 0) {
					node = node.left;
				} else if (item.compareTo(node.value) > 0) {
					node = node.right;
				} else {
					return iterations;
				}
			}
			if (item.compareTo(parent.value) < 0) {
				parent.left = new TreeNode(item);
			} else {
				parent.right = new TreeNode(item);
			}
		}
		size++;
		return iterations;
	}

	public int remove(E item) { //O(n)
		int iterations = 0;
		TreeNode parent, node;
		parent = null;
		node = root;
		while (node != null) {
			iterations++;
			if (item.compareTo(node.value) < 0) {
				parent = node;
				node = node.left;
			} else if (item.compareTo(node.value) > 0) {
				parent = node;
				node = node.right;
			} else {
				break;
			}
		}
		if (node == null) {
			return iterations;
		}
		if (node.left == null && node.right == null) {
			if (parent == null) {
				root = null;
			} else {
				changeChild(parent, node, null);
			}
		} else if (node.left == null) {
			if (parent == null) {
				root = node.right;
			} else {
				changeChild(parent, node, node.right);
			}
		} else if (node.right == null) {
			if (parent == null) {
				root = node.left;
			} else {
				changeChild(parent, node, node.left);
			}
		} else {
			TreeNode rightMostParent = node;
			TreeNode rightMost = node.left;
			while (rightMost.right != null) {
				iterations++;
				rightMostParent = rightMost;
				rightMost = rightMost.right;
			}
			node.value = rightMost.value;
			changeChild(rightMostParent, rightMost, rightMost.left);
		}
		size--;
		return iterations;
	}

	private void changeChild(TreeNode parent, TreeNode node, TreeNode newChild) {
		if (parent.left == node) {
			parent.left = newChild;
		} else {
			parent.right = newChild;
		}
	}

	public void inorder() {
		inorder(root);
	}

	private void inorder(TreeNode node) {
		if (node != null) {
			inorder(node.left);
			System.out.print(node.value + " ");
			inorder(node.right);
		}
	}

	public void preorder() {
		preorder(root);
	}

	private void preorder(TreeNode node) {
		if (node != null) {
			System.out.print(node.value + " ");
			preorder(node.left);
			preorder(node.right);
		}
	}

	public void postorder() {
		postorder(root);
	}

	private void postorder(TreeNode node) {
		if (node != null) {
			postorder(node.left);
			postorder(node.right);
			System.out.print(node.value + " ");
		}
	}

	// Height Method
	public int height() { // O(n)
		if (this.isEmpty())
			return 0;
		else {
			TreeNode node = root;
			return height(node);
		}
	}

	private int height(TreeNode node) { // O(n)
		if (node == null)
			return -1;

		int leftHeight = height(node.left);
		int rightHeight = height(node.right);

		if (leftHeight > rightHeight)
			return (leftHeight + 1);
		else
			return (rightHeight + 1);
	}

	// isBalanced Method
	public boolean isBalanced() { // O(n) if not balanced, O(log N) if balanced
		if (this.isEmpty())
			return true;
		else {
			TreeNode node = root;
			return isBalanced(node);
		}
	}

	public boolean isBalanced(TreeNode node) { // O(n) if not balanced, O(log N) if balanced
		int heightLeft, heightRight;
		if (node == null)
			return true;

		heightLeft = height(node.left);
		heightRight = height(node.right);

		if (Math.abs(heightLeft - heightRight) <= 1 && isBalanced(node.left) && isBalanced(node.right))
			return true;

		return false;
	}

}
