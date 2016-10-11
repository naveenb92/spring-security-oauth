package me.naveen.springsecurityoauth.util;

import me.naveen.springsecurityoauth.model.ApplicationUser;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Naveen Babu on 10-10-2016.
 */
public class OAuth2AccessTokenEnhancer implements TokenEnhancer {

    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {

        Map<String, Object> info = new LinkedHashMap<String, Object>(
                accessToken.getAdditionalInformation());

        // Add custom info to token.
        ApplicationUser user = (ApplicationUser) authentication.getPrincipal();
        info.put("userId",user.getId());
        info.put("tenantId",user.getTenantId());

        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);

        return accessToken;
    }
}
