package murphy.fundamentals.structures;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

/**
 * Custom queue implementation utilizing an internal linked list to provide 
 * queue operations.
 * 
 * Created By: Aaron Murphy
 * Created Date: 05/30/2023
 */
public class QueueFromScratch {
    
    private LinkedListFromScratch list;

    QueueFromScratch() {
        this.list = new LinkedListFromScratch();
    }

    public void offer(String s) {
        this.list.add(s);
    }

    public String peek() {
        if (this.isEmpty()) {
            return null;
        } else {
            return this.list.get(0);
        }
    }

    public String poll() {
        if (this.isEmpty()) {
            return null;
        } else {
            return this.list.remove(0);
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
