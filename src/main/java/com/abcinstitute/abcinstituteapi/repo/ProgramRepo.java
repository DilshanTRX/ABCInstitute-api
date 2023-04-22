package com.abcinstitute.abcinstituteapi.repo;

import com.abcinstitute.abcinstituteapi.entity.Program;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProgramRepo extends JpaRepository<Program,Integer> {

    @Query(value = "SELECT program_id,program_name,program_duration,program_cost FROM program where program_name like %?1% || program_id like %?1%",nativeQuery = true)
    public List<Program> searchProgram(String searchText, PageRequest pageable);

    @Query(value = "SELECT count(program_id) FROM program where program_name like %?1% || program_id like %?1%",nativeQuery = true)
    public int countProgram(String searchText);

}
