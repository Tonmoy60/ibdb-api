package com.rookie.ibdbapi.controller



import com.rookie.ibdbapi.data_handler.DataHandlerInterface
import com.rookie.ibdbapi.model.Author
import com.rookie.ibdbapi.model.Banner
import com.rookie.ibdbapi.model.Category
import net.minidev.json.JSONArray
import net.minidev.json.JSONObject
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import java.util.*

@Service
class ControllerService : DataHandlerInterface {

    private var dataHandler: DataHandlerInterface? = null

    @Autowired
    fun authServices(@Qualifier("realData") dataHandler: DataHandlerInterface?) {
        this.dataHandler = dataHandler
    }

    override fun getBannerById(id: Long): Optional<Banner>? {
        return dataHandler?.getBannerById(id)
    }

    override fun getAllBanner(): MutableList<Banner>? {
        return dataHandler?.getAllBanner()
    }

    override fun getSectionById(id: Long): JSONObject? {
        return dataHandler?.getSectionById(id)
    }

    override fun getAllSection(): JSONArray? {
        return dataHandler?.getAllSection()
    }

    override fun getMyListById(id: Long): JSONObject {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMyLists(): JSONObject {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getBookById(id: Long): JSONObject? {
        return dataHandler?.getBookById(id)
    }

    override fun getAllBook(): JSONArray? {
        return dataHandler?.getAllBook()
    }

    override fun getCategoryById(id: Long): Optional<Category>? {
        return dataHandler?.getCategoryById(id)
    }

    override fun getAllCategories(): MutableList<Category>? {
        return dataHandler?.getAllCategories()
    }

    override fun getAuthorById(id: Long): JSONObject? {
        return dataHandler?.getAuthorById(id)
    }

    override fun getAllAuthor(): JSONArray? {
        return dataHandler?.getAllAuthor()
    }

    override fun getReviewById(id: Long): JSONObject? {
        return dataHandler?.getReviewById(id)
    }

    override fun getAllReview(): JSONArray? {
        return dataHandler?.getAllReview()
    }

    override fun getUserById(id: Long): JSONObject? {
        return dataHandler?.getUserById(id)
    }

}