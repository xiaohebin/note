
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AesECBUtils {
 public static final String DEFAULT_CODING = "utf-8"; 
 /** 
  * 加密 
  * @author lmiky 
  * @date 2014-2-25 
  * @param content 
  * @param key 
  * @return 
  * @throws Exception 
  */ 
 public static String encrypt(String content, String key) throws Exception { 
  byte[] input = content.getBytes(DEFAULT_CODING); 
   
  MessageDigest md = MessageDigest.getInstance("MD5"); 
  byte[] thedigest = md.digest(key.getBytes(DEFAULT_CODING)); 
  SecretKeySpec skc = new SecretKeySpec(thedigest, "AES"); 
  Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding"); 
  cipher.init(Cipher.ENCRYPT_MODE, skc); 
   
  byte[] cipherText = new byte[cipher.getOutputSize(input.length)]; 
  int ctLength = cipher.update(input, 0, input.length, cipherText, 0); 
  ctLength += cipher.doFinal(cipherText, ctLength); 
    
  return parseByte2HexStr(cipherText); 
 } 
  /** 
  * 解密 
  * @author  
  * @date 2014-2-25 
  * @param encrypted 
  * @param seed 
  * @return 
  * @throws Exception 
  */ 
 private static String decrypt(String encrypted, String seed) throws Exception { 
    byte[] keyb = seed.getBytes(DEFAULT_CODING); 
    MessageDigest md = MessageDigest.getInstance("MD5"); 
    byte[] thedigest = md.digest(keyb); 
    SecretKeySpec skey = new SecretKeySpec(thedigest, "AES"); 
    Cipher dcipher = Cipher.getInstance("AES"); 
    dcipher.init(Cipher.DECRYPT_MODE, skey); 
   
    byte[] clearbyte = dcipher.doFinal(toByte(encrypted)); 
    return new String(clearbyte); 
   } 
 /** 
  * 字符串转字节数组 
  * @author lmiky 
  * @date 2014-2-25 
  * @param hexString 
  * @return 
  */ 
 private static byte[] toByte(String hexString) { 
  int len = hexString.length() / 2; 
  byte[] result = new byte[len]; 
  for (int i = 0; i < len; i++) { 
   result[i] = Integer.valueOf(hexString.substring(2 * i, 2 * i + 2), 16).byteValue(); 
  } 
  return result; 
 } 
  
 /** 
  * 字节转16进制数组 
  * @author lmiky 
  * @date 2014-2-25 
  * @param buf 
  * @return 
  */ 
 private static String parseByte2HexStr(byte buf[]) { 
  StringBuffer sb = new StringBuffer(); 
  for (int i = 0; i < buf.length; i++) { 
   String hex = Integer.toHexString(buf[i] & 0xFF); 
   if (hex.length() == 1) { 
    hex = '0' + hex; 
   } 
   sb.append(hex); 
  } 
  return sb.toString(); 
 } 
  
 public static void main(String[] args) throws Exception { 
    String content = "{" +
    "    \"name\": \"杨 X\"," +
    "    \"idcardType\": \"IDENTITY_CARD\"," +
    "    \"idcardNo\": \"330723198307285772\"," +
    "    \"cityNo\": \"330990\"," +
    "    \"phone\": \"13800138000\"," +
    "    \"source\": \"alipay\"," +
    "    \"operType\": \"CREATE\"," +
    "    \"currentLocation\": \"广东省,珠海市,香洲区,人民路 100 号\"," +
    "    \"realAddress\": {" +
    "        \"latitude\": \"113.298775\"," +
    "        \"longitude\": \"22.208647\"," +
    "        \"country\": \"中国\"," +
    "        \"countryCode\": \"234\"," +
    "        \"province\": \"四川省\"," +
    "        \"city\": \"成都市\"," +
    "        \"cityAdcode\": \"33034\"," +
    "        \"district\": \"武侯区\"," +
    "        \"districtAdcode\": \"67888\"" +
    "    }," +
    "    \"hasBeanTo\": [" +
    "        [" +
    "            \"河北省,?家庄市,桥?区\"," +
    "            \"XX1?区\"" +
    "        ]," +
    "        [" +
    "            \"河北省,?家庄市,桥?区\"" +
    "        ]" +
    "    ]," +
    "    \"healty\": {" +
    "        \"allInCity\": 0," +
    "        \"isLeaveCity\": 1," +
    "        \"isContactSuspected\": 0," +
    "        \"currentHealth\": [" +
    "            {" +
    "                \"key\": \"fever\"" +
    "            }," +
    "            {" +
    "                \"key\": \"stuffynose\"" +
    "            }" +
    "        ]" +
    "    }," +
    "    \"hasHBLevelGreen\": \"0\"," +
    "    \"agentIdcardType\": \"IDENTITY_CARD\"," +
    "    \"agentIdcardNo\": \"511621199007214000\"" +
    "}    ";
  System.out.println(AesECBUtils.encrypt(content, "abcdefghijklmnopqrstuvwxyz123456")); 
  //System.out.println(AesECB.decrypt("c830bbecb3f1de2cb685cc97ee01fc3a", "abcdefghijklmnopqrstuvwxyz123456")); 
 }
}