package jvm.roots.forestry

import com.google.gson.Gson
import com.sun.net.httpserver.HttpExchange
import com.sun.net.httpserver.HttpHandler
import com.sun.net.httpserver.HttpServer
import java.net.InetSocketAddress
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

    val httpServer = HttpServer.create(InetSocketAddress("localhost", 8080), 0)

    httpServer.createContext("/") { http ->
        val content = "Hello world! ${parsed.keys}"
        http.sendResponseHeaders(200, content.length.toLong())
        http.responseBody.use { it.write(content.toByteArray()) } // `use` to try-with-resources so we close out stream
    }

    httpServer.start()
}
