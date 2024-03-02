package com.BlogApp.config;

import java.io.IOException;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

    @Component
    public class CustomAuthSucessHandler implements AuthenticationSuccessHandler {

        private static final Logger logger = LoggerFactory.getLogger(CustomAuthSucessHandler.class);

        @Override
        public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                            Authentication authentication) throws IOException, ServletException {

            try {
                Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

                if (roles.contains("ROLE_ADMIN")) {
                    response.sendRedirect(request.getContextPath() + "/admin/profile");
                } else {
                    response.sendRedirect(request.getContextPath() + "/user/profile");
                }
                logger.info("User " + authentication.getName() + " logged in successfully.");
            } catch (Exception e) {
                logger.error("Error handling authentication success", e);
                // You can choose to redirect to an error page or do other error handling here
            }
        }
    }


