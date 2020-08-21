package com.test;

import com.util.IdVo;

import java.util.Collections;
import java.util.Objects;

/**
 * @author: zou_xq
 * @description:
 * @date: 2020/8/20 10:09
 */
public class TestId {
    public static void main(String[] args) {
        IdVo<Integer> idVo = new IdVo<>();
        idVo.setId(1);
        System.out.println(idVo.getId());
        TestId testId= null;
        User user = new User();
        boolean b = Objects.nonNull(user.getCredentialsExpireTime());
        System.out.println(b);
    }
}
