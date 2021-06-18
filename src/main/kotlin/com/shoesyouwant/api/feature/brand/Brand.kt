package com.shoesyouwant.api.feature.brand

import com.shoesyouwant.api.feature.shoes.Shoes
import javax.persistence.*

@Entity
@Table(name = "brand")
data class Brand(@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
                  var id: Long? = null,
                 var name: String? = null,
                 @OneToMany(mappedBy = "brand")
                  var shoes: List<Shoes> = mutableListOf())