package cn.tongyouhui.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;

public class MD5Util {
	public static String md5(String str) throws NoSuchAlgorithmException{
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] input = str.getBytes();
		String output = Base64.encodeBase64String(md.digest(input));
		return output;
	}
}
