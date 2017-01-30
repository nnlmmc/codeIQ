/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 *
 * @author nishioka
 */
public class DeruKui_20160127 {
    public static void main (String[] args) {
        Scanner cin = new Scanner(System.in);
        String line;
        Integer mid;
        String res;
        
        for (; cin.hasNext(); ) {
            line = cin.nextLine();
            mid = Math.round(line.length() / 2 + 0.5f);
            res = line.substring(0, mid-1) + line.substring(mid-1, mid).toUpperCase() + line.substring(mid, line.length());
            System.out.println(res);
        }
    }
}
