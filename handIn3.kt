package handIns

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate

//bad android studio om for at kunne importere og bruge
@RequiresApi(Build.VERSION_CODES.O)
fun main() {
    //opgave 1
    val articles = ArrayList<Article>()

    articles.add(Article("Author 1", "Title 1"))
    articles.add(Article("Author 2", "Title 2"))
    articles.add(Article("Author 3", "Title 3"))
    articles.add(Article("Author 4", "Title 4"))
    articles.add(Article("Author 5", "Title 5"))

    articles.forEach { println(it) }
    //opgave 1 slut

    //opgave 2
    val fastFoods = arrayOf(Sandwich(), Pizza(), Burger())

    for (item in fastFoods) {
        println("Fast Food Item: ${item.description()}")
        //opgave 2 slut

        //opgave 3
        val car1 = Car()
        val car2 = Car()

        car1.changeGear(2)
        car1.speedUp(20)
        car1.applyBrakes(5)

        car2.changeGear(3)
        car2.speedUp(30)
        car2.applyBrakes(10)
    }

    //opgave 4
    val post = RedditPosts("My First Post", "JaneDoe")

    println("Title: ${post.getTitle()}")
    println("Author: ${post.getAuthor()}")
    println("Date: ${post.getDate()}")
    println("Balance: ${post.getBalance()}")

    post.upvote()
    println("Balance after upvote: ${post.getBalance()}")
    //opgave 4 slut

//opgave 4.5
    val frontPage = RedditFrontPage()
    frontPage.addSamplePosts()

    frontPage.deletePostByIndex(0)
    frontPage.deletePostByIndex(5)
    //opgave 4.5 slut

    //opgave 5
    val words = listOf("apple", "banana", "apple", "orange", "banana", "apple", "orange", "banana", "apple",
        "banana", "apple", "orange", "banana", "banana", "apple", "orange", "apple", "orange", "banana")

    val frequencyMap = mutableMapOf<String, Int>()

    words.forEach { word ->
        val count = frequencyMap[word] ?: 0
        frequencyMap[word] = count + 1
    }

    frequencyMap.forEach { (word, count) ->
        println("$word: $count")
    }
}
//opgave 5 slut



//opgave 1
class Article(val author: String, val title: String) {
    override fun toString(): String {
        return "Article(Author: '$author', Title: '$title')"
    }
}
//opgave 1

//opgave 2
interface FastFood {
    fun description(): String
}

class Sandwich : FastFood {
    override fun description() = "Sandwich"
}

class Pizza : FastFood {
    override fun description() = "Pizza"
}

class Burger : FastFood {
    override fun description() = "Burger"
}

// opgave 3
interface Vehicle {
    fun changeGear(a: Int)
    fun speedUp(a: Int)
    fun applyBrakes(a: Int)
}


class Car : Vehicle {
    override fun changeGear(a: Int) {
        println("Changing gear to $a")
    }

    override fun speedUp(a: Int) {
        println("Speeding up by $a")
    }

    override fun applyBrakes(a: Int) {
        println("Applying brakes, decreasing speed by $a")
    }
}
//opgave 3 slut

//opgave 4
class RedditPosts(private var title: String, private var author: String) {
    @RequiresApi(Build.VERSION_CODES.O)
    private var date: LocalDate = LocalDate.now()
    private var balance: Int = 1


    fun getTitle() = title
    fun getAuthor() = author
    @RequiresApi(Build.VERSION_CODES.O)
    fun getDate() = date.toString()
    fun getBalance() = balance

    fun setTitle(newTitle: String) {
        title = newTitle
    }

    fun setAuthor(newAuthor: String) {
        author = newAuthor
    }

    fun upvote() {
        balance++
    }

    fun downvote() {
        balance--
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun toString(): String {
        return "RedditPost(title='$title', author='$author', date=$date, balance=$balance)"
    }
}

//opgave 4.5
class RedditFrontPage {
    private val posts: MutableList<RedditPost> = mutableListOf()

    fun deletePostByIndex(index: Int) {
        if (index >= 0 && index < posts.size) {
            posts.removeAt(index)
        } else {
            println("Invalid index: $index")
        }
    }
    fun addSamplePosts() {
        posts.add(RedditPost("First Post", "User1"))
        posts.add(RedditPost("Second Post", "User2"))
    }
}

class RedditPost(private var title: String, private var author: String) {
}
//opgave 4.5 slut

