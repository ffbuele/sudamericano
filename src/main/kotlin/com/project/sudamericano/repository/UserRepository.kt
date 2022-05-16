package com.project.sudamericano.repository

import com.project.sudamericano.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {

    fun findById(id:Long?): User?
}