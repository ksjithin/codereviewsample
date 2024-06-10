package com.example.mapper

import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Insert
import com.example.model.User

@Mapper
interface UserMapper {

    @Select("SELECT COUNT(*) FROM users WHERE username = #{username} AND password = #{password}")
    fun validateUser(@Param("username") username: String, @Param("password") password: String): Int

    @Insert("INSERT INTO users (username, password) VALUES (#{username}, #{password})")
    fun insertUser(user: User)
}
