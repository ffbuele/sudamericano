package com.project.sudamericano.controller

import com.project.sudamericano.model.Company
import com.project.sudamericano.model.Farmacy
import com.project.sudamericano.service.CompanyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/companies")

class CompanyController {
    @Autowired
    lateinit var companyService: CompanyService

    @GetMapping
    fun list(): List<Company>{
        return companyService.list()
    }

    @GetMapping("/id")
    fun listById(@PathVariable("id") id:Long): Company?{
        return companyService.getById(id)
    }

    @GetMapping("/name/{name}")
    fun listByName (@PathVariable("name") name: String): List<Company>?{
        return companyService.getByName(name)
    }

    @PostMapping
    fun save (@RequestBody company: Company): Company{
        return companyService.save(company)
    }

    @PutMapping
    fun update (@RequestBody company: Company): Company{
        return companyService.update(company)
    }

    @PatchMapping
    fun updateOne (@RequestBody company: Company): Company{
        return companyService.updateOne(company)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return companyService.delete(id)
    }
}