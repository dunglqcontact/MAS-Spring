package com.dunglq.masdemo.controllers;


import com.dunglq.masdemo.dto.ResponseDTO;
import com.dunglq.masdemo.entities.Account;
import com.dunglq.masdemo.entities.Role;
import com.dunglq.masdemo.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ResponseBody
public class RoleController {
    @Autowired
    private RoleService roleService;
    @GetMapping("/v1/roles")
    public ResponseEntity<ResponseDTO> getRoles() {
        ResponseDTO responseDTO = ResponseDTO.success();
        List<Role> roles = roleService.getRoles();
        responseDTO.setData(roles);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
