package com.ronald.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDTO {
    private Integer id;
    private String nameSubject;
    private String siglasSubject;
    private boolean statusSubject;
}
