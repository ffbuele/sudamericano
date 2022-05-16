package com.project.sudamericano.repository

import com.project.sudamericano.model.Farmacy
import com.project.sudamericano.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface FarmacyRepository: JpaRepository<Farmacy, Long>{

    fun findById(id:Long?): Farmacy?

}