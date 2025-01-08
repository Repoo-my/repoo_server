package com.repoo.domain.main.jobpost.domain;

import com.repoo.domain.main.enterprise.domain.Enterprise;
import com.repoo.domain.side.job.domain.Job;
import com.repoo.domain.side.jobgroup.domain.JobGroup;
import io.hypersistence.utils.hibernate.type.array.IntArrayType;
import io.hypersistence.utils.hibernate.type.array.StringArrayType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class JobPost {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long jobpostId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "enterpriseId")
    private Enterprise enterprise;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jobId")
    private Job job;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jobGroupId")
    private JobGroup jobGroup;

    private Integer maxStanding;

    private Integer minStanding;

    private String title;

    private String contents;

    @Type(StringArrayType.class)
    @Column(columnDefinition = "varchar[]")
    private String[] skills;

    @Type(StringArrayType.class)
    @Column(columnDefinition = "varchar[]")
    private String[] tags;

//    private String jobpostImg;

    public JobPost(
            Long jobpostId,
            Enterprise enterprise,
            JobGroup jobGroup,
            Job job,
            Integer maxStanding,
            Integer minStanding,
            String title,
            String contents,
            String[] skills,
            String[] tags
    ) {
        this.jobpostId = jobpostId;
        this.enterprise = enterprise;
        this.job = job;
        this.jobGroup = jobGroup;
        this.maxStanding = maxStanding;
        this.minStanding = minStanding;
        this.title = title;
        this.contents = contents;
        this.skills = skills;
        this.tags = tags;
//        this.jobpostImg = jobpostImg;
    }

    @Builder(builderMethodName = "createBuilder")
    public JobPost(
            Enterprise enterprise,
            Job job,
            JobGroup jobGroup,
            Integer maxStanding,
            Integer minStanding,
            String title,
            String contents,
            String[] skills,
            String[] tags
    ) {
        this.enterprise = enterprise;
        this.job = job;
        this.jobGroup = jobGroup;
        this.maxStanding = maxStanding;
        this.minStanding = minStanding;
        this.title = title;
        this.contents = contents;
        this.skills = skills;
        this.tags = tags;
//        this.jobpostImg = jobpostImg;
    }

    @Builder(builderMethodName = "updateBuilder")
    public JobPost(
            Job job,
            JobGroup jobGroup,
            Integer maxStanding,
            Integer minStanding,
            String title,
            String contents,
            String[] skills,
            String[] tags
    ) {
        this.job = job;
        this.jobGroup = jobGroup;
        this.title = title;
        this.maxStanding = maxStanding;
        this.minStanding = minStanding;
        this.contents = contents;
        this.skills = skills;
        this.tags = tags;
//        this.jobpostImg = jobpostImg;
    }

    public void update(
            Job job,
            JobGroup jobGroup,
            Integer maxStanding,
            Integer minStanding,
            String title,
            String contents,
            String[] skills,
            String[] tags
    ) {
        this.job = job;
        this.jobGroup = jobGroup;
        this.maxStanding = maxStanding;
        this.minStanding = minStanding;
        this.title = title;
        this.contents = contents;
        this.skills = skills;
        this.tags = tags;
//        this.jobpostImg = jobpostImg;
    }
}
