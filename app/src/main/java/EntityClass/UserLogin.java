package EntityClass;

/**
 * @author wangxian
 * @description 用户登录
 * @date 2019/4/8
 */
public class UserLogin {
    /**
     * 用户id
     */
    private int id;

    /**
     * 手机号
     */
    private String userPhone;

    /**
     * 密码
     */
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passworld) {
        this.password = passworld;
    }

    @Override
    public String toString() {
        return "UserLogin{" +
                "id=" + id +
                ", userPhone='" + userPhone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
