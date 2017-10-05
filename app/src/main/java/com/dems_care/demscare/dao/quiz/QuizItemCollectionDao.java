
package com.dems_care.demscare.dao.quiz;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class QuizItemCollectionDao {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("quizs")
    @Expose
    private List<Quiz> quizs = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<Quiz> getQuizs() {
        return quizs;
    }

    public void setQuizs(List<Quiz> quizs) {
        this.quizs = quizs;
    }

}
