package com.ps.dorm.Utils;

import org.springframework.stereotype.Service;

import java.io.File;
import java.lang.annotation.Annotation;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Scan {

    public static void main(String[] args) throws ClassNotFoundException, URISyntaxException {

        //File file = new File("E:\\web\\ideaWorkSpace\\demo\\src\\main\\java\\com\\ps\\annotation");
        List<Class> clas = print("com.ps.service.impl");

        List<Class> arr = new ArrayList<>();
        for (Class l:clas) {
            Annotation[] as = l.getAnnotations();
            for (Annotation a:as) {
                if (a instanceof Service){
                    arr.add(l);
                }
            }
        }

        for (Class l:arr) {
            System.out.println(l);
        }
    }

    public static List<Class> print(String pack) {
        String pathName = pack.replaceAll("\\.","/");

        URI uri = null;
        try {
            uri = Scan.class.getClassLoader().getResource(pathName).toURI();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        List<Class> arrs = new ArrayList();

        File file = new File(uri.getPath());
        File[] list = file.listFiles();
        for (File str: list) {
            if (str.isDirectory()){
                print(pack+"/"+str.getName());
            }else{
                /*String path = str.toString().replace("\\",".");
                String className = str.getName().substring(0,str.getName().length()-5);*/

                String name = pack.replaceAll("/",".")+"."+str.getName().split("\\.")[0];
                try {
                    arrs.add(Class.forName(name));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }

        return arrs;
    }


}
