package ru.CheSeVe.lutiy_project.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.CheSeVe.lutiy_project.entity.User;
import java.util.Optional;
import java.util.stream.Stream;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Stream<User> findByUserName(String userName);
    User findUserByUserName(String userName);
    Optional<User> findOptionalUserName(String userName);
}
