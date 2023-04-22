package com.abcinstitute.abcinstituteapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDto {
    private String student_id;
    private String student_name;
    private String student_address;
    private String student_contact;
}
