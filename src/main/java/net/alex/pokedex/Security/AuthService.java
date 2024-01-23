package net.alex.pokedex.Security;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;

import jakarta.servlet.http.HttpServletRequest;

public class AuthService {
    private static final String AUTH_TOKEN_HEADER_NAME = "PDEX-API-KEY";
    private static final String AUTH_TOKEN = "Hai1234";

    public static Authentication getAuthentication(HttpServletRequest request) {
        var apiKey = request.getHeader(AUTH_TOKEN_HEADER_NAME);

        if (apiKey == null || !apiKey.equals(AUTH_TOKEN)) {
            throw new BadCredentialsException("Llave invalida.");
        }

        return new ApiKeyAuth(apiKey, AuthorityUtils.NO_AUTHORITIES);
    }
}
