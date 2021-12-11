package interface_.dao구현.domain.userInfo.dao.oracle;

import interface_.dao구현.domain.userInfo.UserInfo;
import interface_.dao구현.domain.userInfo.dao.UserInfoDao;

public class UserInfoOracleDao implements UserInfoDao {
    @Override
    public void insertUserInfo(UserInfo userInfo) {
        System.out.println("Insert Into ORACLE DB userID = " + userInfo.getUserId());
    }

    @Override
    public void updateUserInfo(UserInfo userInfo) {
        System.out.println("Update Into ORACLE DB userID = " + userInfo.getUserId());
    }

    @Override
    public void deleteUserInfo(UserInfo userInfo) {
        System.out.println("Delete Into ORACLE DB userID = " + userInfo.getUserId());
    }
}
