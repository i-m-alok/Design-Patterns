package com.imguru.momento;

public class Editor {

    private String content;
    private Integer fontSize;
    private String fontName;

    public EditorState createState(){
        return new EditorState(content, fontSize, fontName);
    }

    public void restore(EditorState state){
        content = state.getContent();
        fontSize = state.getFontSize();
        fontName = state.getFontName();
    }
    public String getFontName() {
        return fontName;
    }

    public void setFontName(String fontName) {
        this.fontName = fontName;
    }

    public Integer getFontSize() {
        return fontSize;
    }

    public void setFontSize(Integer fontSize) {
        this.fontSize = fontSize;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
