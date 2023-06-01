package murphy.fundamentals.structures;

/**
 * Custom stack implementation utilizing an internal linked list to provide 
 * stack operations.
 * 
 * Created By: Aaron Murphy
 * Created Date: 05/30/2023
 */
public class StackFromScratch {
    
    private LinkedListFromScratch list;
    private int capacity;

    public StackFromScratch(int capacity) throws Exception {
        if (capacity > 0) {
            this.list = new LinkedListFromScratch();
            this.capacity = capacity;
        } else {
            throw new Exception("Stack capacity must be at least 1");
        }
    }

    public boolean push(String s) {
        if (this.size() < this.capacity) {
            this.list.add(s);
            return true;
        } else {
            return false;
        }
    }

    public String pop() {
        if (!this.isEmpty() && this.size() <= this.capacity) {
            return this.list.remove(this.size() - 1);
        } else {
            return null;
        }
    }

    public String peek() {
        if (!this.isEmpty() && this.size() <= this.capacity) {
            return this.list.get(this.size() - 1);
        } else {
            return null;
        }
    }

    public int size() {
        return this.list.size();
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public boolean contains(String s) {
        return this.list.contains(s);
    }

    public void clear() {
        this.list.clear();
    }

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
