/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package image.resizer.hybris.plugin;
import java.awt.AlphaComposite;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;


/**
 *
 * @author Noxolo.Mkhungo
 */
public class ImageResizerHybrisPlugin {

    /**
     * @param args the command line arguments
     */
     
     
     private static final String[]imgFolder = {"515Wx515H","300Wx300H","96Wx96H","65Wx65H","30Wx30H"}; 
     private static final Dimension[] imgDimensions={new Dimension(515, 515),new Dimension(300, 300),new Dimension(96, 96),new Dimension(65, 65),new Dimension(30, 30)};
     private static BufferedImage[] imgBufferedImages=new BufferedImage[100];

     
     
   //public static BufferedImage originalImage;
    public static Boolean ImgDimensiionFlag;
    public static void main(String[] args) {
        
	try{
               
                BufferedImage originalImage = null;
                File imageFile = null;
                File outputImageFile = null;
                File path = null;
       
                System.out.println("System get :"+System.getProperty("user.dir")+"/resource/images/1200Wx1200H");
                imageFile =new File(System.getProperty("user.dir")+"/resource/images/1200Wx1200H/GF01_FAB.jpg"); // Image File Path          
                originalImage = ImageIO.read(imageFile);
                int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
              
                
                
                
                System.out.println("Reading complete.");
                //Boolean flag = validateImgDimension(originalImage);
                //validateImage = originalImage;
                int imgWidth = originalImage.getWidth();///Get Original  Image Width
                System.out.println("The Width of the image is :"+ imgWidth);
                int imgHeight = originalImage.getHeight();//Get Original Image Height
                System.out.println("The Height of the image is :"+ imgHeight);
                if(imgWidth == 1200 && imgHeight == 1200)//  Validating the image is the correct dimension size 1200x1200
                    { System.out.println("Verified Image Size Lets do this."); ImgDimensiionFlag =true;} //Set The Image Dimension to true if image does the criteria
                else if(imgWidth != 1200)//  Validating the image is the correct width size 1200x1200
                    {System.out.println("Sorry the image is not a 1200 width Please make sure it a 1200Wx1200H image");ImgDimensiionFlag =false;} //Set The Image Dimension to false if image doesn't the Width criteria
                else if(imgHeight != 1200)//  Validating the image is the correct height size 1200x1200
                    {System.out.println("Sorry the image is not a 1200 in height Please make sure it a 1200Wx1200H image");ImgDimensiionFlag =false;}//Set The Image Dimension to false if image doesn't the height criteria
                else {System.out.println("Please Upload a 1200 x 1200 image."); ImgDimensiionFlag =false;}//Set The Image Dimension to false if image doesn't the criteria
                
                if(ImgDimensiionFlag == true){  //Once we have established that the image is the correct dimension lets the batch writing begin 
                System.out.println("Image Was Verified");
                for (int i=0; i<imgFolder.length; i++) {
                imgFolder[i].toString();
                    System.out.println("Folder #"+(i+1)+" "+imgFolder[i].toString());
                    
                    //Specifying the output Dimension Dynamically.
                    BufferedImage resizedImage = new BufferedImage((int)imgDimensions[i].getWidth(), (int)imgDimensions[i].getHeight(), type);
                    Graphics2D graphics2D = resizedImage.createGraphics();
        
        
                    graphics2D.drawImage(originalImage, 0, 0, (int)imgDimensions[i].getWidth(), (int)imgDimensions[i].getHeight(), null);
                    graphics2D.dispose();
                    graphics2D.setComposite(AlphaComposite.Src);
        

                    graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                    RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                    graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING,
                    RenderingHints.VALUE_RENDER_QUALITY);
                    graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
                   
                    System.out.println("The File Name Input is "+imageFile.getName()); 
                    outputImageFile = new File("C:\\Users\\noxolo.mkhungo\\Documents\\NetBeansProjects\\Image-Resizer-Hybris-Plugin\\src\\images\\"+imgFolder[i].toString()+"\\"+imageFile.getName()); //output file path
                    ImageIO.write(resizedImage, "jpg", outputImageFile);
                    System.out.println("Writing complete.");
                   
                    
                 }
                //BufferedImage resizeImageHintPng = resizeImageWithHint(originalImage, type);
		//ImageIO.write(resizeImageHintPng, "png", new File("C:\\Users\\noxolo.mkhungo\\Documents\\NetBeansProjects\\Image-Resizer-Hybris-Plugin\\src\\images\\515Wx515H\\GF01_FAB.jpg"));
            
            
          
            }
            
            
            
                
                
//		BufferedImage resizeImageJpg = resizeImage(originalImage, type);
//		ImageIO.write(resizeImageJpg, "jpg", new File("C:\\Users\\noxolo.mkhungo\\Pictures\\imgTestR_jpg.jpg"));
//
//		BufferedImage resizeImagePng = resizeImage(originalImage, type);
//		ImageIO.write(resizeImagePng, "png", new File("C:\\Users\\noxolo.mkhungo\\Pictures\\imgTestR_png.jpg"));
//
//		BufferedImage resizeImageHintJpg = resizeImageWithHint(originalImage, type);
//		ImageIO.write(resizeImageHintJpg, "jpg", new File("C:\\Users\\noxolo.mkhungo\\Pictures\\imgTestR_hint_jpg.jpg"));

                
                
		
                
                

	}catch(IOException e){
		System.out.println(e.getMessage());
	}
       

    }
    

    
//    private static Boolean validateImgDimension(BufferedImage validateImage) throws IOException{
//        //validateImage = originalImage;
//        int imgWidth = validateImage.getWidth();
//        System.out.println("The Width of the image is :"+ imgWidth);
//        int imgHeight = validateImage.getHeight();
//        System.out.println("The Height of the image is :"+ imgHeight);
//        if(imgWidth == 1200 && imgHeight == 1200)//  Validating the image is the correct dimension size 1200x1200
//        { System.out.println("Verified Image Size Lets do this."); ImgDimensiionFlag =true;}
//        else if(imgWidth != 1200)//  Validating the image is the correct width size 1200x1200
//        {System.out.println("Sorry the image is not a 1200 width Please make sure it a 1200Wx1200H image");ImgDimensiionFlag =false;}
//        else if(imgHeight != 1200)//  Validating the image is the correct height size 1200x1200
//        {System.out.println("Sorry the image is not a 1200 in height Please make sure it a 1200Wx1200H image");ImgDimensiionFlag =false;}
//        else {System.out.println("Please Upload a 1200 x 1200 image."); ImgDimensiionFlag =false;}
//        return ImgDimensiionFlag;
//    }
    
   
}
