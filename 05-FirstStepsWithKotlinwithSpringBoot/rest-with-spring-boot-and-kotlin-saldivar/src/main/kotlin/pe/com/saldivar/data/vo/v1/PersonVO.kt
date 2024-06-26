package pe.com.saldivar.data.vo.v1

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import com.github.dozermapper.core.Mapping
import org.hibernate.metamodel.RepresentationMode
import org.springframework.hateoas.RepresentationModel
import org.yaml.snakeyaml.representer.Represent

/*@JsonPropertyOrder(
    "id",
    "address",
    "first_name",
    "last_name",
    "gender"
)*/
data class PersonVO(

    @Mapping("id")
    var key : Long = 0,
   // @field:JsonProperty("first_name")
    var firstName : String = "",
   // @field:JsonProperty("last_name")
    var lastName : String = "",
    var address : String = "",
    //@field:JsonIgnore
    var gender : String = "",
): RepresentationModel<PersonVO>()
