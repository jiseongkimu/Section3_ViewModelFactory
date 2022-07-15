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

        // 라이브데이터는 항상 액티비티, 프래그먼트의 수명주기와 연관되어 있기 때문에
        // 직접 뷰모델의 객체에 lifecycleOwner 제공해야 한다.
        // 따라서 현재 액티비티를 바인딩 객체의 lifecycleOwner로서 설정해줘야 한다.
        // 더이상 observe를 사용하지 않아도 된다.
        binding.lifecycleOwner = this
        binding.myViewModel = viewModel

    }
}
