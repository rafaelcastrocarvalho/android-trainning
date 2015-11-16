package br.com.locaweb.treinamento.brasileirao.domain;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "team")
public class Team extends Model {

    @Column(unique = true) private String name;
    @Column private String logoUrl;

    public Team() { }

    public Team(String name, String logoUrl) {
        this.name = name;
        this.logoUrl = logoUrl;
    }

    public String getName() {
        return name;
    }

    public String getLogoUrl() {
        return logoUrl;
    }
}
