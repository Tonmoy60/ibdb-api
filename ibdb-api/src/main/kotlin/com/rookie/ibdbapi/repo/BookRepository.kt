package com.rookie.ibdbapi.repo


import com.rookie.ibdbapi.model.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : JpaRepository<Book, Long> {

}