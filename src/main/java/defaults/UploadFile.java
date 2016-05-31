package defaults;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;

public class UploadFile {
private static String statusMessage;
	
	public static String uploadFile(Part file) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
        ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
        String path = servletContext.getRealPath("Gestion_RH/src/main");
        
		System.out.println("real path : " + path);
		// Extract file name from content-disposition header of file part
		String fileName = getFileName(file);
		System.out.println("***** fileName: " + fileName);
		 
		String basePath = path +  File.separator + "images" + File.separator;
		File outputFilePath = new File(basePath + fileName);
		 
		// Copy uploaded file to destination path
		InputStream inputStream = null;
		OutputStream outputStream = null;
		try {
		inputStream = file.getInputStream();
		outputStream = new FileOutputStream(outputFilePath);
		 
		int read = 0;
		final byte[] bytes = new byte[1024];
		while ((read = inputStream.read(bytes)) != -1) {
		outputStream.write(bytes, 0, read);
		}
		 
		statusMessage = "File upload successfull !!";
		} catch (IOException e) {
		e.printStackTrace();
		statusMessage = "File upload failed !!";
		} finally {
		if (outputStream != null) {
		outputStream.close();
		}
		if (inputStream != null) {
		inputStream.close();
		}
		}
		return null;    // return to same page
		}
	
	
	// Extract file name from content-disposition header of file part
	public static String getFileName(Part part) {
		
		final String partHeader = part.getHeader("content-disposition");
		System.out.println("***** partHeader: " + partHeader);
		for (String content : part.getHeader("content-disposition").split(";")) {
		if (content.trim().startsWith("filename")) {
		return content.substring(content.indexOf('=') + 1).trim()
		.replace("\"", "");
		}
		}
		return null;
		}
}
