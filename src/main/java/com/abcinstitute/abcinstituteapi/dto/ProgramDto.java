package com.abcinstitute.abcinstituteapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProgramDto {
    private String program_id;
    private String program_name;
    private String program_duration;
    private double program_cost;
}
