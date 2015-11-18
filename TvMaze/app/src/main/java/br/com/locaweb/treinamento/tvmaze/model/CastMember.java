package br.com.locaweb.treinamento.tvmaze.model;

public class CastMember {
    private Person person;
    private Person character;

    public Person getPerson() {
        return person;
    }

    public Person getCharacter() {
        return character;
    }

    @Override
    public String toString() {
        return String.format("%s as %s", person, character);
    }
}
