package com.yubao.controller;

import com.google.gson.Gson;
import com.util.Response;

/**
 * Created by Administrator on 2016-11-30.
 */
public class BaseController {
    protected  Gson gson = new Gson();
    protected Response response = new Response();
}
