package com.huadi.controller;


import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping(value = "/file")
public class FileUploadController {

        @RequestMapping(value = "/upload",method = RequestMethod.POST)
        public String uploadFile(@RequestParam("imgPath") MultipartFile file,
                                 MultipartHttpServletRequest request) throws IOException {
            //判断目录是否在服务器上，如果没有我们创建一个目录，并把上传文件放在目录下面
              if(!file.isEmpty()){
                 String imgPath =  request.getSession().getServletContext().getRealPath("/resources/")
                         +file.getOriginalFilename();
                  System.out.println(imgPath);
               //上传文件到指定目录
                  FileUtils.copyInputStreamToFile(file.getInputStream(),new File(imgPath));
              }

              return "result";
        }
    }

