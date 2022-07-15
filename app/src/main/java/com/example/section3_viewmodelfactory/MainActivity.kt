package com.example.section3_viewmodelfactory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.section3_viewmodelfactory.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var viewModelFactory: MainActivityViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModelFactory = MainActivityViewModelFactory(125)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainActivityViewModel::class.java)

        binding.myViewModel = viewModel

        // 메인 액티비티에서 count의 value를 observe한다.
        // 뷰모델에서 private 변수를 대신 참조할 변수를 사용
        // observe를 통해 countTotal(자동으로 get이 호출되면서 count에 접근)값의 변경을 감지
        // 본문엔 데이터 변경에 따른 로직 처리. 여기서 it은 count의 value
        // get의 역할을 자동으로 수행함
        viewModel.countTotal.observe(this, Observer {
            binding.countText.text = it.toString()
        })
    }
}
