/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;

/**
 *
 * @author nishioka
 */
public class C_rank_2016 {
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        
        List<Integer> addend = new ArrayList<Integer>();
        addend.add(Integer.parseInt(cin.nextLine()));
        String line2;
        line2 = cin.nextLine();
        
        String[] addend2 = line2.split(" ");
        for (String a: addend2) {
            addend.add(Integer.parseInt(a));
        }
        
        String r = "no";
        Integer i = 1;
        
        for (Integer a: addend) {
            for (int j = i; j < addend.size(); j++) {
                if ((a + addend.get(j)) == 256) {
                    r = "yes";
                    break;
                }
            }
            i++;
        }
        
        System.out.println(r);
    }
}
