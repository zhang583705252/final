import com.alibaba.druid.sql.ast.expr.SQLCaseExpr;
import com.baizhi.dao.DynamicPictureDAO;
import com.baizhi.dao.ManagerDAO;
import com.baizhi.dao.MenuDAO;
import com.baizhi.entity.DynamicPicture;
import com.baizhi.entity.Manager;
import com.baizhi.entity.Menu;
import org.apache.ibatis.session.SqlSession;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class ManagerTest {
    @Test
    public void test1(){
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
        ManagerDAO md=(ManagerDAO)context.getBean("managerDAO");
        Manager ma=md.queryManagerBy_Name("13713024235");
        System.out.println(ma);
    }
    @Test
    public void test2(){
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
        MenuDAO md=(MenuDAO)context.getBean("menuDAO");
        List<Menu> ma=md.queryAll();
        for(Menu menu:ma){
            System.out.println(menu);
        }



    }
    @Test
    public void test3(){
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
        DynamicPictureDAO md=(DynamicPictureDAO)context.getBean("dynamicPictureDAO");
        List<DynamicPicture> ma=md.queryAll();
        for(DynamicPicture menu:ma){
            System.out.println(menu);
        }
     }
    @Test
    public void test4() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        DynamicPictureDAO md = (DynamicPictureDAO) context.getBean("dynamicPictureDAO");
        DynamicPicture dp=new DynamicPicture();
            dp.setImgPath("img/6.gif");dp.setTitle("图片");
           md.insertPicture(dp);

    }
    @Test
    public void test5() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        DynamicPictureDAO md = (DynamicPictureDAO) context.getBean("dynamicPictureDAO");
        List<Integer> list=new ArrayList<Integer>();
        list.add(90);list.add(98);list.add(99);list.add(100);list.add(101);list.add(102);list.add(103);list.add(104);
        md.deletePicture(list);



    }

    @Test
    public void test6() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        DynamicPictureDAO md = (DynamicPictureDAO) context.getBean("dynamicPictureDAO");

        DynamicPicture dd=md .queryBy_id(99);
        dd.setImgPath("img/3.jpg");
        md.updataPicture(dd);
        System.out.println(dd);

    }
    @Test
    public void test7(){
        //创建工作簿
       HSSFWorkbook hssfWorkbook= new HSSFWorkbook();
        //建表
        HSSFSheet sheet=hssfWorkbook.createSheet("工作表");
        //创建表格行
       HSSFRow row=sheet.createRow(0);
       String[] title={"编号","名字","密码","日期"};
       //创建单元格
        for (int i = 0; i < title.length; i++) {
            String s = title[i];
            HSSFCell cell=row.createCell(i);
            System.out.println(cell);
            cell.setCellValue(s);
        }
        try {
            hssfWorkbook.write(new FileOutputStream(new File("e:/第一个.xls")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
