package com.project.sudamericano.repository

import com.project.sudamericano.model.Company
import org.springframework.data.jpa.repository.JpaRepository

interface CompanyRepository: JpaRepository<Company, Long> {

    fun findById(id:Long?): Company?
}