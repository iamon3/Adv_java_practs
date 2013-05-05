package com.patternMatching;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class RegexTest {

        public static void main(String[] args){
           String msg = "id1:[label1:label2]:id2:[label1:label2:label3]:id3:[label1:label2:label3:label4]";
           Pattern pattern = Pattern.compile("id");
            HashMap<String,String> kv = new HashMap<String,String>();
            Matcher m = pattern.matcher(msg);

            int prev = -1;
            int next = -1;
            int start = -1;
            int end = -1;

            String subMsg = "";
            while (m.find()){
                if(prev == -1){
                    prev = m.end();
                }
                else
                {
                    next = m.end();
                    start = prev;
                    end =   next;
                    subMsg = msg.substring(start,end);
                    kv.put(String.valueOf(subMsg.charAt(0)),subMsg.substring(subMsg.indexOf("["),subMsg.lastIndexOf("]")+1));
                    prev = next;
                }
            }
            subMsg = msg.substring(next);
            kv.put(String.valueOf(subMsg.charAt(0)),subMsg.substring(subMsg.indexOf("["),subMsg.lastIndexOf("]")+1));

            System.out.println(kv);
        }
}
