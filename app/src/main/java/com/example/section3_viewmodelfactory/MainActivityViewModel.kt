package com.example.section3_viewmodelfactory
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MainActivityViewModel(startingTotal: Int) : ViewModel() {

    private var count = MutableLiveData<Int>()

    // private 변수를 외부에서 참조하는 getter를 갖는 변수 선언
    val countTotal : LiveData<Int>
        get() = count

    init{
        count.value = startingTotal
    }

    // 직접 변수를 관찰할 것이기 때문에 count값을 리턴하는 get()은 필요가 없다.

    fun updatedCount(){
        // 널 체크
        count.value = (count.value)?.plus(1)
    }
}