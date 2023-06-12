package murphy.fundamentals.structures;

/**
 * Custom queue implementation utilizing an internal linked list to provide 
 * queue operations.
 * 
 * Created By: Aaron Murphy
 * Created Date: 05/30/2023
 */
public class QueueFromScratch {
    
    private LinkedListFromScratch list;

    /**
     * Create a new empty queue without a capacity
     */
    QueueFromScratch() {
        this.list = new LinkedListFromScratch();
    }

    /**
     * Add a new string to the end of the queue
     * 
     * @param s the string to add
     */
    public void offer(String s) {
        this.list.add(s);
    }

    /**
     * Fetch the element at the beginning of the queue, without removing it from the front of the queue
     * 
     * @return the first element in the queue
     */
    public String peek() {
        if (this.isEmpty()) {
            return null;
        } else {
            return this.list.get(0);
        }
    }

    /**
     * Fetch and remove the element at the beginning of the queue
     * 
     * @return the first element in the queue
     */
    public String poll() {
        if (this.isEmpty()) {
            return null;
        } else {
            return this.list.remove(0);
        }
    }
    
    /**
     * Return the length/size of the queue
     * 
     * @return the number of elements in the queue
     */
    public int size() {
        return this.list.size();
    }

    /**
     * Returns if the queue is empty
     * 
     * @return true if the queue has zero elements, or false otherwise
     */
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    /**
     * Searches the queue for a specific string
     * 
     * @param s the string to search for
     * @return true if the string exists as an element in the queue, else false
     */
    public boolean contains(String s) {
        return this.list.contains(s);
    }

    /**
     * Removes all elements from the queue
     */
    public void clear() {
        this.list.clear();
    }

    /**
    *Creates and returns a string representation of the queue and its elements
    * 
    * @return a string representation of the list
    */
    public String toString() {
        return this.list.toString();
    }

    /**
     * TEST ONLY
     * 
     * @return return the internal list of elements for verification in unit testing.
     */
    public LinkedListFromScratch getElements() {
        return this.list;
    }
}
