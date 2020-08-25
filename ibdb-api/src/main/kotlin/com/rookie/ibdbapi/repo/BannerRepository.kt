package com.rookie.ibdbapi.repo


import com.rookie.ibdbapi.model.Banner
import org.springframework.data.jpa.repository.JpaRepository

interface BannerRepository : JpaRepository<Banner, Long> {
}