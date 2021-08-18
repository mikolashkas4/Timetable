package com.example.timetable.data
import io.reactivex.rxjava3.core.Single
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*


public interface GetListBus {

@FormUrlEncoded
@POST("./lookout_yard/Data/RouteList" )
@Headers("Referer: https://minsktrans.by/lookout_yard/Home/Index/minsk",
"Cookie: pll_language=ru;" +
        " _ym_uid=1629271126558388260; " +
        "_ym_d=1629271126; " +
        "_ym_isad=1; ASP.NET_SessionId=tnbjyoqp3jd0yifnbrgzn3ga; " +
        "__RequestVerificationToken_L2xvb2tvdXRfeWFyZA2=XhXgBgG0zPTtLu-xsoSRAYSl-dQ0rCrp0iFiCtehwuJpNRKE0JWxqiYskya9MIUrkDLs8ft_J64G9M7J_XRiRscucCKzCpW5yamhXWKyPRM1",
"Connection: keep-alive",
"Accept-Encoding: gzip, deflate, br",
"Accept: */*",
"User-Agent: PostmanRuntime/7.28.3",
"Host: <calculated when request is sent>",
"Content-Length: <calculated when request is sent>",
"Content-Type: application/x-www-form-urlencoded",
"Postman-Token: <calculated when request is sent>",
"Cookie: ASP.NET_SessionId=qqdn1rhswwj0al4jiu3lu2ve")
fun getList(@FieldMap params: HashMap<String?, String?>): Single<BusListResponse>



}