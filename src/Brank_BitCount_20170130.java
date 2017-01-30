
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nishioka
 */
public class Brank_BitCount_20170130 {
    public static void main (String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        String line;
        Integer inMax, inCount;
        String maxBin, bin1;
        Integer ans;
        Integer cnt1=0, p=1, r=1;
        
        line = cin.nextLine();
        inMax = Integer.parseInt(line.split(" ")[0]);
        inCount = Integer.parseInt(line.split(" ")[1]);
        maxBin = Integer.toBinaryString(inMax);
        
        ans = PatternCount(maxBin.substring(1, maxBin.length()), inCount);
        cnt1++;
        
        for (int i=1; i<maxBin.length(); i++) {
            if (maxBin.substring(i, i+1).equals("1")) {
                cnt1++;
                ans = ans + PatternCount(maxBin.substring(i+1, maxBin.length()), inCount-1);
            }
        }
        
        for (int i=0; i<cnt1; i++) {
            p *= (cnt1-i);
            r *= (cnt1-i);
        }
        ans += p/r;
        
        System.out.println(ans);
    }
    
    static Integer PatternCount(String strBin, Integer cnt) {
        Integer p=1, r=1;
        
        for (int i=0; i<cnt; i++) {
            p *= (strBin.length()-i);
            r *= (cnt-i);
        }
        
        if (cnt == 0) return 1;
        else return p / r;
    }
}
