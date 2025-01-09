package com.repoo.domain.main.calendar.domain.repository;

import com.repoo.domain.main.calendar.domain.Calendar;
import com.repoo.domain.main.user.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar, Long> {
    List<Calendar> findByUser(Users user);
}
