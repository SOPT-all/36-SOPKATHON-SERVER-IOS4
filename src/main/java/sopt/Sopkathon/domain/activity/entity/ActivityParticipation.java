package sopt.Sopkathon.domain.activity.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import sopt.Sopkathon.domain.activity.entity.enums.ParticipationStatus;
import sopt.Sopkathon.domain.member.entity.Member;
import sopt.Sopkathon.global.common.entity.BaseEntity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
@Table(name = "activity_participation")
public class ActivityParticipation extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(optional = false)
    @JoinColumn(name = "activity_post_id", nullable = false)
    private ActivityPost activityPost;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ParticipationStatus status;

    public static ActivityParticipation of(Member member, ActivityPost post) {
        return ActivityParticipation.builder()
                .member(member)
                .activityPost(post)
                .status(ParticipationStatus.APPLICATION_COMPLETE)
                .build();
    }
}
