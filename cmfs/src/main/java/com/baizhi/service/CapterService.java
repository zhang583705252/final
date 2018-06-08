package com.baizhi.service;

import com.baizhi.entity.Capter;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CapterService {
    //1.添加章节
    boolean insertCapterService(MultipartFile file, String id, HttpServletRequest request);
    //2.文件的下载
    void downCapterService(String url, String oldName, HttpServletRequest request, HttpServletResponse response);
}
