package com.project.sudamericano.repository

import com.project.sudamericano.model.Farmacy
import com.project.sudamericano.model.Sector
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface SectorRepository: JpaRepository<Sector, Long> {

    fun findById(id:Long?): Sector?

    @Query(nativeQuery=true)
    fun getListName (@Param("name") name:String?) : List <Sector>?

    @Modifying
    @Query(nativeQuery=true)
    fun setOtherName (@Param("name")  name:String?, @Param("newName")  newName:String?) : Integer?
}