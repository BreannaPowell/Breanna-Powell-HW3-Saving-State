package com.example.savingstate

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.savingstate.ui.SavingStateViewModel
import com.example.savingstate.ui.StartScreen
import com.example.savingstate.ui.SunScreen

/*
From: Navigate between screens with Compose tutorial
"The Navigation component has three main parts:
    NavController: Responsible for navigating between destinations—that is, the screens in your app.
    NavGraph: Maps composable destinations to navigate to.
    NavHost: Composable acting as a container for displaying the current destination of the NavGraph."

    Route: "A route is a string that corresponds to a destination."
    "You can define an app's routes using an enum class.
    "
*/


/** DEFINING ROUTES (A rout is "a string that corresponds to a destination"):
Start: Select Sun or Shade from one of 2 buttons
Sun: Select cities that are in the sun
Shade: Select cities that are in the shade
"Enum classes in Kotlin have a name property that returns a string with the property name."
*/

enum class AppScreen(@StringRes val title: Int) {

    Start(title = R.string.screen_start),
    Choice(title = R.string.screen_choice),
    Sun(title = R.string.screen_sun),
    Shade(title = R.string.screen_shade)
}

/** NAVIGATION BAR ALONG THE TOP */
@Composable
fun SavingStateAppBar(
    currentScreen: AppScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(currentScreen.title)) },
        modifier = modifier,
        navigationIcon = {
            Row (
                horizontalArrangement = Arrangement.End
            ){
                if (canNavigateBack) {
                    IconButton(onClick = navigateUp) {
                        Icon (
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.button_back)
                        )
                    }
                }


            }
        }
    )
}

@Composable
fun SavingStateApp(modifier: Modifier = Modifier, viewModel: SavingStateViewModel = viewModel()){
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = AppScreen.valueOf(
        backStackEntry?.destination?.route ?: AppScreen.Start.name
    )

    Scaffold(
        topBar = {
            SavingStateAppBar(
                currentScreen = currentScreen,
                // Show back arrow only if there is something on the backstack
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() },
            )
        }
    ) { innerPadding ->
        //val uiState by viewModel.uiState.collectAsState()

        /** ------------------------------- THE NAV HOST --------------------------------- */
        NavHost(
            navController = navController,
            startDestination = AppScreen.Start.name,
            modifier = modifier.padding(innerPadding)
        ){

            /** THE START SCREEN (mapped to a composable) */
            composable(route = AppScreen.Start.name){
                StartScreen(
                    onZipCodeSaved = {
                        navController.navigate(AppScreen.Choice.name)
                    }
                )
            }

            /** THE CHOICE SCREEN (mapped to a composable) */
            composable(route = AppScreen.Choice.name){
                ChoiceScreen(
                    /** NAVIGATE TO SUN SCREEN */
                    onNavigateToSunButtonClicked = { navController.navigate(AppScreen.Sun.name)},

                    /** NAVIGATE TO SHADE SCREEN */
                    onNavigateToShadeButtonClicked = { navController.navigate(AppScreen.Shade.name)}
                )
            }

            /** THE SHADE SCREEN (mapped to a composable) */
            composable(route = AppScreen.Shade.name){
                ShadeScreen()
            }

            /** THE SUN SCREEN (mapped to a composable) */
            composable(route = AppScreen.Sun.name){
                SunScreen()
            }
        }

    }
}