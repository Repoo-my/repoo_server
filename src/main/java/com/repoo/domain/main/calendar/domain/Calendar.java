package com.repoo.domain.main.calendar.domain;

import com.repoo.domain.main.user.domain.Users;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Calendar {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long calendarId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private Users user;

    private String calendarTitle;

    private LocalDate calendarStartDate;

    private LocalDate calendarEndDate;

    private Boolean isAllDay;

    public Calendar(
            Users user,
            String calendarTitle,
            LocalDate calendarStartDate,
            LocalDate calendarEndDate,
            Boolean isAllDay
    ){
        this.user = user;
        this.calendarTitle = calendarTitle;
        this.calendarStartDate = calendarStartDate;
        this.calendarEndDate = calendarEndDate;
        this.isAllDay = isAllDay;
    }

    public void update(
            Users user,
            String calendarTitle,
            LocalDate calendarStartDate,
            LocalDate calendarEndDate,
            Boolean isAllDay
    ){
        this.user = user;
        this.calendarTitle = calendarTitle;
        this.calendarStartDate = calendarStartDate;
        this.calendarEndDate = calendarEndDate;
        this.isAllDay = isAllDay;
    }
}
