package com.test.marvelapptest.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.test.domain.CharacterResult
import com.test.marvelapptest.ui.common.ScopedViewModel
import com.test.usecase.GetDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class DetailViewModel @Inject constructor(
    @Named("characterId") private val characterId: Int,
    private val getDetails: GetDetails
) : ScopedViewModel() {

    private val _model = MutableLiveData<CharacterResult>()
    val model: LiveData<CharacterResult> = _model

    private val _load = MutableLiveData<Boolean>()
    val load: LiveData<Boolean> = _load

    init {
        getDetails()
    }

    private fun getDetails() {
        launch {
            _load.value = true
            _model.value = getDetails.invoke(characterId)
            _load.value = false
        }
    }

}