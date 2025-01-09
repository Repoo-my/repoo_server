package com.repoo.domain.main.calendar.service.implementation;

import com.repoo.domain.main.calendar.domain.repository.CalendarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalendarDeleter {

    private final CalendarRepository calendarRepository;

    public void delete(Long id){
        calendarRepository.deleteById(id);
    }
}
