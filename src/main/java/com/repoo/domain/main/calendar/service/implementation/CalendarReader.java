package com.repoo.domain.main.calendar.service.implementation;

import com.repoo.domain.main.calendar.domain.Calendar;
import com.repoo.domain.main.calendar.domain.repository.CalendarRepository;
import com.repoo.domain.main.calendar.exception.CalendarNotFoundException;
import com.repoo.domain.main.user.domain.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CalendarReader {

    private final CalendarRepository calendarRepository;

    public Calendar findById(Long calendarId) {
        return calendarRepository.findById(calendarId)
                .orElseThrow(CalendarNotFoundException::new);
    }

    public List<Calendar> findByUser(Users user) {
        return calendarRepository.findByUser(user);
    }
}
