package Ann;

import org.junit.Test;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.util.*;

/**
 * 作者：ZLRWJSAN
 * 创建于 2019/6/18 15:41
 */
public class ScanService {

    @Test
    public void demo5() throws IOException, ClassNotFoundException {
        String path = "com.ps.dorm";
        // 将路径转为/
        path = path.replace(".","/");

        // 通过当前线程获得类上下文加载器，通过它获得包的url
        Enumeration<URL> resources = Thread.currentThread().getContextClassLoader().getResources(path);

        // 通过 Enumeration<URL> 获得物理地址, 将物理地址通过 io 解析，获得包下的 class 集合
        getSett(resources.nextElement().getPath());
        /*Set<Class> scan = ClassScaner.scan("com.ps.dorm");
        for (Class set:scan){
            Annotation[] annotations = set.getAnnotations();
            for(Annotation an:annotations){
                if(an instanceof Service){
                    System.out.println(set);
                }
            }
        }*/
    }
    public List getSett(String path) throws ClassNotFoundException {
        List list = new ArrayList();
        File file = new File(path);
        File[] files = file.listFiles();
        for (File file1:files){
            if(file1.isDirectory()){
                list.addAll(getSett(file1.getPath()));
            }else{
                if(file1.isFile() && file1.getName().matches(".*[.]class")){
                    String path1 = file1.getPath();
                    String classes = path1.substring(path1.indexOf("classes") + 8, path1.length());
                    String[] split = classes.split("\\.");
                    String replace = split[0].replace("\\", ".");
                    Class<?> aClass = Class.forName(replace);
                    Annotation[] annotations = aClass.getAnnotations();
                    for( Annotation an:annotations){
                        if(an instanceof Service){
                            System.out.println(aClass);
                        }
                    }
                }
            }
        }
        return list;
    }
}