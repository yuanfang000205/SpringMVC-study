package com.yuanfang.controller;


import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.UUID;

/**
 * @ClassName FileController
 * @Description TODO
 * @Author yuanFangT
 * @Date 2021/9/2
 **/
@Controller
@RequestMapping("file")
public class FileController {

    /**
     *
     * @param img 该参数名与页面中name名一致
     * @return
     */
    @RequestMapping("upload")
    public String upload(MultipartFile img, HttpServletRequest request) throws IOException {
        System.out.println("文件原始名称为: " + img.getOriginalFilename());
        System.out.println("文件原始类型为: " + img.getContentType());
        System.out.println("文件大小为: " + img.getSize());

        //文件上传
        //1.根据upload相对路径获取部署到服务之后绝对路径
        String realPath = request.getSession().getServletContext().getRealPath("/upload");
        //2.修改文件原始名称
        /* 获取文件扩展名 */
        String extension = FilenameUtils.getExtension(img.getOriginalFilename());
        /* 创建新的文件 */
        String newFileName = UUID.randomUUID().toString().replace("-","") + "." +extension;
        //3.生成当天日期目录
        LocalDate now = LocalDate.now();
        File dateDir = new File(realPath, now.toString());
        if(!dateDir.exists()) {
            dateDir.mkdirs();
        }
        //4.上传文件到upload对应日期的目录下
        img.transferTo(new File(dateDir,newFileName));
        return "index";
    }

    /**
     * 用于处理文件下载，请求对应响应输出流
     */
    @RequestMapping("down")
    public void down(String openStyle,String fileName, HttpServletRequest request, HttpServletResponse response) throws IOException{
        openStyle = openStyle==null?"inline":"attachment";

        System.out.println("下载的文件:" + fileName);
        //1.根据下载相对目录获取下载目录在服务器部署之后的绝对目录
        String realPath = request.getSession().getServletContext().getRealPath("/download");
        //2.通过文件输入流读取文件
        FileInputStream is = new FileInputStream(new File(realPath, fileName));
        //3.获取响应输出流
        response.setContentType("text/html; charset=UTF-8");
        //4.附件下载 attachment附件   inline：在线
        response.setHeader("content-disposition",openStyle + ";fileName=" + URLEncoder.encode(fileName,"UTF-8"));
        ServletOutputStream os = response.getOutputStream();

        //5.处理下载流复制  IO流用IOUtils File类用FileUtils
        IOUtils.copy(is, os);
        IOUtils.closeQuietly(is);
        IOUtils.closeQuietly(os);
        //int len;
        //byte[] b = new byte[1024];
        //while (true){
        //    len = is.read(b);
        //    if (len==-1){
        //        break;
        //    }
        //    os.write(b,0,len);
        //}
        ////释放资源
        //is.close();
        //os.close();

    }
}
