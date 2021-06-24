package com.example.wise.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androiddevs.mvvmnewsapp.api.RetrofitInstance
import com.example.wise.model.Crypto
import com.example.wise.model.CrytoResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel(){
    var cryptolivedata: MutableLiveData<CrytoResponse> = MutableLiveData()
    fun getcrptoObserver():MutableLiveData<CrytoResponse>{
        return  cryptolivedata
    }
    fun makeapicall(){
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitInstance.api.getalldata()
            cryptolivedata.postValue(response)
        }
    }
}
