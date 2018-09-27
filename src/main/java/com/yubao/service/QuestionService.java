package com.yubao.service;

import com.util.temp.PageObject;
import com.util.temp.QuestionViewModel;
import com.yubao.model.Question;

/**
 * Created by Administrator on 2016-12-01.
 */
public interface QuestionService {

    PageObject<QuestionViewModel> Get(String key, String type, int index, int size);

    String add(Question question) throws Exception;
    String edit(Question question) throws Exception;

    String addAnswer(String jid, String content) throws Exception;

    QuestionViewModel Get(String id);

    void del(String id) throws Exception;

    void set(String id, String field, int rank) throws Exception;

    void delAnswer(String id) throws Exception;

    void accept(String id) throws Exception;

    /**
     * 获取用户的问题
     * @param uid
     * @param index
     * @param size
     * @return
     */
    PageObject<QuestionViewModel> getbyuser(String uid, int index, int size);

    /**
     * 获取有该用户回答的问题
     * @param uid
     * @param index
     * @param size
     * @return
     */
    PageObject<QuestionViewModel> getByUserAnswer(String uid, int index, int size);

    PageObject<QuestionViewModel> getHot(String key, int index, int size);

}
