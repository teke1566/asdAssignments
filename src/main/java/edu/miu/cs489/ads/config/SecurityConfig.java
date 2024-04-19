package edu.miu.cs489.ads.config;



import edu.miu.cs489.ads.enums.Roles;
import edu.miu.cs489.ads.filter.JwtFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final UserDetailsService userDetailsService;
    private final JwtFilter jwtFilter;



    @Bean
    public UserDetailsService userDetailsSvc() {
        return userDetailsService;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf().disable() // Disabling CSRF protection
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/adsweb/api/v1/authenticate/**").permitAll()
                                .requestMatchers(HttpMethod.GET,"/adsweb/api/v1/users").hasAuthority(Roles.OFFICE_MANAGER.name())
                                .requestMatchers(HttpMethod.GET,"/adsweb/api/v1/users/*").hasAnyAuthority(Roles.DENTIST.name(), Roles.PATIENT.name())
                                .requestMatchers(HttpMethod.GET, "/adsweb/api/v1/dentist/**").hasAuthority(Roles.DENTIST.name())
                                .requestMatchers(HttpMethod.GET, "/adsweb/api/v1/patient/list/*").hasAuthority(Roles.PATIENT.name())
                                .requestMatchers(HttpMethod.GET, "/adsweb/api/v1/patient/**").hasAuthority(Roles.PATIENT.name())

                                .requestMatchers(HttpMethod.PUT, "/adsweb/api/v1/dentist/**").hasAuthority(Roles.DENTIST.name())
                                .requestMatchers(HttpMethod.PUT, "/adsweb/api/v1/dentist/**").hasAuthority(Roles.DENTIST.name())
                                .requestMatchers(HttpMethod.POST, "/adsweb/api/v1/patient/**").hasAuthority(Roles.PATIENT.name())
                                .requestMatchers(HttpMethod.POST, "/adsweb/api/v1/dentist/**").hasAuthority(Roles.DENTIST.name())
                                .requestMatchers(HttpMethod.DELETE, "/adsweb/api/v1/dentist/**").hasAuthority(Roles.DENTIST.name())
                                .requestMatchers(HttpMethod.DELETE, "/adsweb/api/v1/patient/**").hasAuthority(Roles.PATIENT.name())
                                .requestMatchers(HttpMethod.GET, "/adsweb/api/v1/dentist/**").hasAuthority(Roles.DENTIST.name())


                                .anyRequest().authenticated()
                )
                .sessionManagement(sessionManagement ->
                        sessionManagement
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );

        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }



    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/images/**", "/js/**", "/webjars/**");
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsSvc());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }
}
