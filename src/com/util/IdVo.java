package com.util;

import java.io.Serializable;

/**
 * @author: zou_xq
 * @description:
 * @date: 2020/8/20 10:05
 */
public class IdVo<T> implements Serializable {
    private static final long serialVersionUID = 6953113377174582056L;
    private T id;

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public IdVo() {

    }

    public IdVo(T id) {
        this.id = id;
    }

}
