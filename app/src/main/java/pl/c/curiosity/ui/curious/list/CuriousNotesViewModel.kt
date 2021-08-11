package pl.c.curiosity.ui.curious.list

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import pl.c.curiosity.data.db.entity.CuriousNote
import pl.c.curiosity.data.repository.CuriousRepository
import pl.c.curiosity.ui.utils.BaseReactiveViewModel
import timber.log.Timber
import javax.inject.Inject

class CuriousNotesViewModel @Inject constructor(
    private val curiousRepository: CuriousRepository
) : BaseReactiveViewModel() {

    val notes = BehaviorSubject.create<List<CuriousNote>>()

    init {
        loadAll()
    }

    fun loadAll(){
        compositeDisposable.add(
            curiousRepository.loadAllCuriousNotes()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    notes.onNext(it)
                }, Timber::e)
        )
    }
}