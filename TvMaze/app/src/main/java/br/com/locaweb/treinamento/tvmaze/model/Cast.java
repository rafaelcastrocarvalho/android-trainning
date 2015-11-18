package br.com.locaweb.treinamento.tvmaze.model;

import java.util.Collection;

public class Cast {


    private Collection<CastMember> members;

    public Collection<CastMember> getMembers() {
        return members;
    }

    public void setMembers(Collection<CastMember> members) {
        this.members = members;
    }
}
