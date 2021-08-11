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
import timber.log.Timber
import javax.inject.Inject

class AddCuriousNoteViewModel @Inject constructor(
    private val curiousRepository: CuriousRepository
) : BaseReactiveViewModel() {


    val observableNote = ObservableField<String>()
    val observableNoteTitle = ObservableField<String>()
    val observableNoteUrl = ObservableField<String>()
    val close = PublishSubject.create<Unit>()

    fun save(noteTitle: String?, noteUrl: String?, note: String){
        val curiousNote = CuriousNote(
            0,
            noteTitle,
            note,
            DateTime.now().withZone(DateTimeZone.getDefault()),
            DateTime.now().withZone(DateTimeZone.getDefault()),
            noteUrl
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