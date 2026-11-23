package de.p2pfood.app

import android.app.Application
import de.p2pfood.app.data.AppContainer

class P2pFoodApp : Application() {
    val container: AppContainer by lazy { AppContainer(this) }
}
