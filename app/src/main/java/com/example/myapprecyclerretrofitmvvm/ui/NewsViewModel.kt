package com.example.myapprecyclerretrofitmvvm.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapprecyclerretrofitmvvm.R
import com.example.myapprecyclerretrofitmvvm.domain.models.NewsData
import com.example.myapprecyclerretrofitmvvm.domain.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import java.net.SocketTimeoutException
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val repository: NewsRepository,
) : ViewModel() {

    private val _liveData = MutableLiveData<List<NewsData>>()
    val liveData: LiveData<List<NewsData>> get() = _liveData

    private val _errorLiveData = MutableLiveData<Int>()
    val errorLiveData: LiveData<Int> get() = _errorLiveData

    private val _loadingLiveData = MutableLiveData<Boolean>()
    val loadingLiveData: LiveData<Boolean> get() = _loadingLiveData

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        when (throwable) {
            is SocketTimeoutException -> _errorLiveData.value = R.string.connection_error
            else -> _errorLiveData.value = R.string.unknown_error
        }
    }

    fun getNews() {
        _loadingLiveData.value = true
        viewModelScope.launch(exceptionHandler) {
            val newsList = repository.getListNewsData()
            _liveData.value = newsList
            _loadingLiveData.value = false
        }
    }
}