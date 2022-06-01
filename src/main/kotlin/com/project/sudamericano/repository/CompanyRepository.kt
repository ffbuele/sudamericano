package com.project.sudamericano.repository

import com.project.sudamericano.model.Company
import com.project.sudamericano.model.Farmacy
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface CompanyRepository: JpaRepository<Company, Long> {

    fun findById(id:Long?): Company?

    @Query(nativeQuery=true)
    fun getListName (@Param("name") name:String?) : List <Company>?

    @Modifying
    @Query(nativeQuery=true)
    fun setOtherName (@Param("name")  name:String?, @Param("newName")  newName:String?) : Integer?
}