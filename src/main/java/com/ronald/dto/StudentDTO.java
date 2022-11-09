package com.ronald.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private Integer id;
    private String nameStudent;
    private String lastnameStudent;
    private String dniStudent;
    private int ageStudent;

}
