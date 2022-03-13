package com.sqifun.jtc.week9.core.api;

import java.util.List;

/**
 * @program: week9-part3
 * @className: Router
 * @description:
 * @author: sqi
 * @date: 2022-03-12 14:08
 * @version: 1.0
 **/
public interface Router {

    List<String> route(List<String> urls);
}
