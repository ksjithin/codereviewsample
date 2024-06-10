package com.example.controller

import com.example.model.User
import com.example.service.UserService
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class UserController {

    @Autowired
    lateinit var userService: UserService

    @PostMapping("/login")
    fun login(@RequestParam username: String, @RequestParam password: String): String {
        return if (userService.validateUser(username, password)) {
            "Login successful"
        } else {
            "Invalid credentials"
        }
    }

    @PostMapping("/saveprofile")
    fun saveProfile(@RequestBody body: String): String {
        return try {
            val mapper = ObjectMapper().registerModule(KotlinModule())
            val user = mapper.readValue(body, User::class.java)
            userService.saveUserProfile(user)
            "Profile saved successfully"
        } catch (e: Exception) {
            e.printStackTrace()
            "An error occurred: ${e.message}"
        }
    }

    @GetMapping("/user")
    fun getUser(@RequestParam username: String): String {
        return "Hello, $username"
    }
}
