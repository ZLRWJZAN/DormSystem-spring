import com.ps.dorm.Utils.AESUtil;

import java.security.NoSuchAlgorithmException;

/**
 * 作者：ZLRWJSAN
 * 创建于 2019/6/15 10:25
 */
//秘钥： ATeO5tFpp03P8p6s8f/m9g==
  //      密文： S70qMBIGqqoM+1cItg/7OA==
public class aes {
    public static void main(String[] args) throws Exception {
        System.out.println(System.currentTimeMillis());
        String s = "aAlzW+Jhx6f6u8Ln7PFyiQ==";
        String a="WbBEIUlisMhIYTLgW6e46w==";
        //String encode = AESUtil.encode(a, s);

        String decode = AESUtil.decode(s, a);
        System.out.println(decode);
    }
}
