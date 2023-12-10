package com.itmo.exam2;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

class Paragraph implements Serializable{
    private String text;
    private String option1;
    private String option2;
    private Paragraph nextParagraph1;
    private Paragraph nextParagraph2;
    private boolean isEnd;

    public Paragraph(String text, String option1, String option2, boolean isEnd) {
        this.text = text;
        this.option1 = option1;
        this.option2 = option2;
        this.isEnd = isEnd;
    }

    public String getText() {
        return text;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setNextParagraph1(Paragraph nextParagraph1) {
        this.nextParagraph1 = nextParagraph1;
    }

    public void setNextParagraph2(Paragraph nextParagraph2) {
        this.nextParagraph2 = nextParagraph2;
    }

    public Paragraph getNextParagraph1() {
        return nextParagraph1;
    }

    public Paragraph getNextParagraph2() {
        return nextParagraph2;
    }

    public boolean isEnd() {
        return isEnd;
    }
}