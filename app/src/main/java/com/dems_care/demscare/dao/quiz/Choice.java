
package com.dems_care.demscare.dao.quiz;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Choice {

    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("score")
    @Expose
    private Integer score;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

}
