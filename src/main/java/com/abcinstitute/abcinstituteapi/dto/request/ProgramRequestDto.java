package com.abcinstitute.abcinstituteapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProgramRequestDto {
    private String program_name;
    private String program_duration;
    private double program_cost;
}
