package murphy.fundamentals.structures;

/**
 * A custom LinkedList implementation.
 * 
 * Created By: Aaron Murphy
 * Creadted Date: 05/26/2023
 */
public class LinkedListFromScratch {
    
    private int size;
    private Node head;

    public LinkedListFromScratch() {
        this.size = 0;
    }

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

    public void add(int index, String s) throws IndexOutOfBoundsException {
        if (index >= 0 && index < this.size) {
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

    public void clear() {
        this.size = 0;
        this.head = null;
    }

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

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

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

    private class Node {
        String data;
        Node next;

        Node(String s) {
            this.data = s;
        }
    }
}
