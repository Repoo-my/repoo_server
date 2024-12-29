package com.repoo.domain.side.language.domain;

import com.repoo.domain.main.curriculumvitae.domain.CurriculumVitae;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long languageId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curriculumVitaeId")
    private CurriculumVitae curriculumVitae;

    private String languageName;

    public Language(CurriculumVitae curriculumVitae, String languageName) {
        this.curriculumVitae = curriculumVitae;
        this.languageName = languageName;
    }

    public void update(String languageName) {
        this.languageName = languageName;
    }
}
