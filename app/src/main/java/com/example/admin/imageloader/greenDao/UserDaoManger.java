package com.example.admin.imageloader.greenDao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * Created by 陈杰 on 2018/2/21.
 */

public class UserDaoManger {
    private static final  String db_name="test_db"+"10001";
    private static UserDaoManger mInstance;
    private DaoMaster.DevOpenHelper openHelper;
    private Context context;

    public UserDaoManger(Context context) {
        this.context = context;
        openHelper = new DaoMaster.DevOpenHelper(context, db_name);
    }

    /**
     * 获取单例引用
     *
     * @param context
     * @return
     */
    public static UserDaoManger getInstance(Context context) {
        if (mInstance == null) {
            synchronized (UserDaoManger.class) {
                if (mInstance == null) {
                    mInstance = new UserDaoManger(context);
                }
            }
        }
        return mInstance;
    }

    /**
     * 获取可写数据库
     */
    private SQLiteDatabase getWritableDatabase() {
        if (openHelper == null) {
            openHelper = new DaoMaster.DevOpenHelper(context, db_name, null);
        }
        SQLiteDatabase db = openHelper.getWritableDatabase();
        return db;
    }

    /**
     * 插入一条记录
     *
     * @param user
     */
    public void insertUser(UserInfo user) {
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        UserInfoDao userDao = daoSession.getUserInfoDao();
        userDao.insert(user);
    }

    /**
     * 插入用户集合
     *
     * @param users
     */
    public void insertUserList(List<UserInfo> users) {
        if (users == null || users.isEmpty()) {
            return;
        }
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        UserInfoDao userDao = daoSession.getUserInfoDao();
        userDao.insertInTx(users);
    }

    /**
     * 删除一条记录
     *
     * @param user
     */
    public void deleteUser(UserInfo user) {
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        UserInfoDao userDao = daoSession.getUserInfoDao();
        userDao.delete(user);
    }

    /**
     * 更新一条记录
     *
     * @param user
     */
    public void updateUser(UserInfo user) {
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        UserInfoDao userDao = daoSession.getUserInfoDao();
        userDao.update(user);
    }

    /**
     * 查询用户列表
     */
    public List<UserInfo> queryUserList() {
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        UserInfoDao userDao = daoSession.getUserInfoDao();
        QueryBuilder<UserInfo> qb = userDao.queryBuilder();
        List<UserInfo> list = qb.list();
        return list;
    }

    /**
     * 查询用户列表
     */
    public List<UserInfo> queryUserList(int age) {
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        UserInfoDao userDao = daoSession.getUserInfoDao();
        QueryBuilder<UserInfo> qb = userDao.queryBuilder();
        qb.where(UserInfoDao.Properties.Age.gt(age)).orderAsc(UserInfoDao.Properties.Age);
        List<UserInfo> list = qb.list();
        return list;
    }

    /**
     * 查询用户列表
     */
    public List<UserInfo> queryUserList(String name) {
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        UserInfoDao userDao = daoSession.getUserInfoDao();
        QueryBuilder<UserInfo> qb = userDao.queryBuilder();
        qb.where(UserInfoDao.Properties.Name.gt(name)).orderAsc(UserInfoDao.Properties.Name);
        List<UserInfo> list = qb.list();
        return list;
    }
}
