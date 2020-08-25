package com.rookie.ibdbapi.data_handler

import com.rookie.ibdbapi.data_handler.DataHandlerInterface
import com.rookie.ibdbapi.model.Author
import com.rookie.ibdbapi.model.Banner
import com.rookie.ibdbapi.model.Category
import net.minidev.json.JSONArray
import net.minidev.json.JSONObject
import org.springframework.stereotype.Repository
import java.util.*

@Repository("fakeData")
class FakeData : DataHandlerInterface {

    override fun getBannerById(id: Long): Optional<Banner>? {
        return null
    }

    override fun getAllBanner(): MutableList<Banner>? {
        return null
    }

    override fun getSectionById(id: Long): JSONObject? {
        return null
    }

    override fun getAllSection(): JSONArray? {
        return null
    }

    override fun getMyListById(id: Long): JSONObject? {
        return null
    }

    override fun getMyLists(): JSONObject? {
        return null
    }

    override fun getBookById(id: Long): JSONObject? {
        return null
    }

    override fun getAllBook(): JSONArray? {
        return null
    }

    override fun getCategoryById(id: Long): Optional<Category>? {
        return null
    }

    override fun getAllCategories(): MutableList<Category>? {
        return null
    }

    override fun getAuthorById(id: Long): JSONObject? {
        return null
    }

    override fun getAllAuthor(): JSONArray? {
        return null
    }

    override fun getReviewById(id: Long): JSONObject? {
        return null
    }

    override fun getAllReview(): JSONArray? {
        return null
    }

    override fun getUserById(id: Long): JSONObject? {
        return null
    }
}