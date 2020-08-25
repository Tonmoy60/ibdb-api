package com.rookie.ibdbapi.auth


import com.rookie.ibdbapi.auth.AuthRequestBody
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import java.util.*

@Service
class MyUserDetailsService : UserDetailsService {
    //    @Autowired
//    UserRepository userRepository;
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(s: String): UserDetails? {
        val user = AuthRequestBody("shimanto", "ahmed")
        return if (user != null) {
            User(user.username, user.password,
                    ArrayList())
        } else null
    }
}