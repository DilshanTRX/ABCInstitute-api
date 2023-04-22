package com.abcinstitute.abcinstituteapi.api;

import com.abcinstitute.abcinstituteapi.dto.request.StudentRequestDto;
import com.abcinstitute.abcinstituteapi.service.StudentService;
import com.abcinstitute.abcinstituteapi.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping(value = "/create",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE}
    )   // http://localhost:8000/api/v1/student/create (POST)

    public ResponseEntity<StandardResponse> save(@RequestBody StudentRequestDto dto){
        return new ResponseEntity<>(
                new StandardResponse(
                        201 ,
                        studentService.saveStudent(dto),
                        null
                ), HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")   // http://localhost:8000/api/v1/student/15 (GET)
    public ResponseEntity<StandardResponse> findStudent(@PathVariable int id) throws ClassNotFoundException {

        return  new ResponseEntity<>(
                new StandardResponse(
                        200,
                        id+" details ",
                        studentService.findStudent(id)
                ),HttpStatus.OK
        );

    }
    @PutMapping(value = "/modify",params = {"id"})  // http://localhost:8000/api/v1/student/modify?id=15
    public ResponseEntity<StandardResponse> updateStudent(@RequestBody StudentRequestDto dto, @RequestParam int id) throws ClassNotFoundException {
        return new ResponseEntity<>(
                new StandardResponse(
                        201,
                      studentService.updateStudent(dto, id),
                        null
                ),HttpStatus.CREATED
        );

    }
    @DeleteMapping("/remove/{id}")   // http://localhost:8000/api/v1/student/15 (DELETE)
    public ResponseEntity<StandardResponse> deleteStudent(@PathVariable int id){

        return new ResponseEntity<>(
                new StandardResponse(
                        204,
                       studentService.deleteStudent(id),
                        null
                ),HttpStatus.NO_CONTENT
        );
    }

    // method how the data is being request in pagination
    //api/v1/student/list?searchText=sdf&page=1&size=20
    @GetMapping(value = "/list", params = {"searchText","page","size"})     // http://localhost:8000/api/v1/student/list (GET)
    public ResponseEntity<StandardResponse> findAllStudents(
            @RequestParam String searchText,
            @RequestParam int page,
            @RequestParam int size
    ){
        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        "Data List!",
                        studentService.findAllStudent(searchText,page,size)
                ),HttpStatus.OK
        );

    }

}
