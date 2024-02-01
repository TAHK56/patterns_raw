package patterns.example.dao;

import patterns.example.entity.BaseEntity;

public interface BaseDao<E extends BaseEntity> {

    void create(E e);

}
