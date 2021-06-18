package com.shoesyouwant.api.feature.shoes

import com.shoesyouwant.api.feature.brand.IBrandRepository
import com.shoesyouwant.api.util.rest.PageDto
import com.shoesyouwant.api.util.rest.PaginationDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.ws.rs.*

@Service
class ShoesService {
    @Autowired
    private lateinit var brandRepository: IBrandRepository
    @Autowired
    private lateinit var shoesRepository: IShoesRepository

    @Transactional(readOnly = true)
    fun getShoes(@PathParam("id") id: Long): ShoesDto {
        return shoesRepository.findById(id).map { ShoesDtoConverter.convert(it) }.orElse(null)
                ?: throw NotFoundException("Shoes $id does not exist")
    }

    @Transactional(readOnly = true)
    fun getAllShoes(pagination: PaginationDto): PageDto<ShoesDto> {
        val page = shoesRepository.findAll(pagination.toPageable())
        return ShoesDtoConverter.convert(page)
    }

    @Transactional
    fun createShoes(dto: ShoesDto): Long? {
        val brandId = dto.brandId ?: throw BadRequestException("Brand id must not be null")
        val brand = brandRepository.findById(brandId).orElse(null)
                ?: throw BadRequestException("Brand ${dto.brandId} does not exist")

        val shoes = Shoes()
        shoes.name = if (dto.name is String) dto.name else "Unknow"  // Smart cast
        shoes.releaseDate = dto.releaseDate
        shoes.price = (dto.price)?.toFloat()
        shoes.brand = brand
        return shoesRepository.save(shoes).id
    }

    @Transactional
    fun updateShoes(@PathParam("id") id: Long, dto: ShoesDto) {
        val shoes = shoesRepository.findById(id).orElse(null)
                ?: throw NotFoundException()

        shoes.name = dto.name
        shoes.releaseDate = dto.releaseDate
        shoes.price = (dto.price)?.toFloat()

        if(dto.brandId != null && dto.brandId == shoes.brand?.id) {
            val brand = brandRepository.findById(dto.brandId!!).orElse(null)
                    ?: throw BadRequestException()
            shoes.brand = brand
        }

        shoesRepository.save(shoes)
    }

    @Transactional
    fun deleteShoes(@PathParam("id") id: Long) {
        val shoes = shoesRepository.findById(id).orElse(null) ?: throw NotFoundException()
        shoesRepository.delete(shoes)
    }
}