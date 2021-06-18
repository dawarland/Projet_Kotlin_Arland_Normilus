package com.shoesyouwant.api.feature.shoes

import java.time.LocalDate

data class ShoesDto(var id: Long? = null,
                    var name: String? = null,
                    var releaseDate: LocalDate? = null,
                    var price: Float? = null,
                    var brandId: Long? = null,
                    var brandName: String? = null)