package aero.testcompany.internetstat.domain.network

import aero.testcompany.internetstat.view.App
import android.annotation.SuppressLint
import android.provider.Settings
import kotlinx.coroutines.runBlocking

class SyncNetworkDataWorker {
    val api = App.api
    init {
        runBlocking {
            sendUserId()
        }
    }

    @SuppressLint("HardwareIds")
    suspend fun sendUserId() {
        val id = Settings.Secure.getString(App.instance.contentResolver, Settings.Secure.ANDROID_ID)
        val result = api.addUser(id)
        result
    }
}