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
 * 再帰で処理。
 * 最終文字まで探索が終わった場合、入力文字列を返す
 * 差の絶対値が1であった場合、連続した2文字を除いた文字列で再帰処理
 * 
 * 簡単だった。
 */
public class B_rank_20170217 {
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        
        for (; cin.hasNext(); ) {
            System.out.println(stringModify(cin.nextLine(), 0));
        }
    }
    
    static String stringModify(String line, Integer i) {
        Integer m, n;
        
        m = Integer.parseInt(line.substring(i, i+1));
        n = Integer.parseInt(line.substring(i+1, i+2));
        
        if (Math.abs(m-n) == 1) {
            return stringModify(line.substring(0, i) + line.substring(i+2), 0);
        }
        else {
            return i == line.length()-2 ? line : stringModify(line, i+1);
        }
    }
}
