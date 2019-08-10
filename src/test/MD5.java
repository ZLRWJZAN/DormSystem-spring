import com.ps.dorm.Utils.MD5Util;

/**
 * 作者：ZLRWJSAN
 * 创建于 2019/6/15 10:02
 */
public class MD5 {
    public static void main(String[] args) {
        String a="今晚不上课";
        String s = MD5Util.getMd5Code(a);
        System.out.println(s);
        System.out.println("dedcd7508a12354afbcbf55bee7eec9f".equals(s));
        if(s.equals("dedcd7508a12354afbcbf55bee7eec9f")){
            System.out.println("aaaaaaaaaaaaaaaaaa");
        }else {
            System.out.println("11111111111111111111");
        }
    }
}
