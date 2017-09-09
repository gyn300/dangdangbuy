package com.control;
import com.dao.UserDao;
import com.model.Users;
import com.daoinf.UserDaoInf;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;


public class UserControl {
    List<Users> users;
    UserDaoInf udi = new UserDao();

    /**
     * 更新用户集合
     */
    public void updateAllUser() {
        users = udi.getAllUser();
    }

    /**
     * 判断用户名是否存在
     *
     *
     */
    public int judgeUserName(String user_name) {
        int index = -1;// -1表示原来不存在这个名字
        for (int i = 0; i < users.size(); i++) {
            if (users != null) {
                if (user_name.equals(users.get(i).getUser_name())) {
                    index = 1;// 表示已经存在这个名字
                }
            }
        }
        return index;
    }
    /**
     * 判断邮箱是否存在
     */
    public int judgeUserEmail(String user_email) {
        int index = -1;// -1表示原来不存在这个名字
        for (int i = 0; i < users.size(); i++) {
            if (users != null) {
                if (user_email.equals(users.get(i).getUser_email())) {
                    index = 1;// 表示已经存在这个名字
                }
            }
        }
        return index;
    }
    /**
     * 通过判断名字返回user
     */
    public Users getUser(String user_name) {
        updateAllUser();
        Users user = null;// 表示原来不存在这个名字
        for (int i = 0; i < users.size(); i++) {
            if (users != null) {
                if (user_name.equals(users.get(i).getUser_name())) {
                    user = users.get(i);// 表示已经存在这个名字
                    break;
                }
            }
        }
        return user;
    }
    /**
     * 判断用户状态
     */
    public int getStatus(String user_name) {
        int status=-1;//表示不存在这个名字
        for (int i = 0; i < users.size(); i++) {
            if (users != null) {
                if (user_name.equals(users.get(i).getUser_name())) {
                    status = users.get(i).getUser_status();// 表示已经存在这个名字
                }
            }
        }
        return status;
    }
    /**
     * 判断登录用户密码是否正确
     *
     *
     */
    public int judgeUser(String user_name, String user_pwd) {

        int index = -1;// 表示账号不存在
        for (int i = 0; i < users.size(); i++) {
            if (users != null) {
                if (user_name.equals(users.get(i).getUser_name())) {
                    if (user_pwd.equals(users.get(i).getUser_pwd())) {
                        index = 1;// 表示账号密码正确
                    } else {
                        index = 0;// 表示密码错误
                    }
                }
            }
        }
        return index;
    }

    /**
     * 判断是否注册成功
     *
     * @return
     */
    public boolean register(String user_name, String user_pwd,String user_email) {
        boolean flag = false;

            if (udi.regist(user_name, user_pwd,user_email) != 0) {
                flag = true;// 注册成功
            }

        return flag;
    }

    /**
     * 判断登录是否成功
     *
     */
    public boolean login(String user_name, String user_pwd) {
        boolean flag = false;
        if (judgeUser(user_name, user_pwd) == 1) {// 原来账号密码正确
            flag = true;
        } else if (judgeUser(user_name, user_pwd) == -1) {
            System.out.println("账号输入有误");

        } else {
            System.out.println("密码输入有误");
        }

        return flag;
    }

    /**
     * 对字符串md5加密
     *
     */
    public static String getMD5(String str) {

        // 生成一个MD5加密计算摘要
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } finally {
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            return new BigInteger(1, md.digest()).toString(16);
        }

    }

    /**
     * 查看用户
     */
    public void checkUsers() {
        updateAllUser();
        System.out.println("用户id\t" + "用户名\t" + "余额\t" + "用户状态");
        for (Users user : users) {
            System.out.println(user);
        }
    }

    /**
     * 充值
     */
    public boolean recharge(String user_name, double money) {
        boolean flag = false;
        if (getUser(user_name) != null) {
            if (udi.recharge(user_name, money) != 0) {// 存入数据库
                flag = true;
                getUser(user_name).setUser_balance(getUser(user_name).getUser_balance() + money);// 充值
            }
        }
        return flag;
    }

    /**
     * 判断余额是否足够
     */
    public boolean judgeBalance(String user_name, double money) {
        boolean flag = false;
        if (getUser(user_name) != null) {
            if ((getUser(user_name).getUser_balance() - money) >= 0) {// 判断余额是否足够
                flag = true;

            }

        }
        return flag;
    }

    /**
     * 消费
     */
    public boolean consume(String user_name, double money) {
        boolean flag=false;
        if(judgeBalance(user_name,money)){
            if (udi.recharge(user_name, -money) != 0) {// 判断是否存入数据库
            getUser(user_name).setUser_balance(getUser(user_name).getUser_balance() - money);
            flag=true;
          }
        }
        return flag;
    }

    /**
     * 查看余额
     *
     *
     */
    public void checkBalance(String user_name) {
        System.out.println("您的余额为:" + getUser(user_name).getUser_balance());
    }

    /**
     * 修改密码
     */
    public boolean modifyPassword(String user_name, String user_pwd) {
        boolean flag = false;
        if (udi.modifyPassword(user_name, user_pwd) != 0) {
            flag = true;
        }
        return flag;
    }
    /**
     * 修改电话号码
     */
    public boolean modifyTel(String user_name, String user_tel) {
        boolean flag = false;
        if (udi.modifyUser_tel(user_name, user_tel) != 0) {
            flag = true;
        }
        return flag;
    }

    /**
     * 修改收货地址
     */
    public boolean modifyAddress(String user_name, String user_address) {
        boolean flag = false;
        if (udi.modifyUser_address(user_name, user_address) != 0) {
            flag = true;
        }
        return flag;
    }
}
