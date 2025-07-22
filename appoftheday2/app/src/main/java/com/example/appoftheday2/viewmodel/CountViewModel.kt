package com.example.appoftheday2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class CountViewModel: ViewModel() {

    //livedata (youtube channel)
    private val mutableCountDataLiveData = MutableLiveData<Int>()

    fun getMutableLiveData(): MutableLiveData<Int>{
        return mutableCountDataLiveData
    }

    init{
        mutableCountDataLiveData.value = 0
    }

    fun increment(){
        mutableCountDataLiveData.value = mutableCountDataLiveData.value?.plus(1)
    }

    fun decrement(){
        mutableCountDataLiveData.value = mutableCountDataLiveData.value?.minus(1)
    }

}