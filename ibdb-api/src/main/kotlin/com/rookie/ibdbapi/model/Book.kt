package com.rookie.ibdbapi.model

import javax.persistence.*


@Entity
@Table(name = "book")
class Book(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        var id: Long = 0,
        @Column(name = "title")
        var title: String? = null,
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "author_id")
        var author: Author? = null,
        @Column(name = "details")
        var details: String? = null,
        @Column(name = "rating")
        var rating: Double? = null,
        @Column(name = "price")
        var price: Double? = null,
        @Column(name = "type")
        var type: String? = null,
        @Column(name = "image_url")
        var image_url: String? = null,

        @ManyToMany(mappedBy = "book")
        var section: List<Section> = mutableListOf<Section>()


) {

//    override fun toString(): String{
//        return "{book: ${this.title}, subjects: ${section.map { it->it.title }}}";
//    }

    override fun toString(): String {
        return "Book(id=$id, title=$title, author=$author, details=$details, rating=$rating, price=$price, type=$type, image_url=$image_url)"
    }
}