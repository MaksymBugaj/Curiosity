package pl.c.curiosity.ui

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.badge.BadgeDrawable
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.navigation_activity.*
import pl.c.curiosity.R
import pl.c.curiosity.data.repository.CuriousRepository
import javax.inject.Inject

class NavHolder : DaggerAppCompatActivity() {

    private lateinit var navController: NavController

    @Inject
    lateinit var curiousRepository: CuriousRepository

    private val compositeDisposable = CompositeDisposable()
    var badge : BadgeDrawable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.navigation_activity)

        navController = Navigation.findNavController(this, R.id.nav_holder)

        bottomNav.setupWithNavController(navController)

        badge = bottomNav.getOrCreateBadge(R.id.curiousNoteToCheckView)

    }

    override fun onResume() {
        super.onResume()
        getBadges()
    }

    override fun onStop() {
        super.onStop()
        compositeDisposable.dispose()
    }

    private fun getBadges(){
        compositeDisposable.add(
            curiousRepository.loadToCheckNotesCount()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{ count ->
                    badge?.let { view ->
                        if(count < 1) view.isVisible = false
                        else {
                            view.isVisible = true
                            view.number = count
                        }
                    }
                }
        )
    }

}