package com.ds;

import com.ds.array.Array;

/**
 * Main Class to test different implementations of the Data Structure Implemented
 * @author  Srijan Srivastava
 * @version 1.0.0
 * @since   26th August 2021
 * */
public class Main {
    // ****************************
    // PUBLIC METHOD
    // ****************************
    /**
     * Main method that runs the program
     * @param args Unused
     * @throws Exception class
     * */
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
