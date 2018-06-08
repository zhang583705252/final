
import com.baizhi.dao.AblumDAO;
import com.baizhi.dao.CapterDAO;
import com.baizhi.entity.Ablum;
import com.baizhi.entity.Capter;
import com.baizhi.service.CapterService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.UUID;

public class AblumTest {
   /* @Test
    public void selectAblumService(){

       ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring.xml");
         AblumDAO ablumDAO=(AblumDAO) context.getBean("ablumDAO");


    }*/
  /*  @Test
    public void   test(){

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring.xml");
        AblumDAO ablumDAO=(AblumDAO) context.getBean("ablumDAO");
        System.out.println(ablumDAO);
        Ablum ablum=new Ablum();
        ablum.setAname("随园诗话");
        ablum.setCount(2);
        ablum.setId(UUID.randomUUID().toString());
        ablum.setAuthor("袁枚");
        ablumDAO.insertAblum(ablum);
    }*/
   /* @Test
    public void   test2(){

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring.xml");
        AblumDAO ablumDAO=(AblumDAO) context.getBean("ablumDAO");
        System.out.println(ablumDAO);
        Ablum ablum=new Ablum();
        ablum.setAname("若只如初见");
        ablum.setAuthor("我");
        ablumDAO.insertAblum(ablum);
    }
    @Test
    public void updateCountService(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring.xml");
        AblumDAO ablumDAO=(AblumDAO) context.getBean("ablumDAO");
        Ablum ablum=ablumDAO.selectAblum("1");
        ablum.setCount(1);
        ablumDAO.updateCount(ablum);

    }*/
   /* @Test
    public void selectAblum(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring.xml");
        AblumDAO ablumDAO=(AblumDAO) context.getBean("ablumDAO");
        List<Ablum> ablums=ablumDAO.selectAllAblum();
        System.out.println(ablums);

    }
    @Test
    public void insertCapter(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring.xml");
        CapterDAO capterDAO=(CapterDAO) context.getBean("capterDAO");
        Capter capter=new Capter();
        capter.setAname("简介");
        capter.setId(UUID.randomUUID().toString());
        capter.setAblum_id("a674967a-46eb-4453-807c-b73963fd1c01");
        capterDAO.insertCapter(capter);
        System.out.println(capter);*/

   // }
    @Test
    public  void test5(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring.xml");
        AblumDAO ablumDAO=(AblumDAO) context.getBean("ablumDAO");
        Ablum ablum=ablumDAO.selectAblum("7727f7a8-0595-4734-bd2b-195145a16a92");
        System.out.println(ablum.getCount());
        System.out.println(ablum.getAuthor());
        System.out.println(ablum.getChildren());

    }

}
