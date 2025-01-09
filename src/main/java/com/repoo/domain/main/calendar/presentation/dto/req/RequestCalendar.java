package com.repoo.domain.main.calendar.presentation.dto.req;

import java.time.LocalDate;

public record RequestCalendar (
        String calendarTitle,
        LocalDate calendarStartDate,
        LocalDate calendarEndDate,
        Boolean isAllDay
){
}
