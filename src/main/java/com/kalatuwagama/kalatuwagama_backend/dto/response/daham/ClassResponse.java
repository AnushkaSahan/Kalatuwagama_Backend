package com.kalatuwagama.kalatuwagama_backend.dto.response.daham;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ClassResponse {
    private UUID id;
    private UUID dahamPasalaId;
    private String dahamPasalaName;
    private String name;
    private String grade;
    private UUID teacherId;
    private String teacherName;
    private String room;
    private String schedule;
    private Integer capacity;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
