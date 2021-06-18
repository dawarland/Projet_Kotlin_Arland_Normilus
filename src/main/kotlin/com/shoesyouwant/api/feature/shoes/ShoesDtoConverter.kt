package com.shoesyouwant.api.feature.shoes

import com.shoesyouwant.api.util.rest.IDtoConverter

object ShoesDtoConverter : IDtoConverter<Shoes, ShoesDto> {
    override fun convert(entity: Shoes): ShoesDto =
        ShoesDto(id = entity.id,
                name = entity.name,
                releaseDate = entity.releaseDate,
                price = entity.price,
                brandId = entity.brand?.id,
                brandName = entity.brand?.name ?: "")
}