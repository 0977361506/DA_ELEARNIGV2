package com.vnpost.e_learning.converter;

public interface IEntity <T> {
    default T convertToEntity(Object dto) {
        return  null;
    }
}
