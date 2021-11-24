package edu.fiu.wfan.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.fiu.wfan.entity.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer>{

}
