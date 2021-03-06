package com.katrinrudisch.gymbuddy.injection

import android.app.Application
import androidx.room.Room
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.katrinrudisch.gymbuddy.repository.GymBuddyDatabase
import com.katrinrudisch.gymbuddy.repository.GymBuddyRepository
import com.katrinrudisch.gymbuddy.repository.PlanDao
import com.katrinrudisch.gymbuddy.service.ApiService
import com.katrinrudisch.gymbuddy.ui.MainViewModel
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val viewModelModule = module {
    viewModel {
        MainViewModel(get())
    }
}

val repositoryModule = module {
    single {
        GymBuddyRepository(get())
    }
}

val apiModule = module {
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    single { provideApiService(get()) }
}

val retrofitModule = module {

    fun provideGson(): Gson {
        return GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create()
    }

    fun provideHttpClient(): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()

        return okHttpClientBuilder.build()
    }

    fun provideRetrofit(factory: Gson, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create(factory))
            .client(client)
            .build()
    }

    single { provideGson() }
    single { provideHttpClient() }
    single { provideRetrofit(get(), get()) }
}

val databaseModule = module {
    fun provideDatabase(app: Application): GymBuddyDatabase {
        return Room.databaseBuilder(
            app,
            GymBuddyDatabase::class.java, "gymbuddy-db"
        ).build()
    }

    fun providePlanDao(database: GymBuddyDatabase): PlanDao {
        return database.planDao()
    }

    single { provideDatabase(androidApplication()) }
    single { providePlanDao(get()) }
}