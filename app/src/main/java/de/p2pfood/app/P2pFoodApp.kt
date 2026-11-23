package de.p2pfood.app

import android.app.Application
import android.content.Context
import de.p2pfood.app.data.AppContainer
import org.osmdroid.config.Configuration

class P2pFoodApp : Application() {
    val container: AppContainer by lazy { AppContainer(this) }

    override fun onCreate() {
        super.onCreate()
        Configuration.getInstance().load(this, getSharedPreferences("osmdroid", Context.MODE_PRIVATE))
        Configuration.getInstance().userAgentValue = packageName
    }
}
