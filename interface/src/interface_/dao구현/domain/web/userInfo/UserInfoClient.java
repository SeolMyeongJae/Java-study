package interface_.dao구현.domain.web.userInfo;

import interface_.dao구현.domain.userInfo.UserInfo;
import interface_.dao구현.domain.userInfo.dao.UserInfoDao;
import interface_.dao구현.domain.userInfo.dao.mysql.UserInfoMySqlDao;
import interface_.dao구현.domain.userInfo.dao.oracle.UserInfoOracleDao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UserInfoClient {
    public static void main(String[] args) throws IOException {
        // 파일 읽는 클래스
        FileInputStream fis = new FileInputStream("db.properties");

        // 파일을 key : Value 형태로 읽음
        Properties prop = new Properties();
        prop.load(fis);

        String dbType = prop.getProperty("DBTYPE"); // MYSQL

        UserInfo userInfo = new UserInfo();
        userInfo.setUserId("12345");
        userInfo.setPassword("!@#$%");
        userInfo.setUserName("Seol");
        UserInfoDao userInfoDao = null;

        if(dbType.equals("ORACLE")) {
            userInfoDao = new UserInfoOracleDao();
        }
        else if(dbType.equals("MYSQL")) {
            userInfoDao = new UserInfoMySqlDao();
        }
        else {
            System.out.println("db error");
            return;
        }

        userInfoDao.insertUserInfo(userInfo);
        userInfoDao.updateUserInfo(userInfo);
        userInfoDao.deleteUserInfo(userInfo);

    }
}
