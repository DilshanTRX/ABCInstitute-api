package com.abcinstitute.abcinstituteapi.dto.response.paginate;

import com.abcinstitute.abcinstituteapi.dto.response.ProgramResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedProgramResponseDto {
    private long dataCount;
    private List<ProgramResponseDto> dataList;
}
