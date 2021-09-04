package pl.c.curiosity.ui.curious.add

import androidx.databinding.ObservableField
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import org.joda.time.DateTime
import org.joda.time.DateTimeZone
import pl.c.curiosity.data.db.entity.CuriousNote
import pl.c.curiosity.data.repository.CuriousRepository
import pl.c.curiosity.ui.utils.BaseReactiveViewModel
import pl.c.curiosity.utils.TAG
import timber.log.Timber
import javax.inject.Inject

class AddCuriousNoteViewModel @Inject constructor(
    private val curiousRepository: CuriousRepository
) : BaseReactiveViewModel() {


    val observableNote = ObservableField<String>()
    val observableNoteTitle = ObservableField<String>()
    val observableNoteUrl = ObservableField<String>()
    val observableChecker = ObservableField<Boolean>()

    val close = PublishSubject.create<Unit>()
    val emptyNote = PublishSubject.create<Unit>()

    fun save(checked: Boolean){
        if(observableNote.get().isNullOrBlank()){
            emptyNote.onNext(Unit)
            return
        }
        Timber.tag(TAG.mainTag).d("ObservableCheckerValue: ${observableChecker.get()}")
        val curiousNote = CuriousNote(
            0,
            observableNoteTitle.get()?:"",
            observableNote.get()!!,
            DateTime.now().withZone(DateTimeZone.getDefault()),
            DateTime.now().withZone(DateTimeZone.getDefault()),
            observableNoteUrl.get()?:"",
            checked
        )

        compositeDisposable.add(
            curiousRepository.insertCuriousNote(curiousNote)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    close.onNext(Unit)
                }, Timber::e)
        )
    }
}