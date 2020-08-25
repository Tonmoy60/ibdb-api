package com.rookie.ibdbapi.repo


import com.rookie.ibdbapi.model.Review
import org.springframework.data.jpa.repository.JpaRepository

interface ReviewRepository: JpaRepository<Review, Long> {
}