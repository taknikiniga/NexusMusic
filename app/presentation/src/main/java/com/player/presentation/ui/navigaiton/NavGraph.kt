package com.player.presentation.ui.navigaiton

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.player.presentation.screens.pages.main.FavoriteScreen
import com.player.presentation.screens.pages.main.HomeScreen
import com.player.presentation.screens.pages.starter.InterestScreen
import com.player.presentation.screens.pages.starter.IntroScreens
import com.player.presentation.screens.pages.other.MusicEqScreen
import com.player.presentation.screens.pages.starter.PermissionScreen
import com.player.presentation.screens.pages.other.PlayerScreen
import com.player.presentation.screens.pages.main.ProfileScreen
import com.player.presentation.screens.pages.main.SearchScreen
import com.player.presentation.screens.pages.other.SettingScreen
import com.player.presentation.screens.pages.starter.SplashScreen
import com.player.presentation.screens.state.AppVM
import com.player.presentation.screens.state.MusicVM
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NexusMusicApp(modifier: Modifier = Modifier) {
    /* Shared Viewmodel*/
    val viewModel = viewModel<AppVM>()

    val musicVm = hiltViewModel<MusicVM>()

    LaunchedEffect(false) {
        musicVm.getOfflineSongs()
    }

    /*Nav Controller*/
    val navController = rememberNavController()

    val currentBackStack = navController.currentBackStackEntryAsState().value
    val currentDestination = currentBackStack?.destination

    val isStarter = currentDestination?.route in viewModel.starterRoutes

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            AnimatedVisibility(!isStarter) {

                TopAppBar(title = {
                    Text("${navController.currentDestination?.label}")
                })
            }
        },
        bottomBar = {
            AnimatedVisibility(!isStarter) {
                BottomAppBar {

                }
            }
        },
        snackbarHost = {

        },
    ) { innerPadding ->
        /*Nav Graph*/
        NavHost(
            navController = navController,
            startDestination = MusicPlayer,
            modifier = Modifier.padding(innerPadding)
        ) {

            composable(Splash.route) {
                SplashScreen(modifier = modifier)

                LaunchedEffect(false) {
                    delay(3000)
                    navController.navigate(Intro.route)
                }
            }

            composable(Intro.route) {
                IntroScreens(viewModel)
            }

            composable(Interest.route) {
                InterestScreen()
            }

            composable(Permission.route) {
                PermissionScreen()
            }

            composable<Profile> {
                ProfileScreen()
            }

            composable<Search> { SearchScreen() }
            composable<MusicPlayer> { PlayerScreen(musicVm) }
            composable<Favorite> { FavoriteScreen() }
            composable<MusicEq> { MusicEqScreen() }
            composable<Setting> { SettingScreen() }

            composable<Home> {
                HomeScreen()
            }

        }
    }
}