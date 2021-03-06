package com.shoesyouwant.api.util.rest

/**
 * Dto used to return paginated collections.
 */
data class PageDto<D>(var result: List<D>, var totalPages: Int, var totalElements: Long)