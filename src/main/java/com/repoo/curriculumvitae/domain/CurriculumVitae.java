package com.repoo.curriculumvitae.domain;

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
public class CurriculumVitae {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long curriculumVitaeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private Users user;

    @Column(length = 100)
    private String curriculumVitaeTitle; // 이력서 제목

    private String curriculumVitaeIntroduction; // 이력서 간단한 소개

    private String curriculumVitaeAddress;

    private LocalDate curriculumVitaeUpdateDate; // 마지막 수정 날짜

    public CurriculumVitae(
            Users user,
            String curriculumVitaeTitle,
            String curriculumVitaeIntroduction,
            String curriculumVitaeAddress,
            LocalDate curriculumVitaeUpdateDate
    ){
        this.user = user;
        this.curriculumVitaeTitle = curriculumVitaeTitle;
        this.curriculumVitaeIntroduction = curriculumVitaeIntroduction;
        this.curriculumVitaeAddress = curriculumVitaeAddress;
        this.curriculumVitaeUpdateDate = curriculumVitaeUpdateDate;
    }

    public void update(String curriculumVitaeTitle, String curriculumVitaeIntroduction, String curriculumVitaeAddress, LocalDate curriculumVitaeUpdateDate) {
        this.curriculumVitaeTitle = curriculumVitaeTitle;
        this.curriculumVitaeIntroduction = curriculumVitaeIntroduction;
        this.curriculumVitaeAddress = curriculumVitaeAddress;
        this.curriculumVitaeUpdateDate = curriculumVitaeUpdateDate;
    }
}
