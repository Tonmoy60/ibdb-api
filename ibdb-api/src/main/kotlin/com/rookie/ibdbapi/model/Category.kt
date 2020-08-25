package com.rookie.ibdbapi.model

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "category")
class Category(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        var id: Long=0,
        @Column(name = "title")
        var title: String?=null
){

        override fun toString(): String {
                return "Category(id=$id, title=$title)"
        }
}