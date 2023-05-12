package org.example;

import com.norconex.collector.http.HttpCollector;
import com.norconex.collector.http.HttpCollectorConfig;
import com.norconex.commons.lang.xml.XML;

import java.io.File;
import java.io.IOException;

    public class WebCrawler {

    public static void main(String[] args) {
        HttpCollectorConfig config = new HttpCollectorConfig();

        XML xml = new XML(new File("httpcollector-config.xml"));
        config.loadFromXML(xml);
        HttpCollector collector = new HttpCollector(config);


        String folderPath = "./examples-output/complex";
        File folder = new File(folderPath);
//        try {
//            deleteFolder(folder);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        collector.start();
    }




    public static void deleteFolder(File folder) throws IOException {
        if (!folder.exists()) {
            throw new IOException("Folder not found: " + folder.getAbsolutePath());
        }

        if (!folder.isDirectory()) {
            throw new IOException("Not a folder: " + folder.getAbsolutePath());
        }

        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteFolder(file);
                } else {
                    if (!file.delete()) {
                        throw new IOException("Unable to delete file: " + file.getAbsolutePath());
                    }
                }
            }
        }

        if (!folder.delete()) {
            throw new IOException("Unable to delete folder: " + folder.getAbsolutePath());
        }
    }
}
