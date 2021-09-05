package pl.c.curiosity.ui.curious.add

import androidx.databinding.ObservableField
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import org.joda.time.DateTime
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
    val observableChecker = ObservableField<Boolean>()

    val close = PublishSubject.create<Unit>()
    val emptyNote = PublishSubject.create<Unit>()

    private var itemModification: Boolean = false
    private var item: CuriousNote? = null

    fun save(){
        if(observableNote.get().isNullOrBlank()){
            emptyNote.onNext(Unit)
            return
        }
        if(itemModification) updateItem()
        else {
            val curiousNote = CuriousNote(
                id = 0,
                title = observableNoteTitle.get() ?: "",
                note = observableNote.get()!!,
                createdAt = DateTime.now(),
                modifiedAt = null,
                url = observableNoteUrl.get() ?: "",
                toCheck = observableChecker.get() ?: false
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

    fun updateItem(item: CuriousNote){
        observableNote.set(item.note)
        observableNoteTitle.set(item.title)
        observableChecker.set(item.toCheck)
        observableNoteUrl.set(item.url)
        itemModification = true
        this.item = item
    }

    private fun updateItem() {
        val itemToUpdate = item?.copy(
            title = observableNoteTitle.get() ?: "",
            note = observableNote.get()!!,
            modifiedAt = DateTime.now(),
            url = observableNoteUrl.get() ?: "",
            toCheck = observableChecker.get() ?: false
        )
        itemToUpdate?.let {
            compositeDisposable.add(
                curiousRepository.updateNote(itemToUpdate)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        close.onNext(Unit)
                    }, Timber::e)
            )
        }
    }
}