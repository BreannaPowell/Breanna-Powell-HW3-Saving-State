package com.example.savingstate.data

data class SavingStateUiState(
    /** ZIPCODE ENTERED */
    val userZipCode : String = "",

    /** STATE: go to the Shade screen */
    val findShadeChosen : Boolean = false,

    /** STATE: go to the Sun screen */
    val findSunChosen : Boolean = false,

    /** Direction selected - such as North */
    val direction: String = "",

    /** City selected - such as Renton, WA */
    val city: String = "",

)