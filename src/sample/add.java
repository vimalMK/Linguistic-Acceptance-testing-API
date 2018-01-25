package sample;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.poi.sl.usermodel.Placeholder;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFNotes;
import org.apache.poi.xslf.usermodel.XSLFPictureData;
import org.apache.poi.xslf.usermodel.XSLFPictureShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFSlideMaster;
import org.apache.poi.xslf.usermodel.XSLFTextShape;

public class add {
	
	void createSlide() throws IOException
	{
		  XMLSlideShow ppt = new XMLSlideShow();	     
	      ppt.setPageSize(new Dimension (1024,768)); 
	      //creating an FileOutputStream object
	      File file =new File("LATppt.pptx");
	     // File f = new File(filePathString);
	      if(!file.exists()){ 
	    	  FileOutputStream out = new FileOutputStream(file);
		      ppt.write(out);
		      System.out.println("Presentation created successfully ");
		      out.close();
	      }
	      
	      
		
	}
   
	void insertImage(String fileName) throws IOException
	{
		
		  File file = new File("LATppt.pptx");
	      FileInputStream inputstream=new FileInputStream(file);
	      XMLSlideShow ppt = new XMLSlideShow(inputstream);
	      FileOutputStream out = new FileOutputStream(file);
	      addSlide(ppt,fileName);
	      ppt.write(out);
	      System.out.println("Presentation created successfully with image");
	      out.close();
	      
	      
	}
	
	void addSlide(XMLSlideShow ppt, String fileName) throws FileNotFoundException, IOException
	{

		  XSLFSlide slide = ppt.createSlide();
		  swingController c=new swingController();
		 // String title=c.HeaderTitle();
	      String path=c.fun();
	      addText(path,slide,ppt);
		  byte[] pictureData = IOUtils.toByteArray(new FileInputStream(fileName));
          XSLFPictureData pd = ppt.addPicture(pictureData, XSLFPictureData.PictureType.PNG);
	      XSLFPictureShape pic = slide.createPicture(pd);
	       
	}
	
	void addText(String path, XSLFSlide slide,XMLSlideShow ppt)
	{
		XSLFNotes note = ppt.getNotesSlide(slide);

	   
		  // insert text
	    for (XSLFTextShape shape : note.getPlaceholders()) {
	        if (shape.getTextType() == Placeholder.BODY) {
	            shape.setText(path);
	            break;
	        }
	    }
	    
	    
	      
	}
	void screenshot( String fileName)
	{
		try {
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			Rectangle screenRectangle = new Rectangle(screenSize);
			Robot robot = new Robot();
			BufferedImage image = robot.createScreenCapture(screenRectangle);
			ImageIO.write(image, "png", new File(fileName));
			System.out.println("saved.."+fileName);
			insertImage(fileName);

		} catch (Exception e) {
			e.printStackTrace();
		}

	
	}
	
}