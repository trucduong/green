package com.green.sale.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import com.green.sale.entity.Account;
import com.green.sale.utils.ApplicationConfig;

/**
 * https://mvnrepository.com/artifact/commons-fileupload/commons-fileupload/1.4
 * https://mvnrepository.com/artifact/commons-io/commons-io/2.6
 *
 */
@WebServlet("/profile/image")
public class ProfileImageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private String PROFILE_IMAGE_DIR;

    @Override
    public void init() throws ServletException {
        PROFILE_IMAGE_DIR = ApplicationConfig.getConfig("image.dir.profile");
        File filesDir = new File(PROFILE_IMAGE_DIR);
        if (!filesDir.exists()) {
            filesDir.mkdirs();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // lấy thông tin user đang đăng nhập
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("CURRENT_USER");

        String fileName = PROFILE_IMAGE_DIR + File.separator + account.getCode();

        ServletContext ctx = getServletContext();
        File file = new File(fileName);
        
        // nếu không tồn tại thì lấy hình đại diện mặc định
        if (!file.exists()) {
            file = new File(ctx.getRealPath("resources/image/avatar.png"));
        }

        InputStream fis = new FileInputStream(file);
        String mimeType = ctx.getMimeType(file.getAbsolutePath());
        response.setContentType(mimeType != null ? mimeType : "application/octet-stream");
        response.setContentLength((int) file.length());
        response.setHeader("Content-Disposition", "inline");

        ServletOutputStream os = response.getOutputStream();
        byte[] bufferData = new byte[1024];
        int read = 0;
        while ((read = fis.read(bufferData)) != -1) {
            os.write(bufferData, 0, read);
        }
        os.flush();
        os.close();
        fis.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("CURRENT_USER");

        if (!ServletFileUpload.isMultipartContent(request)) {
            throw new ServletException("Content type is not multipart/form-data");
        }

        try {
        	Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
			InputStream filecontent = filePart.getInputStream();
			File file = new File(PROFILE_IMAGE_DIR + File.separator + account.getCode());
			file.delete();
			IOUtils.copy(filecontent, new FileOutputStream(file));
        } catch (Exception e) {
            throw new ServletException("Error to upload file", e);
        }
        
        response.sendRedirect(request.getContextPath() + "/profile");
    }
}
