package com.dunglq.masdemo.controllers;

import com.dunglq.masdemo.dto.ResponseDTO;
import com.dunglq.masdemo.entities.Account;
import com.dunglq.masdemo.exceptions.BaseException;
import com.dunglq.masdemo.request.CreateAccountDTO;
import com.dunglq.masdemo.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@ResponseBody
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/v1/accounts")
    public ResponseEntity<ResponseDTO> getAccounts(Pageable pageable) {
        ResponseDTO responseDTO = ResponseDTO.success();
        Page<Account> accounts = accountService.getAccounts(pageable);
        responseDTO.setData(accounts);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/v1/accounts/{userName}")
    public ResponseEntity<ResponseDTO> getAccount(@PathVariable long userName) throws BaseException {
        ResponseDTO responseDTO = ResponseDTO.success();
        Account account = accountService.getAccountByAccountId(userName);
        responseDTO.setData(account);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/v1/accounts")
    public ResponseEntity<ResponseDTO> createAccount(@Valid @RequestBody CreateAccountDTO createAccountDTO) throws BaseException {
        ResponseDTO responseDTO = ResponseDTO.success();
        Account account = accountService.createAccount(createAccountDTO);
        responseDTO.setData(account);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/v1/accounts/{userName}")
    public ResponseEntity<ResponseDTO> deleteAccount(@PathVariable long userName) throws BaseException {
        ResponseDTO responseDTO = ResponseDTO.success();
        accountService.deleteAccount(userName);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
}
