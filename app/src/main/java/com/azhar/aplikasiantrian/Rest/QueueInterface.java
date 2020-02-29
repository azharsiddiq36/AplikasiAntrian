package com.azhar.aplikasiantrian.Rest;


import com.azhar.aplikasiantrian.Model.CurrentResponse;
import com.azhar.aplikasiantrian.Model.ResponseCall;
import com.azhar.aplikasiantrian.Model.ResponseLoket;
import com.azhar.aplikasiantrian.Model.ResponseRecall;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
public interface QueueInterface {
//    @GET("api/queue/layanan")
//    Call<ServicesResponse> getListServices();
    @FormUrlEncoded
    @POST("api/queue/antrian")
    Call<CurrentResponse> getQueueList(@Field("loket_id") String services_id);
    @GET("api/queue/loket")
    Call<ResponseLoket> getLoket();
    @GET("Services/callTo/{loket}")
    Call<ResponseCall> restCall(@Path("loket") String loket);
    @GET("Services/recallTo/{loket}")
    Call<ResponseRecall> restRecall(@Path("loket") String loket);
}
