package com.zackyj.vhr.service.Impl;

import com.zackyj.vhr.mapper.HrMapper;
import com.zackyj.vhr.model.pojo.Hr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    HrMapper hrMapper;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Hr hr = hrMapper.selectByUsername(s);
        if(hr == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        return hr;
    }
}
