package com.example.android_iot_app_deel_2

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(on: Boolean): ViewModel() {

    private val _lamp1_on: MutableState<Boolean>

    init {
        _lamp1_on= mutableStateOf(on)
    }

    val lamp1_on : State<Boolean> = _lamp1_on
    fun setLamp1On(on: Boolean) {
        _lamp1_on.value = on
    }

}