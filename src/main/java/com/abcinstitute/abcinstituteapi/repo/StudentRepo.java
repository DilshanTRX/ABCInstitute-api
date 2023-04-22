package com.abcinstitute.abcinstituteapi.repo;

import com.abcinstitute.abcinstituteapi.entity.Student;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student,Integer> {

    @Query(value = "SELECT student_id,student_name,student_address,student_contact FROM student where student_name like %?1% || student_id like %?1%",nativeQuery = true)
    public List<Student> searchStudent(String searchText, PageRequest pageable);

    @Query(value = "SELECT count(student_id) FROM student where student_name like %?1% || student_id like %?1%",nativeQuery = true)
    public int countStudent(String searchText);

}
