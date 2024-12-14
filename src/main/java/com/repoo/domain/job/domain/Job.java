package com.repoo.domain.job.domain;

import com.repoo.domain.jobgroup.domain.JobGroup;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long jobId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jobGroupId")
    private JobGroup jobGroup;

    private String jobName;

    @Builder(builderMethodName = "createBuilder")
    public Job(String jobName, JobGroup jobGroup) {
        this.jobGroup = jobGroup;
        this.jobName = jobName;
    }

    @Builder(builderMethodName = "updateBuilder")
    public Job(JobGroup jobGroup, String jobName) {
        this.jobGroup = jobGroup;
        this.jobName = jobName;
    }

    public void update(JobGroup jobGroup, String jobName) {
        this.jobGroup = jobGroup;
        this.jobName = jobName;
    }
}
