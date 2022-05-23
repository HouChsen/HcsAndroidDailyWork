package com.he.week12;

import android.widget.Button;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * Created by 86186 on 2022/5/16.
 */

public class GetPostUtil {
    public static String sendGet(String url,String params){
        String result="";
        BufferedReader in=null;
        try{
            String urlName=url+"?"+params;
            URL realUrl=new URL(urlName);
            URLConnection conn=realUrl.openConnection();
            conn.setRequestProperty("accept","*/*");
            conn.setRequestProperty("connection","Keep_Alive");
            conn.setRequestProperty("user-agent","Mozilla/4.0(compatible;MSIE 6.0;Windows NT 5.1;SV1");
            conn.connect();
            Map<String,List<String>>map =conn.getHeaderFields();
            for(String key:map.keySet()){
                System.out.println(key+"->"+map.get(key));
            }
            in=new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while((line=in.readLine())!=null){

                result+="\n"+line;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                if(in!=null){
                    in.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return  result;
    }
    public static String sendPost(String url,String params){
        PrintWriter out=null;
        BufferedReader in=null;
        String result="";
        try{
            URL realUrl=new URL(url);
            URLConnection conn=realUrl.openConnection();
            conn.setRequestProperty("accept","*/*");
            conn.setRequestProperty("connection","Keep_Alive");
            conn.setRequestProperty("user-agent","Mozilla/4.0(compatible;MSIE 6.0;Windows NT 5.1;SV1");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            out=new PrintWriter(conn.getOutputStream());
            out.print(params);
            out.flush();
            in=new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while((line=in.readLine())!=null){
                result+="\n"+line;
            }
        }catch (Exception e){
            System.out.println("发送POST出现异常"+e);
            e.printStackTrace();
        }
        finally {
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return result;
    }
}
