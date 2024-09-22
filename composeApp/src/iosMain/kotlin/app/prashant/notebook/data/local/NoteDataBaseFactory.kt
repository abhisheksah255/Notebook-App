package app.prashant.notebook.data.local

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import app.prashant.database.NotebookDatabase
import app.prashant.notebook.data.util.DBObject
import org.koin.core.component.KoinComponent

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual object NoteDataBaseFactory : KoinComponent {
    actual fun create(): SqlDriver = NativeSqliteDriver(NotebookDatabase.Schema, DBObject.DB_NAME)
}