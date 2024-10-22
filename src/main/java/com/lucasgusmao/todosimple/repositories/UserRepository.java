package com.lucasgusmao.todosimple.repositories;

import com.lucasgusmao.todosimple.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
