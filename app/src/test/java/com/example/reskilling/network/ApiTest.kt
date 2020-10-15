package com.example.reskilling.network

import com.example.reskilling.model.network.SuperHeroeApi
import com.example.reskilling.model.pojos.*
import com.google.common.truth.Truth.assertThat
import com.google.gson.Gson
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiTest {
//aqui estamos inicializando cosas
    //1.lasdeclaro
    lateinit var mMockWebServer: MockWebServer
    lateinit var mSuperHeroesApi : SuperHeroeApi
//2. las iniciliazo
    @Before
    fun setUp() {
    mMockWebServer = MockWebServer()
    val mRetrofit = Retrofit.Builder()
            .baseUrl(mMockWebServer.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    mSuperHeroesApi = mRetrofit.create(SuperHeroeApi::class.java)

    }
    //otro metodo que pasa despues
    @After
    fun shutDown() {
        mMockWebServer.shutdown()
    }

    @Test
    fun getAllSuperHeroes_happy_case() = runBlocking {
        //los test se dividen en tres csas,  lo que le paso lo que tienen que hcare y lo que voy a comprobar

    //paso 1 : given
        val mResulList = listOf<SuperHeroe>(SuperHeroe(Appearance("Yellow", "Male",
                "No Hair", listOf("6'8", "203 cm"), "Human", listOf("980 lb", "441 kg")),
                Biography( listOf("Rick Jones"),"good", "Richard Milhouse Jones",
                        "Hulk Vol 2 #2 (April, 2008) (as A-Bomb)","Richard Milhouse Jones",
                        "Scarsdale, Arizona","Marvel Comics"),
                Connections("sdsd", "null"), 1,
                Images("https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/xs/1-a-bomb.jpg",
                        "sd", "dsd", "sdd"),
                "A-Bomb", Powerstats(1,1,1,1,1,1),
                "sadsd", Work("sdsd", "sdsd")))


mMockWebServer.enqueue(MockResponse().setBody(Gson().toJson(mResulList)))


    //paso 2: when
    val result = mSuperHeroesApi.fetchAllSuperHeroesWithCoroutines()
     //paso 3 : then
     assertThat(result).isNotNull()
val body = result.body()
        assertThat(body).hasSize(1)
        assertThat(body?.get(0)?.id).isEqualTo(1)



    }

}