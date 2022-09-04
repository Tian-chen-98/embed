package com.tianchen.embed.entity.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.tianchen.embed.entity.db.Question;

import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(builder = EmbedResponse.Builder.class)
public class EmbedResponse {
    private final String questionId;
    private final Set<Question> userResponse;
    
    private EmbedResponse(Builder builder) {
        this.questionId = builder.questionId;
        this.userResponse = builder.userResponse;
    }
    
    @JsonProperty("question_id")
    public String getQuestionId() { return questionId; }
    
    @JsonProperty("user_response")
    public Set<Question> getUserResponse() { return userResponse;}
    
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Builder {
        @JsonProperty("question_id")
        private String questionId;

        @JsonProperty("user_response")
        private Set<Question> userResponse;
    
        public Builder questionId(String questionId) {
            this.questionId = questionId;
            return this;
        }
        
        public Builder userResponse(Set<Question> userResponse) {
            this.userResponse = userResponse;
            return this;
        }
        
        public EmbedResponse build() { return new EmbedResponse(this);}
    }
}
