package ma.bps.presentation;

import java.io.BufferedInputStream;  
  import java.io.BufferedOutputStream;  
  import java.io.File;  
  import java.io.FileInputStream;  
 import java.io.IOException;  
import javax.faces.context.FacesContext;  
import javax.servlet.http.HttpServletResponse;  
import javax.faces.bean.ManagedBean;  
 @ManagedBean(name="fileDownloadBean")  
 public class FileDownloadBean {  
      private static final int DEFAULT_BUFFER_SIZE = 10240;  
      private String filePath = "C:/ahmed/Gestion_RH.rar";  
     public void downLoad() throws IOException {  
          FacesContext context = FacesContext.getCurrentInstance();  
          HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();  
          File file = new File(filePath);  
          if (!file.exists()) {
        	  System.err.println("fichier non existe 999999999999999999999999999999999999999999");
               response.sendError(HttpServletResponse.SC_NOT_FOUND);  
               return;  
         }  
          response.reset();  
          response.setBufferSize(DEFAULT_BUFFER_SIZE);  
          response.setContentType("application/octet-stream");  
          response.setHeader("Content-Length", String.valueOf(file.length()));  
          response.setHeader("Content-Disposition", "attachment;filename=\"" + file.getName() + "\"");  
           BufferedInputStream input = null;  
         BufferedOutputStream output = null;  
         try 
         {  
               input = new BufferedInputStream(new FileInputStream(file), DEFAULT_BUFFER_SIZE);  
               output = new BufferedOutputStream(response.getOutputStream(), DEFAULT_BUFFER_SIZE);  
               byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];  
               int length;  
               while ((length = input.read(buffer)) > 0) 
               {  
                   output.write(buffer, 0, length);  
               }  
         } 
         finally 
         {  
              input.close();  
               output.close();  
         }  
          context.responseComplete();  
    } 
     
     
     
 	// télecharger un fichiers 
     public void downloadFichier(String chemain) throws IOException {  
     	
        // private static final int DEFAULT_BUFFER_SIZE = 10240;  
        // private String filePath = "C:\\ahmed\\Gestion_RH.rar"; ou bien private String filePath = "C:/ahmed/Gestion_RH.rar";     	
     	
    	 System.err.println("Telechargement fichier999999999999999999999999999 999999999999999999999999999999999999999999");
    	 System.err.println(chemain);
    	 
         FacesContext context = FacesContext.getCurrentInstance();  
         HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();  
         File file = new File(chemain);  
         if (!file.exists()) {
       	  System.err.println("fichier non existe 999999999999999999999999999999999999999999");
              response.sendError(HttpServletResponse.SC_NOT_FOUND);  
              return;  
        }  
         response.reset();  
         response.setBufferSize(10240);  
         response.setContentType("application/octet-stream");  
         response.setHeader("Content-Length", String.valueOf(file.length()));  
         response.setHeader("Content-Disposition", "attachment;filename=\"" + file.getName() + "\"");  
          BufferedInputStream input = null;  
        BufferedOutputStream output = null;  
        try 
        {  
              input = new BufferedInputStream(new FileInputStream(file), 10240);  
              output = new BufferedOutputStream(response.getOutputStream(), 10240);  
              byte[] buffer = new byte[10240];  
              int length;  
              while ((length = input.read(buffer)) > 0) 
              {  
                  output.write(buffer, 0, length);  
              }  
        } 
        finally 
        {  
             input.close();  
              output.close();  
        }  
         context.responseComplete();  
   }
     
     
     
     
  }  