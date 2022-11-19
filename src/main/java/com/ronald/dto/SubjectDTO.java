package com.ronald.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDTO {
    private Integer id;
    @NotNull
    @NotEmpty
    private String nameSubject;
    @NotNull
    @NotEmpty
    @Size(min = 2,max = 4)
    private String siglasSubject;
    @NotNull
    private boolean statusSubject;
}
