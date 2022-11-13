package com.ronald.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private Integer id;
    @NotNull
    @NotEmpty
    @Size(max = 50)
    private String nameStudent;
    @NotNull
    @NotEmpty
    @Size(max = 50)
    private String lastnameStudent;
    @NotNull
    @NotEmpty
    @Size(min = 8, max = 8)
    private String dniStudent;
    @NotNull
    @NotEmpty
    private int ageStudent;

}
