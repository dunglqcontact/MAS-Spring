package com.dunglq.masdemo.services.implement;

import com.dunglq.masdemo.entities.Role;
import com.dunglq.masdemo.entities.Status;
import com.dunglq.masdemo.exceptions.BaseException;
import com.dunglq.masdemo.request.CreateAccountDTO;
import com.dunglq.masdemo.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.dunglq.masdemo.repositories.AccountRepository;
import com.dunglq.masdemo.services.AccountService;

import java.util.Date;
import java.util.Optional;

@Service
public class AccountServiceImplement implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Page<Account> getAccounts(Pageable pageable) {
        return accountRepository.findAll(pageable);
    }

    @Override
    public Account getAccountByAccountId(long id) throws BaseException {
        return accountRepository.findById(id).orElseThrow(() ->
                new BaseException(1003, "Can't find account", HttpStatus.BAD_REQUEST));
    }

    @Override
    public Account createAccount(CreateAccountDTO request) throws BaseException {
        Optional<Account> optionalAccount = Optional.ofNullable(accountRepository.findByUserName(request.getUserName()));
        if (optionalAccount.isPresent()) {
            throw new BaseException(1003, "Username already exist", HttpStatus.BAD_REQUEST);
        }
        Date date = new Date();
        Account newAccount = Account.builder()
                .userName(request.getUserName())
                .password(request.getPassword())
                .role(new Role(2L,"user"))
                .createDate(date)
                .status(new Status(1L,"active"))
                .build();
        return accountRepository.save(newAccount);
    }

    @Override
    public void deleteAccount(long id) throws BaseException {
        Account customer = accountRepository.findById(id).orElseThrow(() ->
                new BaseException(1000, "Can't find customer", HttpStatus.NOT_FOUND));
        accountRepository.delete(customer);
    }
}
