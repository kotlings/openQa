package com.yubao.dao;

import com.util.temp.AnswerViewModel;
import com.util.temp.QuestionViewModel;
import com.yubao.model.Answer;
import com.yubao.model.AnswerExample;
import java.util.List;

import com.yubao.model.QuestionExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerMapper {
    List<AnswerViewModel> getAnswerVMs(String questionid);

    int countByExample(AnswerExample example);

    int deleteByExample(AnswerExample example);

    int deleteByPrimaryKey(String id);

    int insert(Answer record);

    int insertSelective(Answer record);

    List<Answer> selectByExample(AnswerExample example);

    Answer selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Answer record, @Param("example") AnswerExample example);

    int updateByExample(@Param("record") Answer record, @Param("example") AnswerExample example);

    int updateByPrimaryKeySelective(Answer record);

    int updateByPrimaryKey(Answer record);
}