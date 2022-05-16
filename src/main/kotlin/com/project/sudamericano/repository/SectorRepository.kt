package com.project.sudamericano.repository

import com.project.sudamericano.model.Sector
import org.springframework.data.jpa.repository.JpaRepository

interface SectorRepository: JpaRepository<Sector, Long> {

    fun findById(id:Long?): Sector?
}