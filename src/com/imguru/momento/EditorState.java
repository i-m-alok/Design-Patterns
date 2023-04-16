package com.imguru.momento;

public class EditorState {

    private final String content;
    private final String fontName;
    private final Integer fontSize;



    public EditorState(String content, Integer fontSize, String fontName) {
        this.content = content;
        this.fontSize = fontSize;
        this.fontName = fontName;
    }

    public String getContent() {
        return content;
    }

    public String getFontName() {
        return fontName;
    }

    public Integer getFontSize() {
        return fontSize;
    }
}
