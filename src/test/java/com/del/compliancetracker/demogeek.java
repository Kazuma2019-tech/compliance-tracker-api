package com.del.compliancetracker;

// Java program to illustrate
// usage of return keyword
class Geeks {

    // Method with void return type
    void demo(double v) {

        // Condition check
        if (v < 0) {
            System.out.println(v);
            return;
        } else {
            ++v;
        }
    }

    public static void main(String[] args) {

        // Call the method
        new Geeks().demo(-1);

        // Display message to illustrate successful execution
        System.out.println("Program executed successfully");
    }
}