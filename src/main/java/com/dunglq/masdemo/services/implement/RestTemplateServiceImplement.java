package com.dunglq.masdemo.services.implement;

import com.dunglq.masdemo.entities.Account;
import com.dunglq.masdemo.entities.Role;
import com.dunglq.masdemo.entities.Status;
import com.dunglq.masdemo.exceptions.BaseException;
import com.dunglq.masdemo.request.CreateAccountDTO;
import com.dunglq.masdemo.services.RestTemplateService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Date;

@Service
public class RestTemplateServiceImplement implements RestTemplateService {

    RestTemplate restTemplate = new RestTemplate();
    private static final String  account_Url = "http://localhost:8080/v1/accounts";

    @Override
    public ResponseEntity<String> getAllAccounts() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        //headers.add("Authorization", headerValue);

        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        ResponseEntity<String> response = response = restTemplate.exchange(account_Url, HttpMethod.GET,entity, String.class);
        return response;
    }

    public ResponseEntity<Account> createAccount(CreateAccountDTO createAccountDTO) throws BaseException {
        Date date = new Date();
        Account newAccount = Account.builder()
                .userName(createAccountDTO.getUserName())
                .password(createAccountDTO.getPassword())
                .role(new Role(2L,"user"))
                .createDate(date)
                .status(new Status(1L,"active"))
                .build();
        return restTemplate.postForEntity(account_Url, newAccount, Account.class);
    }
}
