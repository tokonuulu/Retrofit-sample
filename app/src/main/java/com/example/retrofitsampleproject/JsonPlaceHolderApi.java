package com.example.retrofitsampleproject;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface JsonPlaceHolderApi {

    /**
    * Example of hard-coded queries
    * */
    @GET("posts")
    Call<List<Post>> getPosts(
            @Query("userId") Integer[] userId,
            @Query("_sort") String sort,
            @Query("_order") String order);

    /**
    * Example of query map
    * */
    @GET("posts")
    Call<List<Post>> getPosts(@QueryMap Map<String, String> parameters);

    /**
    * Example of hard-coding paths
    * */
    @GET("posts/{id}/comments")
    Call <List<Comment>> getComments(@Path("id") int postId);

    /**
    * Passing url
    * Can be used for general GET requests (net necessarily for comments)
    * */
    @GET
    Call <List<Comment>> getComments(@Url String url);

    /**
    *  Post gets converted into Json automatically
    *  before getting sent to the server
    * */
    @POST("posts")
    Call <Post> createPost(@Body Post post);

    /**
    * Posting in url format instead of sending Json object
    * */
    @FormUrlEncoded
    @POST("posts")
    Call <Post> createPost(
            @Field("userId") int userId,
            @Field("title") String title,
            @Field("body") String text
    );

    /**
    * Posting in url format using field maps
    * */
    @FormUrlEncoded
    @POST("posts")
    Call <Post> createPost(@FieldMap Map<String, String> fields);


    /**
     * Example put request
     * it completely replaces given post with a new one
     */
    @PUT("posts/{id}")
    Call <Post> putPost(@Path("id") int id, @Body Post post);

    /**
    * Example of patch request
    * it only replaces SOME fields of a post
    * */
    @PATCH("posts/{id}")
    Call <Post> patchPost(@Path("id") int id, @Body Post post);


    /**
     * Example of delete request
     * */
    @DELETE("posts/{id}")
    Call <Post> deletePost(@Path("id") int id);
}
