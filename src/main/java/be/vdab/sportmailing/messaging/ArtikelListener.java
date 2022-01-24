package be.vdab.sportmailing.messaging;

import be.vdab.sportmailing.domain.Sporter;
import be.vdab.sportmailing.events.ArtikelGemaakt;
import be.vdab.sportmailing.exceptions.KanMailNietZendenException;
import be.vdab.sportmailing.mailing.SporterMailing;
import be.vdab.sportmailing.services.SporterService;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;

@Component
public class ArtikelListener {
    private final SporterService service;
    private final SporterMailing mailing;
    private final Logger logger = LoggerFactory.logger(this.getClass());

    public ArtikelListener(SporterService service, SporterMailing mailing) {
        this.service = service;
        this.mailing = mailing;
    }


    @RabbitListener(queues = "sportartikels")
    void verwerkBericht(ArtikelGemaakt gemaakt) {
        for (Sporter sporter : service.findAll()) {
            try {
                mailing.stuurMailMetNieuwArtikel(sporter, gemaakt);
            } catch (KanMailNietZendenException ex) {
                logger.error("Kan mail niet sturen", ex);
            }
        }
    }
}