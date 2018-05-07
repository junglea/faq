package com.junglea.faq.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Define an FAQ object
 *
 * JSON representation:
 * {
 * "id" : "",
 * "question" : "",
 * "answer" : "",
 * "tags" : ["",""],
 * }
 */

@Document(collection="faq")
public class Faq {

    @Id
    private String id;

    @NotBlank
    @Size(max=250)
    @Indexed(unique=true)
    private String question;

    @NotBlank
    @Size(max=250)
    private String answer;

    // TODO define tags: max number and max length
    private List<String> tags;

    public Faq() {
        super();
    }

    public List<String> getTags() {
        return tags;
    }

    public String getAnswer() {
        return answer;
    }

    public String getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s \n %s", this.id, this.question, this.answer);
    }

}