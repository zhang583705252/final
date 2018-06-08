import com.baizhi.dao.UserDAO;

import com.baizhi.dao.UserMapDAO;
import com.baizhi.entity.User;
import com.baizhi.entity.UserMap;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;


public class UserTest {
    //注册功能
    @Test
    public void registUserService( ) {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
        UserDAO userDAO=(UserDAO)context.getBean("userDAO");
        User user=new User();
        user.setUsername("小花");
        user.setPhoneNum("12345678905");
        user.setPassword("123456");
        user.setProvince("北京");
        user.setCity("北京");
        user.setSex("男");
        user.setData(new Date());
        userDAO.insertUser(user);
    }

    @Test
    public void  test4( ) {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
        UserDAO userDAO=(UserDAO)context.getBean("userDAO");
        User user =new User();
        user.setProvince("陕西");
        user.setId(27);
        userDAO.updateUser(user);



    }
    @Test
    public void  test1( ) {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
        UserDAO userDAO=(UserDAO)context.getBean("userDAO");
        List<User> users= userDAO.selectAllUser();
        for (User user : users) {
            System.out.println(user);
        }

    }
    @Test
    public void test3(){
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
        UserMapDAO usermapDAO=(UserMapDAO)context.getBean("userMapDAO");
        List<UserMap> list= usermapDAO.selectprovinceUser();
        List<UserMap>  userMaps= usermapDAO.selectprovinceUser();
        for (UserMap userMap : userMaps) {
            System.out.println(userMap);
        }

    }
    @Test
    public void  test5( ) {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
        UserDAO userDAO=(UserDAO)context.getBean("userDAO");
        User user=new User();
        user.setId(3);
        List<User> users= userDAO.queryAllUser(user);
        for (User use : users) {
            System.out.println(use);
        }

    }

}
