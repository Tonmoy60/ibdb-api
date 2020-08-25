package com.rookie.ibdbapi.repo


import com.rookie.ibdbapi.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {
}