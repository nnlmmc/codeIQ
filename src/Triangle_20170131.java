/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import java.math.*;
/**
 *
 * @author nishioka
 */
public class Triangle_20170131 {
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        Long lngN;
        BigInteger res = new BigInteger("1");
        
        lngN = cin.nextLong();
        
        for (long i=0L; i<lngN; i++) {
            res = res.multiply(BigInteger.valueOf(lngN).subtract(BigInteger.valueOf(i)));
        }
        
        System.out.println(res.add(BigInteger.valueOf(1L)));
    }
}
