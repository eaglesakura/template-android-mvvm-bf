package micromodules.app.main

import android.app.Application
import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri

internal class ApplicationBootstrap : ContentProvider() {
    override fun onCreate(): Boolean {
        ApplicationConfigure.init(context!! as Application)
        return true
    }

    override fun insert(p0: Uri, p1: ContentValues?): Uri? {
        throw UnsupportedOperationException("NOT SUPPORTED")
    }

    override fun query(
        p0: Uri,
        p1: Array<out String>?,
        p2: String?,
        p3: Array<out String>?,
        p4: String?
    ): Cursor? {
        throw UnsupportedOperationException("NOT SUPPORTED")
    }

    override fun update(p0: Uri, p1: ContentValues?, p2: String?, p3: Array<out String>?): Int {
        throw UnsupportedOperationException("NOT SUPPORTED")
    }

    override fun delete(p0: Uri, p1: String?, p2: Array<out String>?): Int {
        throw UnsupportedOperationException("NOT SUPPORTED")
    }

    override fun getType(p0: Uri): String? {
        throw UnsupportedOperationException("NOT SUPPORTED")
    }
}