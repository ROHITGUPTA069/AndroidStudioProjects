package com.example.week1_android


// Abstract shape
object Driver {
    @JvmStatic
    fun main(args: Array<String>) {

        val square: Shape = Square(4.0)
        val rectangle: Shape = Rectangle(4.0, 5.0)
        val triangle: Shape = Triangle(9.0, 2.0)

        println(square)
        println(rectangle)
        println(triangle)

        val employee1: Employee = Contractor("John", "Contractor", 123)
        val employee2: Employee = FullTime("Smith", "Full Time", 456)
        val employee3: Employee = Intern("Sara", "Intern", 789)

        println(employee1)
        println(employee2)
        println(employee3)
    }
}

