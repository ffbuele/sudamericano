package com.project.sudamericano.security

import com.project.sudamericano.security.filter.JwtFilterRequest
import com.project.sudamericano.service.AppUserDetailsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@EnableWebSecurity
class SecurityConfiguration : WebSecurityConfigurerAdapter() {
    @Autowired
    lateinit var appUserDetailsService: AppUserDetailsService

    @Autowired
    lateinit var jwtFilterRequest: JwtFilterRequest

    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth?.userDetailsService(appUserDetailsService)
    }

    override fun configure(http: HttpSecurity) {
        http.csrf()?.disable()
            ?.authorizeRequests()?.antMatchers("/**/auth")
            ?.permitAll()?.anyRequest()?.authenticated()
            ?.and()?.sessionManagement()
            ?.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        http.addFilterBefore(jwtFilterRequest, UsernamePasswordAuthenticationFilter::class.java)
    }

    @Bean
    override fun authenticationManagerBean(): AuthenticationManager {
        return super.authenticationManagerBean()
    }

}