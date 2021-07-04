package fr.gouv.sitr.capprotr.presentation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccueilController {

    /** Logger **/
    private final static Logger LOGGER = LoggerFactory.getLogger(AccueilController.class);

    @RequestMapping(path = "/")
    public String index() {
        LOGGER.trace("Un message de type TRACE !");
        LOGGER.debug("Un message de type DEBUG !");
        LOGGER.info("Un message de type INFO !");
        LOGGER.warn("Un message de type WARN !");
        LOGGER.error("Un message de type ERROR !");
        return "redirect:/accueil";
    }

    @RequestMapping(path = "/accueil")
    public String accueil() {
        return "accueil";
    }
}
