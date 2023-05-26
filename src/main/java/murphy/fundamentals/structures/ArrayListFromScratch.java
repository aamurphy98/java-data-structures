package murphy.fundamentals.structures;

/**
 * A custom ArrayList implementation.
 * 
 * Created By: Aaron Murphy
 * Creadted Date: 05/26/2023
 */
public class ArrayListFromScratch {

    private static final int DEFAULT_CAPACITY = 10;
    private int capacity;
    private int size;
    private String[] elements;

    public ArrayListFromScratch() {
        this.capacity = DEFAULT_CAPACITY;
        this.size = 0;
        this.elements = new String[DEFAULT_CAPACITY];
    }

    public ArrayListFromScratch(int initialCapacity) {
        this.capacity = initialCapacity;
        this.size = 0;
        this.elements = new String[initialCapacity];
    } 
    
    public void add(String s) {
        if (this.size == this.capacity) {
            expandArray();
        }
        this.elements[size] = s;
        this.size++;
    }

    public void add(int index, String s) throws IndexOutOfBoundsException {
        if (index >= 0 && index < this.size) {
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

    public void set(int index, String s) {
        if (index >= 0 && index < size) {
            this.elements[index] = s;
        } else {
            throw new IndexOutOfBoundsException(index);
        }
    }

    public void clear() {
        this.elements = new String[this.capacity];
        this.size = 0;
    }

    public String get(int index) throws IndexOutOfBoundsException {
        if (index >= 0 && index < this.size) {
            return elements[index];
        } else {
            throw new IndexOutOfBoundsException(index);
        }
    }

    public boolean contains(String s) {
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i].equals(s)) {
                return true;
            }
        }

        return false;
    }

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

    public int indexOf(String s) {
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i].equals(s)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(String s) {
        int lastIndex = -1;
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i].equals(s)) {
                lastIndex = i;
            }
        }
        return lastIndex;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

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
     * Returns the internal capacity of the ArrayList
     * 
     * @return the capacity of the ArrayList
     */
    public int getCapacity() {
        return this.capacity;
    }

    /**
     * TEST ONLY
     * Returns the raw array storing the contents of the ArrayList
     * 
     * @return the raw array of Strings
     */
    public String[] getElements() {
        return this.elements;
    }
}