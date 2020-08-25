package com.rookie.ibdbapi.model

import javax.persistence.*


@Entity
@Table(name="review")
class Review(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        val id: Long=0,
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "user_id")
        var user: User?=null,
        @Column(name = "rating")
        var rating: Double?=null,
        @Column(name = "comment")
        var comment: String?=null

)