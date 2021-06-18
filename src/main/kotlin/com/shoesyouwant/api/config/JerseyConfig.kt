package com.shoesyouwant.api.config

import com.shoesyouwant.api.feature.shoes.ShoesResource
import org.glassfish.jersey.server.ResourceConfig
import org.springframework.stereotype.Component

@Component
class JerseyConfig() : ResourceConfig() {
    init {
        register(ShoesResource())
    }
}