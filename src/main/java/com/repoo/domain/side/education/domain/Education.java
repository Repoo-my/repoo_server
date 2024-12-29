package com.repoo.domain.side.education.domain;

import com.repoo.domain.main.curriculumvitae.domain.CurriculumVitae;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long educationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curriculumVitaeId")
    private CurriculumVitae curriculumVitae;

    private String schoolName;

    private String departmentName;

    private LocalDate admission_day;

    private LocalDate graduation_day;

    public Education(CurriculumVitae curriculumVitae, String schoolName, String departmentName, LocalDate admission_day, LocalDate graduation_day) {
        this.curriculumVitae = curriculumVitae;
        this.schoolName = schoolName;
        this.departmentName = departmentName;
        this.admission_day = admission_day;
        this.graduation_day = graduation_day;
    }

    public void update(String schoolName, String departmentName, LocalDate admission_day, LocalDate graduation_day) {
        this.schoolName = schoolName;
        this.departmentName = departmentName;
        this.admission_day = admission_day;
        this.graduation_day = graduation_day;
    }
}
