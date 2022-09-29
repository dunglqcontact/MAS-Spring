package com.dunglq.masdemo.services;

import com.dunglq.masdemo.entities.Account;
import com.dunglq.masdemo.entities.Role;
import com.dunglq.masdemo.exceptions.BaseException;
import com.dunglq.masdemo.request.CreateAccountDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RoleService {
    List<Role> getRoles();
    Role getRoleByRoleId (int accountId) throws BaseException;
}
