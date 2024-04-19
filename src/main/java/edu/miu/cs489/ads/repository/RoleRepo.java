package edu.miu.cs489.ads.repository;


import edu.miu.cs489.ads.enums.Roles;
import edu.miu.cs489.ads.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepo extends CrudRepository<Role,Long> {


    Role findByRole(Roles role);
}
