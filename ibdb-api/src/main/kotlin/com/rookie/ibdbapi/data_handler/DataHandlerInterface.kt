package com.rookie.ibdbapi.data_handler

import com.rookie.ibdbapi.model.Author
import com.rookie.ibdbapi.model.Banner
import com.rookie.ibdbapi.model.Category
import java.util.*
import net.minidev.json.JSONArray
import net.minidev.json.JSONObject

interface DataHandlerInterface {

    fun getBannerById(id: Long): Optional<Banner>?

    fun getAllBanner():MutableList<Banner>?

    fun getSectionById(id:Long) : JSONObject?

    fun getAllSection(): JSONArray?

    fun getMyListById(id : Long) :JSONObject?

    fun getMyLists() :JSONObject?

    fun getBookById(id:Long): JSONObject?

    fun getAllBook(): JSONArray?

    fun getCategoryById(id: Long) : Optional<Category>?

    fun getAllCategories():MutableList<Category>?

    fun getAuthorById(id :Long): JSONObject?

    fun getAllAuthor():JSONArray?

    fun getReviewById(id:Long):JSONObject?

    fun getAllReview():JSONArray?

    fun getUserById(id:Long): JSONObject?

}
