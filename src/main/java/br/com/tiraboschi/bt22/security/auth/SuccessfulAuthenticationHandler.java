package br.com.tiraboschi.bt22.security.auth;

import br.com.tiraboschi.bt22.config.ConfigProperties;
import br.com.tiraboschi.bt22.model.TokenState;
import br.com.tiraboschi.bt22.model.User;
import br.com.tiraboschi.bt22.security.TokenHelper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SuccessfulAuthenticationHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    private ConfigProperties configProperties;

    @Autowired
    TokenHelper tokenHelper;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void onAuthenticationSuccess(final HttpServletRequest request,
                                        final HttpServletResponse response,
                                        final Authentication authentication) throws IOException {
        clearAuthenticationAttributes(request);
        final var user = (User) authentication.getPrincipal();

        final var jws = tokenHelper.create(user.getUsername());
        Cookie authCookie = new Cookie(configProperties.getCookie(), (jws));

        authCookie.setHttpOnly(true);

        authCookie.setMaxAge(configProperties.getExpiresIn().intValue());

        authCookie.setPath("/");
        // Adiciona o cookie na resposta
        response.addCookie(authCookie);

        // Adiciona o JWT no header também
        final var userTokenState = new TokenState(jws, configProperties.getExpiresIn());
        final var jwtResponse = objectMapper.writeValueAsString(userTokenState);
        response.setContentType("application/json");
        response.getWriter().write(jwtResponse);

    }
}