package com.example.timetable.data
import com.example.timetable.data.transport.TransportListResponse
import com.example.timetable.data.transport.RouteListResponce
import com.example.timetable.data.schedule.ScheduleResponce
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.*


public interface TimeTableApi {

@FormUrlEncoded
@POST("./lookout_yard/Data/RouteList" )

@Headers("Referer:https://minsktrans.by/lookout_yard/Home/Index/minsk",
    "Cookie:pll_language=ru; " +
            "_ym_uid=1629271126558388260;" +
            " _ym_d=1629271126;" +
            " _ym_isad=1;" +
            " ASP.NET_SessionId=tnbjyoqp3jd0yifnbrgzn3ga;" +
            " __RequestVerificationToken_L2xvb2tvdXRfeWFyZA2=XhXgBgG0zPTtLu-xsoSRAYSl-dQ0rCrp0iFiCtehwuJpNRKE0JWxqiYskya9MIUrkDLs8ft_J64G9M7J_XRiRscucCKzCpW5yamhXWKyPRM1",
    "Connection:keep-alive",
    "Accept-Encoding:gzip, deflate, br",
    "Accept:*/*",
    "Content-Type:application/x-www-form-urlencoded"
)

fun getTransportList(@Field("p") country:String,
                     @Field("tt") transport:String,
                     @Field("__RequestVerificationToken") token:String
): Observable<TransportListResponse>





@FormUrlEncoded
@POST("./lookout_yard/Data/Route")
@Headers("Referer:https://minsktrans.by/lookout_yard/Home/Index/minsk",
    "Cookie:pll_language=ru;" +
            "_ym_uid=1629271126558388260;" +
            "_ym_d=1629271126; _ym_isad=1;" +
            "ASP.NET_SessionId=tnbjyoqp3jd0yifnbrgzn3ga;" +
            "__RequestVerificationToken_L2xvb2tvdXRfeWFyZA2=XhXgBgG0zPTtLu-xsoSRAYSl-dQ0rCrp0iFiCtehwuJpNRKE0JWxqiYskya9MIUrkDLs8ft_J64G9M7J_XRiRscucCKzCpW5yamhXWKyPRM1",
    "Connection:keep-alive",
    "Accept-Encoding:gzip, deflate, br",
    "Accept:*/*",
    "Content-Type:application/x-www-form-urlencoded"
)
fun getListBusStop(@Field("p") country:String,
                   @Field("tt") transport:String,
                   @Field("r") route:String,
                   @Field("__RequestVerificationToken") token:String
): Single<RouteListResponce>

    @FormUrlEncoded
    @POST("./lookout_yard/Data/Schedule")
    @Headers("Referer:https://minsktrans.by/lookout_yard/Home/Index/minsk",
        "Cookie:pll_language=ru;" +
                " _ym_uid=1629271126558388260;" +
                " _ym_d=1629271126; _ym_isad=1;" +
                " ASP.NET_SessionId=tnbjyoqp3jd0yifnbrgzn3ga;" +
                " __RequestVerificationToken_L2xvb2tvdXRfeWFyZA2=XhXgBgG0zPTtLu-xsoSRAYSl-dQ0rCrp0iFiCtehwuJpNRKE0JWxqiYskya9MIUrkDLs8ft_J64G9M7J_XRiRscucCKzCpW5yamhXWKyPRM1",
        "Connection:keep-alive",
        "Accept-Encoding:gzip, deflate, br",
        "Accept:*/*",
        "Content-Type:application/x-www-form-urlencoded"
    )
    fun getTimeTable(@Field("p")country: String,
                     @Field("tt")transport: String,
                     @Field("r")route:String,
                     @Field("s")idBusStop:String,
                     @Field("d")d:Int,
                     @Field("__RequestVerificationToken") token:String
    ): Single<ScheduleResponce>

}