package murphy.fundamentals.structures;

/**
 * Custom stack implementation utilizing an internal linked list to provide 
 * stack operations.
 * 
 * Created By: Aaron Murphy
 * Created Date: 05/30/2023
 */
public class StackFromScratch {
    
    private static final int DEFAULT_CAPACITY = 10;
    private LinkedListFromScratch list;
    private int capacity;

    /**
     * Create a new empty stack with a capacity of DEFAULT_CAPACITY
     */
    public StackFromScratch() {
        this.capacity = DEFAULT_CAPACITY;
        this.list = new LinkedListFromScratch();
    }

    /**
     * Create a new empty stack with the specified capacity 
     * 
     * @param capacity the maximum number of elements to allow in the stack at once
     * @throws Exception if the capacity is less than one
     */
    public StackFromScratch(int capacity) throws Exception {
        if (capacity > 0) {
            this.list = new LinkedListFromScratch();
            this.capacity = capacity;
        } else {
            throw new Exception("Stack capacity must be at least 1");
        }
    }

    /**
     * Add a new string to the top (highest index) of the stack
     * 
     * @param s the string to add to the stack
     * @return true if the element was added to the stack, or false if the stack is full
     */
    public boolean push(String s) {
        if (this.size() < this.capacity) {
            this.list.add(s);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Fetch and remove the element at the top (highest index) of the stack
     * 
     * @return the top element on the stack
     */
    public String pop() {
        if (!this.isEmpty() && this.size() <= this.capacity) {
            return this.list.remove(this.size() - 1);
        } else {
            return null;
        }
    }

    /**
     * Fetch and return the element at the top (highest index) of the stack without removing
     * 
     * @return the top element on the stack
     */
    public String peek() {
        if (!this.isEmpty() && this.size() <= this.capacity) {
            return this.list.get(this.size() - 1);
        } else {
            return null;
        }
    }

       /**
     * Return the length/size of the stack
     * 
     * @return the number of elements in the stack
     */
    public int size() {
        return this.list.size();
    }

    /**
     * Returns if the stack is empty
     * 
     * @return true if the stack has zero elements, or false otherwise
     */
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    
    /**
     * Searches the stack for a specific string
     * 
     * @param s the string to search for
     * @return true if the string exists as an element in the stack, else false
     */
    public boolean contains(String s) {
        return this.list.contains(s);
    }

    /**
     * Removes all elements from the stack
     */
    public void clear() {
        this.list.clear();
    }

    /**
    *Creates and returns a string representation of the stack and its elements
    * 
    * @return a string representation of the list
    */
    public String toString() {
        return this.list.toString();
    }

    /**
     * TEST ONLY
     * 
     * @return the internal list of elements for verification in unit testing.
     */
    public LinkedListFromScratch getElements() {
        return this.list;
    }

    /**
     * TEST ONLY
     * 
     * @return the internal capacity to limit the addition of elements to the stack for 
     * verification in unit testing
     */
    public int getCapacity() {
        return this.capacity;
    }
}
