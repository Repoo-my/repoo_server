package com.repoo.education.domain;

import com.repoo.curriculumvitae.domain.CurriculumVitae;
import com.repoo.user.domain.Users;
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
}
