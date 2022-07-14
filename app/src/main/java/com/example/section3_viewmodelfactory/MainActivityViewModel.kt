package com.example.section3_viewmodelfactory
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MainActivityViewModel(startingTotal: Int) : ViewModel() {
    private var count = MutableLiveData<Int>()
    val countTotal : LiveData<Int>
        get() = count

    init{
        count.value = startingTotal
    }

    fun updatedCount(){
        count.value = (count.value)?.plus(1)
    }
}