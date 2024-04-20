package com.sumeyyaterzi.tweetsy.api
import com.sumeyyaterzi.tweetsy.models.TweetListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface TweetsyAPI{

    @GET("/v3/b/65c7b271dc74654018a2fc88?meta=false")
   suspend fun getTweets(@Header("X-JSON-Path") category: String ):Response<List<TweetListItem>>



   @GET("/v3/b/65c7b271dc74654018a2fc88?meta=false")
   @Headers("X-JSON-Path:tweets..category")
   suspend fun getCategories(): Response<List<String>>
}