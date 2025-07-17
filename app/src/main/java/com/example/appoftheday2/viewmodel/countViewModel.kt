package com.example.appoftheday2.viewmodel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class countViewModel: ViewModel() {

    var mutableCountData = MutableLiveData<Int>()

    init{
        mutableCountData.value = 0
    }

    fun increment(){
        mutableCountData.value = mutableCountData.value!! + 1
    }
}