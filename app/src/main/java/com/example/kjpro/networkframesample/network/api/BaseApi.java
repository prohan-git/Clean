package com.example.kjpro.networkframesample.network.api;

import com.example.kjpro.networkframesample.model.ZhuangbiImage;
import com.example.kjpro.networkframesample.network.requestBody.PostRequestBody;

import java.util.List;
import java.util.Map;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/****
 * </pre> 
 *  Project_Name:    NetWorkFrameSample
 *  Copyright: 
 *  Version:         1.0.0.1
 *  Created:         Tijun on 2017/8/1 0001 11:40.
 *  E-mail:          prohankj@outlook.com
 *  Desc:            api类，其中的方法分别定义了，补充路径，返回数据类型，请求数据类型
 *                   请求数据类型有多种：
 *                   1：@Query("key") String value     键值对
 *                   2：@QueryMap  Map<String, String> query     键值对Map
 *                   3：@Body PostRequestBody body     body对象
 *                   4：其他很多具体直接参考retorfit
 *
 * </pre>            
 ****/
public interface BaseApi {
    @GET("product/search")
    Observable<List<ZhuangbiImage>> search3(@QueryMap Map<String, String> query);

    @POST("product/search")
    Observable<List<ZhuangbiImage>> search1(@Body PostRequestBody postAction);

    @POST("product/search")
    Observable<List<ZhuangbiImage>> search2(@Query("key") String key, @Query("pageNumber") String pageNumber, @Query("sortField") String sortField);
}
