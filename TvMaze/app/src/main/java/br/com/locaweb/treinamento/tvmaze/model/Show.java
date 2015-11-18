package br.com.locaweb.treinamento.tvmaze.model;

import java.io.Serializable;

public class Show implements Serializable {

    private Long id;
    private String name;
    private Image image;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return name;
    }
}
