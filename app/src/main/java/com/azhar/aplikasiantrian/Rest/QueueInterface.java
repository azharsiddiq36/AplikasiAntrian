package com.azhar.aplikasiantrian.Rest;


import com.azhar.aplikasiantrian.Model.AlihanResponse;
import com.azhar.aplikasiantrian.Model.AntrianResponse;
import com.azhar.aplikasiantrian.Model.ResponseCall;
import com.azhar.aplikasiantrian.Model.ResponseLayanan;
import com.azhar.aplikasiantrian.Model.ResponseLoket;
import com.azhar.aplikasiantrian.Model.ResponseRecall;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
public interface QueueInterface {
    @GET("api/queue/layanan")
    Call<ResponseLayanan> getListServices();
    @FormUrlEncoded
    @POST("api/queue/loket")
    Call<ResponseLoket> getListLoket(@Field("layanan_id") String services_id);
    @FormUrlEncoded
    @POST("api/queue/getantrian")
    Call<AntrianResponse> getQueueList(@Field("layanan_id") String services_id);
    @GET("Services/call/{loket}")
    Call<ResponseCall> restCall(@Path("loket") String loket);
    @GET("Services/recallTo/{loket}")
    Call<ResponseRecall> restRecall(@Path("loket") String loket);
    @FormUrlEncoded
    @POST("Services/switchApi/{serviceid}")
    Call<AlihanResponse> getAlihan(@Path("serviceid") String services_id,
                                   @Field("nomor")String nomor,
                                   @Field("text")String text,
                                   @Field("suara_awalan")String suara_awalan,
                                   @Field("suara")String suara);

}
