package com.ajsw.microdb.repository;

import com.ajsw.microdb.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends MongoRepository<Role, Integer> {
    Role findByRole(String role);
    Role getRoleById(String id);
    Role deleteRoleById(String id);
}
