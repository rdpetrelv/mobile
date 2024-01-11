package com.laundryapp.service

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.security.SecureRandom
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import javax.net.ssl.SSLContext
import javax.net.ssl.X509TrustManager

class ApiServiceForMachines {
    object ApiServicesForMachines {
        const val API_USERNAME = "user"
        const val API_PASSWORD = "myPassword"

        val machinesApiService : MachinesApiService by lazy {
            val client = ApiServicesForMachines.getUnsafeOkHttpClient()
                .addInterceptor(BasicAuthInterceptor(
                    ApiService.ApiServices.API_USERNAME,
                    ApiService.ApiServices.API_PASSWORD
                ))
                .build()

            Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create())
                .client(client)
                //.baseUrl("https://automacorp.devmind.cleverapps.io/api/")
                .baseUrl("https://laundryapp.cleverapps.io/api/")
                .build()
                .create(MachinesApiService::class.java)
        }

        private fun getUnsafeOkHttpClient(): OkHttpClient.Builder =
            OkHttpClient.Builder().apply {
                val trustManager = object : X509TrustManager {
                    @Throws(CertificateException::class)
                    override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) {
                    }

                    @Throws(CertificateException::class)
                    override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String) {
                    }

                    override fun getAcceptedIssuers(): Array<X509Certificate> {
                        return arrayOf()
                    }
                }
                val sslContext = SSLContext.getInstance("SSL").also {
                    it.init(null, arrayOf(trustManager), SecureRandom())
                }
                sslSocketFactory(sslContext.socketFactory, trustManager)
                hostnameVerifier { hostname, _ -> hostname.contains("cleverapps.io") }
                addInterceptor(BasicAuthInterceptor(
                    ApiService.ApiServices.API_USERNAME,
                    ApiService.ApiServices.API_PASSWORD
                ))
            }
    }
}