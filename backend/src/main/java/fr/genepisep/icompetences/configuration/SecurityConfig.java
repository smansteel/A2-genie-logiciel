package fr.genepisep.icompetences.configuration;

import fr.genepisep.icompetences.security.JwtAuthFilter;
import org.jasig.cas.client.validation.Cas30ServiceTicketValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, JwtAuthFilter jwtAuthFilter) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
//                        .requestMatchers("auth/cas").permitAll()
                        .anyRequest().authenticated()
                )
                .sessionManagement(sessionManagement -> sessionManagement
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public Cas30ServiceTicketValidator cas30ServiceTicketValidator() {
        return new Cas30ServiceTicketValidator("https://portail-ovh.isep.fr/cas");
    }

//    @Bean
//    public ServiceProperties serviceProperties() {
//        ServiceProperties serviceProperties = new ServiceProperties();
//        serviceProperties.setService("https://api.icompetences.tardieu.info/auth/cas");
//        serviceProperties.setSendRenew(false);
//        return serviceProperties;
//    }

//    @Bean
//    public CasAuthenticationEntryPoint casAuthenticationEntryPoint() {
//        CasAuthenticationEntryPoint entryPoint = new CasAuthenticationEntryPoint();
//        entryPoint.setLoginUrl("https://portail-ovh.isep.fr/cas/login");
//        entryPoint.setServiceProperties(serviceProperties());
//        return entryPoint;
//    }

}
