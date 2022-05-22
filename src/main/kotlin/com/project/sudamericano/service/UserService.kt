package com.project.sudamericano.service

import com.project.sudamericano.model.User
import com.project.sudamericano.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import javax.persistence.Id

@Service
class UserService {

    @Autowired
    lateinit var userRepository: UserRepository

    fun list (): List<User>{
        return userRepository.findAll()
    }

    fun getById (id:Long?): User?{
        return userRepository.findById(id)
    }

    fun save(user: User): User{
        try {
            user.name?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El name no debe ser vacio")
            user.last_name?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El last name no debe ser vacio")
            user.phone?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El phone no debe ser vacio")
            user.email?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El email no debe ser vacio")
            user.password?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El password no debe ser vacio")
            user.status?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El status no debe ser vacio")
            return userRepository.save(user)
        }
        catch (ex:Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    fun update(user: User): User{
        try {
            userRepository.findById(user.id)
                ?: throw Exception("El id ${user.id} en user no existe")
            user.name?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El name no debe ser vacio")
            user.last_name?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El last name no debe ser vacio")
            user.phone?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El phone no debe ser vacio")
            user.email?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El email no debe ser vacio")
            user.password?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El password no debe ser vacio")
            user.status?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El status no debe ser vacio")
//            userRepository.findById(user.id)
//                ?: throw Exception("El id ${user.id} en user no existe");
            return userRepository.save(user)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    fun updateOne(user: User): User {
        try {
            userRepository.findById(user.id)
                ?: throw Exception("El id ${user.id} no existe en user")
            user.name?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El name no debe ser vacio")
            user.last_name?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El last name no debe ser vacio")
            user.phone?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El phone no debe ser vacio")
            user.email?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El email no debe ser vacio")
            user.password?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El password no debe ser vacio")
            user.status?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El status no debe ser vacio")
            return userRepository.save(user)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex
            )
        }
    }

    fun delete(id: Long): Boolean{
        try {
            userRepository.findById(id)
                ?: throw Exception("El id ${id} no existe en user")
            userRepository.deleteById(id)

            return true
        }
        catch (ex: Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex
            )
        }
    }
}