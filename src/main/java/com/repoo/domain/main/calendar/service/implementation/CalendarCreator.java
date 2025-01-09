package com.repoo.domain.main.calendar.service.implementation;

import com.repoo.domain.main.calendar.domain.Calendar;
import com.repoo.domain.main.calendar.domain.repository.CalendarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalendarCreator {

    private final CalendarRepository calendarRepository;

    public void save(Calendar calendar) {
        calendarRepository.save(calendar);
    }

}
