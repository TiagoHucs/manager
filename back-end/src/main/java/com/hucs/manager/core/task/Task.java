package com.hucs.manager.core.task;

import com.hucs.manager.core.user.User;
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
    private LocalDateTime createdDateTime;
    private LocalDateTime startedDateTime;
    private LocalDateTime closedDateTime;

    @ManyToOne
    private User assignedTo;

    @PrePersist
    public void prePersist(){
        this.createdDateTime = LocalDateTime.now();
        this.status = this.status != null ? this.status : TaskStatus.OPEN;
    }

}
