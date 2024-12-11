package com.repoo.career.domain;

import com.repoo.curriculumvitae.domain.CurriculumVitae;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Career {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long careerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curriculumVitaeId")
    private CurriculumVitae curriculumVitae;

    private String careerName;

    private String careerType;

    private String careerDepartment;

    private String careerPosition;

    private String careerStartDate;

    private String careerEndDate;

    private String retirementDescription;

    private String careerDescription;

    public void update(
            String careerName,
            String careerType,
            String careerDepartment,
            String careerPosition,
            String careerStartDate,
            String careerEndDate,
            String retirementDescription,
            String careerDescription
    ) {
        this.careerName = careerName;
        this.careerType = careerType;
        this.careerDepartment = careerDepartment;
        this.careerPosition = careerPosition;
        this.careerStartDate = careerStartDate;
        this.careerEndDate = careerEndDate;
        this.retirementDescription = retirementDescription;
        this.careerDescription = careerDescription;
    }
}
