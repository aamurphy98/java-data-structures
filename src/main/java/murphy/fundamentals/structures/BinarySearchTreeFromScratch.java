package murphy.fundamentals.structures;

import java.util.ArrayList;

/**
 * Custom binary search tree implementation
 * 
 * Created By: Aaron Murphy
 * Created Date: 06/06/2023
 */
public class BinarySearchTreeFromScratch {

    private Node root;

    /**
     * Add a new integer to the BST
     * 
     * @param i the integer to add
     */
    public void insert(int i) {
        this.root = insert(this.root, i);
    }

    /**
     * Recursively traverse the tree until the location for the integer is found,
     * adding a new Node storing the integer if not already found in the tree
     * 
     * @param root the node to begin to search for the integer
     * @param i the integer to find/add to the tree
     * @return the updated node with the integer added
     */
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

    /**
     * Search for the specified integer in the tree
     * 
     * @param i the integer to search for
     * @return true if the integer exists in the tree, else false
     */
    public boolean search(int i)  {
        return search(root, i);
    }

    /**
     * Recursively traverse the tree until the node containing is found or until the 
     * end of the tree is reached, then return whether or not the integer was found
     * 
     * @param root the node to check for the integer
     * @param i the integer to search for
     * @return true if the node contains the integer, false if the node does not exist
     */
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
    
    /**
     * Search for the specified integer and remove it from the tree, adjusting child
     * nodes of removed integer to maintain the structure of the tree
     * 
     * @param i the integer to remove from the tree
     */
    public void delete(int i) {
        this.root = delete(root, i);
    }

    /**
     * Recursively search for the integer in the tree, removing if found.  If the 
     * removed node has children, re-arrange the child nodes to maintain the structure
     * of the tree
     * 
     * @param root the node to search for the specified integer
     * @param i the integer to remove from the tree
     * @return the updated Node with the specified integer removed the node and its
     *         descendents
     */
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

    /**
     * Recursively determine and return the smallest integer in the subtree consisting of
     * root and its descendents
     * 
     * @param root the Node to search for the minimum value
     * @return the smallest integer within root and its descendents
     */
    private int minValue(Node root) {
        if (root.left != null) {
            return minValue(root.left);
        } else {
            return root.data;
        }
    }

    /**
     * Creates and returns an array representing inorder traversal of the tree
     * 
     * @return an array of integers representing inorder traversal of the tree
     */
    public Integer[] inorder() {
        return inorder(this.root, new ArrayList<Integer>()).toArray(new Integer[0]);
    }

    /**
     * Recursively traverse the tree and populate a list representing inorder traversal
     * of the tree
     * 
     * @param root the root of the current subtree to traverse inorder
     * @param list the list to populate with the integers of the tree inorder
     * @return a populated list containing the node and its descendents integers inorder
     */
    private ArrayList<Integer> inorder(Node root, ArrayList<Integer> list) {
        if (root != null) {
            list = inorder(root.left, list);
            list.add(root.data);
            list = inorder(root.right, list); 
        }

        return list;
    }

    /**
     * Creates and returns an array representing preorder traversal of the tree
     * 
     * @return an array of integers representing preorder traversal of the tree
     */
    public Integer[] preorder() {
        return preorder(this.root, new ArrayList<Integer>()).toArray(new Integer[0]);
    }

    /**
     * Recursively traverse the tree and populate a list representing preorder traversal
     * of the tree
     * 
     * @param root the root of the current subtree to traverse preorder
     * @param list the list to populate with the integers of the tree preorder
     * @return a populated list containing the node and its descendents integers preorder
     */
    private ArrayList<Integer> preorder(Node root, ArrayList<Integer> list) {
        if (root != null) {
            list.add(root.data);
            list = preorder(root.left, list);
            list = preorder(root.right, list); 
        }

        return list;
    }

    /**
     * Creates and returns an array representing postorder traversal of the tree
     * 
     * @return an array of integers representing postorder traversal of the tree
     */
    public Integer[] postorder() {
        return postorder(this.root, new ArrayList<Integer>()).toArray(new Integer[0]);
    }

    /**
     * Recursively traverse the tree and populate a list representing postorder traversal
     * of the tree
     * 
     * @param root the root of the current subtree to traverse postorder
     * @param list the list to populate with the integers of the tree postorder
     * @return a populated list containing the node and its descendents integers postorder
     */
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


