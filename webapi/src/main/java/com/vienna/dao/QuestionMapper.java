package com.vienna.dao;

import com.vienna.response.QuestionViewModel;
import com.vienna.model.Question;
import com.vienna.model.QuestionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionMapper {

    QuestionViewModel getQuestionVM(String id);

    List<QuestionViewModel> getQuestionVMs(QuestionExample example);

    int countByExample(QuestionExample example);

    int deleteByExample(QuestionExample example);

    int deleteByPrimaryKey(String id);

    int insert(Question record);

    int insertSelective(Question record);

    List<Question> selectByExample(QuestionExample example);

    Question selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Question record, @Param("example") QuestionExample example);

    int updateByExample(@Param("record") Question record, @Param("example") QuestionExample example);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);

    List<QuestionViewModel> getByUserAnswer(@Param("uid") String uid, @Param("offset") int index, @Param("limit") int size);

    int countByUserAnswer(String uid);

    int update(Question record);
}
