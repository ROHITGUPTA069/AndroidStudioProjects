package com.example.appoftheday2.concepts

class Employee private constructor(){
    companion object {
        @Volatile
        private var instance: Employee? = null
        fun getInstance()=
            instance ?: synchronized (this){
                instance ?: Employee(). also { instance = it }
            }
    }
    fun doSomething() = "Doing Something"
}