package fr.genepisep.icompetences.configuration;

import fr.genepisep.icompetences.services.IsepUserDetailsService;
import org.apereo.cas.client.session.SingleSignOutFilter;
import org.apereo.cas.client.validation.Cas30ServiceTicketValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.cas.ServiceProperties;
import org.springframework.security.cas.authentication.CasAuthenticationProvider;
import org.springframework.security.cas.web.CasAuthenticationEntryPoint;
import org.springframework.security.cas.web.CasAuthenticationFilter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsByNameServiceWrapper;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, IsepUserDetailsService isepUserDetailsService) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .anyRequest().authenticated()
                )
                .exceptionHandling(exceptionHandling -> exceptionHandling
                        .authenticationEntryPoint(casAuthenticationEntryPoint())
                )
                .sessionManagement(sessionManagement -> sessionManagement
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .addFilter(casAuthenticationFilter(isepUserDetailsService))
                .addFilterBefore(singleSignOutFilter(), CasAuthenticationFilter.class)
                .addFilterBefore(logoutFilter(), LogoutFilter.class);

        return http.build();
    }

    @Bean

    public CasAuthenticationProvider casAuthenticationProvider(IsepUserDetailsService userDetailsService) {
        CasAuthenticationProvider provider = new CasAuthenticationProvider();
        provider.setAuthenticationUserDetailsService(new UserDetailsByNameServiceWrapper<>(userDetailsService));
        provider.setServiceProperties(serviceProperties());
        provider.setTicketValidator(cas30ServiceTicketValidator());
        provider.setKey("MyVerySuperSecretKey");
        return provider;
    }

    @Bean
    public Cas30ServiceTicketValidator cas30ServiceTicketValidator() {
        return new Cas30ServiceTicketValidator("https://portail-ovh.isep.fr/cas");


    }

    @Bean
    public ServiceProperties serviceProperties() {
        ServiceProperties serviceProperties = new ServiceProperties();
        serviceProperties.setService("https://api.icompetences.tardieu.info/login/cas");
        serviceProperties.setSendRenew(false);
        return serviceProperties;
    }

    @Bean
    public CasAuthenticationEntryPoint casAuthenticationEntryPoint() {
        CasAuthenticationEntryPoint entryPoint = new CasAuthenticationEntryPoint();
        entryPoint.setLoginUrl("https://portail-ovh.isep.fr/cas/login");
        entryPoint.setServiceProperties(serviceProperties());
        return entryPoint;
    }

    @Bean
    public CasAuthenticationFilter casAuthenticationFilter(IsepUserDetailsService isepUserDetailsService) throws Exception {
        CasAuthenticationFilter filter = new CasAuthenticationFilter();
        filter.setAuthenticationManager(authentication -> casAuthenticationProvider(isepUserDetailsService).authenticate(authentication));
        filter.setServiceProperties(serviceProperties());
        return filter;
    }

    @Bean
    public SingleSignOutFilter singleSignOutFilter() {
        return new SingleSignOutFilter();
    }

    @Bean
    public LogoutFilter logoutFilter() {
        LogoutFilter logoutFilter = new LogoutFilter("https://portail-ovh.isep.fr/cas/logout", new SecurityContextLogoutHandler());
        return logoutFilter;
    }
}
