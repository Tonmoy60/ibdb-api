package com.rookie.ibdbapi.model

import javax.persistence.*

@Entity
@Table(name = "author")
class Author(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        var id: Long=0,
        @Column(name="name")
        var name: String?=null,
        @Column(name="details")
        var details: String?=null,
        @Column(name="rating")
        var rating: Double?=null,
        @Column(name="type")
        var type: String?=null,
        @Column(name="image_url")
        var imageUrl: String?=null,
        @OneToMany(mappedBy = "author", cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
        var books: List<Book> = emptyList()
) {
        override fun toString(): String {
                return "Author(id=$id, name=$name, details=$details, rating=$rating, type=$type, imageUrl=$imageUrl)"
        }
}