package clinicar.web.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author Petz
 * @since 28/08/18
 */
@Configuration
public class SessionListener implements HttpSessionListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(SessionListener.class);

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        LOGGER.info("==== Session is created ====");
        event.getSession().setMaxInactiveInterval(300);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        LOGGER.info("==== Session is destroyed ====");
        event.getSession().invalidate();
    }
}

