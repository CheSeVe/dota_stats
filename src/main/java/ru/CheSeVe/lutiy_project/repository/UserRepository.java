package ru.CheSeVe.lutiy_project.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.CheSeVe.lutiy_project.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
