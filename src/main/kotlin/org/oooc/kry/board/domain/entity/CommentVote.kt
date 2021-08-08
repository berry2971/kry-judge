package org.oooc.kry.board.domain.entity

import java.io.Serializable
import javax.persistence.*

class CommentVoteId (
    val comment: Comment = Comment(),
    // val user: User = User(),
    val updown: Byte = 0
): Serializable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CommentVoteId

        if (comment != other.comment) return false
        if (updown != other.updown) return false

        return true
    }

    override fun hashCode(): Int {
        var result = comment.hashCode()
        result = 31 * result + updown.hashCode()
        return result
    }
}

@Entity
@IdClass(CommentVoteId::class)
class CommentVote (

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    val comment: Comment = Comment(),

//    TODO: Mapping to User
//    @Id
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    val user: User = User(),

    @Id
    val updown: Long = 0

): Serializable
