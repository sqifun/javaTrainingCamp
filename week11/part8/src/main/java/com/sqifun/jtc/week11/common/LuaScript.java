package com.sqifun.jtc.week11.common;

/**
 * @program: week11-part8
 * @className: LuaScript
 * @description:
 * @author: sqi
 * @date: 2022-03-27 13:20
 * @version: 1.0
 **/
public class LuaScript {

    public static final String LOCK_SCRIPT =
            "if redis.call('setnx', KEYS[1], ARGV[1]) == 1 then\n" +
            "    redis.call('expire', KEYS[1], ARGV[2]);\n" +
            "    return 1;\n" +
            "else\n" +
            "    return 0;\n" +
            "end";

    public static final String RELEASE_LOCK_SCRIPT =
            "if redis.call('get', KEYS[1]) == ARGV[1] then\n" +
            "    return redis.call('del', KEYS[1]);\n" +
            "else\n" +
            "    return 0;\n" +
            "end";

    public static final String DECREASE_INVENTORY =
            "if redis.call('get', KEYS[1]) == 0 then\n" +
            "    return 0;\n" +
            "else\n" +
            "    return redis.call('decr', KEYS[1]);\n" +
            "end";
}