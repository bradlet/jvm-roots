package jvm.roots.forestry

import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

fun main(args: Array<String>) {
    val httpClient = HttpClient.newHttpClient()
    val gson = Gson()

    println("Hello Kotlin! ${args.joinToString(separator = " ")}")

    val response = httpClient.send(
        HttpRequest.newBuilder(
            URI("https://dummyjson.com/products")
        ).GET().build(),
        HttpResponse.BodyHandlers.ofString()
    )

    val parsed = gson.fromJson(response.body(), Map::class.java)
    println(parsed.keys)
}
