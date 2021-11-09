package dao;

import bean.Contact_us;


public interface ContactDao {
    /**
     * @Description //TODO 保存用户提交建议
     * @Param [user]
     * @return int
     **/
    public int save(Contact_us user);
}
