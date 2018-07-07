package com.udesh.fishtank.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udesh.fishtank.data.Repository
import com.udesh.fishtank.data.remote.Response
import com.udesh.fishtank.extensions.mainThreadSafely
import com.udesh.fishtank.util.SingleLiveEvent
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit

class HomeViewModel(private val repository: Repository) : ViewModel() {

    private var disposable: Disposable? = null

    val response = MutableLiveData<Response>()
    val error = SingleLiveEvent<String>()

    fun loadFeeds() {
        dispose()
        disposable = Observable.interval(0, 5, TimeUnit.SECONDS)
                        .map {
                            Log.d("LOL", "flatMap")
                            repository.getFeeds().execute().body()!!
                        }
                        .mainThreadSafely()
                        .subscribe({
                            Log.d("LOL", "onNext")
                            response.postValue(it)
                        }, {
                            Log.d("LOL", "error $it")
                            error.postValue(it.message)
                            dispose()
                        })
    }

    fun dispose() {
        disposable?.let {
            if (!it.isDisposed)
                it.dispose()
            disposable = null
        }
    }

    override fun onCleared() {
        super.onCleared()
        dispose()
    }

}
