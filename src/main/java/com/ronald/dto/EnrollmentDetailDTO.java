package com.ronald.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnrollmentDetailDTO {
    private Integer id;
    @NotNull
    @NotEmpty
    @JsonBackReference
    private EnrollmentDTO enrollment;
    @NotNull
    @NotEmpty
    private SubjectDTO subject;
    @NotNull
    @NotEmpty
    @Size(min = 3, max = 3)
    private String room;
}
