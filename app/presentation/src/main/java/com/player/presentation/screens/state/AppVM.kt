package com.player.presentation.screens.state

import android.content.Context
import androidx.lifecycle.ViewModel
import com.player.presentation.R
import com.player.presentation.screens.state.model.PagerModel
import com.player.presentation.ui.navigaiton.Interest
import com.player.presentation.ui.navigaiton.Intro
import com.player.presentation.ui.navigaiton.Permission
import com.player.presentation.ui.navigaiton.Splash

class AppVM : ViewModel() {

    val starterRoutes = setOf(Splash.route, Intro.route, Permission.route, Interest.route)

    fun getPagerData(context: Context): List<PagerModel> {
        return listOf(
            PagerModel(
                context.getString(R.string.title_1),
                context.getString(R.string.des_1),
                R.drawable.ic_launcher_background
            ),
            PagerModel(
                context.getString(R.string.title_2),
                context.getString(R.string.des_2),
                R.drawable.ic_launcher_background
            ),
            PagerModel(
                context.getString(R.string.title_3),
                context.getString(R.string.des_3),
                R.drawable.ic_launcher_background
            ),
        )
    }

}