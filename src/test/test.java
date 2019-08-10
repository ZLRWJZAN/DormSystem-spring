import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

/**
 * 作者：ZLRWJSAN
 * 创建于 2019/6/14 15:26
 */
public class test {

    /**
     * 5 获得一个路径下的全部class
     */
    @Test
    public void demo5() throws IOException, ClassNotFoundException {
        String path = "com.ps";

        // 将路径转为/
        path = path.replace(".","/");

        // 通过当前线程获得类上下文加载器，通过它获得包的url
        Enumeration<URL> resources = Thread.currentThread().getContextClassLoader().getResources(path);
        // 通过 Enumeration<URL> 获得物理地址, 将物理地址通过 io 解析，获得包下的 class 集合
        System.out.println(getSet(resources.nextElement().getPath()));

    }

    private Set<Class<?>> getSet(String path) throws IOException, ClassNotFoundException {
        Set<Class<?>> set = new HashSet<>();
        File file = new File(path);
        File[] files = file.listFiles();
        for (File file1 : files) {
            if(file1.isDirectory()){
                set.addAll(getSet(file1.getPath()));
            }else if(file1.isFile() && file1.getName().matches(".*[.]class")){
                // 获得从target后的路径，且变成.路径
                String path1 = file1.getPath();
                System.out.println(path1+"    1");
                path1 = path1.substring(path1.indexOf("classes")+8,path1.length());
                System.out.println(path1+"    2");
                path1 = path1.replace("\\",".");
                System.out.println(path1+"    3");
                path1 = path1.substring(0,path1.length()-6);
                System.out.println(path1+"    4");

                set.add(Class.forName(path1));
            }
        }
        return set;
    }
}
