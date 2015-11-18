package br.com.locaweb.treinamento.tvmaze.model;

import java.io.Serializable;

public class Episode implements Serializable {

    private Long id;

    private String name;

    private Integer season;

    private Image image;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getSeason() {
        return season;
    }

    public Image getImage() {
        return image;
    }

    @Override
    public String toString() {
        return name;
    }
}
