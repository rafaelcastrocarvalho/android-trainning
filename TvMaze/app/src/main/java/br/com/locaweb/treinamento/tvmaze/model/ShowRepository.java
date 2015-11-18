package br.com.locaweb.treinamento.tvmaze.model;

import java.util.Collection;
import java.util.List;

public interface ShowRepository {

    Show findById(Long id);

    Collection<Episode> listShowEpisodes(Long showId);

    Collection<CastMember> getCast(Long showId);

    Collection<Show> findByName(String showName);
}
