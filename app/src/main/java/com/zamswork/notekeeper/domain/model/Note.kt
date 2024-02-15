package com.zamswork.notekeeper.domain.model

import java.util.Date

data class Note(val id: Int, val title: String, val content: String, val createdOn: Date)
