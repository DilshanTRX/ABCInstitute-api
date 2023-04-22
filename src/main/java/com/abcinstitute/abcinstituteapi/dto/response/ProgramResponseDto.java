package com.abcinstitute.abcinstituteapi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProgramResponseDto {
    private String program_id;
    private String program_name;
    private String program_duration;
    private double program_cost;
}
