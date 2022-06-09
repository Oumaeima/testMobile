package com.example.miniapplication.Models;

public class Citation {
    private String text;

    public Citation() {
    }

    public Citation(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
