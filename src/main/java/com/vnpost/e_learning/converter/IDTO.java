package com.vnpost.e_learning.converter;

public interface IDTO <T> {
    default T convertToDTO(Object entity){
        return null ;
    }
}
