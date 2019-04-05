package com.example.retrofitexample;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {

    /*
    // http://jsonplaceholder.typicode.com/posts
    @GET("posts") // "posts" is a relative URL
    Call<List<Post>> getPosts();*/

    @GET("posts")
    Call<List<Post>> getPosts(@Query("userId") int userId,
                              @Query("_sort") String sort,
                              @Query("_order") String order); // /posts?userId=1

    @GET("posts/{id}/comments")
    Call<List<Comment>> getComments(@Path("id") int postId); // /posts/1/comments

}
