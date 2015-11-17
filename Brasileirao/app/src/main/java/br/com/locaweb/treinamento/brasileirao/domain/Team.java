package br.com.locaweb.treinamento.brasileirao.domain;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.annotations.SerializedName;

@Table(name = "team")
public class Team extends Model {

    @Column(unique = true)
    private String name;

    @SerializedName("logo_url")
    @Column
    private String logoUrl;

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
