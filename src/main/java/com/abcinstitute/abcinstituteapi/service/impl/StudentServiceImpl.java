package com.abcinstitute.abcinstituteapi.service.impl;

import com.abcinstitute.abcinstituteapi.dto.StudentDto;
import com.abcinstitute.abcinstituteapi.dto.request.StudentRequestDto;
import com.abcinstitute.abcinstituteapi.entity.Student;
import com.abcinstitute.abcinstituteapi.repo.StudentRepo;
import com.abcinstitute.abcinstituteapi.dto.response.StudentResponseDto;
import com.abcinstitute.abcinstituteapi.dto.response.paginate.PaginatedStudentResponseDto;
import com.abcinstitute.abcinstituteapi.service.StudentService;
import com.abcinstitute.abcinstituteapi.util.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
@EnableAutoConfiguration
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;



    @Autowired
    private StudentMapper studentMapper;

    @Override
    public String saveStudent(StudentRequestDto dto) {
        Student student= new Student(0,dto.getStudent_name(), dto.getStudent_address(), dto.getStudent_contact(),null);
        StudentDto sDto = new StudentDto();
        return studentRepo.save(student).getStudent_id()+" Saved";

    }

    @Override
    public StudentResponseDto findStudent(int id) throws ClassNotFoundException {
        Optional<Student> byId =studentRepo.findById(id);
        //System.out.println(byId.get().getStudent_name());
        if(byId.isPresent()){
//            System.out.println(studentMapper.toStudentResponseDto(byId.get()).getStudent_name());
            return studentMapper.toStudentResponseDto(byId.get());
        }
        throw new ClassNotFoundException("Not Found");
    }

    @Override
    public String updateStudent(StudentRequestDto dto, int id) throws ClassNotFoundException {

        Optional<Student> byId = studentRepo.findById(id);

        if(byId.isPresent()) {

            byId.get().setStudent_name(dto.getStudent_name());
            byId.get().setStudent_address(dto.getStudent_address());
            byId.get().setStudent_contact(dto.getStudent_contact());
            studentRepo.save(byId.get());
            return byId.get().getStudent_name() + " was updated!";
        }
        throw new ClassNotFoundException("Not Found");
    }

    @Override
    public String deleteStudent(int id) {
        studentRepo.deleteById(id);
        return id+ "was deleted";
    }

    @Override
    public PaginatedStudentResponseDto findAllStudent(String searchText, int page, int size) {
        return new PaginatedStudentResponseDto(
                studentRepo.countStudent(searchText),
               studentMapper.toStudentResponseDtoList(studentRepo.searchStudent(
                        searchText, PageRequest.of(page, size)
                ))
        );


    }
}
