package com.repoo.domain.main.calendar.service;

import com.repoo.domain.main.calendar.domain.Calendar;
import com.repoo.domain.main.calendar.exception.CalendarNotFoundException;
import com.repoo.domain.main.calendar.presentation.dto.res.ResponseCalendar;
import com.repoo.domain.main.calendar.service.implementation.CalendarReader;
import com.repoo.domain.main.user.service.QueryUsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryCalendarService {

    private final QueryUsersService queryUsersService;
    private final CalendarReader calendarReader;

    public Calendar getCalendar(Long id, Long userId) {
        Calendar calendar = calendarReader.findById(id);
        if (calendar.getUser().getUsersId().equals(queryUsersService.getUser(userId).getUsersId())){
            return calendar;
        } else {
            throw new CalendarNotFoundException();
        }
    }

    public ResponseCalendar getResponseCalendar(Long id, Long userId) {
        Calendar calendar = calendarReader.findById(id);
        if (calendar.getUser().getUsersId().equals(queryUsersService.getUser(userId).getUsersId())){
            return new ResponseCalendar(
                    calendar.getCalendarId(),
                    calendar.getCalendarTitle(),
                    calendar.getCalendarStartDate(),
                    calendar.getCalendarEndDate(),
                    calendar.getIsAllDay()
            );
        } else {
            throw new CalendarNotFoundException();
        }
    }

    public List<ResponseCalendar> getResponseCalendars(Long userId) {
        List<Calendar> calendars = calendarReader.findByUser(queryUsersService.getUser(userId));
        List<ResponseCalendar> responseCalendars = new ArrayList<>();

        for (Calendar calendar : calendars) {
            responseCalendars.add(new ResponseCalendar(
                    calendar.getCalendarId(),
                    calendar.getCalendarTitle(),
                    calendar.getCalendarStartDate(),
                    calendar.getCalendarEndDate(),
                    calendar.getIsAllDay()
            ));
        }

        return responseCalendars;
    }
}
