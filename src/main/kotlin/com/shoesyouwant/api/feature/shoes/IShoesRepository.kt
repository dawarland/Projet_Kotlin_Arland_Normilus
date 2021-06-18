package com.shoesyouwant.api.feature.shoes

import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface IShoesRepository : PagingAndSortingRepository<Shoes, Long>