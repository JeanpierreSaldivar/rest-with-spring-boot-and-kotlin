package pe.com.saldivar.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import pe.com.saldivar.data.vo.v1.PersonVO
import pe.com.saldivar.data.vo.v2.PersonVO as PersonVOV2
import pe.com.saldivar.services.PersonService
import pe.com.saldivar.util.MediaType

@RestController
@RequestMapping("api/person/v1")
class PersonController {

    @Autowired
    private lateinit var service : PersonService
    // var service : PersonService = PersonService()

    @GetMapping(produces = [MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML])
    fun finAll(): List<PersonVO> {
        return service.findAll()
    }

    @GetMapping(value= ["/{id}"],produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,MediaType.APPLICATION_YML])
    fun finById(
        @PathVariable(value = "id") id: Long,
    ): PersonVO {
        return service.findById(id)
    }

    @PostMapping(
        consumes = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,MediaType.APPLICATION_YML],
        produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,MediaType.APPLICATION_YML])
    fun create(
        @RequestBody person: PersonVO
    ): PersonVO {
        return service.create(person)
    }

    @PostMapping(value= ["/v2"],
        consumes = [MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML],
        produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,MediaType.APPLICATION_YML])
    fun createV2(
        @RequestBody person: PersonVOV2
    ): PersonVOV2 {
        return service.createV2(person)
    }

    @PutMapping(
        consumes = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,MediaType.APPLICATION_YML],
        produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,MediaType.APPLICATION_YML])
    fun update(
        @RequestBody person: PersonVO
    ): PersonVO {
        return service.update(person)
    }

    @DeleteMapping(value= ["/{id}"],
        produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,MediaType.APPLICATION_YML])
    fun delete(
        @PathVariable(value = "id") id: Long,
    ): ResponseEntity<Any> {
        service.delete(id)
        return ResponseEntity.noContent().build<Any>()
    }
}