package com.hucs.manager.core.user;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

@Service
public class CurrentUser {

    public String getCurrentUser() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes != null) {
            HttpSession session = (HttpSession) requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);
            if (session != null) {
                return (String) session.getAttribute("username");
            }
        }
        return null;
    }

}
