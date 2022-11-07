package com.example.savingstate.ui
import androidx.lifecycle.ViewModel
import com.example.savingstate.data.SavingStateUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/* THE VIEW MODEL SAVES AND MANAGES THE STATES */

class SavingStateViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(SavingStateUiState())
    val uiState: StateFlow<SavingStateUiState> = _uiState.asStateFlow()

    fun setZipCode(userZipCode: String) {
        _uiState.update { currentState ->
            currentState.copy(userZipCode = userZipCode)
        }
    }

    fun setShade(desiredShade: Boolean){
        _uiState.update { currentState ->
            currentState.copy(findShadeChosen = desiredShade)
        }
    }

    fun setSun(desiredSun: Boolean){
        _uiState.update { currentState ->
            currentState.copy(findSunChosen = desiredSun)
        }
    }

    /**
     * Set the city chosen by the user
     */
    fun setCity(desiredCity: String) {
        _uiState.update { currentState ->
            currentState.copy(city = desiredCity)
        }
    }

}