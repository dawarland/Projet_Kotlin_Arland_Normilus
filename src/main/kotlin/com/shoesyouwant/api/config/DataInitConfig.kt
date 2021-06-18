package com.shoesyouwant.api.config

import com.shoesyouwant.api.feature.brand.Brand
import com.shoesyouwant.api.feature.brand.IBrandRepository
import com.shoesyouwant.api.feature.shoes.Shoes
import com.shoesyouwant.api.feature.shoes.IShoesRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.LocalDate

@Configuration
class DataInitConfig {

    @Bean
    fun init(IBrandRepository: IBrandRepository, shoesRepository: IShoesRepository) = CommandLineRunner {
        val nike = Brand(name = "Nike")
        IBrandRepository.save(nike)

        val jordan = Brand(name = "Jordan")
        IBrandRepository.save(jordan)

        val shoesList = listOf(
            Shoes(
                name = "AirForce",
                releaseDate = LocalDate.parse("1991-11-08"),
                price = 120.99f,
                brand = nike
            ),
            Shoes(
                name = "Requin",
                releaseDate = LocalDate.parse("2001-03-08"),
                price = 90f,
                brand = nike
            ),
            Shoes(
                name = "Jordan 1",
                releaseDate = LocalDate.parse("1983-12-17"),
                price = 320.50f,
                brand = jordan
            )
        )

        shoesList.forEach {
            shoesRepository.save(it);
        }
    }
}