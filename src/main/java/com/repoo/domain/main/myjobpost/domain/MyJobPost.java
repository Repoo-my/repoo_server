package com.repoo.domain.main.myjobpost.domain;

import com.repoo.domain.main.curriculumvitae.domain.CurriculumVitae;
import com.repoo.domain.main.enterprise.domain.Enterprise;
import com.repoo.domain.main.jobpost.domain.JobPost;
import com.repoo.domain.main.user.domain.Users;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class MyJobPost {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long myJobPostId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private Users user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "enterpriseId")
    private Enterprise enterprise;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jobpostId")
    private JobPost jobPost;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curriculumVitaeId")
    private CurriculumVitae curriculumVitae;

    private Boolean isSubmit;

    public MyJobPost(Users user, Enterprise enterprise, JobPost jobPost, CurriculumVitae curriculumVitae, Boolean isSubmit) {
        this.user = user;
        this.enterprise = enterprise;
        this.jobPost = jobPost;
        this.curriculumVitae = curriculumVitae;
        this.isSubmit = isSubmit;
    }

    public void update(Users user, Enterprise enterprise, JobPost jobPost, CurriculumVitae curriculumVitae, Boolean isSubmit) {
        this.user = user;
        this.enterprise = enterprise;
        this.jobPost = jobPost;
        this.curriculumVitae = curriculumVitae;
        this.isSubmit = isSubmit;
    }

}
