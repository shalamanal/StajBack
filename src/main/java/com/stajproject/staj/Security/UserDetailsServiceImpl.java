package com.stajproject.staj.Security;

import com.stajproject.staj.model.Users;
import com.stajproject.staj.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UsersRepo usersRepo;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String nickname) throws UsernameNotFoundException {
        Users users = usersRepo.findByNickname(nickname).orElseThrow(() -> new UsernameNotFoundException("User with nickname "+ nickname + " not found" ));
        return UserDetailsImpl.build(users);
    }
}
