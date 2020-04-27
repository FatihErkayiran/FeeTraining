package com.Management.feeTraining.Controllers;


import com.Management.feeTraining.DA0.AccountantDao;
import com.Management.feeTraining.Entities.Accountant;
import com.Management.feeTraining.Services.AccountantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("accountants")
public class AccountantController {

    @Autowired
    AccountantDao accountantDao;

    @GetMapping
    public List<Accountant> getAccountants(){
       return accountantDao.getAllAccountants();
    }

    @GetMapping("/{id}")
    public Accountant getAccountantById(@PathVariable("id") long id){
        return accountantDao.getAccountantById(id);
    }

    @PostMapping
    public void addAccountant(@RequestBody Accountant accountant){
        accountantDao.addAccountant(accountant);
    }

    @PutMapping("/{id}")
    public Accountant updateAccountant(@PathVariable("id") long id,@RequestBody Accountant accountant){
        return accountantDao.updateAccountant(id, accountant);
    }

    @DeleteMapping("/{id}")
    public void deleteAccountant(@PathVariable("id") long id){
        accountantDao.deleteAccountant(id);
    }

}
