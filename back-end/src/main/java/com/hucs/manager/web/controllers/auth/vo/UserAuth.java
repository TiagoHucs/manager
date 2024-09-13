package com.hucs.manager.web.controllers.auth.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserAuth {

    private String username;
    private String email;
    private String password;
    private String token;

}
