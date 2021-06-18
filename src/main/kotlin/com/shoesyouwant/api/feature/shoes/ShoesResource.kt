package com.shoesyouwant.api.feature.shoes

import com.shoesyouwant.api.util.rest.PageDto
import com.shoesyouwant.api.util.rest.PaginationDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/shoes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Component
class ShoesResource {

    @Autowired
    private lateinit var shoesService: ShoesService

    @GET
    @Path("/{id}")
    fun getShoes(@PathParam("id") id: Long) = shoesService.getShoes(id)

    @GET
    fun getAllShoes(@BeanParam pagination: PaginationDto): PageDto<ShoesDto> = shoesService.getAllShoes(pagination)

    @POST
    fun createShoes(dto: ShoesDto): Long? = shoesService.createShoes(dto)

    @POST
    @Path("/{id}")
    fun updateShoes(@PathParam("id") id: Long, dto: ShoesDto) = shoesService.updateShoes(id, dto)

    @DELETE
    @Path("/{id}")
    fun deleteShoes(@PathParam("id") id: Long) = shoesService.deleteShoes(id)
}