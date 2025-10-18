package com.example.dbsample.service;

import java.util.Collections;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.dbsample.entity.LoginUser;

@Service
public class LoginUserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        // 「ユーザー名：tarou」が入力されると、UserDetailsの実装クラスを返す
		if (username.equals("tarou")) {
			// 対象データが存在する
			// UserDetailsの実装クラスを返す
			return new LoginUser("tarou",
					"pass",
					Collections.emptyList());
		} else {
			// 対象データが存在しない
			throw new UsernameNotFoundException(
					username + " => 指定しているユーザー名は存在しません");
		}
        
    }

}


