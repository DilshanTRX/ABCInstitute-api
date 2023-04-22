package com.abcinstitute.abcinstituteapi.api;

import com.abcinstitute.abcinstituteapi.dto.request.ProgramRequestDto;
import com.abcinstitute.abcinstituteapi.service.ProgramService;
import com.abcinstitute.abcinstituteapi.service.StudentService;
import com.abcinstitute.abcinstituteapi.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/program")
public class ProgramController {
    @Autowired
    private ProgramService programService;

    @PostMapping(value = "/create",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE}
    )   // http://localhost:8000/api/v1/program/create (POST)

    public ResponseEntity<StandardResponse> save(@RequestBody ProgramRequestDto dto){
        return new ResponseEntity<>(
                new StandardResponse(
                        201 ,
                       programService.saveProgram(dto),
                        null
                ), HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")   // http://localhost:8000/api/v1/program/15 (GET)
    public ResponseEntity<StandardResponse> findProgram(@PathVariable int id) throws ClassNotFoundException {

        return  new ResponseEntity<>(
                new StandardResponse(
                        200,
                        id+" details ",
                      programService.findProgram(id)
                ),HttpStatus.OK
        );

    }
    @PutMapping(value = "/modify",params = {"id"})  // http://localhost:8000/api/v1/program/modify?id=15
    public ResponseEntity<StandardResponse> updateProgram(@RequestBody ProgramRequestDto dto, @RequestParam int id) throws ClassNotFoundException {
        return new ResponseEntity<>(
                new StandardResponse(
                        201,
                        programService.updateProgram(dto, id),
                        null
                ),HttpStatus.CREATED
        );

    }
    @DeleteMapping("/remove/{id}")   // http://localhost:8000/api/v1/program/15 (DELETE)
    public ResponseEntity<StandardResponse> deleteProgram(@PathVariable int id){

        return new ResponseEntity<>(
                new StandardResponse(
                        204,
                       programService.deleteProgram(id),
                        null
                ),HttpStatus.NO_CONTENT
        );
    }

    // method how the data is being request in pagination
    //api/v1/program/list?searchText=sdf&page=1&size=20
    @GetMapping(value = "/list", params = {"searchText","page","size"})     // http://localhost:8000/api/v1/program/list (GET)
    public ResponseEntity<StandardResponse> findAllCustomers(
            @RequestParam String searchText,
            @RequestParam int page,
            @RequestParam int size
    ){
        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        "Data List!",
                        programService.findAllProgram(searchText,page,size)
                ),HttpStatus.OK
        );

    }
}
