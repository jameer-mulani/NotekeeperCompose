package com.zamswork.notekeeper.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zamswork.notekeeper.domain.model.Note
import com.zamswork.notekeeper.domain.usecase.AddNoteUseCase
import com.zamswork.notekeeper.domain.usecase.GetAllNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class NoteListViewModel @Inject constructor(
    private val getAllNoteUseCase: GetAllNoteUseCase,
    private val addNoteUseCase: AddNoteUseCase
) : ViewModel() {
    companion object{
        private const val TAG = "NoteListViewModel"
    }

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->  throwable.printStackTrace() }


    private val _allNotes = mutableStateOf(AllNotesState())
    val allNotes : State<AllNotesState> = _allNotes

    init {
        getAllNotes()
    }

    fun getAllNotes(){
        viewModelScope.launch {
            val allNotes = getAllNotesInternal()
            _allNotes.value = _allNotes.value.copy(loading = false, error = null, notes = allNotes)
        }
    }

    private suspend fun getAllNotesInternal() : List<Note>{
        return withContext(Dispatchers.IO + coroutineExceptionHandler){
            val allNotes = getAllNoteUseCase(null)
            allNotes
        }
    }

    override fun onCleared() {
        Log.i(TAG, "onCleared: called")
        super.onCleared()

    }
}

data class AllNotesState(
    val notes : List<Note> = emptyList(),
    val loading : Boolean = false,
    val error : String? = null
)