package com.example.demo;

/**
 * 描述: 测试
 * 作者: lishuai
 * 时间: 2019-05-09
 */
public class Test123 {
    public static void main(String[] args) {
        User u  = new User("1");
        User user = new User("1");
        System.out.println(user);
        System.out.println(u);
        System.out.println(u == user);
        int i = u.hashCode();
        System.out.println();
    }
}
