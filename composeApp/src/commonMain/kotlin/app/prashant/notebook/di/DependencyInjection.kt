package app.prashant.notebook.di

import androidx.lifecycle.ViewModel
import app.prashant.database.NotebookDatabase
import app.prashant.notebook.data.local.NoteDataBaseFactory
import app.prashant.notebook.data.local.NotebookDataStore
import app.prashant.notebook.data.repository.AppStateOwnerImpl
import app.prashant.notebook.data.repository.DataStoreRepositoryImpl
import app.prashant.notebook.data.repository.NoteRepositoryImpl
import app.prashant.notebook.di.platform.platformModule
import app.prashant.notebook.domain.repositories.AppStateOwner
import app.prashant.notebook.domain.repositories.DataStoreRepository
import app.prashant.notebook.domain.repositories.NoteRepository
import app.prashant.notebook.presentations.app.NoteVM
import app.prashant.notebook.presentations.home.HomeViewModel
import app.prashant.notebook.presentations.note.NoteViewModel
import org.koin.core.context.startKoin
import org.koin.core.definition.Definition
import org.koin.core.definition.KoinDefinition
import org.koin.core.module.Module
import org.koin.core.qualifier.Qualifier
import org.koin.dsl.module

fun initiateKoin(additionalModules: List<Module>? = null) {
    startKoin {
        modules(additionalModules.orEmpty() + listOf(commonModule, platformModule))
    }
}

private val commonModule = module {
    single<NotebookDataStore> {
        NotebookDataStore(dataStore = get())
    }
    single<DataStoreRepository> {
        DataStoreRepositoryImpl(notebookDataStore = get())
    }
    single<NotebookDatabase> {
        NotebookDatabase(driver = NoteDataBaseFactory.create())
    }
    single<NoteRepository> { NoteRepositoryImpl(database = get()) }

    single<AppStateOwner> { AppStateOwnerImpl(dataStoreRepository = get()) }

    viewModel { HomeViewModel(noteRepository = get()) }
    viewModel { NoteVM(appStateOwner = get()) }
    viewModel { NoteViewModel(noteRepository = get()) }
}

private inline fun <reified T : ViewModel> Module.viewModel(
    qualifier: Qualifier? = null,
    noinline definition: Definition<T>
): KoinDefinition<T> {
    return factory(qualifier, definition)
}