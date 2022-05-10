package com.hub.myapp.config;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;


public class CustomSessionInformationExpiredStrategy implements SessionInformationExpiredStrategy{

    private Logger log = Logger.getLogger(this.getClass().getName());
    private String expiredUrl = "";

    public CustomSessionInformationExpiredStrategy(String expiredUrl) {
        this.expiredUrl = expiredUrl;
    }

    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent sessionInformationExpiredEvent) throws IOException, ServletException {

        log.info("Redirecting to session expired pageee");
        HttpServletRequest request = sessionInformationExpiredEvent.getRequest();
        HttpServletResponse response = sessionInformationExpiredEvent.getResponse();
        request.getSession();// creates a new session
        System.out.println("*************** " + request.getContextPath() + expiredUrl);
        response.sendRedirect(request.getContextPath() + expiredUrl);
    }
    

}
