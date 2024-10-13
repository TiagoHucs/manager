package com.hucs.manager.web.controllers.task;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EnumDTO {

    private String code;
    private String description;

}
