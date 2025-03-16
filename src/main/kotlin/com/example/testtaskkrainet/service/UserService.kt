package com.example.testtaskkrainet.service

import com.example.testtaskkrainet.model.User
import com.example.testtaskkrainet.model.dto.CreateUserDto
import com.example.testtaskkrainet.repository.UserRepository
import com.example.testtaskkrainet.tools.*
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UserService (val userRepository: UserRepository) {
    fun createUser(user: CreateUserDto) : User {
        return userRepository.save(user.toUser())
    }

    fun getUser(id: Long) : User? {
        return userRepository.findByIdOrNull(id)
    }

    fun updateUser(user: User) : User? {
        var user0 = userRepository.findByIdOrNull(user.id)?: return null
        user0.name = user.name
        return userRepository.save(user0)
    }

    fun deleteUser(id: Long){
        userRepository.deleteById(id)
    }
}