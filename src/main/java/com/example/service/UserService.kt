package com.example.service

import com.example.mapper.UserMapper
import com.example.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    lateinit var userMapper: UserMapper

    fun validateUser(username: String, password: String): Boolean {
        return userMapper.validateUser(username, password) > 0
    }

    fun saveUserProfile(user: User) {
        userMapper.insertUser(user)
    }
}
