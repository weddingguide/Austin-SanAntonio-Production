package jwm.wgbe;
import jwm.entity.*;
import jwm.db.*;
import jwm.logger.*;
import java.io.*;
import jwm.image.*;
import jwm.idmanager.*;
import javax.swing.*;

public class ImageCacheHandler
{
   private String galleryRoot;
   private DBData dbData;

   public ImageCacheHandler( DBData aDbData )
   {
      dbData = aDbData;
      galleryRoot = SiteProperty.valueOf( dbData, "galleryRoot", "** galleryRoot SiteProperty not defined**" );

      File gallery = new File( galleryRoot );
      if (!gallery.exists()) // hack for server xfer and renaming \web to \domains
      {
         galleryRoot = SiteProperty.valueOf( dbData, "galleryRoot2", "** galleryRoot SiteProperty not defined**" );
      }

   }
   public String getCachedImageURL( int businessEntityId, String imageFileName, String cachedFilePrefix, String subFolder, int width, int height, boolean scaleOnlyNoCrop )
   {
      String sourceImageFileName = galleryRoot+"/"+businessEntityId+"/"+imageFileName;

      File sourceImage = new File( sourceImageFileName );
      if (( !sourceImage.exists() ) || (imageFileName.trim().equals("")))
      {
         sourceImageFileName = galleryRoot+"/0/imagenotfound.jpg";
         imageFileName = "ImageNotFound.jpg";
      }

      String cachedFileName      = galleryRoot+"/cache/"+businessEntityId+"/"+subFolder+"/"+cachedFilePrefix + imageFileName;
      String cachedImageURL       = "/galleries/cache/"+businessEntityId+"/"+subFolder+"/"+cachedFilePrefix+imageFileName;

      File cachedImage = new File( cachedFileName );

      if (( !cachedImage.exists() )
         ||( sourceImage.lastModified() > cachedImage.lastModified() ))
      {
         ImageIcon newImage;
         if (!scaleOnlyNoCrop)
         {
            newImage = JPGImage.sizeAndCropImage( sourceImageFileName, width, height );
         }
         else
         {
            newImage = JPGImage.scaleToFit( sourceImageFileName, width, height );
         }

         JPGImage.writeJPGImage( newImage.getImage(), cachedFileName );
      }
      return( cachedImageURL );
   }

   public String cachedImageTag ( int businessEntityId, String imageFileName, String cachedFilePrefix, String subFolder, int width, int height, String additionalAttributes, boolean scaleOnlyNoCrop )
   {
      return( cachedImageTag( businessEntityId, imageFileName, cachedFilePrefix, subFolder, width, height, additionalAttributes, scaleOnlyNoCrop, false ));
   }

   public String cachedImageTag ( int businessEntityId, String imageFileName, String cachedFilePrefix, String subFolder, int width, int height, String additionalAttributes, boolean scaleOnlyNoCrop, boolean parmsOnly )
   {
      String cachedImageURL = getCachedImageURL( businessEntityId, imageFileName, cachedFilePrefix, subFolder, width, height, scaleOnlyNoCrop );

//    if (!scaleOnlyNoCrop)
      if (true)
      {
        String retValue = "src=\""+cachedImageURL+"\" border=\"0\" width=\""+width+"\" height="+height+"\" " + additionalAttributes;
        if (parmsOnly) return( retValue );
        return( "<img " + retValue + ">");
      }
      else
      {
         return("<div style=\"display:inline; border:2px solid black; width:"+width+"px; height:"+height+"px;\"" + additionalAttributes + "><img src=\""+cachedImageURL+"\" width=\""+width+"\" height="+height+"\" " + "/></div>");
      }
   }
}
