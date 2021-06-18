package com.shoesyouwant.api.feature.shoes

import com.shoesyouwant.api.feature.brand.Brand
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "shoes")
data class Shoes(@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
                var id: Long? = null,
                 var name: String? = null,
                 var releaseDate: LocalDate? = null,
                 var price: Float? = null,
                 @ManyToOne
                 var brand: Brand? = null)