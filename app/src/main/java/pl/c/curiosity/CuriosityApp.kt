package pl.c.curiosity

import com.facebook.stetho.Stetho
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import pl.c.curiosity.di.DaggerAppComponent
import timber.log.Timber

class CuriosityApp : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        Stetho.initializeWithDefaults(this)
        return DaggerAppComponent.builder().application(this).build()
    }
}