package com.basiccode.mvvmsample.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.basiccode.mvvmsample.UserDetail
import com.basiccode.mvvmsample.repository.UserDetailRepository

class UserDetailViewModel : ViewModel() {

    val userDetail = MutableLiveData<UserDetail>()

    fun getUserDetail() {
        UserDetailRepository.getUserDetail(1) { userData ->
            userDetail.postValue(userData)
        }
    }
}