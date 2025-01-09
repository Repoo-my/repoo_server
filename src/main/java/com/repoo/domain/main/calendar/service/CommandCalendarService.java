package com.repoo.domain.main.calendar.service;

import com.repoo.domain.main.calendar.domain.Calendar;
import com.repoo.domain.main.calendar.presentation.dto.req.RequestCalendar;
import com.repoo.domain.main.calendar.service.implementation.CalendarCreator;
import com.repoo.domain.main.calendar.service.implementation.CalendarDeleter;
import com.repoo.domain.main.calendar.service.implementation.CalendarReader;
import com.repoo.domain.main.calendar.service.implementation.CalendarUpdater;
import com.repoo.domain.main.user.domain.Users;
import com.repoo.domain.main.user.service.QueryUsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandCalendarService {

    private final CalendarReader calendarReader;
    private final CalendarCreator calendarCreator;
    private final CalendarUpdater calendarUpdater;
    private final CalendarDeleter calendarDeleter;
    private final QueryUsersService queryUsersService;

    public void create(RequestCalendar requestCalendar, Long userId){
        calendarCreator.save(new Calendar(
                queryUsersService.getUser(userId),
                requestCalendar.calendarTitle(),
                requestCalendar.calendarStartDate(),
                requestCalendar.calendarEndDate(),
                requestCalendar.isAllDay()
        ));
    }

    public void update(RequestCalendar requestCalendar, Long id, Long userId){
        Calendar calendar = calendarReader.findById(id);
        Users user = queryUsersService.getUser(userId);
        if(calendar.getUser().getUsersId().equals(user.getUsersId())) {
            calendarUpdater.update(
                    calendar,
                    new Calendar(
                            user,
                            requestCalendar.calendarTitle(),
                            requestCalendar.calendarStartDate(),
                            requestCalendar.calendarEndDate(),
                            requestCalendar.isAllDay()
                    )
            );
        }
    }

    public void delete(Long id, Long userId){
        if(calendarReader.findById(id).getUser().getUsersId().equals(queryUsersService.getUser(userId).getUsersId())) {
            calendarDeleter.delete(id);
        }
    }
}
