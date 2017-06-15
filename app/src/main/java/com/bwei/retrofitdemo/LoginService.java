package com.bwei.retrofitdemo;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

import static android.os.Build.VERSION_CODES.M;

/**
 * Created by muhanxi on 17/6/15.
 */

public interface LoginService {



    @GET("Bwei/login?username=11111111111&password=1&postkey=1503d")
    public Call<LoginBean> getLogin();

    // get
//    http://qhb.2dyt.com/Bwei/login
    //GET表示get请求方式  Query 表示请求参数 "username" key
    @GET("Bwei/login")
    public Call<LoginBean> getLogin(@Query("username") String username, @Query("password") String password,@Query("postkey") String postkey );


    //表示get请求方式  QueryMap 把请求参数封装在这个里面
    @GET("Bwei/login")
    public Call<LoginBean> getLoginMap(@QueryMap Map<String,String> map);


    //表示get请求方式  Path 可以改变请求的路径 和请求的参数 但是  @Path("key") 必须和@GET("Bwei/{key}") 一致
    // Bwei/login/1
    @GET("Bwei/{key}")
    public Call<LoginBean> getPath(@Path("key") String type,@QueryMap Map<String,String> map);



    // post
//表示 post请求  Field 请求的参数 FormUrlEncoded 表示用表单提交
    @FormUrlEncoded
    @POST("Bwei/login")
    public Call<LoginBean> postLogin(@Field("username") String username, @Field("password") String password,@Field("postkey") String postkey);


    @FormUrlEncoded
    @POST("Bwei/login")
    public Call<LoginBean> postLoginMap(@FieldMap  Map<String,String> map);





//    Headers可以添加请求头
    @Headers({"customkey:value","customkey1:value1"})
    @POST("Bwei/login")
    public Call<LoginBean> postBody(@Body User user);



    //上传图片

//    Multipart
    @Multipart
    @POST("Bwei/upload")
    public Call<Ret> uploadPhoto(@Part("image") MultipartBody body);



    @Multipart
    @POST("Bwei/upload")
    public Call<Ret> uploadPhoto1(@Part MultipartBody.Part part);


//    @Url 这个注解 表示动态改变请求的接口地址
    @FormUrlEncoded
    @POST
    public Call<LoginBean> loginUrl(@Url String url,@FieldMap Map<String,String> map);




    //


    @GET
    public Call<String> get(@Url String url,@QueryMap Map<String,String> map);


    @FormUrlEncoded
    @POST
    public Call<String> post(@Url String url,@FieldMap Map<String,String> map);



}
