package com.itmo.project.lesson10.images;
//Задание на метод clone (пакет images)
//Реализовать метод clone класса Editor, создающий глубокую копию объекта.

import com.itmo.project.lesson10.clonequals.Item;

public final class Editor implements Cloneable{
    private Drawable drawable;

    public Editor(Drawable drawable) { // конструктор
        setDrawable(drawable);
    }

    public void setDrawable(final Drawable drawable){
        this.drawable = drawable;
    }

    public void show(){
        drawable.draw();
    }

    public Editor clone(){
        try {

            return (Editor) super.clone();

        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}