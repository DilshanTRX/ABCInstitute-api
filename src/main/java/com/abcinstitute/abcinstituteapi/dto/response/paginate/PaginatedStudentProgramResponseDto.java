package com.abcinstitute.abcinstituteapi.dto.response.paginate;


import com.abcinstitute.abcinstituteapi.dto.response.StudentProgramResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedStudentProgramResponseDto {
    private long dataCount;
    private List<StudentProgramResponseDto> dataList;
}
