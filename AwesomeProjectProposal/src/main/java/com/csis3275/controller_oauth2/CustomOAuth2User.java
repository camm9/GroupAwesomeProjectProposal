package com.csis3275.controller_oauth2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
 
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;
 
//@AllArgsConstructor
public class CustomOAuth2User implements OAuth2User {

    private OAuth2User oAuth2User;

    public CustomOAuth2User(OAuth2User user) {
		// TODO Auto-generated constructor stub
	}

	@Override
    public Map<String, Object> getAttributes() {
        return oAuth2User.getAttributes();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        oAuth2User.getAuthorities().forEach(ga -> authorities.add(ga));
        authorities.add(new SimpleGrantedAuthority("USER"));
        return authorities;
    }

    @Override
    public String getName() {
        return oAuth2User.getAttribute("name");
    }

    public String getEmail() {
        return oAuth2User.<String>getAttribute("email");
    }
}