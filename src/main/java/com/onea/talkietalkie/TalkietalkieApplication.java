package com.onea.talkietalkie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.support.BaseLdapPathContextSource;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@SpringBootApplication
public class TalkietalkieApplication {

	@Configuration
	@EnableWebSecurity
	public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.csrf().disable().authorizeRequests().antMatchers("/secured/resource/test").authenticated()
	                .and().exceptionHandling();
	        http.formLogin().failureUrl("/login?error").defaultSuccessUrl("/").loginPage("/login").permitAll().and()
	                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
	                .permitAll();
	        http.exceptionHandling().accessDeniedPage("/login");
	    }

	    @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	        auth.ldapAuthentication().userSearchFilter("(&(objectClass=user)(sAMAccountName={0}))")
	                .contextSource(ldapContextSource());
	    }

	    @Bean
	    public BaseLdapPathContextSource ldapContextSource() {
	        LdapContextSource bean = new LdapContextSource();
	        String[] urls = new String[2];
	        urls[0] = "ldap://10.1.1.12:3268";
	        urls[1] = "ldap://10.1.1.11:3268";
	        bean.setUrls(urls);
	        bean.setBase("DC=1AAUTO,DC=INC");
	        bean.setUserDn("bindldap@1aauto.inc");
	        bean.setPassword("4GxnMTGcPFuLWQsv");
	        bean.setPooled(true);
	        bean.setReferral("follow");
	        return bean;
	    }

	}
	
	public static void main(String[] args) {
		SpringApplication.run(TalkietalkieApplication.class, args);
	}

}

