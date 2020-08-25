package com.rookie.ibdbapi.model

import javax.persistence.*

@Entity
@Table(name = "user")
class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        var id: Long=0,
        @Column(name="user_id")
        var userid: String?=null,
        @Column(name="name")
        var name: String?=null,
        @Column(name="password")
        var password: String?=null,
        @Column(name="email")
        var email: String?=null,
        @Column(name="image_url")
        var imageUrl: String?=null,
        @OneToMany(mappedBy = "user", cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
        var review: List<Review> = emptyList()
){
        override fun toString(): String{
                return "{id: ${this.id},{userId: ${this.userid},{name: ${this.name},{password: ${this.password},{email: ${this.email},{imageUrl: ${this.imageUrl}, products: ${review.map { it->it.id }}}";
        }
}