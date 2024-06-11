package fr.genepisep.icompetences.configuration;

import fr.genepisep.icompetences.services.CasUserDetailsService;
import fr.genepisep.icompetences.services.IsepUserDetailsService;
import org.apereo.cas.client.session.SingleSignOutFilter;
import org.apereo.cas.client.validation.Cas30ServiceTicketValidator;
import org.apereo.cas.client.validation.TicketValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.cas.ServiceProperties;
import org.springframework.security.cas.authentication.CasAuthenticationProvider;
import org.springframework.security.cas.web.CasAuthenticationEntryPoint;
import org.springframework.security.cas.web.CasAuthenticationFilter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private static final Logger logger = LoggerFactory.getLogger("AuthConfig");

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, CasAuthenticationFilter casAuthenticationFilter, SingleSignOutFilter singleSignOutFilter, LogoutFilter logoutFilter) throws Exception {
        http.authorizeHttpRequests(request -> request
                        .requestMatchers("/secured", "/login/cas").authenticated())
                .exceptionHandling(exceptionHandling -> exceptionHandling.authenticationEntryPoint(authenticationEntryPoint()))
                .addFilterBefore(casAuthenticationFilter, CasAuthenticationFilter.class)
                .addFilterBefore(singleSignOutFilter, CasAuthenticationFilter.class)
                .addFilterBefore(logoutFilter, LogoutFilter.class)
                .csrf(csrf -> csrf.ignoringRequestMatchers("/exit/cas"));

        return http.build();
    }

    @Bean
    public CasAuthenticationProvider casAuthenticationProvider(CasUserDetailsService casUserDetailsService, TicketValidator ticketValidator, ServiceProperties serviceProperties) {
        CasAuthenticationProvider provider = new CasAuthenticationProvider();
        provider.setServiceProperties(serviceProperties);
        provider.setTicketValidator(ticketValidator);
        provider.setUserDetailsService(casUserDetailsService);
        provider.setKey("CAS_PROVIDER_LOCALHOST_8900");
        return provider;
    }

    @Bean
    public CasAuthenticationEntryPoint authenticationEntryPoint() {
        CasAuthenticationEntryPoint entryPoint = new CasAuthenticationEntryPoint();
        entryPoint.setLoginUrl("https://portail-ovh.isep.fr/cas/login");
        entryPoint.setServiceProperties(serviceProperties());
        return entryPoint;
    }

    @Bean
    public CasAuthenticationFilter casAuthenticationFilter(CasAuthenticationProvider casAuthenticationProvider, ServiceProperties serviceProperties) throws Exception {
        CasAuthenticationFilter filter = new CasAuthenticationFilter();
        filter.setAuthenticationManager(authentication -> casAuthenticationProvider.authenticate(authentication));
        filter.setServiceProperties(serviceProperties);
        return filter;
    }

    @Bean
    public ServiceProperties serviceProperties() {
        logger.info("service properties");
        ServiceProperties serviceProperties = new ServiceProperties();
        serviceProperties.setService("https://api.icompetences.tardieu.info/login/cas");
        serviceProperties.setSendRenew(false);
        return serviceProperties;
    }

    @Bean
    public TicketValidator ticketValidator() {
        return new Cas30ServiceTicketValidator("https://portail-ovh.isep.fr/cas");
    }

    @Bean
    public CasUserDetailsService casUserDetailsService() {
        return new CasUserDetailsService();
    }

    @Bean
    public SecurityContextLogoutHandler securityContextLogoutHandler() {
        return new SecurityContextLogoutHandler();
    }

    @Bean
    public LogoutFilter logoutFilter(SecurityContextLogoutHandler securityContextLogoutHandler) {
        LogoutFilter logoutFilter = new LogoutFilter("https://portail-ovh.isep.fr/logout", securityContextLogoutHandler);
        logoutFilter.setFilterProcessesUrl("/logout/cas");
        return logoutFilter;
    }

    @Bean
    public SingleSignOutFilter singleSignOutFilter() {
        SingleSignOutFilter singleSignOutFilter = new SingleSignOutFilter();
        singleSignOutFilter.setLogoutCallbackPath("/exit/cas");
        singleSignOutFilter.setIgnoreInitConfiguration(true);
        return singleSignOutFilter;
    }
}
