package com.example.week1_android;

public class practice { // ✅ You must wrap everything in a class

    public static void main(String[] args) {
        practice P = new practice(); // instance of the outer class
        Student student = P.new Student(33, "sjk", "A");

        // Using fields directly
        System.out.println("Roll: " + student.roll);
        System.out.println("Name: " + student.name);
        System.out.println("Section: " + student.Sec);

        // Or using toString()
        System.out.println("Student: " + student); // calls toString() implicitly
    }

    // Non-static inner class
    class Student {
        int roll;
        String name;
        String Sec;

        Student(int roll, String name, String Sec) {
            this.roll = roll;
            this.name = name;
            this.Sec = Sec;
        }

        // Override toString() for clean printing
        @Override
        public String toString() {
            return "Roll: " + roll + ", Name: " + name + ", Section: " + Sec;
        }
    }
}
