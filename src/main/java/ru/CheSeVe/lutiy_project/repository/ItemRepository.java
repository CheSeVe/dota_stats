package ru.CheSeVe.lutiy_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.CheSeVe.lutiy_project.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {

}
