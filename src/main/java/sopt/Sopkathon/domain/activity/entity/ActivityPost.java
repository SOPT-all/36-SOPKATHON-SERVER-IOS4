package sopt.Sopkathon.domain.activity.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import sopt.Sopkathon.domain.activity.entity.enums.ActivityTag;
import sopt.Sopkathon.global.common.entity.BaseEntity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
@Table(name = "activity_post")
public class ActivityPost extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne(optional = false)
//    @JoinColumn(name = "member_id", nullable = false)
//    private Member writer;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column(nullable = false)
    private LocalDateTime endTime;

    @Column(nullable = false)
    private String activityRegion;

    @Column(nullable = false)
    private long maxParticipation;

    @Column(nullable = false)
    private boolean isFood;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ActivityTag tag;

    @OneToMany(mappedBy = "activityPost", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ActivityParticipation> participations = new ArrayList<>();

    @OneToMany(mappedBy = "activityPost", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ActivityReview> reviews = new ArrayList<>();
}
