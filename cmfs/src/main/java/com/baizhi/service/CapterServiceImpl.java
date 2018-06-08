package com.baizhi.service;

import com.baizhi.dao.CapterDAO;
import com.baizhi.entity.Capter;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.UUID;
@Service
@Transactional
public class CapterServiceImpl implements  CapterService{
    @Autowired
    private CapterDAO capterDAO;
    @Override
    public boolean insertCapterService(MultipartFile audio, String id, HttpServletRequest request){


        try {
            //获取文件的存储路径
            //1.项目路径
            String objectPath= request.getSession().getServletContext().getRealPath("/");
            //2.获取项目文件的对象
            File file= new File(objectPath);
            //3.获取文件的上一级路径(web的路径)
            String webappsPath = file.getParent();
            //4.在web文件路径创建上传文件的路径
            File uploadPath=new File(webappsPath+"/audio");
            //判断该路径是否存在,不存在创建一个
            if(!uploadPath.exists()) uploadPath.mkdir();
            //二。为了防止多次上传文件时，前面的文件被后面的文件覆盖，每上传一个文件需取一个新名字
            //1.获取上传文件的名字(旧名字）
            String oldname=audio.getOriginalFilename();
            //文件的格式不能改因此，我们要获取他的后缀（通过一个根据类FilenameUtils）
            String extension= FilenameUtils.getExtension(oldname);
            //通过uuid为上传文件取新名字
            UUID uuid=UUID.randomUUID();
            String newname=uuid.toString();
            //新名字拼上后缀，为新文件的完整名字
            newname=newname+"."+extension;
            //shang传文件
            audio.transferTo(new File(uploadPath.getPath()+"/"+newname));
            Capter capter=new Capter();
            capter.setId(UUID.randomUUID().toString());
            capter.setDownPath(uploadPath.getPath()+"/"+newname);
            capter.setAblum_id(id);
            capter.setSize(String.valueOf(audio.getSize()));
            capter.setUploadDate(new Date());
            capter.setAname(oldname);
            System.out.println("\\"+"audio"+"\\"+newname);
            capterDAO.insertCapter(capter);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }
    //文件的下载


    @Override
    public void downCapterService(String url, String oldName, HttpServletRequest request, HttpServletResponse response) {
        //找文件的存储位置
        String objectPath = request.getSession().getServletContext().getRealPath("/");
        //根据文件路径做参数，获取对应的文件
        File file=new File(objectPath);
        //web文件的路径
        String webPath=file.getParent();
        //要下载文件的路径
        String  filePath=webPath+"/"+url;
        //根据下载文件的路径找到我们下载的文件
        File fileDown=new File(filePath);
        //设置文件的响应头
        String fileName=null;
        try{
            fileName=new String(oldName.getBytes("utf-8"), "ISO8859-1");}
        catch (Exception e ){
            e.printStackTrace();
        }
        response.setHeader("content-Disposition","attachment-filename"+fileName);
        response.setContentType("audio/mpeg");
        //将数据响应
        try{
            OutputStream outputStream=response.getOutputStream();
            outputStream.write(FileUtils.readFileToByteArray(fileDown));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
