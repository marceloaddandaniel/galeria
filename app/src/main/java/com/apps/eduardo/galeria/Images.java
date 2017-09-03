package com.apps.eduardo.galeria;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.webkit.MimeTypeMap;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by Eduardo on 02/09/2017.
 */

public class Images {

    public static List<String> getImagesFromCamera(Activity activity){
//        String cameraDirPath = "/storage/emulated/0/DCIM/Camera/";
//        String cameraDirPath = "/storage/36A7-1EE3/DCIM/Camera/";
        String cameraDirPath = "/storage/emulated/0/WhatsApp/Media/WhatsApp Images";


        File cameraDirectory = new File(cameraDirPath);
        List<String> photos = new ArrayList<>();
        File[] photoFiles = cameraDirectory.listFiles();
        for (File file : photoFiles){
            if(file.isFile() && !file.getName().startsWith(".") && getMimeType(file.getAbsolutePath()).startsWith("image")){
                photos.add(file.getAbsolutePath());
                Log.d("fotos",file.getAbsolutePath());
            }
        }
        Collections.sort(photos, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                File f1 = new File(o1);
                File f2 = new File(o2);
                return (int)(f2.lastModified() -f1.lastModified());
            }
        });
        return photos;
    }
    public static ArrayList<String> getFilePaths(Activity activity) {

        Uri u = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        String[] projection = {MediaStore.Images.ImageColumns.DATA};
        Cursor c = null;
        SortedSet<String> dirList = new TreeSet<String>();
        ArrayList<String> resultIAV = new ArrayList<String>();

        String[] directories = null;
        if (u != null) {
            c = activity.managedQuery(u, projection, null, null, null);
        }

        if ((c != null) && (c.moveToFirst())) {
            do {
                String tempDir = c.getString(0);
                tempDir = tempDir.substring(0, tempDir.lastIndexOf("/"));
                try {
                    dirList.add(tempDir);
                } catch (Exception e) {

                }
            }
            while (c.moveToNext());
            directories = new String[dirList.size()];
            dirList.toArray(directories);

        }

        for (int i = 0; i < dirList.size(); i++) {
            File imageDir = new File(directories[i]);
            File[] imageList = imageDir.listFiles();
            if (imageList == null)
                continue;
            for (File imagePath : imageList) {
                try {

                    if (imagePath.isDirectory()) {
                        imageList = imagePath.listFiles();

                    }
                    String mimeType = getMimeType(imagePath.getAbsolutePath());
                    if (mimeType!=null && mimeType.startsWith("image")){
                        String path = imagePath.getAbsolutePath();
                        resultIAV.add(path);
                    }
                }
                //  }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return resultIAV;
    }

    public static String getMimeType(String url) {
        String type = null;
        String extension = MimeTypeMap.getFileExtensionFromUrl(url);
        if (extension != null) {
            type = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
        }
        return type;
    }
}
