package com.example.ncdc_selftest.Model;

public class Model {

    private int image;
    private String question;
    private String desc;

    public Model(int image, String question) {
        this.image = image;
        this.question = question;

    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }


}
