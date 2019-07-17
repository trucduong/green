package com.green.sale.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.sale.utils.ApplicationConfig;

@WebServlet("/product/image")
public class ProductImageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private String PRODUCT_IMAGE_DIR;

    @Override
    public void init() throws ServletException {
        PRODUCT_IMAGE_DIR = ApplicationConfig.getConfig("image.dir.product");
        
        File filesDir = new File(PRODUCT_IMAGE_DIR);
        if (!filesDir.exists()) {
            filesDir.mkdirs();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext ctx = getServletContext();
        File file;
        
        // lấy product code từ request
        String productCode = request.getParameter("code");
        if (productCode == null || productCode.isEmpty()) {
            file = new File(ctx.getRealPath("resources/image/product.png"));
            
        } else {
            String fileName = PRODUCT_IMAGE_DIR + File.separator + productCode;
            file = new File(fileName);
            
            // nếu không tồn tại thì lấy hình mặc định
            if (!file.exists()) {
                file = new File(ctx.getRealPath("resources/image/product.png"));
            }
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
}
