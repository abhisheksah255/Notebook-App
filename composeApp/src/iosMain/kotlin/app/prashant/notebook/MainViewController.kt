package app.prashant.notebook

import androidx.compose.ui.window.ComposeUIViewController
import app.prashant.notebook.presentations.app.NoteBookApp

fun MainViewController() = ComposeUIViewController { NoteBookApp() }