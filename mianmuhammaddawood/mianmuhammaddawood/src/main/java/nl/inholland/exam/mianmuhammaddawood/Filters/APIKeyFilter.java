package nl.inholland.exam.mianmuhammaddawood.Filters;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class APIKeyFilter extends OncePerRequestFilter{

  private static final String API_KEY = "NCC-1701";
  private static final String HEADER_PREFIX = "Bearer ";

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {

    String authorizationHeader = request.getHeader("Authorization");

    if (authorizationHeader == null || !authorizationHeader.startsWith(HEADER_PREFIX) ||
        !authorizationHeader.substring(HEADER_PREFIX.length()).equals(API_KEY)) {
      response.sendError(HttpServletResponse.SC_FORBIDDEN, "Forbidden");
      return;
    }

    filterChain.doFilter(request, response);
  }
}

