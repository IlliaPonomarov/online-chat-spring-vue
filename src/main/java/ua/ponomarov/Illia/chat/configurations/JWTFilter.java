package ua.ponomarov.Illia.chat.configurations;


import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import ua.ponomarov.Illia.chat.security.JWTUtil;
import ua.ponomarov.Illia.chat.services.PeopleDetailService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JWTFilter extends OncePerRequestFilter {

    private final JWTUtil jwtUtil;
    private final PeopleDetailService peopleDetailService;

    public JWTFilter(JWTUtil jwtUtil, PeopleDetailService peopleDetailService) {
        this.jwtUtil = jwtUtil;
        this.peopleDetailService = peopleDetailService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && !authHeader.isBlank() && authHeader.startsWith("Bearer ")){
            String jwt = authHeader.substring(7);

            if (jwt.isBlank())
                response.sendError(HttpServletResponse.SC_BAD_REQUEST,
                        "Invalid JWT Token in Bearer Header");

            else {

                try{
                    String username = jwtUtil.validateTokenAndRetrieveClaim(jwt);
                    UserDetails userDetails = peopleDetailService.loadUserByUsername(username);


                    UsernamePasswordAuthenticationToken authToken =
                            new UsernamePasswordAuthenticationToken(
                                    userDetails,
                                    userDetails.getPassword(),
                                    userDetails.getAuthorities()
                            );

                    if (SecurityContextHolder.getContext().getAuthentication() == null)
                        SecurityContextHolder.getContext().setAuthentication(authToken);


                }
                catch (JWTVerificationException exception){
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST,
                            "Invalid JWT Token");
                }

            }
        }

        filterChain.doFilter(request, response);




    }
}
