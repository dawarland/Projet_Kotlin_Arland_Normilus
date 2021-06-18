package com.shoesyouwant.api.feature.brand

import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface IBrandRepository : PagingAndSortingRepository<Brand, Long>