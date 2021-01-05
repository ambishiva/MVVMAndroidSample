package com.basiccode.mvvmsample.repository

import com.basiccode.mvvmsample.UserDetail

object UserDetailRepository {


    fun getUserDetail(id: Int, callback: (UserDetail) -> Unit) {
        callback(UserDetail(name = "Shiva Singhal", id = 1001, mobileNo = 7814293876))
    }
}