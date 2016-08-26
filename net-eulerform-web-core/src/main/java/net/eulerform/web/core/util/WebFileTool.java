package net.eulerform.web.core.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.multipart.MultipartFile;

import net.eulerform.common.CalendarTool;
import net.eulerform.common.FileReader;
import net.eulerform.web.core.exception.MultipartFileSaveException;

public class WebFileTool {

	public static File saveMultipartFile(MultipartFile multipartFile) throws MultipartFileSaveException {

            String uploadPath = WebConfig.getUploadPath();
            
            return saveMultipartFile(multipartFile, uploadPath);
        
	}

	public static File saveMultipartFile(MultipartFile multipartFile, String uploadPath) throws MultipartFileSaveException{
	    try {
            ServletContext scx = ContextLoader.getCurrentWebApplicationContext().getServletContext();

            String realUploadPath = scx.getRealPath(uploadPath);
        
            File targetDir = new File(realUploadPath);
            String sourceFileName = multipartFile.getOriginalFilename();
            
            String prefix = CalendarTool.formatDate(new Date(), "yyyyMMddHHmmss-");
            
            String extension = FileReader.getFileExtension(sourceFileName);
            
            String targetFileName = prefix + UUID.randomUUID().toString() + extension;
            
            File targetFile = new File(realUploadPath, targetFileName);
            if (!targetDir.exists()) {
                targetDir.mkdirs();
            }
            multipartFile.transferTo(targetFile);
            return targetFile;
        } catch (IllegalStateException | IOException e) {
            throw new MultipartFileSaveException(e);
        }
	}
}
