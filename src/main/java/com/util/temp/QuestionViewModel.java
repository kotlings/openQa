package com.util.temp;

import com.yubao.model.Question;

import java.util.List;

/**
 * Created by Administrator on 2016-12-05.
 */
public class QuestionViewModel extends Question {
    public UserViewModel user;   //发布者
    public List<AnswerViewModel> answers;  //回答
}
