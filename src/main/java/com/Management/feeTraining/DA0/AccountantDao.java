package com.Management.feeTraining.DA0;

import com.Management.feeTraining.Entities.Accountant;

import java.util.List;

public interface AccountantDao {

    public List<Accountant> getAllAccountants();
    public Accountant getAccountantById(long id);
    public void addAccountant(Accountant accountant);
    public Accountant updateAccountant(long id,Accountant accountant);
    public void deleteAccountant(long id);

}
