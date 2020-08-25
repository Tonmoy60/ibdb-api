//package com.rookie.ibdbapi
//
//import com.rookie.ibdbapi.model.*
//import org.springframework.boot.CommandLineRunner
//import org.springframework.boot.autoconfigure.SpringBootApplication
//import org.springframework.data.jpa.repository.config.EnableJpaAuditing
//import kotlin.random.Random
//
//
//@SpringBootApplication
//@EnableJpaAuditing // Enabling JPA Auditing
//class CommandLine : CommandLineRunner {
//
//    var details = "কাল রাত্তির থেকে মেঘের কামাই নেই । কেবলই চলছে বৃষ্টি । গাছগুলো বোকার মতো জবুস্থবু হয়ে রয়েছে । পাখির ডাক বন্ধ । আজ মনে পড়ছে আমার ছেলেবেলাকার সন্ধেবেলা ।\n" +
//            "তখন আমাদের ঐ সময়টা কাটত চাকরদের মহলে । তখনও ইংরেজি শব্দের বানান আর মানে-মুখস্থর বুক-ধড়াস সন্ধেবেলার ঘাড়ে চেপে বসে নি । সেজদাদা বলতেন আগে চাই বাংলা ভাষার গাঁথুনি , তার পরে ইংরেজি শেখার পত্তন । "
//
//    val bookTitles: List<String> = listOf("দেয়াল", "গৌরীপুর জংশন", "ময়ুরাক্ষী", "মেঘের উপর বাড়ি", "গীতাঞ্জলি", "সহজ ক্যালকুলাস")
//    val bookImages: List<String> = listOf("https://images-na.ssl-images-amazon.com/images/I/51OOjWAKi%2BL._SX313_BO1,204,203,200_.jpg", "https://images-na.ssl-images-amazon.com/images/I/51GKn4taVyL._SY346_.jpg", "https://images-na.ssl-images-amazon.com/images/I/41VoTqb3haL._SY346_.jpg", "https://images-na.ssl-images-amazon.com/images/I/418G8IhX22L._SX307_BO1,204,203,200_.jpg", "https://images-na.ssl-images-amazon.com/images/I/51mPtCNLx1L._SX348_BO1,204,203,200_.jpg", "https://images-na.ssl-images-amazon.com/images/I/41YzEgyb2tL._BO1,204,203,200_.jpg")
//    val authorNames: List<String> = listOf("হুমায়ূন আহমেদ", "রবীন্দ্রনাথ ঠাকুর", "কাজী নজরুল ইসলাম", "আবদুল্লাহ্ আবু সায়ীদ", "আসাদ চৌধুরী")
//    val authorImages: List<String> = listOf("https://upload.wikimedia.org/wikipedia/commons/8/85/Humayun_Ahmed_13Nov2010.jpg", "https://upload.wikimedia.org/wikipedia/commons/8/80/Rabindranath_Tagore_unknown_location.jpg", "https://upload.wikimedia.org/wikipedia/commons/a/a6/Nazrul.jpg", "https://upload.wikimedia.org/wikipedia/commons/thumb/e/ee/Abdullah_Abu_Sayeed_%28cropped%29.jpg/1280px-Abdullah_Abu_Sayeed_%28cropped%29.jpg", "https://upload.wikimedia.org/wikipedia/commons/thumb/1/12/Asad_Chowdhury_2010.jpg/1280px-Asad_Chowdhury_2010.jpg")
//    val categoriess: List<String> = listOf("এডভেঞ্চার", "সাহিত্য", "গল্প", "কবিতা", "উপন্যাস")
//    val myListss: List<String> = listOf("ওয়াচ লেটার", "ফেভারিট", "বাংলা", "অনুবাদ", "এডভেঞ্চার")
//    val bannerImages: List<String> = listOf("https://deshiserver.rokomari.store/rokomari110/banner/91d64ca4-32da-45ba-80ac-0dfea3ffecc9.png", "https://deshiserver.rokomari.store/rokomari110/banner/4f47b4b0-756f-4394-8457-bbb05e3a0edf.png", "https://deshiserver.rokomari.store/rokomari110/banner/f66ff055-4b7d-4bbd-b6e7-e6500be19498.png", "https://deshiserver.rokomari.store/rokomari110/banner/858dd184-a313-4bd8-adbd-dc6b99137e46.png", "https://deshiserver.rokomari.store/rokomari110/banner/858dd184-a313-4bd8-adbd-dc6b99137e46.png")
//    var fakeSize = bookTitles.size - 1
//
//    override fun run(vararg args: String?) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    fun getUsers(): List<User> {
//
//        var items = ArrayList<User>()
//
//        repeat(10) {
//
//            var n = Random.nextInt(fakeSize)
//            var item1 = User(1001, "aaa", "aaa", "", authorNames[n], authorImages[n])
//            items.add(item1)
//
//        }
//
//        return items
//    }
//
//    fun getBooks(): List<Book> {
//        var items = ArrayList<Book>()
//        repeat(10) {
//
//            var n = Random.nextInt(fakeSize)
//
//            var item1 = Book(
//                    1001, bookTitles[n], getAuthors()[n], details,
//                    4.5, 0.0, categoriess[n], bookImages[n]
//            )
//            items.add(item1)
//        }
//
//        return items
//    }
//
//
//    fun getAuthors(): List<Author> {
//
//        var items = ArrayList<Author>()
//
//
//        repeat(10) {
//
//            var n = Random.nextInt(fakeSize)
//
//            var item1 = Author(
//                    1001, authorNames[n], details,
//                    4.5, categoriess[n], authorImages[n]
//            )
//            items.add(item1)
//        }
//
//
//        return items
//    }
//
//    fun getCategories(): List<Category> {
//
//        var items = ArrayList<Category>()
//
//        repeat(10) {
//
//            var n = Random.nextInt(fakeSize)
//            var item1 = Category(1001, categoriess[n])
//
//            items.add(item1)
//
//        }
//        return items
//    }
//
////    fun getSections(): List<Section> {
////
////
////        var items = ArrayList<Section>()
////
////        repeat(10) {
////
////            var n = Random.nextInt(fakeSize)
////            var item1 = Section(1,categoriess()[n].title, getBooks())
////
////            items.add(item1)
////
////        }
////        return items
////
////    }
//
//
////    fun getMyLists(): List<Section> {
////
////        var items = ArrayList<Section>()
////
////        for (item in myListss) {
////            items.add(Section(item, getBooks()))
////        }
////
////        return items
////
////    }
//
//    fun getBanners(): List<Banner> {
//
//        var items = ArrayList<Banner>()
//
//        for (item in bannerImages) {
//            items.add(Banner(1, getBooks()[0].title, item, "https://rokomari.com"))
//        }
//
//        return items
//
//    }
//
//    fun getReviews(): List<Review> {
//
//        var items = ArrayList<Review>()
//
//
//        repeat(3) {
//
//            var n = Random.nextInt(fakeSize)
//
//            var item1 = Review(1001, getUsers()[n], 3.5, details)
//            items.add(item1)
//        }
//
//
//        return items
//
//    }
//
//
//}
//
