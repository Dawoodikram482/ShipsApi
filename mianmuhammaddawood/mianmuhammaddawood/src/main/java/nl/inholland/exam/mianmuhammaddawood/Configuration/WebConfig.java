package nl.inholland.exam.mianmuhammaddawood.Configuration;

import nl.inholland.exam.mianmuhammaddawood.Filters.APIKeyFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {
  @Autowired
  private APIKeyFilter apiKeyFilter;

  @Bean
  public FilterRegistrationBean<OncePerRequestFilter> loggingFilter() {
    FilterRegistrationBean<OncePerRequestFilter> registrationBean = new FilterRegistrationBean<>();
    registrationBean.setFilter(apiKeyFilter);
    registrationBean.addUrlPatterns("/ships/*");
    return registrationBean;
  }
}
