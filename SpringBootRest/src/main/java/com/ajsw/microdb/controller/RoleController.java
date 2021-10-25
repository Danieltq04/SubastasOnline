package com.ajsw.microdb.controller;

import com.ajsw.microdb.dto.RoleRequest;
import com.ajsw.microdb.model.Role;
import com.ajsw.microdb.service.RoleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/RoleController")
@CrossOrigin("*")
@Api(tags = "Role")
public class RoleController {
    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping(value = "/")
    public List<Role> getAll(){
        return roleService.getAll();
    }
    @GetMapping(value = "/{id}")
    public Role get(@PathVariable String id){
        return roleService.getById(id);
    }
    @PostMapping(value = "/")
    public Role save(@RequestBody RoleRequest roleRequest){
        return roleService.save(roleRequest);
    }
    @DeleteMapping(value = "/{id}")
    public Role delete(@PathVariable String id){
        return roleService.delete(id);
    }
    @PutMapping(value = "/")
    public Role update(@RequestBody Role request){
        return roleService.update(request);
    }

}
