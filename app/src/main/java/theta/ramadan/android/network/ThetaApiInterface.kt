package theta.ramadan.android.network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST
import theta.ramadan.android.ui.ChatFragment

interface ThetaApiInterface {


    @GET("all")
    fun getAllCountries(): Call<List<ChatFragment.ChatMessage>>

    @POST("login")
    fun loginUser(): Call<ChatFragment.ChatMessage>

    @POST("signup")
    fun userSignUp(): Call<ChatFragment.ChatMessage>


    @POST("logout")
    fun userLogout(): Call<ChatFragment.ChatMessage>

    companion object {
        private var retrofit: Retrofit? = null
        private const val BASE_URL = "https://restcountries.eu/rest/v2/"


        fun getRetrofitInstance(): ThetaApiInterface? {
            if (retrofit == null) {
                // Create New Object for Retrofit

                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            }
            return retrofit?.create(ThetaApiInterface::class.java)
        }
    }

}
