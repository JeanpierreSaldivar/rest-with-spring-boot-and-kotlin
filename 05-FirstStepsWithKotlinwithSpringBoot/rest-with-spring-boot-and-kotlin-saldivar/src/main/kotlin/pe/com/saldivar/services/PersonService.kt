package pe.com.saldivar.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import pe.com.saldivar.data.vo.v1.PersonVO
import pe.com.saldivar.data.vo.v2.PersonVO as PersonVOV2
import pe.com.saldivar.exceptions.ResourceNotFoundException
import pe.com.saldivar.mapper.DozerMapper
import pe.com.saldivar.mapper.custom.PersonMapper
import pe.com.saldivar.model.Person
import pe.com.saldivar.repository.PersonRepository
import java.util.logging.Logger

@Service
class PersonService {

    @Autowired
    private  lateinit var repository : PersonRepository

    @Autowired
    private  lateinit var mapper : PersonMapper

    private val logger = Logger.getLogger(PersonService::class.java.name)
    fun finAll(): List<PersonVO> {
        logger.info("Finding all person!")
        val persons = repository.findAll()
        return DozerMapper.parseListObjects(persons, PersonVO::class.java)
    }

    fun finById(id: Long): PersonVO {
        logger.info("Finding one person!")
        val person = repository.findById(id)
            .orElseThrow {
                ResourceNotFoundException("No records found for this ID!")
            }
        return DozerMapper.parseObject(person, PersonVO::class.java)
    }

    fun create(person : PersonVO): PersonVO{
        logger.info("Creating one person with name ${person.firstName}!")
        val entity : Person = DozerMapper.parseObject(person, Person::class.java)
        return DozerMapper.parseObject(repository.save(entity), PersonVO::class.java)
    }

    fun createV2(person : PersonVOV2): PersonVOV2{
        logger.info("Creating one person with name ${person.firstName}!")
        val entity : Person = mapper.mapVOToEntity(person)
        return mapper.mapEntityToVO(repository.save(entity))
    }

    fun update(person : PersonVO) : PersonVO {
        logger.info("Updating one person with ID ${person.id}!")
        val entity = repository.findById(person.id)
            .orElseThrow {
                ResourceNotFoundException("No records found for this ID!")
            }
        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.address = person.address
        entity.gender = person.gender
        return DozerMapper.parseObject(repository.save(entity), PersonVO::class.java)
    }
    fun delete(id : Long){
        logger.info("Creating one person with ID $id!")
        val entity =  repository.findById(id)
            .orElseThrow {
                ResourceNotFoundException("No records found for this ID!")
            }

        repository.delete(entity)
    }

}