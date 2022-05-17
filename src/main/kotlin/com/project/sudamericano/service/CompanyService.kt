package com.project.sudamericano.service

import com.project.sudamericano.model.Company
import com.project.sudamericano.repository.CompanyRepository
import com.project.sudamericano.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service

class CompanyService {

    @Autowired
    lateinit var companyRepository: CompanyRepository

    @Autowired
    lateinit var userRepository: UserRepository

    fun list (): List<Company>{
        return companyRepository.findAll()
    }

    fun getById (id:Long?): Company?{
        return companyRepository.findById(id)
    }

    fun save(company: Company): Company{
        try {
            company.name?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El name no debe ser vacio")
            company.status?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El status no debe ser vacio")
            company.id_user?.takeIf { it > 0 }
                ?: throw Exception("El id_user debe ser mayor a 0")
            userRepository.findById(company.id_user)
                ?: throw Exception("El id ${company.id_user} en user no existe")

            return companyRepository.save(company)
        }
        catch (ex:Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    fun update(company: Company): Company{
        try {
            companyRepository.findById(company.id)
                ?: throw Exception("El id ${company.id} no existe en Sector")
            company.name?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El name no debe ser vacio")
            company.status?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El status no debe ser vacio")
            company.id_user?.takeIf { it > 0 }
                ?: throw Exception("El id_user debe ser mayor a 0")
            userRepository.findById(company.id_user)
                ?: throw Exception("El id ${company.id_user} no existe en User")
            return companyRepository.save(company)
        }
        catch (ex:Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    fun updateOne(company: Company): Company {
        try {
            companyRepository.findById(company.id)
                ?: throw Exception("El id ${company.id} no existe en Sector")
            company.name?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El name no debe ser vacio")
            company.status?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El status no debe ser vacio")
            company.id_user?.takeIf { it > 0 }
                ?: throw Exception("El idUser debe ser mayor a 0")
            userRepository.findById(company.id_user)
                ?: throw Exception("El id ${company.id_user} no existe en User")

            return companyRepository.save(company)
        }
        catch (ex:Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    fun delete (id:Long): Boolean{
        try {
            val response = companyRepository.findById(id)
                ?:throw Exception("El id ${id} no existe en company")
            response.apply {
                companyRepository.deleteById(id)
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