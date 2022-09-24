package com.rchyn.travelokaclone.presentation.ui.fragments.home

import TimerFlow
import androidx.lifecycle.*
import com.rchyn.travelokaclone.data.DataSource
import com.rchyn.travelokaclone.domain.model.Cities
import com.rchyn.travelokaclone.domain.model.Hotel
import com.rchyn.travelokaclone.domain.model.Promo
import com.rchyn.travelokaclone.utils.longToTime
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class HomeViewModel : ViewModel() {

    private val dataSource = DataSource

    val listPromoLandscape: LiveData<List<Int>> = dataSource.listPromoLandscape.asLiveData()

    val listHotel: LiveData<List<Hotel>> = dataSource.listHotel.asLiveData()

    val listPromo:LiveData<List<Promo>> =dataSource.listPromo.asLiveData()

    private val _time: MutableStateFlow<String> = MutableStateFlow("00:00:00")
    val time: LiveData<String> = _time.asLiveData()

    val searchQuery = MutableLiveData<Cities>()
    val listHotelByCities: LiveData<List<Hotel>>

    init {
        searchQuery.value = Cities.BALI
        listHotelByCities = Transformations.switchMap(searchQuery) { q ->
            dataSource.listHotelByCities(q).asLiveData()
        }
        setTimeCountDown()
    }

    private fun setTimeCountDown() {
        viewModelScope.launch {
            TimerFlow.create(14400000L, 1000L).collect {
                _time.value = it.longToTime()
            }
        }
    }
}