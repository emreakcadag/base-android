/**
 * Created by Emre Akçadağ on 25.02.2022
 */
sealed class Environment(val baseUrl: String) {

    object Dev : Environment("\"https://api.twitter.com/\"")
    object Prod : Environment("\"https://api.twitter.com/\"")

    companion object {

        const val BASE_URL = "BASE_URL"
    }
}
