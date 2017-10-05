
package com.dems_care.demscare.dao.quiz;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Body {

    @SerializedName("question")
    @Expose
    private String question;
    @SerializedName("choice")
    @Expose
    private List<Choice> choice = null;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Choice> getChoice() {
        return choice;
    }

    public void setChoice(List<Choice> choice) {
        this.choice = choice;
    }

}
