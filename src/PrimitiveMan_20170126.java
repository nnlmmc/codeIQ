/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;

/**
 *
 * @author nishioka
 */
public class PrimitiveMan_20170126 {
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        String strBin = cin.nextLine();
        Integer intChar;
        byte byChar;
        byte[] byAsc;
        String r, strR="";
        Integer bIn = 0, eIn = 8;
        
        while (eIn <= strBin.length()) {
            intChar = Integer.parseInt(strBin.substring(bIn, eIn), 2);
            if (eIn != strBin.length()) {
                byChar = intChar.byteValue();
                byAsc = new byte[]{byChar};
                r = new String(byAsc);
                strR = strR + r;
            }
            else {
                if (intChar != 10) {
                    byChar = intChar.byteValue();
                    byAsc = new byte[]{byChar};
                    r = new String(byAsc);
                    strR = strR + r;
                }
            }
            bIn = eIn;
            eIn = eIn + 8;
        }
        
        System.out.println(strR);
    }   
}
