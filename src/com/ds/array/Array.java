package com.ds.array;

import java.util.Arrays;

public class Array<T> {
    private Object[] array;
    private int count;
    private int capacity;

    public Array() {
        this.array = new Object[1];
        this.count = 0;
        this.capacity = 1;
    }

    public Array(int capacity) {
        this.capacity = capacity;
        this.array = new Object[capacity];
    }

    public T at(int i) {
        @SuppressWarnings("unchecked")
        T elem = (T) array[i];
        return elem;
    }

    public int size() { return this.count; }

    public int capacity() { return this.capacity; }

    public boolean isEmpty() { return this.count == 0; }

    private void growSize() {
        Object[] temp = null;
        if(this.count == this.capacity) {
            temp = new Object[this.capacity * 2];
            if (this.capacity >= 0) System.arraycopy(this.array, 0, temp, 0, this.capacity);
        }
        this.array = temp;
        this.capacity = this.capacity * 2;
    }

    public void push(T item) {
        if(this.count == this.capacity) {
            growSize();
        }
        this.array[count++] = item;
    }

    public void insert(int index, T item) {
        if(this.count == this.capacity)
            growSize();
        if (this.count - index >= 0)
            System.arraycopy(this.array, index, this.array, index + 1, this.count - index);
        this.array[index] = item;
        count++;
    }

    public void prepend(T item) {
        insert(0, item);
    }

    public T pop() throws Exception {
        if(count < 1)
            throw new Exception("No Element Present in the array");
        @SuppressWarnings("unchecked")
        T elem = (T)this.array[this.count - 1];
        this.array[this.count - 1] = 0;
        count--;
        return elem;
    }

    public T delete(int index) {
        if (index >= this.count || index < 0)
            throw new IllegalArgumentException("Wrong index given");
        @SuppressWarnings("unchecked")
        T elem = (T)this.array[index];
        for(int i = index; i < this.count - 1; i++) {
            this.array[i] = this.array[i+1];
        }
        this.array[this.count - 1] = 0;
        count--;
        return elem;
    }

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

    public int find(T item) {
        for(int i = 0; i < this.count; i++) {
            if(this.array[i] == item)
                return i;
        }
        return -1;
    }


    @Override
    public String toString() {
        if(this.count == 0)
            return "The Array is Empty";
//        return Arrays.toString(array);
        String output = "";
        output = "[" + this.at(0);
        for(int i = 1; i < this.count; i++)
            output += ", " + this.at(i);
        output += "]";
        return output;
    }

}
