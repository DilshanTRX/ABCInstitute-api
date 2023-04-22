package com.abcinstitute.abcinstituteapi.service;


import com.abcinstitute.abcinstituteapi.dto.request.ProgramRequestDto;
import com.abcinstitute.abcinstituteapi.dto.response.ProgramResponseDto;
import com.abcinstitute.abcinstituteapi.dto.response.paginate.PaginatedProgramResponseDto;

public interface ProgramService {

    public String saveProgram(ProgramRequestDto dto);
    public ProgramResponseDto findProgram(int id) throws ClassNotFoundException;
    public String updateProgram(ProgramRequestDto dto, int id) throws ClassNotFoundException;
    public String deleteProgram(int id);
    public PaginatedProgramResponseDto findAllProgram(
            String searchText, int page, int size
    );

}
