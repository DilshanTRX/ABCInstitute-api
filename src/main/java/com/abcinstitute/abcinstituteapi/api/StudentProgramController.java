package com.abcinstitute.abcinstituteapi.api;

import com.abcinstitute.abcinstituteapi.dto.request.StudentProgramRequestDto;
import com.abcinstitute.abcinstituteapi.service.StudentProgramService;
import com.abcinstitute.abcinstituteapi.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/studentprogram")
public class StudentProgramController {

    @Autowired
    private StudentProgramService studentprogramService;

    @PostMapping(value = "/create",params = {"student_id","program_id"},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE}
    )   // http://localhost:8000/api/v1/studentprogram/create (POST)

    public ResponseEntity<StandardResponse> save(@RequestBody StudentProgramRequestDto dto,@RequestParam int student_id, @RequestParam int program_id) throws ClassNotFoundException {
        return new ResponseEntity<>(
                new StandardResponse(
                        201 ,
                        studentprogramService.saveStudentProgram(dto,student_id,program_id),
                        null
                ), HttpStatus.CREATED
        );
    }

//    @GetMapping("/{id}")   // http://localhost:8000/api/v1/studentprogram/15 (GET)
//    public ResponseEntity<StandardResponse> findStudent(@PathVariable int id) throws ClassNotFoundException {
//
//        return  new ResponseEntity<>(
//                new StandardResponse(
//                        200,
//                        id+" details ",
//                        studentprogramService.findStudentProgram(id)
//                ),HttpStatus.OK
//        );
//
//    }
//    @PutMapping(value = "/modify",params = {"id"})  // http://localhost:8000/api/v1/studentprogram/modify?id=15
//    public ResponseEntity<StandardResponse> updateStudentProgram(@RequestBody StudentProgramRequestDto dto, @RequestParam int id) throws ClassNotFoundException {
//        return new ResponseEntity<>(
//                new StandardResponse(
//                        201,
//                        studentprogramService.updateStudentProgram(dto, id),
//                        null
//                ),HttpStatus.CREATED
//        );
//
//    }
//    @DeleteMapping("/remove/{id}")   // http://localhost:8000/api/v1/studentprogram/15 (DELETE)
//    public ResponseEntity<StandardResponse> deleteStudentProgram(@PathVariable int id){
//
//        return new ResponseEntity<>(
//                new StandardResponse(
//                        204,
//                        studentprogramService.deleteStudentProgram(id),
//                        null
//                ),HttpStatus.NO_CONTENT
//        );
//    }

    // method how the data is being request in pagination
    //api/v1/student/list?searchText=sdf&page=1&size=20
//    @GetMapping(value = "/list", params = {"searchText","page","size"})     // http://localhost:8000/api/v1/studentprogram/list (GET)
//    public ResponseEntity<StandardResponse> findAllStudentsPrograms(
//            @RequestParam String searchText,
//            @RequestParam int page,
//            @RequestParam int size
//    ){
//        return new ResponseEntity<>(
//                new StandardResponse(
//                        200,
//                        "Data List!",
//                        studentprogramService.findAllStudentProgram(searchText,page,size)
//                ),HttpStatus.OK
//        );
//
//    }

}
