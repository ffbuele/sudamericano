package com.project.sudamericano.service

import com.project.sudamericano.model.Farmacy
import com.project.sudamericano.repository.CompanyRepository
import com.project.sudamericano.repository.FarmacyRepository
import com.project.sudamericano.repository.SectorRepository
import com.project.sudamericano.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service

class FarmacyService {

    @Autowired
    lateinit var farmacyRepository: FarmacyRepository

    @Autowired
    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var companyyRepository: CompanyRepository

    @Autowired
    lateinit var sectorRepository: SectorRepository

    fun list (): List<Farmacy>{
        return farmacyRepository  .findAll()
    }

    fun getById (id:Long?): Farmacy?{
        return farmacyRepository  .findById(id)
    }

    fun save(farmacy: Farmacy): Farmacy {
        try {
            farmacy.name?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El name no debe ser vacio")
            farmacy.phone?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El phone no debe ser vacio")
            farmacy.address?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El address no debe ser vacio")
            farmacy.status?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El status no debe ser vacio")
            farmacy.idUser?.takeIf { it > 0 }
                ?: throw Exception("El idUser debe ser mayor a 0")
            farmacy.idCompany?.takeIf { it > 0 }
                ?: throw Exception("El diCompany debe ser mayor a 0")
            farmacy.idSector?.takeIf { it > 0 }
                ?: throw Exception("El idSector debe ser mayor a 0")
            userRepository.findById(farmacy.idUser)
                ?: throw Exception("El id ${farmacy.idUser} no existe en User")
            companyyRepository.findById(farmacy.idCompany)
                ?: throw Exception("El id ${farmacy.idCompany} no existe en Company")
            sectorRepository.findById(farmacy.idSector)
                ?: throw Exception("El id ${farmacy.idSector} no existe en Sector")

            return farmacyRepository.save(farmacy)
        }
        catch (ex:Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    fun update(farmacy: Farmacy): Farmacy {
        try {
            farmacyRepository .findById(farmacy.id)
                ?: throw Exception("El id ${farmacy.id} no existe en Farmacy")
            farmacy.name?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El name no debe ser vacio")
            farmacy.phone?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El phone no debe ser vacio")
            farmacy.address?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El address no debe ser vacio")
            farmacy.status?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El status no debe ser vacio")
            farmacy.idUser?.takeIf { it > 0 }
                ?: throw Exception("El idUser debe ser mayor a 0")
            farmacy.idCompany?.takeIf { it > 0 }
                ?: throw Exception("El diCompany debe ser mayor a 0")
            farmacy.idSector?.takeIf { it > 0 }
                ?: throw Exception("El idSector debe ser mayor a 0")
            userRepository.findById(farmacy.idUser)
                ?: throw Exception("El id ${farmacy.idUser} no existe en User")
            companyyRepository.findById(farmacy.idCompany)
                ?: throw Exception("El id ${farmacy.idCompany} no existe en Company")
            sectorRepository.findById(farmacy.idSector)
                ?: throw Exception("El id ${farmacy.idSector} no existe en Sector")
            return farmacyRepository.save(farmacy)
        }
        catch (ex:Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    fun updateOne(farmacy: Farmacy): Farmacy {
        try {
            farmacyRepository .findById(farmacy.id)
                ?: throw Exception("El id ${farmacy.id} no existe en Farmacy")
            farmacy.name?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El name no debe ser vacio")
            farmacy.phone?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El phone no debe ser vacio")
            farmacy.address?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El address no debe ser vacio")
            farmacy.status?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El status no debe ser vacio")
            farmacy.idUser?.takeIf { it > 0 }
                ?: throw Exception("El idUser debe ser mayor a 0")
            farmacy.idCompany?.takeIf { it > 0 }
                ?: throw Exception("El diCompany debe ser mayor a 0")
            farmacy.idSector?.takeIf { it > 0 }
                ?: throw Exception("El idSector debe ser mayor a 0")
            userRepository.findById(farmacy.idUser)
                ?: throw Exception("El id ${farmacy.idUser} no existe en User")
            companyyRepository.findById(farmacy.idCompany)
                ?: throw Exception("El id ${farmacy.idCompany} no existe en Company")
            sectorRepository.findById(farmacy.idSector)
                ?: throw Exception("El id ${farmacy.idSector} no existe en Sector")
            return farmacyRepository.save(farmacy)
        }
        catch (ex:Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    fun delete (id:Long): Boolean{
        try {
            val response = farmacyRepository.findById(id)
                ?:throw Exception("El id ${id} no existe en farmacy")
            response.apply {
                farmacyRepository.deleteById(id)
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