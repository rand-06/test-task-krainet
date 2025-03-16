package com.example.testtaskkrainet.controller

import com.example.testtaskkrainet.model.User
import com.example.testtaskkrainet.model.dto.CreateUserDto
import com.example.testtaskkrainet.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController (val userService: UserService){
    @GetMapping
    fun getUserById(@RequestParam id: Long) : ResponseEntity<User?> {
        return ResponseEntity.status(HttpStatus.OK).body(
            userService.getUser(id)
        )
    }

    @PostMapping
    fun createNewUser(@RequestBody user: CreateUserDto):ResponseEntity<User>{
        return ResponseEntity.status(HttpStatus.OK).body(
            userService.createUser(user)
        )
    }

    @PatchMapping
    fun editUser(@RequestBody user: User): ResponseEntity<User>{
        return ResponseEntity.status(HttpStatus.OK).body(
            userService.updateUser(user)
        )
    }

    @DeleteMapping
    fun deleteUser(@RequestParam id: Long):ResponseEntity<HttpStatus>{
        userService.deleteUser(id)
        return ResponseEntity(HttpStatus.OK)
    }
}