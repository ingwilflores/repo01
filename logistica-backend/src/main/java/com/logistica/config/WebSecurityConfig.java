package com.logistica.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.logistica.service.impl.UserDetailsServiceImpl;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Autowired
	UserDetailsServiceImpl jwtUserDetailsService;

	@Autowired
	JwtRequestFilter jwtRequestFilter;

//        @Bean
//        public JwtRequestFilter authenticationJwtTokenFilter() {
//            return new JwtRequestFilter();
//        }
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// configure AuthenticationManager so that it knows from where to load
		// user for matching credentials
		// Use BCryptPasswordEncoder
		auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
//                auth.userDetailsService(jwtUserDetailsService);
//                auth.setPasswordEncoder(new BCryptPasswordEncoder());
	}
        
//        @Override
//        public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
//            authenticationManagerBuilder.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
//        }

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
        
        

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		// We don't need CSRF for this example
		httpSecurity
                        //.cors().
                        .cors().configurationSource(corsConfigurationSource())
                        .and().csrf().disable()
				.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and()
                                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                    		.authorizeRequests()
                                .antMatchers("/authenticate").permitAll()
                                //.antMatchers("/api/localizacionEntrega/**").hasAnyRole("ADMIN",)
//                                .antMatchers("/api/cliente/**").hasAnyRole("ADMIN")
//                                .antMatchers("/api/plan/**").hasAnyRole("ADMIN")
//                                .antMatchers("/api/user/**").hasAnyRole("ADMIN")
//                                .antMatchers("/api/cliente/**").hasAnyRole("ADMIN")
//                                .antMatchers("/api/cliente/**").hasAnyRole("ADMIN")
                                //.antMatchers("/api/**").hasAnyRole("ROLE_EDITOR", "ROLE_AUTHORISER")
                                //.antMatchers("/api/admin/**").hasRole("ADMIN")
                                //.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                        
                                .antMatchers("/v2/api-docs").permitAll()
                                .antMatchers("/swagger-ui/**").permitAll()
                                .antMatchers("/swagger-resources/**").permitAll()
                                //.antMatchers("/api/plan/**").hasAnyRole("ADMIN") //-----------------FUNCIONA BIEN
                                .antMatchers("/**").authenticated();
                
//                                .anyRequest().authenticated().and().
//                                exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
//				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}
//        @Bean(name="entityManagerFactory")
//        public LocalSessionFactoryBean sessionFactory() {
//            LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//
//            return sessionFactory;
//        } 
        
//        @Bean
//        CorsConfigurationSource corsConfigurationSource() {
//            final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//
//            CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();
//            source.registerCorsConfiguration("/**", corsConfiguration);
//
//            return source;
//        }
//        @Bean
//        CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(Arrays.asList("*"));
//        configuration.setAllowedMethods(Arrays.asList("GET","POST"));
//        configuration.setAllowCredentials(true);
//        //the below three lines will add the relevant CORS response headers
//        configuration.addAllowedOrigin("*");
//        configuration.addAllowedHeader("*");
//        configuration.addAllowedMethod("*");
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }
        
//        @Bean
//    CorsConfigurationSource corsConfigurationSource() {
//        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//
//        CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();
//        source.registerCorsConfiguration("/**", corsConfiguration);
//
//        return source;
//    }
    
    @Bean
  CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.addAllowedOrigin("*");
    configuration.addAllowedHeader("*");
    configuration.addAllowedMethod("*");
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
  }
        
//        @Bean
//    CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(Arrays.asList("*"));
//        configuration.setAllowedMethods(Arrays.asList("PUT", "DELETE","GET", "POST"));
//        configuration.setAllowCredentials(true);
//        //the below three lines will add the relevant CORS response headers
//        //configuration.setAllowedOrigins(Arrays.asList("*"));
////        configuration.addAllowedHeader(Arrays.asList("*"));
////        configuration.addAllowedMethod(Arrays.asList("*"));
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }
    
//    @Value( "${app.allow.origins}" )
//    private String allowOrigins;
//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        System.out.println("allow origin: " + allowOrigins);
//        return new WebMvcConfigurerAdapter() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")
//                //.allowedOrigins("http://localhost")
//                .allowedOrigins(allowOrigins)
//                .allowedMethods("PUT", "DELETE","GET", "POST");
//            }
//        };
//    }
    
}
