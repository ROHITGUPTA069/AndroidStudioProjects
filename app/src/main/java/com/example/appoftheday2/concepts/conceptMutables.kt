package com.example.appoftheday2.concepts

object conceptMutables {
    @JvmStatic
    fun main(args: Array<String>) {

        val mutableList = mutableListOf(1,2,3) //val means cannot change the variables
        println(mutableList)
        mutableList[0] = 4
        mutableList.add(5)
        println(mutableList)

        val immutableList = listOf(1,2,3)
        println(immutableList)

        val emp1 = Employee.getInstance()
        val emp2 = Employee.getInstance()
        val emp3 = Employee.getInstance()

        //one connection with restapi
    }
}