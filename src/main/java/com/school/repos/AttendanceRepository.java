package com.school.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.domain.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

}
