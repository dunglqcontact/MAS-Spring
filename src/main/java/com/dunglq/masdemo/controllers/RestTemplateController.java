package com.dunglq.masdemo.controllers;

import com.dunglq.masdemo.dto.ResponseDTO;
import com.dunglq.masdemo.entities.Account;
import com.dunglq.masdemo.exceptions.BaseException;
import com.dunglq.masdemo.request.CreateAccountDTO;
import com.dunglq.masdemo.services.RestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/rest-template")
public class RestTemplateController {
    @Autowired
    private RestTemplateService restTemplateService;

    @GetMapping
    public ResponseEntity<String> getAllAccount(){
        return restTemplateService.getAllAccounts();
    }

    @PostMapping
    public ResponseEntity<Account> CreateAccount(@Valid @RequestBody CreateAccountDTO createAccountDTO) throws BaseException {
        return restTemplateService.createAccount(createAccountDTO);
    }
}
