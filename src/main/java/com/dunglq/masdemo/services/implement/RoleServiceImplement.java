package com.dunglq.masdemo.services.implement;

import com.dunglq.masdemo.entities.Role;
import com.dunglq.masdemo.exceptions.BaseException;
import com.dunglq.masdemo.repositories.RoleRepository;
import com.dunglq.masdemo.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImplement  implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleByRoleId(int roleId) throws BaseException {
        return roleRepository.findById(roleId).orElseThrow(() ->
                new BaseException(1003, "Can't find account", HttpStatus.BAD_REQUEST));
    }
}
