package com.abcinstitute.abcinstituteapi.service.impl;

import com.abcinstitute.abcinstituteapi.dto.ProgramDto;
import com.abcinstitute.abcinstituteapi.dto.request.ProgramRequestDto;
import com.abcinstitute.abcinstituteapi.entity.Program;
import com.abcinstitute.abcinstituteapi.repo.ProgramRepo;
import com.abcinstitute.abcinstituteapi.dto.response.ProgramResponseDto;
import com.abcinstitute.abcinstituteapi.dto.response.paginate.PaginatedProgramResponseDto;
import com.abcinstitute.abcinstituteapi.service.ProgramService;
import com.abcinstitute.abcinstituteapi.util.mapper.ProgramMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
@EnableAutoConfiguration
public class ProgramServiceImpl implements ProgramService {

    @Autowired
    private ProgramRepo programRepo;



    @Autowired
    private ProgramMapper programMapper;

    @Override
    public String saveProgram(ProgramRequestDto dto) {
Program program= new Program(0,dto.getProgram_name(), dto.getProgram_duration(), dto.getProgram_cost(),null);
        ProgramDto pDto = new ProgramDto();
        return  programRepo.save(program).getProgram_id()+" Saved";

    }

    @Override
    public ProgramResponseDto findProgram(int id) throws ClassNotFoundException {
        Optional<Program> byId =programRepo.findById(id);
        if(byId.isPresent()){
            return programMapper.toProgramResponseDto(byId.get());
        }
        throw new ClassNotFoundException("Not Found");
    }

    @Override
    public String updateProgram(ProgramRequestDto dto, int id) throws ClassNotFoundException {
        Optional<Program> byId = programRepo.findById(id);

        if(byId.isPresent()) {

            byId.get().setProgram_name(dto.getProgram_name());
            byId.get().setProgram_duration(dto.getProgram_duration());
            byId.get().setProgram_cost(dto.getProgram_cost());
            programRepo.save(byId.get());
            return byId.get().getProgram_name() + " was updated!";
        }
        throw new ClassNotFoundException("Not Found");
    }

    @Override
    public String deleteProgram(int id) {

        programRepo.deleteById(id);
        return id+ "was deleted";
    }

    @Override
    public PaginatedProgramResponseDto findAllProgram(String searchText, int page, int size) {

        return new PaginatedProgramResponseDto(
                programRepo.countProgram(searchText),
                programMapper.toProgramResponseDtoList(programRepo.searchProgram(
                        searchText, PageRequest.of(page, size)
                ))
        );
    }
}
