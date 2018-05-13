package de.marcusjanke.examples.springcloud.greetingservice.model;

public class News {

    private String text;

    public News() {

    }

    public News(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
