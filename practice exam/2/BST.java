import java.util.NoSuchElementException;

/**
 * Your implementation of a BST.
 */
public class BST<T extends Comparable<? super T>> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private BSTNode<T> root;
    private int size;

    /*
     * Do not add a constructor.
     */

    /**
     * Returns whether or not data matching the given parameter is contained
     * within the tree.
     *
     * This should be done recursively.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * Must be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to search for. You may assume data is never null.
     * @return true if the parameter is contained within the tree, false otherwise.
     */
    public boolean contains(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        return searchData(root,data);
    }
    private boolean searchData(BSTNode<T> node, T data){
        if(node == null){
            return false;
        }else{
            if(data.compareTo(node.getData()) == 0){
                return true;
            }else if(data.compareTo(node.getData()) < 0){
                return searchData(node.getLeft(),data);

            }else{
                return searchData(node.getRight(),data);
            }
        }
    }

    /**
     * Removes and returns the data from the tree matching the given parameter.
     *
     * This must be done recursively.
     *
     * There are 3 cases to consider:
     * 1: The node containing the data is a leaf (no children). In this case,
     * simply remove it.
     * 2: The node containing the data has one child. In this case, simply
     * replace it with its child.
     * 3: The node containing the data has 2 children. Use the SUCCESSOR to
     * replace the data. You should use recursion to find and remove the
     * successor (you will likely need an additional helper method to
     * handle this case efficiently).
     *
     * Do NOT return the same data that was passed in. Return the data that
     * was stored in the tree.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * Must be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to remove. You may assume that data is never null.
     * @return The data that was removed.
     * @throws java.util.NoSuchElementException If the data is not in the tree.
     */
    public T remove(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if(!contains(data)){throw new NoSuchElementException();}
        BSTNode<T> dummy = new BSTNode<>(data);
        root = removeHelper(root,data,dummy);
        size--;
        return dummy.getData();
    }
    private BSTNode<T> removeHelper(BSTNode<T> current,T data, BSTNode<T> dummy){
        if(data.compareTo(current.getData())<0){
            current.setLeft(removeHelper(current.getLeft(),data,dummy));
        }else if(data.compareTo(current.getData())>0){
            current.setRight(removeHelper(current.getRight(),data,dummy));
        }else{
            dummy.setData(current.getData());
            if(current.getLeft() ==null && current.getRight() ==null){
                return null;
            }else if(current.getLeft() != null && current.getRight() ==null){
                return current.getLeft();
            }else if(current.getLeft() == null && current.getRight() !=null){
                return current.getRight();
            }else{
                BSTNode<T> dummy2 = new BSTNode<>(data);
                current.setRight(removeSuccessor(current.getRight(),dummy2));
                current.setData(dummy2.getData());
            }
        }
        return current;
    }
    private BSTNode<T> removeSuccessor(BSTNode<T> current, BSTNode<T> dummy){
        if(current.getLeft() == null){
            dummy.setData(current.getData());
            return current.getRight();
        }else{
            current.setLeft(removeSuccessor(current.getLeft(),dummy));
            return current;
        }
    }


    /**
     * Returns the root of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The root of the tree
     */
    public BSTNode<T> getRoot() {
        // DO NOT MODIFY THIS METHOD!
        return root;
    }

    /**
     * Returns the size of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the tree
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}