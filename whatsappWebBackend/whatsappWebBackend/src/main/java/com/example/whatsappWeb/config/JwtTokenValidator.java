package com.example.whatsappWeb.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.util.List;

public class JwtTokenValidator extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String jwt= request.getHeader("Authorization");
        if(jwt!=null){
            try{
                //Bearer Token
                jwt=jwt.substring(7);
                SecretKey key= Keys.hmacShaKeyFor(JwtConstant.secret_key.getBytes());
                Claims claim= Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt).getBody();
                String username=String.valueOf(claim.get("email"));
                String authorities=String.valueOf(claim.get("authorities"));
                List<GrantedAuthority> auth= AuthorityUtils.commaSeparatedStringToAuthorityList(authorities);
                Authentication authentication=new UsernamePasswordAuthenticationToken(username,null,auth);
                SecurityContextHolder.getContext().setAuthentication(authentication);
                
            }catch(Exception e)
            {
                throw new BadCredentialsException("invalid token received");
            }
        }
        filterChain.doFilter(request,response);
    }
}
