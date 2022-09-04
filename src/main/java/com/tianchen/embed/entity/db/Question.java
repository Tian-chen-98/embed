package com.tianchen.embed.entity.db;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "questions")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Question {
    @Id
    @JsonProperty("question_id")
    private String id;
    
    @Column(name = "question_body")
    @JsonProperty("question_body")
    private String body;
    
    @Enumerated(value = EnumType.STRING)
    @JsonProperty("quesiton_type")
    private QuestionType type;
    
    @JsonIgnore
    @ElementCollection
    private List<String> options;
    
    @JsonProperty("correct_answer")
    @ElementCollection
    private List<String> correctAns;
    
    @ManyToMany(mappedBy = "user_answer")
    @JsonProperty("user_selection")
    private Set<User> user_answer;
    
    public String getQuestionId() { return id; }
    
    public void setQuesitonId() { this.id = id; }
    
    public String getQuestionBody() { return body; }
    
    public void setQuestionBody() { this.body = body; }
    
    public QuestionType getQuestionType() { return type; }
    
    public void setQuestionType() { this.type = type; }
    
    public List<String> getOptions() { return options; }
    
    public void setOptions() { this.options = options; }
    
    public List<String> getCorrectAns() { return correctAns; }
    
    public void setCorrectAns() { this.correctAns = correctAns; }
    
    public Set<User> getUserResponse() {return user_answer;}
}
