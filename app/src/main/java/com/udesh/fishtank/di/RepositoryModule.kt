package com.udesh.fishtank.di

import com.udesh.fishtank.data.Repository
import com.udesh.fishtank.data.remote.RemoteDataSource
import org.koin.dsl.module.module

val repositoryModule = module {

    single { RemoteDataSource() }
    single { Repository(get()) }

}
