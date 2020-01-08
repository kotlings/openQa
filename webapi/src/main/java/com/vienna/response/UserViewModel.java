package com.vienna.response;

import com.vienna.model.User;
import org.dozer.DozerBeanMapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016-12-05.
 */
public class UserViewModel {
    static DozerBeanMapper mapper = new DozerBeanMapper();
    static public UserViewModel From(User user){
        UserViewModel vm = mapper.map(user, UserViewModel.class);
        return vm;
    }

    static public List<UserViewModel> From(List<User> users){
        List<UserViewModel> vms = new ArrayList<UserViewModel>();

        for (User user:users){
            UserViewModel vm = new UserViewModel();
            mapper.map(user, UserViewModel.class);
            vms.add(mapper.map(user, UserViewModel.class));
        }
        return vms;
    }

    private String id;

    private String name;

    /**
     * VIP等级
     */
    private int rmb;

    private int questioncnt;

    private int answercnt;

    private String pic;

    /**
     * 用户权限
     */
    private int auth;

    /**
     * 经验值
     */
    private int experience;

    private Date createtime;

    public int getQuestioncnt() {
        return questioncnt;
    }

    public void setQuestioncnt(int questioncnt) {
        this.questioncnt = questioncnt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRmb() {
        return rmb;
    }

    public void setRmb(int rmb) {
        this.rmb = rmb;
    }

    public int getAnswercnt() {
        return answercnt;
    }

    public void setAnswercnt(int answercnt) {
        this.answercnt = answercnt;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public int getAuth() {
        return auth;
    }

    public void setAuth(int auth) {
        this.auth = auth;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}

