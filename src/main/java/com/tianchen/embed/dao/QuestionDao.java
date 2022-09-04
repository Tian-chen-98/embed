package com.tianchen.embed.dao;

import com.tianchen.embed.entity.db.Question;
import com.tianchen.embed.entity.db.QuestionType;
import com.tianchen.embed.entity.db.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class QuestionDao {
    @Autowired
    private SessionFactory sessionFactory;
    
    public void setUserResponse(String userId, Question question) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            User user = session.get(User.class, userId);
            Set<Question> userSelect = user.getResponse();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
             session.close();
            }
        }
    }
    
    public Set<Question> getUserResponse(String userId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(User.class, userId).getResponse();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new HashSet<>();
    }
}
