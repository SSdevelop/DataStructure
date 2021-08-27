package com.ds;

import com.ds.array.Array;

public class Main {

    public static void main(String[] args) throws Exception {
        Array<Integer> array = new Array<>();
        array.push(1);
        array.push(2);
        array.push(3);
//        array.push(4);
        array.pop();
        array.push(3);
        array.push(3);
        array.push(4);
        array.remove(3);
        System.out.println(array.find(3));
        System.out.println(array);
    }
}
