package com.example.testtaskkrainet.controller

import com.example.testtaskkrainet.model.User
import com.example.testtaskkrainet.model.dto.CreateUserDto
import com.example.testtaskkrainet.model.dto.ShowUserDto
import com.example.testtaskkrainet.service.UserService
import com.example.testtaskkrainet.tools.*
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController (val userService: UserService){
    @GetMapping
    fun getUserById(@RequestParam id: Long) : ResponseEntity<ShowUserDto?> {
        return ResponseEntity.status(HttpStatus.OK).body(
            userService.getUser(id)?.toShowUserDto()
        )
    }

    @GetMapping("/all")
    fun getAllUsers():ResponseEntity<List<ShowUserDto>>{
        return ResponseEntity.status(HttpStatus.OK).body(
            userService.allUsers().toListOfShowUserDto()
        )
    }

    @PostMapping
    fun createNewUser(@RequestBody user: CreateUserDto):ResponseEntity<ShowUserDto>{
        return ResponseEntity.status(HttpStatus.OK).body(
            userService.createUser(user).toShowUserDto()
        )
    }

    @PatchMapping
    fun editUser(@RequestBody user: User): ResponseEntity<ShowUserDto>{
        return ResponseEntity.status(HttpStatus.OK).body(
            userService.updateUser(user)?.toShowUserDto()
        )
    }

    @DeleteMapping
    fun deleteUser(@RequestParam id: Long):ResponseEntity<HttpStatus>{
        userService.deleteUser(id)
        return ResponseEntity(HttpStatus.OK)
    }
}