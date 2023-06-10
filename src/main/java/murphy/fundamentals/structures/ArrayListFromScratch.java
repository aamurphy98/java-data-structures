package murphy.fundamentals.structures;

/**
 * A custom ArrayList implementation.
 * 
 * Created By: Aaron Murphy
 * Created Date: 05/26/2023
 */
public class ArrayListFromScratch {

    private static final int DEFAULT_CAPACITY = 10;
    private int capacity;
    private int size;
    private String[] elements;

    /**
     * Create a new empty ArrayList, setting the initial capacity to DEFAULT_CAPACITY
     */
    public ArrayListFromScratch() {
        this.capacity = DEFAULT_CAPACITY;
        this.size = 0;
        this.elements = new String[DEFAULT_CAPACITY];
    }

    /**
     * Create a new empty ArrayList
     * 
     * @param initialCapacity the initial capacity of the list before expansion is required
     */
    public ArrayListFromScratch(int initialCapacity) {
        this.capacity = initialCapacity;
        this.size = 0;
        this.elements = new String[initialCapacity];
    } 
    
    /**
     * Adds a new string to the end of the ArrayList, expanding the list if the capacity of 
     * the list has been surpassed
     * 
     * @param s the String to add to the end of the list
     */
    public void add(String s) {
        if (this.size == this.capacity) {
            expandArray();
        }
        this.elements[size] = s;
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
            if (this.size == this.capacity) {
                expandArray();
            }
            for (int i = this.size; i > index; i--) {
                this.elements[i] = this.elements[i - 1];
            }
            this.elements[index] = s;
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
    public void set(int index, String s) throws IndexOutOfBoundsException {
        if (index >= 0 && index < size) {
            this.elements[index] = s;
        } else {
            throw new IndexOutOfBoundsException(index);
        }
    }

    /**
     * Removes all elements from the list, and resets the size to zero
     */
    public void clear() {
        this.elements = new String[this.capacity];
        this.size = 0;
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
            return elements[index];
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
        return this.indexOf(s) != -1; 
    }

    /**
     * Removes the specified string from the list, shifting any elements behind the string to 
     * the left (decreasing the index by one).
     * 
     * @param s the string to remove from the list
     * @return the removed string, or null if the specified string was not found
     */
    public String remove(String s) {
        boolean removed = false;
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i].equals(s)) {
                removed = true;
            }

            if (removed && i < this.size - 1) {
                this.elements[i] = this.elements[i + 1];
            }
        }

        if (removed) {
            this.elements[this.size - 1] = null;
            this.size--;
            return s;
        } else {
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
        if (index >= 0 && index < this.size) {
            String removed = this.elements[index]; 
            if (index == this.size - 1) {
                this.elements[index] = null;
                this.size--; 
            } else {
                for (int i = index; i < this.size - 1; i++) {
                    this.elements[i] = this.elements[i + 1];
                }
                this.elements[this.size - 1] = null;
                this.size--;
            }
            return removed;
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
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i].equals(s)) {
                return i;
            }
        }
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
        int lastIndex = -1;
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i].equals(s)) {
                lastIndex = i;
            }
        }
        return lastIndex;
    }

    /**
     * Returns the number of elements in the list
     * @return the number of elements in the list
     */
    public int size() {
        return this.size;
    }

    /**
     * Returns if the list is empty
     * @return true if the list has zero elements, or false otherwise
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Creates and returns a string representation of the list and its elements
     * @return a string representation of the list
     */
    public String toString() {
        String strung = "[";
        for (int i = 0; i < this.size; i++) {
            strung += this.elements[i];
            if (i < this.size - 1) {
                strung += ", ";
            }
        }
        return strung += "]";
    }

    /**
     * Increases the capacity of the list by creating a new internal array and copying the
     * elements of the list to the new array
     */
    private void expandArray() {
        this.capacity *= 2;
        String[] expandedArray = new String[this.capacity];
        for (int i = 0; i < this.size; i++) {
            expandedArray[i] = this.elements[i];
        }
        this.elements = expandedArray;
    }


    /**
     * TEST ONLY
     * Returns the internal capacity of the list
     * 
     * @return the capacity of the list
     */
    public int getCapacity() {
        return this.capacity;
    }

    /**
     * TEST ONLY
     * Returns the raw array storing the contents of the list
     * 
     * @return the raw array of Strings
     */
    public String[] getElements() {
        return this.elements;
    }
}