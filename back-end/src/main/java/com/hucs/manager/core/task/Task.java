package com.hucs.manager.core.task;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_TASK")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    private String name;
    private String description;
    private TaskStatus status;
    private LocalDate targetDate;
    private LocalDateTime createdDateTime;
    private LocalDateTime closedDateTime;

    @PrePersist
    public void prePersist(){
        this.createdDateTime = LocalDateTime.now();
        this.status = this.status != null ? this.status : TaskStatus.OPEN;
    }

}
