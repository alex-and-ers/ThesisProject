package main.repository;

import main.model.User;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface Repo extends CrudRepository<User, Long>
{
}
