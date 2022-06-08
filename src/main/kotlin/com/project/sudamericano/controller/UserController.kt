package com.project.sudamericano.controller

import com.project.sudamericano.dto.UserDto
import com.project.sudamericano.model.User
import com.project.sudamericano.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")

class UserController {
    @Autowired
    lateinit var userService: UserService

    @GetMapping
    fun list(): List<User>{
        return userService.list()
    }

    @GetMapping("/id")
    fun listById(@PathVariable("id") id:Long): User?{
        return userService.getById(id)
    }

/*    @GetMapping("/name/{name}")
    fun listByName (@PathVariable("name") name: String): List<User>?{
        return userService.getByName(name)
    }*/

    @GetMapping("/status/{status}")
    fun listByStatus (@PathVariable("status") status: String): List<User>?{
        return userService.getByStatus(status)
    }

    @PostMapping
    fun save (@RequestBody user: User): User{
        return userService.save(user)
    }

    @PostMapping("/change/status")
    fun updateOtherStatus (@RequestBody userDto: UserDto): String?{
        return userService.updateOtherStatus (userDto)
    }

    @PutMapping
    fun update (@RequestBody user: User): User{
        return userService.update(user)
    }

    @PatchMapping
    fun updateOne (@RequestBody user: User): User{
        return userService.updateOne(user)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return userService.delete(id)
    }
}