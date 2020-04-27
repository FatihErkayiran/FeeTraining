package com.Management.feeTraining.Services;

import com.Management.feeTraining.DA0.AccountantDao;
import com.Management.feeTraining.Entities.Accountant;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class AccountantService implements AccountantDao {

    @Autowired
    SessionFactory sessionFactory;

    public List<Accountant> getAllAccountants(){
        Session session=sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Accountant> criteria = builder.createQuery(Accountant.class);
        Root<Accountant> myObjectRoot = criteria.from(Accountant.class);
        criteria.select(myObjectRoot);
        TypedQuery<Accountant> query = session.createQuery(criteria);
        return query.getResultList();

    }

    public Accountant getAccountantById(long id){
        Session session=sessionFactory.getCurrentSession();
        return session.find(Accountant.class,id);
    }

    public void addAccountant(Accountant accountant){
        Session session=sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(accountant);
        session.getTransaction().commit();
    }

    public Accountant updateAccountant(long id,Accountant accountant){
        Session session=sessionFactory.getCurrentSession();
        session.beginTransaction();
        Accountant accountant1=getAccountantById(id);
        accountant1.setName(accountant.getName());
        accountant1.setEmail(accountant.getEmail());
        accountant1.setPassword(accountant.getPassword());
        accountant1.setAddress(accountant.getAddress());
        accountant1.setContact(accountant.getContact());
        session.update(accountant1);
        session.getTransaction().commit();
        return accountant1;
    }

    public void deleteAccountant(long id){
        Session session=sessionFactory.getCurrentSession();
        session.beginTransaction();
        Accountant accountant=getAccountantById(id);
        session.delete(accountant);
        session.getTransaction().commit();
    }


}
