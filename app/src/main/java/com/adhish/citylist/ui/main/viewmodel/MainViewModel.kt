package com.adhish.citylist.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adhish.citylist.data.model.CountryResponse
import com.adhish.citylist.data.model.GeoNames
import com.adhish.citylist.data.repository.MainRepository
import com.adhish.citylist.utils.Resource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    private val cities = MutableLiveData<Resource<List<GeoNames>>>()
    private val compositeDisposable = CompositeDisposable()

    init {
        fetchCities("san")
    }

    private fun fetchCities(name: String) {
        cities.postValue(Resource.loading(null))
        compositeDisposable.add(
            mainRepository.getCountries(name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ geoNames ->
                    cities.postValue(Resource.success(geoNames))
                }, {
                    cities.postValue(Resource.error("Something Went Wrong", null))
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun getCountries(): LiveData<Resource<List<GeoNames>>> {
        return cities
    }
}
