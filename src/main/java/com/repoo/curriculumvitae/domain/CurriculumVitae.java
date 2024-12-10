package com.repoo.curriculumvitae.domain;

import com.repoo.enterprise.domain.Enterprise;
import com.repoo.user.domain.Users;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class CurriculumVitae {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long curriculumVitaeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private Users user;

    @Column(length = 100)
    private String curriculumVitaeTitle; // 이력서 제목

    private String curriculumVitaeEmail;

    @Column(length = 11)
    private String curriculumVitaePhone;

    private String curriculumVitaeIntroduction; // 이력서 간단한 소개

    private String curriculumVitaeAddress;
}
