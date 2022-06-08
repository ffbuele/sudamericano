package com.project.sudamericano.controller

import com.project.sudamericano.dto.SectorDto
import com.project.sudamericano.model.Sector
import com.project.sudamericano.service.SectorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/sectors")

class SectorController {
    @Autowired
    lateinit var sectorService: SectorService

    @GetMapping
    fun list(): List<Sector>{
        return sectorService.list()
    }

    @GetMapping("/id")
    fun listById(@PathVariable("id") id:Long): Sector?{
        return sectorService.getById(id)
    }

    @GetMapping("/name/{name}")
    fun listByName (@PathVariable("name") name: String): List<Sector>?{
        return sectorService.getByName(name)
    }

    @PostMapping
    fun save (@RequestBody sector: Sector): Sector{
        return sectorService.save(sector)
    }

    @PostMapping("/change/name")
    fun updateOtherName (@RequestBody sectorDto: SectorDto): String?{
        return sectorService.updateOtherName(sectorDto)
    }

    @PutMapping
    fun update (@RequestBody sector: Sector): Sector{
        return sectorService.update(sector)
    }

    @PatchMapping
    fun updateOne (@RequestBody sector: Sector): Sector{
        return sectorService.updateOne(sector)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return sectorService.delete(id)
    }
}