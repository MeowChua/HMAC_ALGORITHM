package com.company;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Enumeration;
import java.util.SortedSet;
import java.util.TreeSet;

public class Sha {
    static public final String SEPARATOR = "+" ;
    public static String encode(String src) {
        try {
            MessageDigest md;
            md = MessageDigest.getInstance( "SHA-1" );
            byte bytes[] = src.getBytes( "UTF-8" );
            md.update(bytes, 0, bytes. length );
            byte[] sha1hash = md.digest();
            return convertToHex(sha1hash);
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
    }
    private static String convertToHex(byte[] sha1hash) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < sha1hash. length ; i++) {
            byte c = sha1hash[i];
            addHex(builder, (c >> 4) & 0xf);
            addHex(builder, c & 0xf);
        }
        return builder.toString();
    }
    private static void addHex(StringBuilder builder, int c) {
        if (c < 10)
            builder.append((char) (c + '0' ));
        else
            builder.append((char) (c + 'a' - 10));
    }
    /*
    public ActionForward performCheck(ActionMapping actionMapping, Basivoirorm form,
                                      HttpServletRequest request, HttpServletResponse response){
        SortedSet<String> vadsFields = new TreeSet<String>();
        Enumeration<String> paramNames = request.getParameterNames();
        // retrieve and sort the fields starting with vads_* alphabetically
        while (paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement();
            if (paramName.startsWith( "vads_" )) {
                vadsFields.add(paramName);
            }
        }
// Compute the signature
        String sep = Sha.SEPARATOR;
        StringBuilder sb = new StringBuilder();
        for (String vadsParamName : vadsFields) {
            String vadsParamValue = request.getParameter(vadsParamName);
            if (vadsParamValue != null) {
                sb.append(vadsParamValue);
            }
            sb.append(sep);
        }
        sb.append( shaKey );
        String c_sign = Sha.encode(sb.toString());
        return c_sign;}

     */
}
