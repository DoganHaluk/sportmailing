package be.vdab.sportmailing.services;

import be.vdab.sportmailing.domain.Sporter;

import java.util.List;

public interface SporterService {
    List<Sporter> findAll();
}
