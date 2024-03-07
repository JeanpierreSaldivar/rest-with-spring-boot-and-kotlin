package pe.com.saldivar.mapper

import org.modelmapper.ModelMapper


object DozerMapper {

    //private val mapper : Mapper = DozerBeanMapperBuilder.buildDefault()
    private val mapper : ModelMapper = ModelMapper()

    fun <O,D> parseObject(origen: O, destination: Class<D>?) : D {
        return mapper.map(origen, destination)
    }

    fun <O,D> parseListObjects(origen: List<O>, destination: Class<D>?) : ArrayList<D> {
        val destinationObjects : ArrayList<D> = ArrayList()
        for (o in origen){
            destinationObjects.add(mapper.map(o, destination))
        }
        return destinationObjects
    }
}