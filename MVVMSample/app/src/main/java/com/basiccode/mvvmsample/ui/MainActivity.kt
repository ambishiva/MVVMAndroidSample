package com.basiccode.mvvmsample.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.basiccode.mvvmsample.R
import com.basiccode.mvvmsample.UserDetail
import com.basiccode.mvvmsample.viewmodel.UserDetailViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var userDetailViewModel: UserDetailViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialiseUserDetailViewModel()
        addUserDetailObserver()
    }

    private fun initialiseUserDetailViewModel() {
        userDetailViewModel = ViewModelProvider(this).get(UserDetailViewModel::class.java)
        userDetailViewModel?.getUserDetail()
    }

    private fun addUserDetailObserver() {
        userDetailViewModel?.userDetail?.observe(this, Observer { userDetail ->
            Log.d("User Details Data","Id is ${userDetail.id} , name is ${userDetail.name}")
            populateUserDetails(userDetail)
        })
    }

    private fun populateUserDetails(userDetail: UserDetail?) {
        userName.text = userDetail?.name
        userId.text = userDetail?.id.toString()
        mobileNo.text = userDetail?.mobileNo.toString()
    }
}