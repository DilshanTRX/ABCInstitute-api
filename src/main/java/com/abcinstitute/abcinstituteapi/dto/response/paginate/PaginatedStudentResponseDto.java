package com.abcinstitute.abcinstituteapi.dto.response.paginate;

import com.abcinstitute.abcinstituteapi.dto.response.StudentResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedStudentResponseDto {
    private long dataCount;
    private List<StudentResponseDto> dataList;
}
