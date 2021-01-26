package com.example.getcontainers.dto;

import lombok.Data;

@Data
public class TestDto {
    private String version;
    private String pagetype;
    public TestDto(String version,String pagetype){
        this.version = version;
        this.pagetype = pagetype;
    }
}
