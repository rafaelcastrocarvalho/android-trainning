package br.com.locaweb.treinamento.tvmaze.model;

public class Person {

    private Long id;
    private String name;
    private Image image;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Image getImage() {
        return image;
    }

    @Override
    public String toString() {
        return name;
    }
}
