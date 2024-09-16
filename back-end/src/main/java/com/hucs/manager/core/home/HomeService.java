package com.hucs.manager.core.home;

import com.hucs.manager.core.user.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeService {

    @Autowired
    private CurrentUser currentUser;

    public HomeResource getHome() {
        return HomeResource.builder()
                .welcome("Welcome to initial archetype").build();
    }

}
