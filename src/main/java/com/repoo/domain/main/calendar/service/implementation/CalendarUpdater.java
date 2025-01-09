package com.repoo.domain.main.calendar.service.implementation;

import com.repoo.domain.main.calendar.domain.Calendar;
import com.repoo.domain.main.calendar.domain.repository.CalendarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalendarUpdater {

    private final CalendarRepository calendarRepository;

    public void update(Calendar updatalbeCalendar, Calendar calendar) {
        updatalbeCalendar.update(
                calendar.getUser(),
                calendar.getCalendarTitle(),
                calendar.getCalendarStartDate(),
                calendar.getCalendarEndDate(),
                calendar.getIsAllDay()
        );

        calendarRepository.save(updatalbeCalendar);
    }
}
