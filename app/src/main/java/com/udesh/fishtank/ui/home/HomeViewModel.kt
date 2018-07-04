package com.udesh.fishtank.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;
import com.udesh.fishtank.data.Repository
import com.udesh.fishtank.data.remote.Response
import com.udesh.fishtank.extensions.mainThreadSafely
import io.reactivex.disposables.CompositeDisposable

class HomeViewModel(private val repository: Repository) : ViewModel() {

    private val disposable = CompositeDisposable()

    val response = MutableLiveData<Response>()

    fun loadFeeds() {
        disposable.add(repository.getFeeds()
                .mainThreadSafely()
                .subscribe({
                    response.postValue(it)
                }, {}))
    }

    override fun onCleared() {
        super.onCleared()
        if (!disposable.isDisposed) {
            disposable.clear()
            disposable.dispose()
        }
    }

}
