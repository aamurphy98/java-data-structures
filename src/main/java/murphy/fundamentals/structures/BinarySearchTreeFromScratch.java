package murphy.fundamentals.structures;

import java.util.ArrayList;

public class BinarySearchTreeFromScratch {

    private Node root;

    public void insert(int i) {
        this.root = insert(this.root, i);
    }

    private Node insert(Node root, int i) {

        if (root == null) {
            root = new Node(i);
            return root;
        }

        if (i < root.data) {
            root.left = insert(root.left, i);
        } else if (i > root.data) {
            root.right = insert(root.right, i);
        } 

        return root;
    }

    public boolean search(int i)  {
        return search(root, i);
    }

    private boolean search(Node root, int i) {
        if (root == null) {
            return false;
        } else if (root.data == i) {
            return true;
        } else if (i < root.data) {
            return search(root.left, i);
        } else {
            return search(root.right, i);
        }
    }
    
    public void delete(int i) {
        this.root = delete(root, i);
    }

    private Node delete(Node root, int i) {
        if (root == null) {
            return root;
        } else if (root.data == i) {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.left == null && root.right != null) {
                root = root.right;
            } else if (root.left != null && root.right == null) {
                root = root.left;
            } else {
                // Find the next inorder Node, which is the smallest value Node below the right child
                root.data = minValue(root.right);
                root.right = delete(root.right, root.data);
            }
        } else if (i < root.data) {
            root.left = delete(root.left, i);
        } else {
            root.right = delete(root.right, i);
        }

        return root;
    }

    private int minValue(Node root) {
        if (root.left != null) {
            return minValue(root.left);
        } else {
            return root.data;
        }
    }

    // L > add > R
    public Integer[] inorder() {
        return inorder(this.root, new ArrayList<Integer>()).toArray(new Integer[0]);
    }

    private ArrayList<Integer> inorder(Node root, ArrayList<Integer> list) {
        if (root != null) {
            list = inorder(root.left, list);
            list.add(root.data);
            list = inorder(root.right, list); 
        }

        return list;
    }

    // add > L > R
    public Integer[] preorder() {
        return preorder(this.root, new ArrayList<Integer>()).toArray(new Integer[0]);
    }

    private ArrayList<Integer> preorder(Node root, ArrayList<Integer> list) {
        if (root != null) {
            list.add(root.data);
            list = preorder(root.left, list);
            list = preorder(root.right, list); 
        }

        return list;
    }

    // L > R > add
    public Integer[] postorder() {
        return postorder(this.root, new ArrayList<Integer>()).toArray(new Integer[0]);
    }

    private ArrayList<Integer> postorder(Node root, ArrayList<Integer> list) {
        if (root != null) {
            list = postorder(root.left, list);
            list = postorder(root.right, list); 
            list.add(root.data);
        }

        return list;
    }

    /**
     * TEST ONLY
     * Test method to manually set the BST structure to verify traversal methods
     */
    public void setRoot(Node root) {
        this.root = root;
    }

    /**
     * Internal node class, public for testing purposes only to verify traversal
     */
    public class Node {
        int data;
        public Node left;
        public Node right;

        public Node(int i) {
            this.data = i;
            this.left = null;
            this.right = null;
        }
    }
}


