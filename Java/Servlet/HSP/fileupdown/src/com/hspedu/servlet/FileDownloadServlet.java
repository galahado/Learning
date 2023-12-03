package com.hspedu.servlet;

import org.apache.commons.io.IOUtils;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

public class FileDownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FileDownloadServlet 被调用...");
        //1. 先准备要下载的文件[假定这些文件是公共的资源]
        //   重要: 保证当我们的tomcat启动后，在工作目录out下有download文件夹, 并且有可供下载的文件!!
        //   老师再次说明，如果你没有看到你创建的download在工作目录out下 rebuild project -> restart, 就OK

        //2. 获取到要下载的文件的名字
        request.setCharacterEncoding("utf-8");
        String downLoadFileName = request.getParameter("name");
        //System.out.println("downLoadFileName= " + downLoadFileName);

        //3. 给http响应，设置响应头 Content-Type , 就是文件的MIME
        //   通过servletContext 来获取
        ServletContext servletContext = request.getServletContext();
        String downLoadPath = "/download/"; //下载目录从 web工程根目录计算 /download/1.jpg
        String downLoadFileFullPath = downLoadPath + downLoadFileName;
        String mimeType = servletContext.getMimeType(downLoadFileFullPath);
        System.out.println("mimeType= " + mimeType);
        response.setContentType(mimeType);

        //4. 给http响应，设置响应头 Content-Disposition
        //   这里考虑的细节比较多，比如不同的浏览器写法不一样，考虑编码
        //   ff 是 文件名中文需要 base64, 而 ie/chrome 是 URL编码
        //   这里我们不需要同学们记住，只需知道原理
        //   老韩解读
        //(1)如果是Firefox 则中文编码需要 base64
        //(2)Content-Disposition 是指定下载的数据的展示形式 , 如果attachment 则使用文件下载方式
        //(3)如果是其他(主流ie/chrome) 中文编码使用URL编码
        if (request.getHeader("User-Agent").contains("Firefox")) {
            // 火狐 Base64编码
            response.setHeader("Content-Disposition", "attachment; filename==?UTF-8?B?" +
                    new BASE64Encoder().encode(downLoadFileName.getBytes("UTF-8")) + "?=");
        } else {
            // 其他(主流ie/chrome)使用URL编码操作
            response.setHeader("Content-Disposition", "attachment; filename=" +
                    URLEncoder.encode(downLoadFileName, "UTF-8"));
        }

        //5. 读取下载的文件数据，返回给客户端/浏览器
        //(1) 创建一个和要下载的文件，关联的输入流
        InputStream resourceAsStream =
                servletContext.getResourceAsStream(downLoadFileFullPath);
        //(2) 得到返回数据的输出流 [因为返回文件大多数是二进制(字节), IO java基础]
        ServletOutputStream outputStream = response.getOutputStream();

        //(3) 使用工具类，将输入流关联的文件，对拷到输出流，并返回给客户端/浏览器
        IOUtils.copy(resourceAsStream, outputStream);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
