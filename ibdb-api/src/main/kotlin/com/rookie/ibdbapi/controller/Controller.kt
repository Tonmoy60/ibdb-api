package com.rookie.ibdbapi.controller

import com.rookie.ibdbapi.auth.AuthRequestBody
import com.rookie.ibdbapi.auth.AuthenticationResponse

import com.rookie.ibdbapi.auth.JwtUtil
import com.rookie.ibdbapi.auth.MyUserDetailsService
import com.rookie.ibdbapi.data_handler.DataHandlerInterface
import com.rookie.ibdbapi.model.Author
import com.rookie.ibdbapi.model.Banner
import com.rookie.ibdbapi.model.Category
import net.minidev.json.JSONArray
import net.minidev.json.JSONObject
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/")
class Controller :DataHandlerInterface {


    @Autowired
    private val authenticationManager: AuthenticationManager? = null
    @Autowired
    private val jwtTokenUtil: JwtUtil? = null
    @Autowired
    private val userDetailsService: MyUserDetailsService? = null

    @Autowired
    private val controllerService: ControllerService? = null

    @RequestMapping(value = ["/authenticate"], method = [RequestMethod.POST])
    @Throws(Exception::class)
    fun createAuthenticationToken(@RequestBody authenticationRequest: AuthRequestBody): ResponseEntity<*> {
        try {
            authenticationManager!!.authenticate(
                    UsernamePasswordAuthenticationToken(authenticationRequest.username, authenticationRequest.password)
            )
        } catch (e: BadCredentialsException) {
            throw Exception("Incorrect username or password", e)
        }
        val userDetails = authenticationRequest.username?.let {
            userDetailsService
                    ?.loadUserByUsername(it)

        }

        val jwt = userDetails?.let { jwtTokenUtil!!.generateToken(it) }
        return jwt?.let { AuthenticationResponse(it) }?.let { ResponseEntity.ok(it) }!!
    }


    @GetMapping(value = ["/hello"])
    fun hello():String{
        return "Welcome to ibdb project"
    }

    @GetMapping(value = ["/banners/{id}"])
    override fun getBannerById(@PathVariable("id") id: Long): Optional<Banner>? {
        return controllerService?.getBannerById(id)
    }

    @GetMapping(value = ["/banners"])
    override fun getAllBanner(): MutableList<Banner>? {
        return controllerService?.getAllBanner()
    }

    @GetMapping(value = ["/sections/{id}"])
    override fun getSectionById(@PathVariable("id") id: Long): JSONObject? {
        return controllerService?.getSectionById(id)
    }

    @GetMapping(value = ["/sections"])
    override fun getAllSection(): JSONArray? {
        return controllerService?.getAllSection()
    }


    override fun getMyListById(id: Long): JSONObject {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMyLists(): JSONObject {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    @GetMapping(value = ["/books/{id}"])
    override fun getBookById(@PathVariable("id") id: Long): JSONObject? {
        return controllerService?.getBookById(id)
    }

    @GetMapping(value = ["/books"])
    override fun getAllBook(): JSONArray? {
        return controllerService?.getAllBook()
    }

    @GetMapping(value = ["/categories/{id}"])
    override fun getCategoryById(@PathVariable("id") id: Long): Optional<Category>? {
        return controllerService?.getCategoryById(id)
    }

    @GetMapping(value = ["categories"])
    override fun getAllCategories(): MutableList<Category>? {
        return controllerService?.getAllCategories()
    }

    @GetMapping(value = ["/authors/{id}"])
    override fun getAuthorById(@PathVariable("id") id: Long): JSONObject? {
        return controllerService?.getAuthorById(id)
    }

    @GetMapping(value = ["/authors"])
    override fun getAllAuthor(): JSONArray? {
        return controllerService?.getAllAuthor()
    }

    @GetMapping(value = ["/reviews/{id}"])
    override fun getReviewById(@PathVariable("id") id: Long): JSONObject? {
        return controllerService?.getReviewById(id)
    }
    @GetMapping(value = ["/reviews"])
    override fun getAllReview(): JSONArray? {
        return controllerService?.getAllReview()
    }

    @GetMapping(value = ["/users/{id}"])
    override fun getUserById(@PathVariable("id") id: Long): JSONObject? {
        return controllerService?.getUserById(id)
    }

}
