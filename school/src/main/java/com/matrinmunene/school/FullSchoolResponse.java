package com.matrinmunene.school;

import lombok.*;
import java.util.List;

/**
 * @author Martin Munene
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FullSchoolResponse {
    private String name;
    private String email;
    List<Student> students;
}