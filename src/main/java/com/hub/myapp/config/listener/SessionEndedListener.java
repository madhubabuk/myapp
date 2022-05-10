package com.hub.myapp.config.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.session.SessionDestroyedEvent;
import org.springframework.stereotype.Component;

@Component
public class SessionEndedListener implements ApplicationListener<SessionDestroyedEvent> {

    @Override
    public void onApplicationEvent(SessionDestroyedEvent event)
    {
    	System.out.println("############# sessssssion #################");
    	
        for (SecurityContext securityContext : event.getSecurityContexts())
        {
            Authentication authentication = securityContext.getAuthentication();
            String user = (String) authentication.getPrincipal();
            
        }
    }

}
