package com.abcinstitute.abcinstituteapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentRequestDto {
    private  String student_name;
    private  String student_address;
    private String student_contact;
}
