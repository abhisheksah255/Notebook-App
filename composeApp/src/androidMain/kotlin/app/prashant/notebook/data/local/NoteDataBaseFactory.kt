package app.prashant.notebook.data.local

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import app.prashant.database.NotebookDatabase
import app.prashant.notebook.data.util.DBObject
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual object NoteDataBaseFactory : KoinComponent {
    private val context: Context by inject()

    actual fun create(): SqlDriver =
        AndroidSqliteDriver(NotebookDatabase.Schema, context, DBObject.DB_NAME)
}