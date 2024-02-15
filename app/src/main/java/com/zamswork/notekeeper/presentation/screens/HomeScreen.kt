package com.zamswork.notekeeper.presentation.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.zamswork.notekeeper.R
import com.zamswork.notekeeper.domain.model.Note
import com.zamswork.notekeeper.presentation.viewmodel.NoteListViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotesList(
    modifier: Modifier = Modifier,
    noteListViewModel: NoteListViewModel = hiltViewModel(),
    onNoteCreateListener: () -> Unit
) {
    val allNotes = noteListViewModel.allNotes.value
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Your Notes") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onNoteCreateListener) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(R.string.add_note)
                )
            }
        }
    ) {


        if (allNotes.notes.isEmpty()) {
            EmptyView(
                title = "Empty notes",
                subText = "Click + button to add some notes",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
            )
        } else {
            LazyColumn(modifier = modifier.padding(it)) {
                items(allNotes.notes) { note ->
                    NoteListItem(note)
                }
            }
        }
    }
}

@Composable
fun NoteListItem(note: Note, modifier: Modifier = Modifier) {
    ListItem(
        modifier = modifier,
        headlineContent = {
            Text(text = note.title, style = MaterialTheme.typography.titleLarge)
        })
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun NoteListPreview() {
    NotesList {

    }
}