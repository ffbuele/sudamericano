package com.project.sudamericano.repository

import com.project.sudamericano.model.Farmacy
import com.project.sudamericano.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface FarmacyRepository: JpaRepository<Farmacy, Long>{

    fun findById(id:Long?): Farmacy?

    @Query(nativeQuery=true)
    fun getListName (@Param("name") name:String?) : List <Farmacy>?
}
