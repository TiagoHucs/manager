package com.hucs.manager.core.task;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Builder
@Table(name = "TB_TASK")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private TaskStatus status;
    private LocalDateTime createdDateTime;
    private LocalDateTime closedDateTime;

}
