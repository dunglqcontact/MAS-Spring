package com.dunglq.masdemo.services;

import com.dunglq.masdemo.exceptions.BaseException;
import com.dunglq.masdemo.request.CreateAccountDTO;
import com.dunglq.masdemo.entities.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AccountService {
    Page<Account> getAccounts(Pageable pageable);
    Account getAccountByAccountId (long accountId) throws BaseException;
    Account createAccount(CreateAccountDTO request) throws BaseException;
    void deleteAccount(long userName) throws BaseException;
}
