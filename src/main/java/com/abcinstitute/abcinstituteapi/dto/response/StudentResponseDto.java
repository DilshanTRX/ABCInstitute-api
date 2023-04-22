package com.abcinstitute.abcinstituteapi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponseDto {
  private String student_id;
  private String student_name;
  private String student_address;
  private String student_contact;
}
