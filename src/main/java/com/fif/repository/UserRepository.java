package com.fif.repository;

import com.fif.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.List;


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

    @Transactional(readOnly = true)
    public List<User> searchByKeyword(String keyword) {
        String searchQuery = "SELECT u FROM User u WHERE u.username LIKE :keyword";
        Query query = em.createQuery(searchQuery);
        query.setParameter("keyword", "%" + keyword + "%");
        List<User> res = query.getResultList();
        return res;}

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
