package com.example.week1_android.appoftheday;


// blue print of data which represents an employee with employee data
class Employee {

    // data
    String employeeName;
    String employeeType; // fulltime, intern, contractor
    int employeeId;


    // parameter / argument
    Employee(String employeeName, String employeeType, int employeeId) {
        this.employeeType = employeeType;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
    }

    // toString() -> method
    public String toString() {
        return "Employee Name: " + employeeName + "\nEmployee First Character: " + employeeType + "\nEmployee ID: " + employeeId;
    }
}

