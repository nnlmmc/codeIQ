/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 *
 * @author nishioka
 */

/*
 * 入力は、「a b c x y」の空白区切り文字列
 * x yは1x1のマス目の左下隅の座標である。2点のxを代入したときのyの値を評価すればよいのではないか。
 * 頂点がマス目を通過するか否かの判定を追加。
 * 
 * 特定パターンでエラーとなるが、理由が全くわからないため凍結。
 */
public class Relation_Graph_20170130 {
    public static void main (String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        String[] inList = new String[4];
        Integer a, b, c;
        Integer x, y;
        Integer z1, z2, z;
        Double z3;
        String r;
        
        for (; cin.hasNext(); ) {
            inList = cin.nextLine().split(" ");
            a = Integer.parseInt(inList[0]);
            b = Integer.parseInt(inList[1]);
            c = Integer.parseInt(inList[2]);
            x = Integer.parseInt(inList[3]);
            y = Integer.parseInt(inList[4]);
            
            z1 = a * (int)Math.pow(x, 2) + b * x + c;
            z2 = a * (int)Math.pow(x + 1, 2) + b * (x + 1) + c;
            z3 = a * Math.pow(x + 0.5, 2) + b * (x + 0.5) + c;
            
            System.out.println("z1: " + z1 + ", z2: " + z2 + ", z3: " + z3);
            
            if (z2 > z1) {
                z = z1;
                z1 = z2;
                z2 = z;
            }

            if (z1 > y + 1) {
                if (z2 < y + 1) r = "S";
                else if (z2 == y + 1) r = "l";
                else {
                    if (z3 == (double)y+1) r = "l";
                    else if (z3 < (double)y+1) r = "S";
                    else r = "L";
                }
            }
            else if (z1 == y + 1) {
                if (z2 > y + 1) r = "l";
                else {
                    if (z3 > (double)y+1) r = "l";
                    else r = "S";
                }
            }
            else if (z1 == y) {
                if (z2 > y) r = "S";
                else {
                    if (z3 < (double)y) r = "u";
                    else r = "S";
                }
            }
            else if (z1 < y) {
                if (z2 > y) r = "S";
                else if (z2 == y) r = "u";
                else {
                    if (z3 == (double)y) r = "u";
                    else if (z3 > (double)y) r = "S";
                    else r = "U";
                }
            }
            else {
                if (z3 == (double)y+1.0 && a > 0) r = "l";
                else if (z3 == (double)y && a < 0) r = "u";
                else r = "S";
            }
            
            System.out.println(r);
        }
    }
}
