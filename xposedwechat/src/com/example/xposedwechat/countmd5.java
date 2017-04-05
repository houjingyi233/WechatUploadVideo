package com.example.xposedwechat;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class countmd5
{
	public static final String a(InputStream inputStream, int i) throws NoSuchAlgorithmException, IOException 
	{
		String str = null;
		if (inputStream != null && i > 0) 
		{
			MessageDigest instance = MessageDigest.getInstance("MD5");
			StringBuilder stringBuilder = new StringBuilder(32);
			byte[] bArr = new byte[i];
			while (true)
			{
				int read = inputStream.read(bArr);
				if (read == -1) 
				{
					break;
				}
				instance.update(bArr, 0, read);
			}
	        byte[] digest = instance.digest();
	        for (byte b : digest)
	        {
	        	stringBuilder.append(Integer.toString((b & 0xFF) + 256, 16).substring(1));
	        }
	        str = stringBuilder.toString();
		} 
	    return str;
	}

    public static String g(File file) throws IOException, NoSuchAlgorithmException
    {
    	FileInputStream fileInputStream=new FileInputStream(file);
        long j = 102400;
        if (file == null || !file.exists()) 
        {
            return null;
        }
        if (102400 > file.length()) 
        {
        	j = file.length();
        }
        String a = a(fileInputStream, (int) j);
        fileInputStream.close();
        return a;     
    }
}
