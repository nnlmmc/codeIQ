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
 * アルゴリズム（2017/01/30）考えるのに疲れたのとソースの修正がめんどくさくなったため、まとめておく。
 * 
 * 折る方向と折られる面が表か裏かを判断できれば解決できる。
 * 縦方向、横方向にそれぞれ折られていない場合と折られている場合で条件が異なる。
 * 　折られている場合、上辺と下辺または右辺と左辺を含む面が表裏交互に連続する。
 * 　折られていない場合、上辺の最後と下辺の最初または右辺の最後と左辺の最初が同じ面。
 * 一度以上、折られている場合、辺の重なりが上下または左右のどちらにあるかを判定できれば
 * 各点が追加される辺の面の向きがわかる。折り目は面の向きに依存し、折る方向に依存しない。
 * 追加される点は、水平の辺は奇数番目、垂直の辺は偶数番目になる。但し、折る方向と
 * 交わる方向に折られていない場合、下辺または右辺の開始番号が奇数または偶数と異なる。
 * 点jが追加された点かどうかを判定し、追加点であれば面の向きからm、vを判定、
 * 追加された点でなければ、前回の結果から代入を行う。
 */
public class LRTB_20160127 {
    public static void main (String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        Integer k;
        String ord;
        char[] ans = new char[0];
        Integer hPoint=0, vPoint=0;
        Integer hCnt=0, vCnt=0;
        Boolean hPos=false, vPos=false;
        Boolean hfSts=true, vfSts=true;
        
        for (; cin.hasNext(); ) {
            ord = cin.nextLine();
            for (int i = 0; i<ord.length(); i++) {
                char[] bup = (char[])ans.clone();
                k = 0;
                // 横方向におられる場合
                if (ord.substring(i, i+1).equals("L") || ord.substring(i, i+1).equals("R")) {
                    ans = new char[hPoint+(int)Math.pow(2, hCnt+1)+vPoint];
                    if (vCnt == 0 && hCnt == 0) {
                        hfSts = false;
                    }
                    else {
                        hfSts = true;
                    }
                    for (int j=0; j<ans.length; j++) {
                        // 上辺、下辺（縦方向に一回以上おられている場合）
                        if ((j < (hPoint+(int)Math.pow(2,hCnt+1))/2 || (j >= (hPoint+(int)Math.pow(2,hCnt+1)+vPoint)/2 && j < hPoint+(int)Math.pow(2,hCnt+1)+vPoint/2) && vCnt != 0)) {
                            switch (j % 2) {
                                case 0:
                                    if (hfSts) ans[j] = 'v';
                                    else ans[j] = 'm';
                                    hfSts = !hfSts;
                                    break;
                                case 1:
                                    ans[j] = bup[k];
                                    k++;
                                    break;
                            }
                        }
                        // 下辺（縦方向におられていない場合）
                        else if ((j < (hPoint+(int)Math.pow(2,hCnt+1))/2 || j >= (hPoint+(int)Math.pow(2,hCnt+1)+vPoint)/2 && j < hPoint+(int)Math.pow(2,hCnt+1)+vPoint/2) && vCnt == 0) {
                            hfSts = hPos;
                            switch(j % 2) {
                                case 0:
                                    ans[j] = bup[k];
                                    k++;
                                    break;
                                case 1:
                                    if (hfSts) ans[j] = 'm';
                                    else ans[j] = 'v';
                                    break;
                            }
                        }
                        // 左右辺の場合
                        else {
                            ans[j] = bup[k];
                            k++;
                        }
                    }
                    hCnt++;
                    if (ord.substring(i, i+1).equals("L")) hPos = true;
                    else hPos = false;
                    hPoint = (int)Math.pow(2, hCnt);
                }
                // 縦方向におられる場合
                else {
                    ans = new char[vPoint+(int)Math.pow(2, vCnt+1)+hPoint-1];
                    for (int j=0; j<ans.length; j++) {
                        // 右辺の場合（奇数番目の点に変化はないため、引継）
                        if (hCnt != 0 || (j >= hPoint/2 && j < (hPoint+(int)Math.pow(2,vCnt+1))/2)) {
                            switch (j % 2) {
                                case 0:
                                    ans[j] = bup[k];
                                    k++;
                                    break;
                                case 1:
                                    if (hPos) ans[j] = 'm';
                                    else ans[j] = 'v';
                                    break;
                            }
                        }
                        // 左辺の場合（奇数番目の点に変化はないため、引継）
                        else if (hCnt == 0 || j >= hPoint+((int)Math.pow(2,hCnt+1)+vPoint)/2) {
                            switch(j % 2) {
                                case 0:
                                    ans[j] = bup[k];
                                    k++;
                                    break;
                                case 1:
                                    if (hPos) ans[j] = 'v';
                                    else ans[j] = 'm';
                                    break;
                            }
                        }
                        // 左右編の場合
                        else {
                            ans[j] = bup[k];
                            k++;
                        }
                    }
                    vCnt++;
                    vPoint = (int)Math.pow(2, hCnt);
                }
            }
            String r = String.valueOf(ans);
            System.out.println(r);
        }
    }
}
