package com.repoo.domain.main.calendar.presentation;

import com.repoo.domain.main.calendar.presentation.dto.req.RequestCalendar;
import com.repoo.domain.main.calendar.presentation.dto.res.ResponseCalendar;
import com.repoo.domain.main.calendar.service.CommandCalendarService;
import com.repoo.domain.main.calendar.service.QueryCalendarService;
import com.repoo.global.jwt.decode.JWTPayloadDecoder;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/calendar")
public class CalendarController {

    private final QueryCalendarService queryCalendarService;
    private final CommandCalendarService commandCalendarService;
    private final JWTPayloadDecoder jWTPayloadDecoder;

    @GetMapping("/{calendarId}")
    public ResponseCalendar getCalendar(
            @RequestHeader String accessToken,
            @PathVariable Long calendarId
    ){
        return queryCalendarService.getResponseCalendar(
                calendarId,
                jWTPayloadDecoder.jwtPayloadDecodeToUserId(accessToken)
        );
    }

    @GetMapping
    public List<ResponseCalendar> getCalendar(
            @RequestHeader String accessToken
    ){
        return queryCalendarService.getResponseCalendars(
                jWTPayloadDecoder.jwtPayloadDecodeToUserId(accessToken)
        );
    }

    @PostMapping
    public void addCalendar(
            @RequestHeader String accessToken,
            @RequestBody RequestCalendar calendar
    ){
        commandCalendarService.create(
                calendar,
                jWTPayloadDecoder.jwtPayloadDecodeToUserId(accessToken)
        );
    }

    @PutMapping("/{calendarId}")
    public void updateCalendar(
            @RequestHeader String accessToken,
            @PathVariable Long calendarId,
            @RequestBody RequestCalendar calendar
    ){
        commandCalendarService.update(
                calendar,
                calendarId,
                jWTPayloadDecoder.jwtPayloadDecodeToUserId(accessToken)
        );
    }

    @DeleteMapping("/{calendarId}")
    public void deleteCalendar(
            @RequestHeader String accessToken,
            @PathVariable Long calendarId
    ){
        commandCalendarService.delete(
                calendarId,
                jWTPayloadDecoder.jwtPayloadDecodeToUserId(accessToken)
        );
    }

}
