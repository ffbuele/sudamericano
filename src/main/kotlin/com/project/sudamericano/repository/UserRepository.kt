package com.project.sudamericano.repository

import com.project.sudamericano.model.Farmacy
import com.project.sudamericano.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface UserRepository: JpaRepository<User, Long> {

    fun findById(id:Long?): User?

    @Query(nativeQuery=true)
    /*fun getListName (@Param("name") name:String?) : List <User>?*/
    fun getListStatus (@Param("status") status:String?) : List <User>?
}