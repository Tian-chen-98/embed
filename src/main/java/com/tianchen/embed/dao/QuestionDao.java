package com.tianchen.embed.dao;

import com.tianchen.embed.entity.db.Question;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QuestionDao {
    @Autowired
    private SessionFactory sessionFactory;
    
    public void collectUserRespons(String userId, Question question)
}
