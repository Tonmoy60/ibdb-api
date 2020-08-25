package com.rookie.ibdbapi.data_handler

import com.rookie.ibdbapi.model.Author
import com.rookie.ibdbapi.model.Banner
import com.rookie.ibdbapi.model.Category
import com.rookie.ibdbapi.repo.*
import net.minidev.json.JSONArray
import net.minidev.json.JSONObject
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import java.util.*

@Repository("realData")
class RealData : DataHandlerInterface {

    @Autowired
    var authorRepository: AuthorRepository? = null
    @Autowired
    var bannerRepository: BannerRepository? = null
    @Autowired
    var bookRepository: BookRepository? = null
    @Autowired
    var categoryRepository: CategoryRepository? = null
    @Autowired
    var sectionRepository: SectionRepository? = null
    @Autowired
    var reviewRepository: ReviewRepository? = null
    @Autowired
    var userRepository: UserRepository? = null

    override fun getBannerById(id: Long): Optional<Banner>? {
        return bannerRepository?.findById(id)
    }

    override fun getAllBanner(): MutableList<Banner>? {
        return bannerRepository?.findAll()
    }

    override fun getSectionById(id: Long): JSONObject? {
        var data = sectionRepository?.findById(id)
        val secObj = JSONObject()

        secObj.put("id", data?.get()?.id)
        secObj.put("title", data?.get()?.title)
        val bookArray: JSONArray = JSONArray()
        for (book in data?.get()?.book!!) {
            val bookObj = JSONObject()

            bookObj.put("id", book.id)
            bookObj.put("title", book.title)
            bookObj.put("author", book.author)
            bookObj.put("details", book.details)
            bookObj.put("rating", book.rating)
            bookObj.put("price", book.price)
            bookObj.put("type", book.type)
            bookObj.put("image_url", book.image_url)
            bookArray.appendElement(bookObj)
        }
        secObj.put("book", bookArray)
        return secObj

    }

    override fun getAllSection(): JSONArray? {
        // fetch all students from database
        val section = sectionRepository?.findAll()

//        val ja = JSONArray()
        val secArray: JSONArray = JSONArray()

        for (s in section!!) {
            val secObj = JSONObject()
            secObj.put("id", s.id)
            secObj.put("title", s.title)
            val bookArray: JSONArray = JSONArray()
            for (b in s.book) {
                val bookObj = JSONObject()
                bookObj.put("id", b.id)
                bookObj.put("title", b.title)
                bookObj.put("author", b.author)
                bookObj.put("details", b.details)
                bookObj.put("rating", b.rating)
                bookObj.put("price", b.price)
                bookObj.put("type", b.type)
                bookObj.put("image_url", b.image_url)
                bookArray.appendElement(bookObj)
            }
            secObj.put("book", bookArray)
            secArray.appendElement(secObj)

        }

        return secArray
    }

    override fun getMyListById(id: Long): JSONObject {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMyLists(): JSONObject {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getBookById(id: Long): JSONObject? {
        var data = bookRepository?.findById(id)
        val bookObj = JSONObject()
        bookObj.put("id", data?.get()?.id)
        bookObj.put("title", data?.get()?.title)
        bookObj.put("details", data?.get()?.details)
        bookObj.put("rating", data?.get()?.rating)
        bookObj.put("price", data?.get()?.price)
        bookObj.put("type", data?.get()?.type)
        bookObj.put("image_url", data?.get()?.image_url)

        val authorObj = JSONObject()
        authorObj.put("id", data?.get()?.author?.id)
        authorObj.put("name", data?.get()?.author?.name)
        authorObj.put("details", data?.get()?.author?.details)
        authorObj.put("rating", data?.get()?.author?.rating)
        authorObj.put("type", data?.get()?.author?.type)
        authorObj.put("image_url", data?.get()?.author?.imageUrl)

        bookObj.put("author",authorObj)

        return bookObj

    }

    override fun getAllBook(): JSONArray? {
        var data = bookRepository?.findAll()
        val bookArray: JSONArray = JSONArray()
        for (book in data!!) {

            val bookObj = JSONObject()
            bookObj.put("id", book?.id)
            bookObj.put("title", book?.title)
            bookObj.put("author", book?.author)
            bookObj.put("details", book?.details)
            bookObj.put("rating", book?.rating)
            bookObj.put("price", book?.price)
            bookObj.put("type", book?.type)
            bookObj.put("image_url", book?.image_url)

            val authorObj = JSONObject()
            authorObj.put("id", book?.author?.id)
            authorObj.put("name", book?.author?.name)
            authorObj.put("details", book?.author?.details)
            authorObj.put("rating", book?.author?.rating)
            authorObj.put("type", book?.author?.type)
            authorObj.put("image_url", book?.author?.imageUrl)

            bookObj.put("author",authorObj)

            bookArray.appendElement(bookObj)
        }

        return bookArray
    }

    override fun getCategoryById(id: Long): Optional<Category>? {
        return categoryRepository?.findById(id)
    }

    override fun getAllCategories(): MutableList<Category>? {
        return categoryRepository?.findAll()
    }

    override fun getAuthorById(id: Long): JSONObject? {
        var data= authorRepository?.findById(id)

        val authorObj = JSONObject()
        authorObj.put("id", data?.get()?.id)
        authorObj.put("name", data?.get()?.name)
        authorObj.put("details", data?.get()?.details)
        authorObj.put("rating", data?.get()?.rating)
        authorObj.put("type", data?.get()?.type)
        authorObj.put("image_url", data?.get()?.imageUrl)

        val bookArray: JSONArray = JSONArray()
        for (book in data?.get()?.books!!){
            val bookObj = JSONObject()
            bookObj.put("id", book?.id)
            bookObj.put("title", book?.title)
            bookObj.put("author", book?.author)
            bookObj.put("details", book?.details)
            bookObj.put("rating", book?.rating)
            bookObj.put("price", book?.price)
            bookObj.put("type", book?.type)
            bookObj.put("image_url", book?.image_url)
            bookArray.appendElement(bookObj)
        }
        authorObj.put("books",bookArray)

        return authorObj
    }

    override fun getAllAuthor(): JSONArray? {
        var data= authorRepository?.findAll()
        var authorArray:JSONArray= JSONArray()
        for (author in data!!){
            val authorObj = JSONObject()
            authorObj.put("id", author?.id)
            authorObj.put("name", author?.name)
            authorObj.put("details", author?.details)
            authorObj.put("rating", author?.rating)
            authorObj.put("type", author?.type)
            authorObj.put("image_url", author?.imageUrl)

            val bookArray: JSONArray = JSONArray()
            for (book in author?.books!!){
                val bookObj = JSONObject()
                bookObj.put("id", book?.id)
                bookObj.put("title", book?.title)
                bookObj.put("author", book?.author)
                bookObj.put("details", book?.details)
                bookObj.put("rating", book?.rating)
                bookObj.put("price", book?.price)
                bookObj.put("type", book?.type)
                bookObj.put("image_url", book?.image_url)
                bookArray.appendElement(bookObj)
            }
            authorObj.put("books",bookArray)

            authorArray.appendElement(authorObj)
        }

        return authorArray
    }

    override fun getReviewById(id: Long): JSONObject? {
        var data = reviewRepository?.findById(id)
        val reviewObj = JSONObject()
        reviewObj.put("id", data?.get()?.id)
        reviewObj.put("comment", data?.get()?.comment)
        reviewObj.put("rating", data?.get()?.rating)
        val userObj = JSONObject()
        userObj.put("id", data?.get()?.user?.id)
        userObj.put("userId", data?.get()?.user?.userid)
        userObj.put("name", data?.get()?.user?.name)
        userObj.put("email", data?.get()?.user?.email)
        userObj.put("password", data?.get()?.user?.password)
        userObj.put("imageUrl", data?.get()?.user?.imageUrl)
        reviewObj.put("user", userObj)

        return reviewObj
    }

    override fun getAllReview(): JSONArray? {
        var data = reviewRepository?.findAll()
        val reviewArray: JSONArray = JSONArray()
        for (r in data!!) {
            val reviewObj = JSONObject()
            reviewObj.put("id", r?.id)
            reviewObj.put("comment", r?.comment)
            reviewObj.put("rating", r?.rating)

            val userObj = JSONObject()
            userObj.put("id", r?.user?.id)
            userObj.put("userId", r?.user?.userid)
            userObj.put("name", r?.user?.name)
            userObj.put("email", r?.user?.email)
            userObj.put("password", r?.user?.password)
            userObj.put("imageUrl", r?.user?.imageUrl)
            reviewObj.put("user", userObj)
            reviewArray.appendElement(reviewObj)
        }

        return reviewArray
    }

    override fun getUserById(id: Long): JSONObject? {
        var data=userRepository?.findById(id)
        val userObj = JSONObject()
        userObj.put("id", data?.get()?.id)
        userObj.put("userId", data?.get()?.userid)
        userObj.put("name", data?.get()?.name)
        userObj.put("email", data?.get()?.email)
        userObj.put("password", data?.get()?.password)
        userObj.put("imageUrl", data?.get()?.imageUrl)

        return userObj
    }


}