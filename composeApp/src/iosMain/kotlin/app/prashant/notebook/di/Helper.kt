package app.prashant.notebook.di

import app.prashant.notebook.utils.SharedObjects.createNotebookFolders


/**
 * [initKoin] function represents koin injection for iOS
 *
 * @author Prashant Singh
 * */
fun initKoin() {
    initiateKoin()
    createNotebookFolders()
}
