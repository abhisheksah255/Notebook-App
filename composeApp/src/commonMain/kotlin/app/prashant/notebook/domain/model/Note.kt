package app.prashant.notebook.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Note(
    @SerialName("id")
    val id: Long = 0L,
    @SerialName("title")
    val title: String,
    @SerialName("description")
    val description: String,
    @SerialName("created_at")
    val createdAt: Long = 0L,
    @SerialName("last_modified")
    val lastModified: Long? = null,
    @SerialName("is_pinned")
    val isPinned: Boolean = false,
    @SerialName("isSelected")
    val isSelected: Boolean = true,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as Note

        if (id != other.id) return false
        if (title != other.title) return false
        if (description != other.description) return false
        if (createdAt != other.createdAt) return false
        if (lastModified != other.lastModified) return false
        if (isPinned != other.isPinned) return false
        if (isSelected != other.isSelected) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + title.hashCode()
        result = 31 * result + description.hashCode()
        result = 31 * result + createdAt.hashCode()
        result = 31 * result + (lastModified?.hashCode() ?: 0)
        result = 31 * result + isPinned.hashCode()
        result = 31 * result + isSelected.hashCode()
        return result
    }
}