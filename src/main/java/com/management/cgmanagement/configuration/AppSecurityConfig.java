//package com.management.cgmanagement.configuration;
//
//import com.management.cgmanagement.configuration.user.JwtAuthenticationFilter;
//import com.management.cgmanagement.configuration.user.RestAuthenticationEntryPoint;
//import com.management.cgmanagement.configuration.user.UserAccessDeniedHandler;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.BeanIds;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@EnableWebSecurity
//public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private IAppUserService appUserService;
//
//    @Bean
//    public JwtAuthenticationFilter jwtAuthenticationFilter() {
//        return new JwtAuthenticationFilter();
//    }
//
//    @Bean(BeanIds.AUTHENTICATION_MANAGER)
//    @Override
//    protected AuthenticationManager authenticationManager() throws Exception {
//        return  super.authenticationManager();
//    }
//
//
//    @Bean
//    public RestAuthenticationEntryPoint restAuthenticationEntryPoint(){
//        return new RestAuthenticationEntryPoint();
//    }
//
//    @Bean
//    public UserAccessDeniedHandler userAccessDeniedHandler(){
//        return new UserAccessDeniedHandler();
//    }
//
//    @Autowired
//    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(appUserService).passwordEncoder(NoOpPasswordEncoder.getInstance());
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().ignoringAntMatchers("/**");
//        http.httpBasic().authenticationEntryPoint(restAuthenticationEntryPoint());
//        http.authorizeRequests()
//                .antMatchers("/", "/login").permitAll()
//                .and().authorizeRequests().antMatchers("/admin**").hasAnyRole("ADMIN")
//                .and().authorizeRequests().antMatchers("/student**").hasAnyRole("STUDENT")
//                .and().authorizeRequests().antMatchers("/teacher**").hasAnyRole("TEACHER")
//                .and().authorizeRequests().antMatchers("/staff**").hasAnyRole("STAFF")
//                .and()
//                .csrf().disable();
//        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
//                .exceptionHandling().accessDeniedHandler(userAccessDeniedHandler());
//        http.sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        http.cors();
//    }
//
//}
