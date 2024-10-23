package com.hucs.manager.core.patterns;

import com.hucs.manager.core.config.NegocioException;

public interface Validator<T> {

    void validate(T t) throws NegocioException;

}
