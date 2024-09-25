package com.fif.repository;

import com.fif.entity.Log;
import com.fif.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.text.SimpleDateFormat;
import java.text.ParseException;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager em;


    @Transactional(readOnly = true)
    public List<User> queryAll() {
        Query query = em.createQuery("SELECT u FROM User u");
        List<User> result = query.getResultList();
        return result;
    }

    @Transactional(readOnly = true)
    public User get(Integer id) {
        return em.find(User.class, id);
    }

    @Transactional
    public User save(User user) {
        em.persist(user);
        em.flush();
        return user;
    }

    @Transactional
    public void delete(Integer id) {
        User u = get(id);
        if(u != null) {
            em.remove(u);
        }
    }

    @Transactional
    public User update(User user){
        User selectedUser = get(user.getId());
        selectedUser.setUsername(user.getUsername());
        selectedUser.setAnak(user.getAnak());
        selectedUser.setGender(user.getGender());
        selectedUser.setStatus(user.getStatus());
        selectedUser.setBirthday(user.getBirthday());
        em.merge(selectedUser);
        return user;
    }



}
