package com.lucasgusmao.todosimple;

import com.lucasgusmao.todosimple.models.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name ="user_id", nullable = false, updatable = false)
    private User user;

    @Column(name = "description", length = 250, nullable = false)
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 250)
    private String description;

}
