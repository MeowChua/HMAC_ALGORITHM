package com.company;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256
{


    public String SHA256 (final String strText)
    {
        return SHA (strText, "SHA-256");
    }


    public String SHA512 (final String strText)
    {
        return SHA (strText, "SHA-512");
    }


    private String SHA (final String strText, final String strType)
    {
        // return value
        String strResult = null;

        // Is it a valid string
        if (strText != null && strText.length() > 0)
        {
            try
            {
                // SHA encryption starts
                // Create an encryption object and pass in the encryption type
                MessageDigest messageDigest = MessageDigest.getInstance (strType);
                // Pass in the string to be encrypted
                messageDigest.update (strText.getBytes ());
                // get byte type result
                byte byteBuffer [] = messageDigest.digest ();

                // convert byte to string
                StringBuffer strHexString = new StringBuffer ();
                // traverse byte buffer
                for (int i = 0; i <byteBuffer.length; i ++)
                {
                    String hex = Integer.toHexString (0xff & byteBuffer [i]);
                    if (hex.length () == 1)
                    {
                        strHexString.append ('0');
                    }
                    strHexString.append (hex);
                }
                // get the result
                strResult = strHexString.toString ();
            }
            catch (NoSuchAlgorithmException e)
            {
                e.printStackTrace ();
            }
        }

        return strResult;
    }

    public static void main (String args []) {
        SHA256 ey = new SHA256 ();
        System.out.println (ey.SHA ("ILoveYou", "MD5")); // 62accaf23ac9a73c0b28765b7dfaf75a
    }
}

