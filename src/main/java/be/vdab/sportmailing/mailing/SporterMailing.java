package be.vdab.sportmailing.mailing;

import be.vdab.sportmailing.domain.Sporter;
import be.vdab.sportmailing.events.ArtikelGemaakt;

public interface SporterMailing {
    void stuurMailMetNieuwArtikel(Sporter sporter, ArtikelGemaakt gemaakt);
}
