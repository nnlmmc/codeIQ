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
 * 正解は、小さい順にソートし、0番目が0なら1番目をそれ以外ならば末尾を出力
 */
public class C_rank_20170127 {
    public static void main (String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        String cards;
        Integer r;
        
        for (; cin.hasNext();) {
            cards = cin.nextLine();
            if (cards.contains("0")) {
                r = cards.substring(0,1).equals("0") ? 9 : Integer.parseInt(cards.substring(0,1));
                for (int i = 1; i < 4; i++) {
                    if (r > Integer.parseInt(cards.substring(i, i+1)) && !cards.substring(i, i+1).equals("0")) {
                        r = Integer.parseInt(cards.substring(i, i+1));
                    }
                }
            }
            else {
                r = 0;
                for (int i = 0; i < 4; i++) {
                    if (r < Integer.parseInt(cards.substring(i, i+1))) {
                        r = Integer.parseInt(cards.substring(i, i+1));
                    }
                }
            }
            System.out.println(r);
        }
    }
}
