package fr.gouv.sitr.capprotr.presentation.intercepteur;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * The Class LoggingDebugAspect.
 *
 */
@Aspect
@Configuration
@Profile({ "dev", "prod" })
public class LoggingDebugAspect {

    /** Logger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingDebugAspect.class);

    /**
     * Log en DEBUG l'entrée dans toutes les méthodes publiques de l'application.
     *
     * @param joinPoint
     *            the join point
     */
    @Before("execution(public * fr.gouv.sitr.capprotr..*.*(..))")
    public void logBeforeAllMethods(JoinPoint joinPoint) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Entrée dans {}", joinPoint.toShortString());
        }
    }

    /**
     * Log en DEBUG la sortie de toutes les méthodes publiques de l'application (si aucune exception n'est envoyée).
     *
     * @param joinPoint
     *            the join point
     * @param result
     *            the result
     */
    @AfterReturning(value = "execution(public * fr.gouv.sitr.capprotr..*.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Sortie de {} avec le valeur de retour {}", joinPoint.toShortString(), result);
        }
    }
}
