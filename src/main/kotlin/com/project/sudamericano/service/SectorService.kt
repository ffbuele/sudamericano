package com.project.sudamericano.service

import com.project.sudamericano.model.Sector
import com.project.sudamericano.repository.SectorRepository
import com.project.sudamericano.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service

class SectorService {

    @Autowired
    lateinit var sectorRepository: SectorRepository

    @Autowired
    lateinit var userRepository: UserRepository

    fun list (): List<Sector>{
        return sectorRepository.findAll()
    }

    fun getById (id:Long?): Sector?{
        return sectorRepository.findById(id)
    }

    fun save(sector: Sector): Sector{
        try {
            sector.name?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El name no debe ser vacio")
            sector.status?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El status no debe ser vacio")
            sector.id_user?.takeIf { it > 0 }
                ?: throw Exception("El id_user debe ser mayor a 0")
            userRepository.findById(sector.id_user)
                ?: throw Exception("El id ${sector.id_user} no existe en user")

            return sectorRepository.save(sector)
        }
        catch (ex:Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    fun update(sector: Sector): Sector{
        try {
            sectorRepository.findById(sector.id)
                ?: throw Exception("El id ${sector.id} no existe en Sector")
            sector.name?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El name no debe ser vacio")
            sector.status?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El status no debe ser vacio")
            sector.id_user?.takeIf { it > 0 }
                ?: throw Exception("El id_user debe ser mayor a 0")
            userRepository.findById(sector.id_user)
                ?: throw Exception("El id ${sector.id_user} no existe en User")
            return sectorRepository.save(sector)
        }
        catch (ex:Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    fun updateOne(sector: Sector): Sector {
        try {
            sectorRepository.findById(sector.id)
                ?: throw Exception("El id ${sector.id} no existe en Sector")
            sector.name?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El name no debe ser vacio")
            sector.status?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El status no debe ser vacio")
            sector.id_user?.takeIf { it > 0 }
                ?: throw Exception("El id_user debe ser mayor a 0")
            userRepository.findById(sector.id_user)
                ?: throw Exception("El id ${sector.id_user} no existe en User")
            return sectorRepository.save(sector)
        }
        catch (ex:Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    fun delete (id:Long): Boolean{
        try {
            val response = sectorRepository.findById(id)
                ?:throw Exception("El id ${id} no existe en sector")
            response.apply {
                sectorRepository.deleteById(id)
            }
            return true
        }
        catch (ex: Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex
            )
        }
    }
}