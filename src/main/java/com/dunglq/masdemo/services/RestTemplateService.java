package com.dunglq.masdemo.services;

import com.dunglq.masdemo.entities.Account;
import com.dunglq.masdemo.exceptions.BaseException;
import com.dunglq.masdemo.request.CreateAccountDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface RestTemplateService {
    ResponseEntity<String> getAllAccounts();
    ResponseEntity<Account> createAccount(CreateAccountDTO createAccountDTO) throws BaseException;
}
