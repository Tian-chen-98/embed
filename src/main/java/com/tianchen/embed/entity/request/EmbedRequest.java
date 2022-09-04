package com.tianchen.embed.entity.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tianchen.embed.entity.db.Question;

public class EmbedRequest {
    @JsonProperty("question")
    private Question question;
    
    public Question getQuestion() { return question; }
}
