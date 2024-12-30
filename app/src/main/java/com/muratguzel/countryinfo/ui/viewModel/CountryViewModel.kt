package com.muratguzel.countryinfo.ui.viewModel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.muratguzel.countryinfo.data.entity.CountryItem
import com.muratguzel.countryinfo.data.repository.CountryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CountryViewModel(context: Application) : AndroidViewModel(context) {
    var crepo = CountryRepository(context)
    var countryList = MutableLiveData<List<CountryItem>>()


    fun getDataFromInternet(context: Context) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val data = crepo.getDataFromInternet(context)
                viewModelScope.launch(Dispatchers.Main) {
                    countryList.value = data
                }
            } catch (e: Exception) {
                // Hata durumunda uygun bir işlem yapabilirsiniz, örneğin loglama veya hata mesajı göstermek
                viewModelScope.launch(Dispatchers.Main) {
                    // Hata durumunda boş bir liste veya hata mesajı dönebiliriz
                    countryList.value = emptyList()
                }
            }
        }
    }

    fun refreshData(context: Context) {
        viewModelScope.launch(Dispatchers.Main) {
            countryList.value = crepo.refreshData(context)
        }
    }


}