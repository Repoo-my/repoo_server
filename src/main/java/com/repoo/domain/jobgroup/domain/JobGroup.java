package com.repoo.domain.jobgroup.domain;

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
public class JobGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long jobGroupId;

    private String jobGroupName;

    public void update(String JobGroupName) {
        this.jobGroupName = JobGroupName;
    }
}
