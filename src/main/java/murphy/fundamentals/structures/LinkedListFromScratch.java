package murphy.fundamentals.structures;

/**
 * A custom LinkedList implementation.
 * 
 * Created By: Aaron Murphy
 * Created Date: 05/26/2023
 */
public class LinkedListFromScratch {
    
    private int size;
    private Node head;

    /**
     * Create a new empty LinkedList
     */
    public LinkedListFromScratch() {
        this.size = 0;
    }

    /**
     * Adds a new string to the end of LinkedList
     * 
     * @param s the String to add to the end of the list
     */
    public void add(String s) {
        if (this.head == null) {
            this.head = new Node(s);
        } else {
            Node currentNode = this.head;
            while(currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = new Node(s);
        }
        this.size++;
    }

    /**
     * Adds a new string at the specified index to the list, moving any list elements at 
     * or behind the index one to the right (increasing its index by one)
     * 
     * @param index the index in the list to insert the new String
     * @param s the string to add to the list
     * @throws IndexOutOfBoundsException if the index passed is less than zero or beyond
     *                                   the size of the existing array
     */
    public void add(int index, String s) throws IndexOutOfBoundsException {
        if (index >= 0 && index <= this.size) {
            Node currentNode = this.head;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }
            Node newNode = new Node(s);
            newNode.next = currentNode.next;
            currentNode.next = newNode;
            this.size++;
        } else {
            throw new IndexOutOfBoundsException(index);
        }
    }
    
    /**
     * Sets the list element at the specified index to the String passed in, replacing the 
     * current list element at that index and maintianing the size of the list
     * 
     * @param index the index in the list to set the new String
     * @param s the new String to set in the list at the specified index
     */
    public void set(int index, String s) {
        if (index >= 0 && index < this.size) {
            Node currentNode = this.head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
            currentNode.data = s;
        } else {
            throw new IndexOutOfBoundsException(index);
        }
    }
    
    /**
     * Removes all elements from the list, and resets the size to zero
     */
    public void clear() {
        this.size = 0;
        this.head = null;
    }

    /**
     * Retrieves the list element at the specified index
     * 
     * @param index the index of the desired list element to return
     * @return the String stored at the index in the list
     * @throws IndexOutOfBoundsException if the index passed is not within the bounds of the list
     */
    public String get(int index) throws IndexOutOfBoundsException {
        if (index >= 0 && index < this.size) {
            Node currentNode = this.head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
            return currentNode.data;
        } else {
            throw new IndexOutOfBoundsException(index);
        }
    }

    /**
     * Searches the list for the specified string and returns if the string was found
     * 
     * @param s the string to search for in the list
     * @return true if the list contains the specified string, else false
     */
    public boolean contains(String s) {
        Node currentNode = this.head;
        while (currentNode != null) {
            if (currentNode.data.equals(s)) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    /**
     * Removes the specified string from the list, shifting any elements behind the string to 
     * the left (decreasing the index by one).
     * 
     * @param s the string to remove from the list
     * @return the removed string, or null if the specified string was not found
     */
    public String remove(String s) {
        if (this.head.data.equals(s)) {
            this.head = this.head.next;
            size--;
            return s;
        } else {
            Node currentNode = head.next;
            Node previousNode = head;
            while (currentNode != null) {
                if (currentNode.data.equals(s)) {
                    previousNode.next = currentNode.next;
                    size--;
                    return s;
                }
            }
            return null;
        }
    }

    /**
     * Removes the string at the specified index from the list, shifting any elements behind the
     * string to the left (decreasing the index by one).
     * 
     * @param index the index of the string to remove
     * @return the removed string
     * @throws IndexOutOfBoundsException if the index passed is not within the bounds of the list
     */
    public String remove(int index) throws IndexOutOfBoundsException{
        if (index == 0) {
            String removed = this.head.data;
            this.head = this.head.next;
            this.size--;
            return removed;
        } else if (index > 0 && index < this.size) {
            Node currentNode = this.head;
            Node prevNode = null;
            for (int i = 0; i < index; i++) {
                prevNode = currentNode;
                currentNode = currentNode.next;
            }
            prevNode.next = currentNode.next;
            this.size--;
            return currentNode.data;
        } else {
            throw new IndexOutOfBoundsException(index);
        }
    }

    /**
     * Searches for the specified string and returns the index of the first occurance (lowest
     * index) in the list
     * 
     * @param s the string to find the index of within the list
     * @return the index of the first occurance of the string within the list, or -1 if the 
     *         string is not found
     */
    public int indexOf(String s) {
        int index = 0;
        Node currentNode = this.head;
        do {
            if (currentNode.data.equals(s)) {
                return index;
            }
            index++;
            currentNode = currentNode.next;
        } while (currentNode != null);
        return -1;
    }

    /**
     * Searches for the specified string and returns the index of the last occurance (highest 
     * index) in the list
     * 
     * @param s the string to find the index of within the list
     * @return the index of the last occurance of the string within the list, or -1 if the
     *         string is not found
     */
    public int lastIndexOf(String s) {
        int index = 0;
        int lastIndexOf = -1;
        Node currentNode = this.head;
        do {
            if (currentNode.data.equals(s)) {
                lastIndexOf = index;
            }
            index++;
            currentNode = currentNode.next;
        } while (currentNode != null);
        return lastIndexOf;
    }

    /**
     * Returns the number of elements in the list
     * 
     * @return the number of elements in the list
     */
    public int size() {
        return size;
    }

    /**
     * Returns if the list is empty
     * 
     * @return true if the list has zero elements, or false otherwise
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Creates and returns a string representation of the list and its elements
     * 
     * @return a string representation of the list
     */
    public String toString() {
        String strung = "[";
        Node currentNode = this.head;
        while (currentNode != null) {
            strung += currentNode.data;
            if (currentNode.next != null) {
                strung += ", ";
            }
            currentNode = currentNode.next;
        }
        return strung + "]";
    }

    /**
     * This class represents a single element of the linked list, storing the String and the next Node
     * in the list
     */
    private class Node {
        String data;
        Node next;

        Node(String s) {
            this.data = s;
        }
    }
}
