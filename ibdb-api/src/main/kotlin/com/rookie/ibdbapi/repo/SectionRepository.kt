package com.rookie.ibdbapi.repo


import com.rookie.ibdbapi.model.Section
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SectionRepository : JpaRepository<Section, Long> {

}