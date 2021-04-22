package com.adhish.catsapp.ui.main.view

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adhish.catsapp.data.model.CatsResponse
import com.adhish.catsapp.data.repository.MainRepository
import com.adhish.catsapp.utils.Resource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    private val cats = MutableLiveData<Resource<List<CatsResponse>>>()
    private val compositeDisposable = CompositeDisposable()

    init {
        fetchCats()
    }

    private fun fetchCats() {
        cats.postValue(Resource.loading(null))
        compositeDisposable.add(
            mainRepository.getCats(1, 10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ catList ->
                    cats.postValue(Resource.success(catList))
                }, {
                    cats.postValue(Resource.error("Something Went Wrong", null))
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun getCats(): LiveData<Resource<List<CatsResponse>>> {
        return cats
    }
}
