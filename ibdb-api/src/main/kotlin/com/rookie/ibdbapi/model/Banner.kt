package com.rookie.ibdbapi.model

import org.springframework.data.jpa.domain.AbstractPersistable_.id
import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "banner")
class Banner(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        var id: Long = 0,
        @Column(name = "title")
        var title: String? = null,
        @Column(name = "image_url")
        var imageUrl: String? = null,
        @Column(name = "promo_url")
        var promoUrl: String? = null
)
{

        override fun toString(): String {
                return "Banner(id=$id, title=$title, imageUrl=$imageUrl, promoUrl=$promoUrl)"
        }
}