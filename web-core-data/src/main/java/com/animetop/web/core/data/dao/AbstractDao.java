package com.animetop.web.core.data.dao;

import java.io.Serializable;
import java.util.List;

public interface AbstractDao<ID extends Serializable,T> {
    List<T> findAll();
}
