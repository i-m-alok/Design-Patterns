package com.imguru.momento;

public class Main{


    public static void main(String[] args) {
        Editor editor = new Editor();
        History history = new History();

        editor.setContent("Hello");
        history.push(editor.createState());
        editor.setFontName("Noto Sans");
        history.push(editor.createState());
        editor.setFontSize(14);
        history.push(editor.createState());
        editor.setContent("Hello Alok");
        history.push(editor.createState());
        editor.setContent("Hello Alok .llmdewff");
        System.out.println(editor.getContent());
        editor.restore(history.pop());

        System.out.println(editor.getContent());
    }

//    public void editAndSaveInHistory(Editor editor, History history, ){
//
//    }


}
