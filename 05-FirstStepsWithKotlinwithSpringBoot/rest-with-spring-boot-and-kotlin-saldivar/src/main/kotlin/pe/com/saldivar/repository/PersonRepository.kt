package pe.com.saldivar.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import pe.com.saldivar.data.vo.v1.PersonVO
import pe.com.saldivar.model.Person

@Repository
interface PersonRepository : JpaRepository<Person, Long?>