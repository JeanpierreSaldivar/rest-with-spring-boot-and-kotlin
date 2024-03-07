package pe.com.saldivar.mapper.custom

import org.springframework.stereotype.Service
import pe.com.saldivar.data.vo.v2.PersonVO
import pe.com.saldivar.model.Person
import java.util.*

@Service
class PersonMapper {
    fun mapEntityToVO(person: Person): PersonVO {
        val vo = PersonVO()
        vo.id = person.id
        vo.firstName = person.firstName
        vo.lastName = person.lastName
        vo.birthDay = Date()
        vo.address = person.address
        vo.gender = person.gender
        return vo
    }

    fun mapVOToEntity(person: PersonVO): Person {
        val entity = Person()
        entity.id = person.id
        entity.firstName = person.firstName
        entity.lastName = person.lastName
        //entity.birthDay = person.birthDay
        entity.address = person.address
        entity.gender = person.gender
        return entity
    }
}