package com.abcinstitute.abcinstituteapi.repo;


import com.abcinstitute.abcinstituteapi.entity.StudentProgram;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentProgramRepo extends JpaRepository<StudentProgram,Integer> {
    @Query(value = "SELECT id,student_student_id,program_program_id,register_date FROM student_has_program where student_student_id like %?1% || program_program_id like %?1%",nativeQuery = true)
    public List<StudentProgram> searchStudentProgram(String searchText, PageRequest pageable);

    @Query(value = "SELECT count(id) FROM student_has_program where student_student_id like %?1% || program_program_id like %?1%",nativeQuery = true)
    public int countStudentProgram(String searchText);
}
