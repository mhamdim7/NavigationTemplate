package com.capgemini.navigationtemplate

import androidx.annotation.OptIn
import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.car.app.annotations.ExperimentalCarApi
import androidx.car.app.model.*
import androidx.car.app.navigation.NavigationManager
import androidx.car.app.navigation.model.MapController
import androidx.car.app.navigation.model.MapWithContentTemplate

class NavigationScreen(carContext: CarContext) : Screen(carContext) {

    private val navigationManager =
        carContext.getCarService(CarContext.NAVIGATION_SERVICE) as NavigationManager

    @OptIn(ExperimentalCarApi::class)
    override fun onGetTemplate(): Template {
        val standardAction = Action.BACK
        val actionStrip = ActionStrip.Builder().addAction(standardAction).build()

        val pane = Pane.Builder()
            .setLoading(true)
            .build()

        val mapController = MapController.Builder()
            .setMapActionStrip(actionStrip)
            .build()

        return MapWithContentTemplate.Builder()
            .setContentTemplate(PaneTemplate.Builder(pane).build())
            .setActionStrip(actionStrip)
            .setMapController(mapController)
            .build()
    }
}