package com.project.sudamericano.controller

import com.project.sudamericano.model.Farmacy
import com.project.sudamericano.service.FarmacyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/farmacies")

class FarmacyController {

    @Autowired
    lateinit var farmacyService: FarmacyService

    @GetMapping
    fun list(): List<Farmacy>{
        return farmacyService.list()
    }

    @GetMapping("/id")
    fun listById(@PathVariable("id") id:Long): Farmacy?{
        return farmacyService.getById(id)
    }

    @GetMapping("/name/{name}")
    fun listByName (@PathVariable("name") name: String): List<Farmacy>?{
        return farmacyService.getByName(name)
    }

    @PostMapping
    fun save (@RequestBody farmacy: Farmacy): Farmacy {
        return farmacyService.save(farmacy)
    }

    @PutMapping
    fun update (@RequestBody farmacy: Farmacy): Farmacy {
        return farmacyService.update(farmacy)
    }

    @PatchMapping
    fun updateOne (@RequestBody farmacy: Farmacy): Farmacy {
        return farmacyService.updateOne(farmacy)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return farmacyService.delete(id)
    }
}