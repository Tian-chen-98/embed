package com.tianchen.embed.entity.db;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    @Id
    @JsonProperty("user_id")
    private String user_id;
    
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_responses", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {
        @JoinColumn(name = "question_id")})
    Set<Question> response;
    
    public Set<Question> getResponse() {
        return response;
    }
    
    public void setResponse() { this.response = response;}
}
