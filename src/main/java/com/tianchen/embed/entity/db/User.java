package com.tianchen.embed.entity.db;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user_responses")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    @Id
    @JsonProperty("user_id")
    private String user_id;
    
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {
        @JoinColumn(name = "item_id")})
    Set<Question> questions;
    
    public Set<Question> getItemSet() {
        return questions;
    }
}
