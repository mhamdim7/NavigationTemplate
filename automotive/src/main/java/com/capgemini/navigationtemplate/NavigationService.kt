package com.capgemini.navigationtemplate

import androidx.car.app.CarAppService
import androidx.car.app.Session
import androidx.car.app.validation.HostValidator

class NavigationService : CarAppService() {
    override fun onCreateSession(): Session {
        return NavigationSession()
    }

    override fun createHostValidator(): HostValidator {
        return HostValidator.ALLOW_ALL_HOSTS_VALIDATOR
    }
}

