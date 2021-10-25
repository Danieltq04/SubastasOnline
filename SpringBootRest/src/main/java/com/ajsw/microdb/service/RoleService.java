package com.ajsw.microdb.service;

import com.ajsw.microdb.dto.RoleRequest;
import com.ajsw.microdb.exception.SystemLoginException;
import com.ajsw.microdb.model.Role;
import com.ajsw.microdb.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }
    public Role save(RoleRequest roleRequest){
        Role role = new Role();
        role.setRole(roleRequest.getRole());
        roleRepository.save(role);
        return roleRepository.save(role);
    }
    public Role delete(String id){
        Role role = roleRepository.getRoleById(id);
        if(role == null){
            throw new SystemLoginException("");
        }
        return roleRepository.deleteRoleById(id);
    }
    public Role update(Role role){
        Role roleUpdate = roleRepository.getRoleById(role.getId());
        roleUpdate.setRole(role.getRole());
        roleRepository.save(roleUpdate);
        return roleUpdate;
    }
    public List<Role> getAll(){
        return roleRepository.findAll();
    }
    public Role getById(String id){
        return roleRepository.getRoleById(id);
    }
}
