package com.intcore.userstask.di.modules;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.intcore.userstask.data.remote.ApiModule;
import com.intcore.userstask.util.Constatnts;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {
    @Provides
    static Gson provideGson(){
        return  new GsonBuilder()
                .setLenient()
                .create();
    }

    @Provides
    static OkHttpClient provideOkhttp(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(5, TimeUnit.MINUTES) // connect timeout
                .writeTimeout(5, TimeUnit.MINUTES) // write timeout
                .readTimeout(5, TimeUnit.MINUTES); // read timeout
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        logging.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        builder.addInterceptor(logging);




            return builder.build();

    }

    @Provides
    static Retrofit provideRetofitInstance(OkHttpClient client, Gson gson){


        return new Retrofit.Builder()
                .baseUrl(Constatnts.BASE_URL)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    @Provides
    static ApiModule provideApiModule(Retrofit retrofit){
        return retrofit.create(ApiModule.class);
    }

}
