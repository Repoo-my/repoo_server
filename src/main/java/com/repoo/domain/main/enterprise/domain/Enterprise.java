package com.repoo.domain.main.enterprise.domain;

import io.hypersistence.utils.hibernate.type.array.StringArrayType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Enterprise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long enterpriseId;

    private String enterpriseName;

    private String enterprisePassword;

    private String enterpriseDescription;

    private String enterpriseEmail;

    private String enterprisePhone;

    @Type(StringArrayType.class)
    @Column(columnDefinition = "varchar[]")
    private String[] enterpriseTags;

//    private String enterpriseImg;

    public Enterprise(String enterpriseName,
                      String enterprisePassword,
                      String enterpriseDescription,
                      String enterpriseEmail,
                      String enterprisePhone,
                      String[] enterpriseTags) {
        this.enterpriseName = enterpriseName;
        this.enterprisePassword = enterprisePassword;
        this.enterpriseDescription = enterpriseDescription;
        this.enterpriseEmail = enterpriseEmail;
        this.enterprisePhone = enterprisePhone;
        this.enterpriseTags = enterpriseTags;
    }

    public void update(String enterpriseName,
                       String enterprisePassword,
                       String enterpriseDescription,
                       String enterpriseEmail,
                       String enterprisePhone,
                       String[] enterpriseTags){
        this.enterpriseName = enterpriseName;
        this.enterprisePassword = enterprisePassword;
        this.enterpriseDescription = enterpriseDescription;
        this.enterpriseEmail = enterpriseEmail;
        this.enterprisePhone = enterprisePhone;
        this.enterpriseTags = enterpriseTags;
    }
}
