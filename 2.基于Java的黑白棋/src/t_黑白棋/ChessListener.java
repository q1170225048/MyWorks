package t_黑白棋;


import java.awt.Graphics;  
import java.awt.event.MouseAdapter;  
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JLabel;  
import javax.swing.JOptionPane;  
      
public class ChessListener extends MouseAdapter{  
    private Graphics g;        //将画布对象传过来  
    private int xiafa;         //记录当前棋子的下法  
    public  static int stata=1;//判断下黑棋还是白棋（黑棋阿狸，白棋桃子）  
    private int x1,y1;         //记录点击处的横坐标和纵坐标  
    private JLabel jilu;       //当前下棋子的人  
    private JLabel baizila;      //阿狸棋子数  
    private JLabel heizila;    //桃子棋子数  
    private Heibai ch;          //用来刷新棋盘  
    private int   te=0;        //特殊情况  
    private int   change;      //记录改变的棋子数目  
    String d="";
    public ChessListener(Graphics g,Heibai ch,JLabel jilu,JLabel baizila,JLabel heizila){  
        this.g=g;  
        this.ch=ch;  
        this.jilu=jilu;  
        this.baizila=baizila;  
        this.heizila=heizila;  
    }  
          
    //点击下棋子  
    public void mouseClicked(MouseEvent e){  
        int a=1;            //记录所下的子  
        String s = null;  
        String text=null;
        
        String c="";
        FileOutputStream output = null;
        try {
			output = new FileOutputStream("D://ddd.txt");
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
        x1=e.getX();  
        y1=e.getY();  
        for(int i=0;i<Heibai.rows-1;i++){  
            for(int j=0;j<Heibai.cols-1;j++){  
                int x2=Heibai.x+Heibai.size/2+Heibai.size*i;//得到棋盘中棋子所在点的横坐标  
                int y2=Heibai.y+Heibai.size/2+Heibai.size*j;//得到棋盘中棋子所在点的纵坐标  
                //将棋子下在棋盘格子的正中央  
                if(Math.abs(x1-x2)<Heibai.size/3&&Math.abs(y1-y2)<Heibai.size/3){  
                    if(Heibai.chess[i][j]==0){  
                        if(stata==1){  
                            //Image b=new ImageIcon("image/ali.jpg").getImage();  
                            //g.drawImage(b, x2-Chess.Chess_size/2, y2-Chess.Chess_size/2, Chess.Chess_size, Chess.Chess_size, null);  
                            //g.setColor(Color.BLACK);  
                            stata=2;  
                        }  
                        else if(stata==2){  
                            //Image w=new ImageIcon("image/ali.jpg").getImage();  
                            //g.drawImage(w, x2-Chess.Chess_size/2, y2-Chess.Chess_size/2, Chess.Chess_size, Chess.Chess_size, null);  
                            //g.setColor(Color.WHITE);  
                            stata=1;  
                        }  
                        Heibai.chess[i][j]=3-stata;//将棋子存入棋盘  
                        //g.fillOval(x2-Chess.size/2, y2-Chess.size/2, Chess.Chess_size, Chess.Chess_size);  
                        //--------------如果8个方向都不能改变棋子则不改变棋盘状态--------------  
                        if (hengYou(i, j) == null && hengZuo(i, j) == null
                                && hengShang(i, j) == null
                                && hengXia(i, j) == null
                                && xieyouS(i, j) == null
                                && xieyouX(i, j) == null
                                && xiezuoS(i, j) == null
                                && xiezuoX(i, j) == null){  
                        	Heibai.chess[i][j]=0;  
                            if(stata==1){  
                                stata=2;  
                            }  
                            else if(stata==2){  
                                stata=1;  
                            }  
                            //刷新棋盘  
                            ch.update(g);  
                            JOptionPane.showMessageDialog(null, "不能放子");  
                        }  
                        else{  
                            // 改变中间子颜色  
                        	
                        	 c =stata+" "+i+" "+j+"\r\n";
                        	 
                        	 d+=c;
							try {
								byte[] buff=new byte[]{};
								buff=d.getBytes();
								
								output.write(buff);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
                            
                            hengYou1(i, j);  
                            hengZuo1(i, j);  
                            hengShang1(i, j);  
                            hengXia1(i, j);  
                            xieyou1(i, j);  
                            xieyou2(i, j);  
                            xiezuo1(i, j);  
                            xiezuo2(i, j);  
                            // 以坐标为圆心画圆  
                            //g.fillOval(x2-Chess.size/2, y2-Chess.size/2, Chess.Chess_size, Chess.Chess_size);  
                            //g.setColor(Color.BLACK);  
                            ch.update(g);  
                            //改变棋子记录框里面的数字  
                            baizila.setText(judge()[0]+"");  
                            heizila.setText(judge()[1]+"");  
                            System.out.println("改变了"+change+"个子");  
                            change=0;  
                            //判断当前下棋的人  
                            if(stata==1){  
                                jilu.setText("  白子下  ");  
                                a=1;  
                                s="白子";  
                            }  
                            else if(stata==2){  
                                jilu.setText("  黑子下  ");  
                                a=2;  
                                s="黑子";  
                            }  
                            xiafa=Check(a);  
                            //输出当前下棋的人还有几种下法  
                            System.out.println(s+"有"+xiafa+"种下法");  
                            if(xiafa==0&&full()==false){//如果不能下子并且棋盘未满  
                                te++;  
                                JOptionPane.showMessageDialog(null, s+"不能下子，跳过!");  
                                if(stata==1){//如果阿狸不能下子则跳过，桃子下  
                                    stata=2;  
                                    jilu.setText("  黑子下  ");  
                                    a=2;  
                                    s="黑子";  
                                }  
                                else if(stata==2){//如果桃子不能下子则跳过，阿狸下  
                                    stata=1;  
                                    jilu.setText("  白子下  ");  
                                    a=1;  
                                    s="白子";  
                                }  
                                xiafa=Check(a);  
                                System.out.println(s+"有"+xiafa+"种下法");  
                                if(xiafa==0){  
                                    te++;//如果无子可下，则特殊情况记录加1  
                                }else 
                                    te=0;  
                            }  
                            //----------------胜负判断----------------  
                            if(judge()[0]==0){//如果白子没子了则黑子获胜  
                                JOptionPane.showMessageDialog(null,"游戏结束，黑子获胜");  
                            }  
                            else if(judge()[1]==0){//如果黑子没子了则白子获胜  
                                JOptionPane.showMessageDialog(null, "游戏结束，白子获胜");  
                            }  
                            if(full()){  
                                if(judge()[0]>judge()[1]){//如果白子的子较多，则白子获胜  
                                    JOptionPane.showMessageDialog(null, "游戏结束，白子获胜"); 
                                    text="白子获胜"+judge()[0]+":"+judge()[1];
                                    byte[] buff=new byte[]{};
                                    buff=text.getBytes();
                                    try {
										output.write(buff,0,buff.length);
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
                                }  
                                else if(judge()[0]<judge()[1]){//如果黑子的子较多，则黑子获胜  
                                    JOptionPane.showMessageDialog(null, "游戏结束，黑子获胜"); 
                                    text="黑子获胜"+judge()[1]+":"+judge()[0];
                                    byte[] buff=new byte[]{};
                                    buff=text.getBytes();
                                    try {
										output.write(buff,0,buff.length);
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
                                }  
                                else if(judge()[0]==judge()[1]){  
                                    JOptionPane.showMessageDialog(null, "平局");  
                                }  
                            }  
                        }  
                        return;  
                    }  
                }  
            }  
        }  
    }  
          
    /** 
     * 判断输赢的方法，如果黑棋多则黑棋获胜，否则白棋获胜 
     * @return 黑棋和白棋的数目 
     */
    public int[] judge(){  
        int count[]=new int[2];  
        for(int i=0;i<Heibai.rows-1;i++){  
            for(int j=0;j<Heibai.cols-1;j++){  
                if(Heibai.chess[i][j]==1){  
                    count[0]++;  
                }  
                else if(Heibai.chess[i][j]==2){  
                    count[1]++;  
                }  
            }  
        }  
        return count;  
    }  
          
    /** 
     * 判断棋盘是否已满的方法 
     */
    public boolean full(){  
        if(te==2){      //如果双方都不能下子，则游戏结束  
            return true;  
        }  
        else{  
            for(int i=0;i<Heibai.rows-1;i++){  
                for(int j=0;j<Heibai.cols-1;j++){  
                    //如果有一个地方是空的则返回false  
                    if(Heibai.chess[i][j]==0){  
                        return false;  
                    }  
                }  
            }  
        }  
        return true;  
    }  
          
    /** 
     *  判断当前棋子的下法还有多少种 
     *  @param return 返回下法的总数  
     */
    public int Check(int a){  
        int n=0;  
        for(int i=0;i<Heibai.chess.length;i++){  
            for(int j=0;j<Heibai.chess[i].length;j++){  
                if(Heibai.chess[i][j]!=0){  
                    continue;  
                }  
                else{  
                	Heibai.chess[i][j]=a;  
                    if(hengYou(i, j) != null || hengZuo(i, j) != null
                    || hengShang(i, j) != null || hengXia(i, j) != null
                    || xieyouS(i, j)   != null || xieyouX(i, j) != null
                    || xiezuoS(i, j)   != null || xiezuoX(i, j) != null)  
                    {  
                    	Heibai.chess[i][j]=0;  
                    n++;                //如果有一个地方可以下子，则n+1  
                    }  
                    else{  
                    	Heibai.chess[i][j]=0;  
                    }  
                }  
            }  
        }  
        return n;  
    }  
          
    /*********************************************** 检测相同颜色 *******************************/
    /** 
     * 改变两棋子之间的棋子的颜色——直线 
     */
    public void paintChess(int r1, int c1, int r2, int c2) {  
        // 横向  
        if (c1 == c2) {  
            for (int k = Math.min(r1, r2) + 1; k < Math.max(r1, r2); k++) {  
            	Heibai.chess[k][c1] = Heibai.chess[r1][c1];  
                change++;  
            }  
        }  
        // 纵向  
        if (r1 == r2) {  
            for (int k = Math.min(c1, c2) + 1; k < Math.max(c1, c2); k++) {  
            	Heibai.chess[r1][k] = Heibai.chess[r1][c1];  
                change++;  
            }  
        }  
    }  
          
    /** 
     * 改变两棋子之间的棋子的颜色——斜线——右上 
     */
    public void paintChess1(int r1, int c1, int r2, int c2) {  
        for (int k = Math.min(r1, r2) + 1, v = Math.max(c1, c2) - 1; k < Math  
                .max(r1, r2); k++, v--) {  
        	Heibai.chess[k][v] = Heibai.chess[r1][c1];  
            change++;  
        }  
    }  
          
    /** 
     * 改变两棋子之间的棋子的颜色——斜线——右下 
     */
    public void paintChess2(int r1, int c1, int r2, int c2) {  
        for (int k = Math.min(r1, r2) + 1, v = Math.min(c1, c2) + 1; k < Math  
                .max(r1, r2); k++, v++) {  
        	Heibai.chess[k][v] = Heibai.chess[r1][c1];  
            change++;  
        }  
    }  
          
    /** 
     * 改变两棋子之间的棋子的颜色——斜线——左上 
     */
    public void paintChess3(int r1, int c1, int r2, int c2) {  
        for (int k = Math.max(r1, r2) - 1, v = Math.max(c1, c2) - 1; k > Math  
                .min(r1, r2); k--, v--) {  
        	Heibai.chess[k][v] = Heibai.chess[r1][c1];  
            change++;  
        }  
    }  
      
    /** 
     * 改变两棋子之间的棋子的颜色——斜线——左下 
     */
    public void paintChess4(int r1, int c1, int r2, int c2) {  
        for (int k = Math.min(r1, r2) + 1, v = Math.max(c1, c2) - 1; k <= Math  
                .max(r1, r2); k++, v--) {  
        	Heibai.chess[k][v] = Heibai.chess[r1][c1];  
            change++;  
        }  
    }  
          
    /** 
     * 向右检测是否有相同颜色棋子，如果有且不相邻，改变中间棋子颜色，否则返回NULL 
     * @param x 
     * @param y 
     * @return 
     */
    public int[] hengYou(int x, int y) {  
        int r = -2;  
        int i;  
        // 向右  
        for (i = x + 1; i < Heibai.rows-1; i++) {  
            if (Heibai.chess[i][y] != 1 && Heibai.chess[i][y] != 2) {  
                break;  
            }  
            if (Heibai.chess[i][y] == Heibai.chess[x][y]) {  
                r = i;  
                break;  
            }  
        }  
        if (r != -2 && Heibai.chess[x + 1][y] != Heibai.chess[i][y]) {  
            return new int[] { r, y };  
        } else {  
            // System.out.println("向右不能");  
            return null;  
        }  
    }  
          
    /** 
     * 向左检测是否有相同颜色棋子，如果有且不相邻，改变中间棋子颜色，否则返回NULL 
     */
    public int[] hengZuo(int x, int y) {  
        int r = -2;  
        int i;  
        // 向左  
        for (i = x - 1; i >= 0; i--) {  
            if (Heibai.chess[i][y] != 1 && Heibai.chess[i][y] != 2) {  
                break;  
            }  
            if (Heibai.chess[i][y] == Heibai.chess[x][y]) {  
                r = i;  
                break;  
            }  
        }  
        if (r != -2 && Heibai.chess[x - 1][y] != Heibai.chess[i][y]) {  
      
            return new int[] { r, y };  
        } else {  
            // System.out.println("向左不能");  
            return null;  
        }  
    }  
      
    /** 
     * 向上检测是否有相同颜色棋子，如果有且不相邻，改变中间棋子颜色，否则返回NULL 
     */
    public int[] hengShang(int x, int y) {  
        int r = -2;  
        int i;  
        // 向上  
        for (i = y - 1; i >= 0; i--) {  
            if (Heibai.chess[x][i] == 0) {  
                break;  
            }  
            if (Heibai.chess[x][i] == Heibai.chess[x][y]) {  
                r = i;  
                break;  
            }  
        }  
        if (r != -2 &&Heibai.chess[x][y - 1] != Heibai.chess[x][i]) {  
      
            return new int[] { x, r };  
        } else {  
            // System.out.println("向上不能");  
            return null;  
        }  
    }  
      
    /** 
     * 向上检测是否有相同颜色棋子，如果有且不相邻，改变中间棋子颜色，否则返回NULL 
     */
    public int[] hengShang1(int x, int y) {  
        int r = -2;  
        int i;  
        // 向上  
        for (i = y - 1; i >= 0; i--) {  
            if (Heibai.chess[x][i] == 0) {  
                break;  
            }  
            if (Heibai.chess[x][i] == Heibai.chess[x][y]) {  
                r = i;  
                break;  
            }  
        }  
        if (r != -2 && Heibai.chess[x][y - 1] != Heibai.chess[x][i]) {  
            // 改变中间的子  
            paintChess(x, y, x, r);  
            return new int[] { x, r };  
        } else {  
            return null;  
        }  
    }  
      
    /** 
     * 向下检测是否有相同颜色棋子，如果有且不相邻，改变中间棋子颜色，否则返回NULL 
     */
    public int[] hengXia(int x, int y) {  
        int r = -2;  
        int i;  
        // 向下  
        for (i = y + 1; i < Heibai.rows-1; i++) {  
            if (Heibai.chess[x][i] == 0) {  
                break;  
            }  
            if (Heibai.chess[x][i] == Heibai.chess[x][y]) {  
                r = i;  
                break;  
            }  
        }  
      
        if (r != -2 &&Heibai.chess[x][y + 1] != Heibai.chess[x][i]) {  
            return new int[] { x, r };  
        } else {  
            // System.out.println("向下不能");  
            return null;  
        }  
    }  
      
    /** 
     * 向下检测是否有相同颜色棋子，如果有且不相邻，改变中间棋子颜色，否则返回NULL 
     */
    public int[] hengXia1(int x, int y) {  
        int r = -2;  
        int i;  
        // 向下  
        for (i = y + 1; i < Heibai.rows-1; i++) {  
            if (Heibai.chess[x][i] == 0) {  
                break;  
            }  
            if (Heibai.chess[x][i] == Heibai.chess[x][y]) {  
                r = i;  
                break;  
            }  
        }  
        if (r != -2 && Heibai.chess[x][y + 1] != Heibai.chess[x][i]) {  
            // 改变中间的子  
            paintChess(x, y, x, r);  
            return new int[] { x, r };  
        } else {  
            return null;  
        }  
    }  
      
    /** 
     * 斜右上方向 
     * @param x 
     * @param y 
     * @return 
     */
    public int[] xieyouS(int x, int y) {  
        // 向上  
        int r = -2, s = -2;  
        int i, j;  
        for (i = x + 1, j = y - 1; i < Heibai.rows-1 && j >= 0; i++, j--) {  
            if (Heibai.chess[i][j] == 0) {  
                break;  
            }  
            if (Heibai.chess[i][j] == Heibai.chess[x][y]) {  
                r = i;  
                s = j;  
                break;  
            }  
        }  
        if (r != -2 && s != -2
                && Heibai.chess[x + 1][y - 1] != Heibai.chess[i][j]) {  
            return new int[] { r, s };  
        } else {  
            // System.out.println("向右上不能");  
            return null;  
        }  
    }  
          
    /** 
     * 斜右下方向 
     *  
     * @param x 
     * @param y 
     * @return 
     */
    public int[] xieyouX(int x, int y) {  
        // 向下  
        int r = -2, s = -2;  
        int i, j;  
        for (i = x + 1, j = y + 1; i < Heibai.rows-1 && j < Heibai.cols-1; i++, j++) {  
            if (Heibai.chess[i][j] == 0) {  
                break;  
            }  
            if (Heibai.chess[i][j] == Heibai.chess[x][y]) {  
                r = i;  
                s = j;  
                break;  
            }  
        }  
        if (r != -2 && s != -2
                && Heibai.chess[x + 1][y + 1] != Heibai.chess[i][j]) {  
            return new int[] { r, s };  
        } else {  
            // System.out.println("向右下不能");  
            return null;  
        }  
    }  
      
    /** 
     * 斜左上方向 
     *  
     * @param x 
     * @param y 
     * @return 
     */
    public int[] xiezuoS(int x, int y) {  
        // 向上  
        int r = -2, s = -2;  
        int i, j;  
        for (i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {  
            if (Heibai.chess[i][j] == 0) {  
                break;  
            }  
            if (Heibai.chess[i][j] == Heibai.chess[x][y]) {  
                r = i;  
                s = j;  
                break;  
            }  
        }  
        if (r != -2 && s != -2
                && Heibai.chess[x - 1][y - 1] != Heibai.chess[i][j]) {  
            return new int[] { r, s };  
        } else {  
            return null;  
        }  
    }  
      
    /** 
     * 斜左下方向 
     * @param x 
     * @param y 
     * @return 
     */
    public int[] xiezuoX(int x, int y) {  
        // 向下  
        int r = -2, s = -2;  
        int i, j;  
        for (i = x - 1, j = y + 1; i >= 0 && j < Heibai.cols-1; i--, j++) {  
            if (Heibai.chess[i][j] == 0) {  
                break;  
            }  
            if (Heibai.chess[i][j] == Heibai.chess[x][y]) {  
                r = i;  
                s = j;  
                break;  
            }  
        }  
        if (r != -2 && s != -2
                && Heibai.chess[x - 1][y + 1] != Heibai.chess[i][j]) {  
            return new int[] { r, s };  
        } else {  
            return null;  
        }  
    }  
          
    /** 
     * 向右检测是否有相同颜色棋子，如果有且不相邻，改变中间棋子颜色，否则返回NULL 
     */
    public int[] hengYou1(int x, int y) {  
        int r = -2;  
        int i;  
        // 向右  
        for (i = x + 1; i < Heibai.cols-1; i++) {  
            if (Heibai.chess[i][y] != 1 && Heibai.chess[i][y] != 2) {  
                break;  
            }  
            if (Heibai.chess[i][y] == Heibai.chess[x][y]) {  
                r = i;  
                break;  
            }  
        }  
      
        if (r != -2 && Heibai.chess[x + 1][y] != Heibai.chess[i][y]) {  
            // 改变中间的子  
            paintChess(x, y, r, y);  
            return new int[] { r, y };  
        } else {  
            return null;  
        }  
    }  
      
    /** 
     * 向左检测是否有相同颜色棋子，如果有且不相邻，改变中间棋子颜色，否则返回NULL 
     */
    public int[] hengZuo1(int x, int y) {  
        int r = -2;  
        int i;  
        // 向左  
        for (i = x - 1; i >= 0; i--) {  
            if (Heibai.chess[i][y] != 1 && Heibai.chess[i][y] != 2) {  
                break;  
            }  
            if (Heibai.chess[i][y] == Heibai.chess[x][y]) {  
                r = i;  
                break;  
            }  
        }  
      
        if (r != -2 && Heibai.chess[x - 1][y] != Heibai.chess[i][y]) {  
            // 改变中间的子  
            paintChess(x, y, r, y);  
            return new int[] { r, y };  
        } else {  
            return null;  
        }  
    }  
      
    /** 
     * 斜右上方向  
     * @param x 
     * @param y 
     * @return 
     */
    public int[] xieyou1(int x, int y) {  
        // 向上  
        int r = -2, s = -2;  
        int i, j;  
        for (i = x + 1, j = y - 1; i < Heibai.rows-1 && j >= 0; i++, j--) {  
            if (Heibai.chess[i][j] == 0) {  
                break;  
            }  
            if (Heibai.chess[i][j] == Heibai.chess[x][y]) {  
                r = i;  
                s = j;  
                break;  
            }  
        }  
        if (r != -2 && s != -2
                && Heibai.chess[x + 1][y - 1] != Heibai.chess[i][j]) {  
            // 改变中间的子  
            paintChess1(x, y, i, j);  
            return new int[] { r, s };  
        } else {  
            return null;  
        }  
    }  
      
    /** 
     * 斜右下方向 
     *  
     * @param x 
     * @param y 
     * @return 
     */
    public int[] xieyou2(int x, int y) {  
        // 向下  
        int r = -2, s = -2;  
        int i, j;  
        for (i = x + 1, j = y + 1; i < Heibai.rows-1 && j < Heibai.cols-1; i++, j++) {  
            if (Heibai.chess[i][j] == 0) {  
                break;  
            }  
            if (Heibai.chess[i][j] == Heibai.chess[x][y]) {  
                r = i;  
                s = j;  
                break;  
            }  
        }  
        if (r != -2 && s != -2
                && Heibai.chess[x + 1][y + 1] != Heibai.chess[i][j]) {  
            // 改变中间的子  
            paintChess2(x, y, i, j);  
            return new int[] { r, s };  
        } else {  
            return null;  
        }  
    }  
      
    /** 
     * 斜左上方向 
     *  
     * @param x 
     * @param y 
     * @return 
     */
    public int[] xiezuo1(int x, int y) {  
        // 向上  
        int r = -2, s = -2;  
        int i, j;  
        for (i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {  
            if (Heibai.chess[i][j] == 0) {  
                break;  
            }  
            if (Heibai.chess[i][j] == Heibai.chess[x][y]) {  
                r = i;  
                s = j;  
                break;  
            }  
        }  
        if (r != -2 && s != -2
                && Heibai.chess[x - 1][y - 1] != Heibai.chess[i][j]) {  
            // 改变中间的子  
            paintChess3(x, y, i, j);  
            return new int[] { r, s };  
        } else {  
            return null;  
        }  
    }  
      
    /** 
     * 斜左下方向  
     * @param x 
     * @param y 
     * @return 
     */
    public int[] xiezuo2(int x, int y) {  
        // 向下  
        int r = -2, s = -2;  
        int i, j;  
        for (i = x - 1, j = y + 1; i >= 0 && j < Heibai.cols-1; i--, j++) {  
            if (Heibai.chess[i][j] == 0) {  
                break;  
            }  
            if (Heibai.chess[i][j] == Heibai.chess[x][y]) {  
                r = i;  
                s = j;  
                break;  
            }  
        }  
        if (r != -2 && s != -2
                && Heibai.chess[x - 1][y + 1] != Heibai.chess[i][j]) {  
            // 改变中间的子  
            paintChess4(x, y, i, j);  
            return new int[] { r, s };  
        } else {  
            return null;  
        }  
    }  
}