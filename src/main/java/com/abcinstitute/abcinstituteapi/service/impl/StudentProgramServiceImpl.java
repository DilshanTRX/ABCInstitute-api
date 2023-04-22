package com.abcinstitute.abcinstituteapi.service.impl;


import com.abcinstitute.abcinstituteapi.dto.StudentProgramDto;
import com.abcinstitute.abcinstituteapi.dto.request.StudentProgramRequestDto;
import com.abcinstitute.abcinstituteapi.entity.Program;
import com.abcinstitute.abcinstituteapi.entity.Student;
import com.abcinstitute.abcinstituteapi.entity.StudentProgram;
import com.abcinstitute.abcinstituteapi.repo.ProgramRepo;
import com.abcinstitute.abcinstituteapi.repo.StudentProgramRepo;
import com.abcinstitute.abcinstituteapi.dto.response.StudentProgramResponseDto;
import com.abcinstitute.abcinstituteapi.dto.response.paginate.PaginatedStudentProgramResponseDto;
import com.abcinstitute.abcinstituteapi.repo.StudentRepo;
import com.abcinstitute.abcinstituteapi.service.StudentProgramService;
import com.abcinstitute.abcinstituteapi.util.mapper.StudentProgramMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@EnableAutoConfiguration
public class StudentProgramServiceImpl implements StudentProgramService {
    @Autowired
    private StudentProgramRepo studentprogramRepo;
 @Autowired
    private StudentRepo studentRepo;

 @Autowired
 private ProgramRepo programRepo;


    @Autowired
    private StudentProgramMapper studentprogramMapper;

    @Override
    public String saveStudentProgram(StudentProgramRequestDto dto,int student_id,int program_id) throws ClassNotFoundException {
        Optional<Student> studentId =studentRepo.findById(student_id);
        //System.out.println(byId.get().getStudent_name());

        if(studentId.isEmpty()){
//            System.out.println(studentMapper.toStudentResponseDto(byId.get()).getStudent_name());
            throw new ClassNotFoundException("Student Not Found");
        }

        Optional<Program> programId =programRepo.findById(program_id);
        //System.out.println(byId.get().getStudent_name());

        if(programId.isEmpty()){
//            System.out.println(studentMapper.toStudentResponseDto(byId.get()).getStudent_name());
            throw new ClassNotFoundException("Program Not Found");
        }

        StudentProgram studentprogram= new StudentProgram(0,studentId.get(), programId.get(), dto.getRegister_date());
        StudentProgramDto spDto = new StudentProgramDto();
        return  studentprogramRepo.save(studentprogram).getStudentId()+" Saved";

    }


//    @Override
//    public StudentProgramResponseDto findStudentProgram(int id) throws ClassNotFoundException {
//        Optional<StudentProgram> byId =studentprogramRepo.findById(id);
//        if(byId.isPresent()){
//            return studentprogramMapper.toStudentProgramResponseDto(byId.get());
//        }
//        throw new ClassNotFoundException("Not Found");
//    }
//
//    @Override
//    public String updateStudentProgram(StudentProgramRequestDto dto, int id) throws ClassNotFoundException {
//        Optional<StudentProgram> byId = studentprogramRepo.findById(id);
//
//        if(byId.isPresent()) {
//
//            byId.get().setStudentId((Student) dto.getStudent_student_id());
//            byId.get().setProgramId((Program) dto.getProgram_program_id());
//            byId.get().setRegister_date(dto.getRegister_date());
//            studentprogramRepo.save(byId.get());
//            return byId.get().getStudentId() + " was updated!";
//        }
//        throw new ClassNotFoundException("Not Found");
//    }

//    @Override
//    public String deleteStudentProgram(int id) {
//
//        studentprogramRepo.deleteById(id);
//        return id+ "was deleted";
//    }
//
//    @Override
//    public PaginatedStudentProgramResponseDto findAllStudentProgram(String searchText, int page, int size) {
//
//        return new PaginatedStudentProgramResponseDto(
//                studentprogramRepo.countStudentProgram(searchText),
//                studentprogramMapper.toStudentProgramResponseDtoList(studentprogramRepo.searchStudentProgram(
//                        searchText, PageRequest.of(page, size)
//                ))
//        );
//    }
}
