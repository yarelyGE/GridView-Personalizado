package com.orbita.innovacion.ejemplo08gridview;

import android.graphics.Bitmap;

public class item {
    private Bitmap image;
    private String name;

    public item(Bitmap image, String name) {
        this.image = image;
        this.name = name;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
