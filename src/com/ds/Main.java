package com.ds;

import com.ds.array.Array;

public class Main {

    public static void main(String[] args) {
        Array<Integer> array = new Array<>();
        array.push(1);
        array.push(2);
        array.push(3);
//        array.push(4);
        System.out.println(array + "\n" + array.capacity());
    }
}
