package com.udesh.fishtank.ui.home

import android.service.voice.VoiceInteractionService
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;
import com.udesh.fishtank.data.Repository
import com.udesh.fishtank.data.remote.Response
import com.udesh.fishtank.extensions.mainThreadSafely
import com.udesh.fishtank.util.SingleLiveEvent
import io.reactivex.disposables.CompositeDisposable

class HomeViewModel(private val repository: Repository) : ViewModel() {

    private val disposable = CompositeDisposable()

    val response = MutableLiveData<Response>()
    val error = SingleLiveEvent<String>()

    fun loadFeeds() {
        disposable.add(repository.getFeeds()
                .mainThreadSafely()
                .subscribe({
                    response.postValue(it)
                }, {
                    error.postValue(it.message)
                }))
    }

    override fun onCleared() {
        super.onCleared()
        if (!disposable.isDisposed) {
            disposable.clear()
            disposable.dispose()
        }
    }

}
