package com.repoo.domain.main.calendar.presentation.dto.res;

import java.time.LocalDate;

public record ResponseCalendar(
        Long calendarId,
        String calendarTitle,
        LocalDate calendarStartDate,
        LocalDate calendarEndDate,
        Boolean isAllDay
) {
}
