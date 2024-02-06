public class Test {
	public static void main(String[] args) {
		BST<Integer> tree = new BST<>();
		Heap<Integer> heap = new Heap<>();
		
		int[] randomNumbers = new int[10000];
		fillArrayRandomNumbers(randomNumbers);
		arrayToBST(randomNumbers, tree);
		arrayToHeap(randomNumbers, heap);
		System.out.println("Random List");
		System.out.println("BST Height: " + tree.height());
		/* BST Height Explanation:
		 * The height for the 'Random List' BST is relatively low because adding values 
		 * at random creates a large tree where there are many breaks and separate paths 
		 * for new values to go to. The height is the amount of levels there are to the
		 * tree, and since the height for the unsorted list is usually around 15-30, that
		 * means the 'levels' all have a ton of different values and it spans out widely.
		 * With each addition to the BST, it's placed at the bottom of the BST.
		 */
		System.out.println("BST isBalanced? " + tree.isBalanced());
		System.out.println("Heap Height: " + heap.height());
		/* Heap Height Explanation:
		 * The height for the 'Random List' Heap should be vaguely similar to the height
		 * of the 'Random List' BST. The Heap's height will always be lesser than or
		 * equal to the height of the BST because the Heap's structure from top to
		 * bottom changes with each addition to the Heap, instead of only the bottom row
		 * changing with each addition, as seen in the BST
		 */
		System.out.println("Heap isBalanced? " + heap.isBalanced());
		
		System.out.println();
		tree.clear();
		heap.clear();
		java.util.Arrays.sort(randomNumbers);
		arrayToBST(randomNumbers, tree);
		arrayToHeap(randomNumbers, heap);
		
		System.out.println("Sorted List:");
		System.out.println("BST Height: " + tree.height());
		/* BST Height Explanation:
		 * The height for the 'Sorted List' BST is very high because of how the add method
		 * in a BST works. Once a number is added to the BST, that numbers position is
		 * essentially locked, so when you use a sorted list each value in increasing 
		 * which means that each new value creates a new level in the BST, which is why
		 * the height is so high for this one
		 */
		System.out.println("BST isBalanced? " + tree.isBalanced());
		System.out.println("Heap Height: " + heap.height());
		/* Heap Height Explanation:
		 * The height of the 'Sorted List' Heap is the same as the 'Random List' Heap
		 * because with the addition of every new value, the entire Heap changes, not
		 * just the bottom row. The order of the list does not matter for Heaps because
		 * of the dynamic properties a heap has
		 */
		System.out.println("Heap isBalanced? " + heap.isBalanced());
	}
	
	public static void fillArrayRandomNumbers(int[] a) {
		for(int i = 0; i < a.length; i++) {
			a[i] = (int)(Math.random()*10000);
		}
	}
	public static void arrayToBST(int[] a, BST<Integer> b) {
		for(int i = 0; i < a.length; i++) {
			b.add(a[i]);
		}
	}
	public static void arrayToHeap(int[] a, Heap<Integer> h) {
		for(int i = 0; i < a.length; i++) {
			h.add(a[i]);
		}
	}
	
	
}
	
	
