import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Your implementation of the pre-order, in-order, and post-order
 * traversals of a tree.
 */
public class Traversals<T extends Comparable<? super T>> {

    /**
     * DO NOT ADD ANY GLOBAL VARIABLES!
     */

    /**
     * Given the root of a binary search tree, generate a
     * pre-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the pre-order traversal of the tree.
     */
    public List<T> preorder(TreeNode<T> root) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        List<T> dataList = new ArrayList<>();
        preorderHelper(dataList, root);
        return dataList;
    }
    private void preorderHelper(List<T> dataList, TreeNode<T> node){
        if (node != null) {
            dataList.add(node.getData());
            preorderHelper(dataList, node.getLeft());
            preorderHelper(dataList, node.getRight());
        }
        return;
    }

    /**
     * Given the root of a binary search tree, generate an
     * in-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the in-order traversal of the tree.
     */
    public List<T> inorder(TreeNode<T> root) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        List<T> dataList = new ArrayList<>();
        inorderHelper(dataList, root);
        return dataList;
    }
    private void inorderHelper(List<T> dataList, TreeNode<T> node){
        if (node != null) {
            inorderHelper(dataList, node.getLeft());
            dataList.add(node.getData());
            inorderHelper(dataList, node.getRight());
        }
        return;

    }

    /**
     * Given the root of a binary search tree, generate a
     * post-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the post-order traversal of the tree.
     */
    public List<T> postorder(TreeNode<T> root) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        List<T> dataList = new ArrayList<>();
        postorderHelper(dataList,root);
        return dataList;
    }
    private void postorderHelper(List<T> dataList, TreeNode<T> node){
        if (node != null) {
            postorderHelper(dataList, node.getLeft());
            postorderHelper(dataList, node.getRight());
            dataList.add(node.getData());
        }
        return;
    }
}