import com.sssoyalan.ogoochallenge.models.BadgesCount

data class RowwModel(
    val CurrentFolderSpItemUrl: String?,
    val FilterLink: String?,
    val FirstRow: Int?,
    val FolderPermissions: String?,
    val ForceNoHierarchy: String?,
    val HierarchyHasIndention: String?,
    val LastRow: Int?,
    val Row: List<Row>?,
    val RowLimit: Int?
)
data class Rows(
    val rows: List<Row>?
)

data class Row(
    val Author: List<Author>,
    val Badge: List<Badge>,
    val Created: String?,
    val ID: String?,
    val Message: String?,
    val PraiseRating: String,
    val PrincipalCount: String?,
    val RelatedPerson: List<RelatedPerson>
)

data class RelatedPerson(
    val email: String?,
    val id: String?,
    val picture: String?,
    val sip: String?,
    val title: String?
)

data class Author(
    val email: String?,
    val id: String?,
    val picture: String?,
    val sip: String?,
    val title: String?
)

data class Badge(
    val isSecretFieldValue: Boolean,
    val lookupId: Int,
    val lookupValue: String?
)