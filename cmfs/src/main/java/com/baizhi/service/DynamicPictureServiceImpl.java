package com.baizhi.service;

import com.baizhi.dao.DynamicPictureDAO;
import com.baizhi.entity.DynamicPicture;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class DynamicPictureServiceImpl implements DynamicPictureService{
    @Autowired
    private DynamicPictureDAO dynamicPictureDAO;


    //查询所有
    public List<DynamicPicture> queryAllService(){

       List<DynamicPicture> pictures= dynamicPictureDAO.queryAll();
       return pictures;

    }
    //添加图片
    @Override
    public void addPictureService(String title, String desc, String status, Date data, MultipartFile img,HttpServletRequest request) {
        //获取文件的存储路径
        //1.项目路径

        System.out.println(request);
         String objectPath= request.getSession().getServletContext().getRealPath("/");
         //2.获取项目文件的对象
        File  file= new File(objectPath);
        //3.获取文件的上一级路径(web的路径)
        String webappsPath = file.getParent();
        //4.在web文件路径创建上传文件的路径
         File uploadPath=new File(webappsPath+"/upload");
        //判断该路径是否存在,不存在创建一个
        if(!uploadPath.exists()) uploadPath.mkdir();
        //二。为了防止多次上传文件时，前面的文件被后面的文件覆盖，每上传一个文件需取一个新名字
        //1.获取上传文件的名字(旧名字）
        String oldname=img.getOriginalFilename();
        //文件的格式不能改因此，我们要获取他的后缀（通过一个根据类FilenameUtils）
        String extension= FilenameUtils.getExtension(oldname);
        //通过uuid为上传文件取新名字
        UUID uuid=UUID.randomUUID();
        String newname=uuid.toString();
        //新名字拼上后缀，为新文件的完整名字
        newname=newname+"."+extension;
        //shang传文件
        try {
            img.transferTo(new File(uploadPath.getPath()+"/"+newname));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //将传入的数据封装成实体传入数据库
         DynamicPicture dynamicPicture=new DynamicPicture();
        dynamicPicture.setData(data);
        dynamicPicture.setStatus(status);
        dynamicPicture.setDesc(desc);
        dynamicPicture.setTitle(title);
        dynamicPicture.setImgPath(newname);
        dynamicPictureDAO.insertPicture(dynamicPicture);

    }
    //清除图片
    @Override
    public void removePictureService(List<Integer> list) {
        if(list==null) throw new RuntimeException("请求数据不能为空");
        dynamicPictureDAO.deletePicture(list);
    }
    //修改图片
    @Override
    public void updataPicture(DynamicPicture dynamicPicture) {
        //先根据id查出要修改的数据
        DynamicPicture d_Picture=dynamicPictureDAO.queryBy_id(dynamicPicture.getId());
        //将页面修改的对象赋值给数据库查出来的dx
        d_Picture.setStatus(dynamicPicture.getStatus());
        //存入数据库
        dynamicPictureDAO.updataPicture(d_Picture);

    }
    //添加图片
    @Override
    public DynamicPicture queryBy_id(DynamicPicture dynamicPicture) {
        dynamicPictureDAO.insertPicture(dynamicPicture);
        return null;
    }


}
