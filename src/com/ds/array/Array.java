package com.ds.array;

/**
 * Array class to implement the Dynamic Array
 *@author  Srijan Srivastava
 *@version 1.0.0
 *@since   27th August 2021
 * */
public class Array<T> {
    //***********************
    // FIELDS
    //***********************
    private Object[] array;
    private int count;
    private int capacity;
    //**********************
    // CONSTRUCTORS
    //**********************
    /**
     * Default Constructor; initializes the fields
     * */
    public Array() {
        this.array = new Object[1];
        this.count = 0;
        this.capacity = 1;
    }

    /**
     * Parameterised Constructor to initialize fields
     * @param   capacity    Sets the capacity and initial size of the array.
     *                      Count is still zero
     * */
    public Array(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.array = new Object[capacity];
    }

    //***********************
    // PRIVATE METHODS
    //***********************

    /**
     * Method to increase the size of the array if the array is full and more values are to be added.
     * */
    private void growSize() {
        Object[] temp = null;
        if(this.count == this.capacity) {
            temp = new Object[this.capacity * 2];
            if (this.capacity >= 0) System.arraycopy(this.array, 0, temp, 0, this.capacity);
        }
        this.array = temp;
        this.capacity = this.capacity * 2;
    }

    /**
     * Gets the element at the specified index of the array
     * @param   i       Index from which the element is requried
     * @return  elem    The element present at index i
     * @throws ArrayIndexOutOfBoundsException   When the index value is more
     *                                          than the number of elements.
     * */
    public T at(int i) {
        if(i >= this.count)
            throw new ArrayIndexOutOfBoundsException();
        @SuppressWarnings("unchecked")
        T elem = (T) array[i];
        return elem;
    }

    /**
     * Returns the size of array
     * @return  size of the array
     * */
    public int size() { return this.count; }

    /**
     * Returns the capacity of the array
     * @return  capacity of the array
     * */
    public int capacity() { return this.capacity; }

    /**
     * Returns true if the array is empty
     * @return  true    if array is empty
     *          false   if array is not empty
     * */
    public boolean isEmpty() { return this.count == 0; }

    /**
     * Pushes the element at the end of the array
     * @param   item    Element to push at the end of array
     * */
    public void push(T item) {
        if(this.count == this.capacity) {
            growSize();
        }
        this.array[count++] = item;
    }

    /**
     * Inserts an element at a specified index
     * @param   index   Index at which the element is to be inserted
     * @param   item    Item to be inserted at that index
     * */
    public void insert(int index, T item) {
        if(this.count == this.capacity)
            growSize();
        if (this.count - index >= 0)
            System.arraycopy(this.array, index, this.array, index + 1, this.count - index);
        this.array[index] = item;
        count++;
    }

    /**
     * Insert an element at the top of the array
     * @param   item  Item to be inserted
     * */
    public void prepend(T item) {
        insert(0, item);
    }

    /**
     * Returns the last element of the array
     * @return  elem    Last element of the array
     * */
    public T pop() throws Exception {
        if(count < 1)
            throw new Exception("No Element Present in the array");
        @SuppressWarnings("unchecked")
        T elem = (T)this.array[this.count - 1];
        this.array[this.count - 1] = 0;
        count--;
        return elem;
    }

    /**
     * Returns the element at specified index and shrinks the array
     * @param   index   Index at which the element is required
     * @return  elem    Element at specified index
     * */
    public T delete(int index) {
        if (index >= this.count || index < 0)
            throw new IllegalArgumentException("Wrong index given");
        @SuppressWarnings("unchecked")
        T elem = (T)this.array[index];
        if (this.count - 1 - index >= 0)
            System.arraycopy(this.array, index + 1, this.array, index, this.count - 1 - index);
        this.array[this.count - 1] = 0;
        count--;
        return elem;
    }

    /**
     * Remove the given item (All the occurrences)
     * @param   item    Item to be removed from the element
     * */
    public void remove(T item) {
        Object[] temp = new Object[this.count];
        int index = 0;
        int i;
        for(i = 0; i < this.count; i++) {
            if(this.array[i] != item) {
                temp[index++] = this.array[i];
            }
        }
        this.count = this.count - index + 1;
        this.array = temp;
    }

    /**
     * Find the given item from the array
     * @param   item    Item to be searched in the array
     * @return  The index if the element is found and -1 if not found
     * */
    public int find(T item) {
        for(int i = 0; i < this.count; i++) {
            if(this.array[i] == item)
                return i;
        }
        return -1;
    }

    /**
     * Print the elements of the array
     * @return  The String to be printed when the object is called
     *          in System.out.println OR System.out.print
     * */
    @Override
    public String toString() {
        if(this.count == 0)
            return "The Array is Empty";
        StringBuilder output;
        output = new StringBuilder("[" + this.at(0));
        for(int i = 1; i < this.count; i++)
            output.append(", ").append(this.at(i));
        output.append("]");
        return output.toString();
    }
}
