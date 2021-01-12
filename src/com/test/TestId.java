package com.test;

import com.util.IdVo;

import java.util.*;

/**
 * @author: zou_xq
 * @description:
 * @date: 2020/8/20 10:09
 */
public class TestId {
    public static void main(String[] args) {
//        IdVo<Integer> idVo = new IdVo<>();
//        idVo.setId(1);
//        System.out.println(idVo.getId());
//        TestId testId= null;
//        User user = new User();
//        boolean b = Objects.nonNull(user.getCredentialsExpireTime());
//        System.out.println(b);
        List<TestMapVo> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            TestMapVo mapVo = new TestMapVo();
            mapVo.setId(1);
            mapVo.setBeginTime(202010+i);
            mapVo.setEndTime(202020+i);
            list.add(mapVo);
        }
        System.out.println(list);





    }


}
