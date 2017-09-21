package t_�ڰ���;


import java.awt.Graphics;  
import java.awt.event.MouseAdapter;  
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JLabel;  
import javax.swing.JOptionPane;  
      
public class ChessListener extends MouseAdapter{  
    private Graphics g;        //���������󴫹���  
    private int xiafa;         //��¼��ǰ���ӵ��·�  
    public  static int stata=1;//�ж��º��廹�ǰ��壨���尢�꣬�������ӣ�  
    private int x1,y1;         //��¼������ĺ������������  
    private JLabel jilu;       //��ǰ�����ӵ���  
    private JLabel baizila;      //����������  
    private JLabel heizila;    //����������  
    private Heibai ch;          //����ˢ������  
    private int   te=0;        //�������  
    private int   change;      //��¼�ı��������Ŀ  
    String d="";
    public ChessListener(Graphics g,Heibai ch,JLabel jilu,JLabel baizila,JLabel heizila){  
        this.g=g;  
        this.ch=ch;  
        this.jilu=jilu;  
        this.baizila=baizila;  
        this.heizila=heizila;  
    }  
          
    //���������  
    public void mouseClicked(MouseEvent e){  
        int a=1;            //��¼���µ���  
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
                int x2=Heibai.x+Heibai.size/2+Heibai.size*i;//�õ��������������ڵ�ĺ�����  
                int y2=Heibai.y+Heibai.size/2+Heibai.size*j;//�õ��������������ڵ��������  
                //�������������̸��ӵ�������  
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
                        Heibai.chess[i][j]=3-stata;//�����Ӵ�������  
                        //g.fillOval(x2-Chess.size/2, y2-Chess.size/2, Chess.Chess_size, Chess.Chess_size);  
                        //--------------���8�����򶼲��ܸı������򲻸ı�����״̬--------------  
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
                            //ˢ������  
                            ch.update(g);  
                            JOptionPane.showMessageDialog(null, "���ܷ���");  
                        }  
                        else{  
                            // �ı��м�����ɫ  
                        	
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
                            // ������ΪԲ�Ļ�Բ  
                            //g.fillOval(x2-Chess.size/2, y2-Chess.size/2, Chess.Chess_size, Chess.Chess_size);  
                            //g.setColor(Color.BLACK);  
                            ch.update(g);  
                            //�ı����Ӽ�¼�����������  
                            baizila.setText(judge()[0]+"");  
                            heizila.setText(judge()[1]+"");  
                            System.out.println("�ı���"+change+"����");  
                            change=0;  
                            //�жϵ�ǰ�������  
                            if(stata==1){  
                                jilu.setText("  ������  ");  
                                a=1;  
                                s="����";  
                            }  
                            else if(stata==2){  
                                jilu.setText("  ������  ");  
                                a=2;  
                                s="����";  
                            }  
                            xiafa=Check(a);  
                            //�����ǰ������˻��м����·�  
                            System.out.println(s+"��"+xiafa+"���·�");  
                            if(xiafa==0&&full()==false){//����������Ӳ�������δ��  
                                te++;  
                                JOptionPane.showMessageDialog(null, s+"�������ӣ�����!");  
                                if(stata==1){//������겻��������������������  
                                    stata=2;  
                                    jilu.setText("  ������  ");  
                                    a=2;  
                                    s="����";  
                                }  
                                else if(stata==2){//������Ӳ���������������������  
                                    stata=1;  
                                    jilu.setText("  ������  ");  
                                    a=1;  
                                    s="����";  
                                }  
                                xiafa=Check(a);  
                                System.out.println(s+"��"+xiafa+"���·�");  
                                if(xiafa==0){  
                                    te++;//������ӿ��£������������¼��1  
                                }else 
                                    te=0;  
                            }  
                            //----------------ʤ���ж�----------------  
                            if(judge()[0]==0){//�������û��������ӻ�ʤ  
                                JOptionPane.showMessageDialog(null,"��Ϸ���������ӻ�ʤ");  
                            }  
                            else if(judge()[1]==0){//�������û��������ӻ�ʤ  
                                JOptionPane.showMessageDialog(null, "��Ϸ���������ӻ�ʤ");  
                            }  
                            if(full()){  
                                if(judge()[0]>judge()[1]){//������ӵ��ӽ϶࣬����ӻ�ʤ  
                                    JOptionPane.showMessageDialog(null, "��Ϸ���������ӻ�ʤ"); 
                                    text="���ӻ�ʤ"+judge()[0]+":"+judge()[1];
                                    byte[] buff=new byte[]{};
                                    buff=text.getBytes();
                                    try {
										output.write(buff,0,buff.length);
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
                                }  
                                else if(judge()[0]<judge()[1]){//������ӵ��ӽ϶࣬����ӻ�ʤ  
                                    JOptionPane.showMessageDialog(null, "��Ϸ���������ӻ�ʤ"); 
                                    text="���ӻ�ʤ"+judge()[1]+":"+judge()[0];
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
                                    JOptionPane.showMessageDialog(null, "ƽ��");  
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
     * �ж���Ӯ�ķ�������������������ʤ����������ʤ 
     * @return ����Ͱ������Ŀ 
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
     * �ж������Ƿ������ķ��� 
     */
    public boolean full(){  
        if(te==2){      //���˫�����������ӣ�����Ϸ����  
            return true;  
        }  
        else{  
            for(int i=0;i<Heibai.rows-1;i++){  
                for(int j=0;j<Heibai.cols-1;j++){  
                    //�����һ���ط��ǿյ��򷵻�false  
                    if(Heibai.chess[i][j]==0){  
                        return false;  
                    }  
                }  
            }  
        }  
        return true;  
    }  
          
    /** 
     *  �жϵ�ǰ���ӵ��·����ж����� 
     *  @param return �����·�������  
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
                    n++;                //�����һ���ط��������ӣ���n+1  
                    }  
                    else{  
                    	Heibai.chess[i][j]=0;  
                    }  
                }  
            }  
        }  
        return n;  
    }  
          
    /*********************************************** �����ͬ��ɫ *******************************/
    /** 
     * �ı�������֮������ӵ���ɫ����ֱ�� 
     */
    public void paintChess(int r1, int c1, int r2, int c2) {  
        // ����  
        if (c1 == c2) {  
            for (int k = Math.min(r1, r2) + 1; k < Math.max(r1, r2); k++) {  
            	Heibai.chess[k][c1] = Heibai.chess[r1][c1];  
                change++;  
            }  
        }  
        // ����  
        if (r1 == r2) {  
            for (int k = Math.min(c1, c2) + 1; k < Math.max(c1, c2); k++) {  
            	Heibai.chess[r1][k] = Heibai.chess[r1][c1];  
                change++;  
            }  
        }  
    }  
          
    /** 
     * �ı�������֮������ӵ���ɫ����б�ߡ������� 
     */
    public void paintChess1(int r1, int c1, int r2, int c2) {  
        for (int k = Math.min(r1, r2) + 1, v = Math.max(c1, c2) - 1; k < Math  
                .max(r1, r2); k++, v--) {  
        	Heibai.chess[k][v] = Heibai.chess[r1][c1];  
            change++;  
        }  
    }  
          
    /** 
     * �ı�������֮������ӵ���ɫ����б�ߡ������� 
     */
    public void paintChess2(int r1, int c1, int r2, int c2) {  
        for (int k = Math.min(r1, r2) + 1, v = Math.min(c1, c2) + 1; k < Math  
                .max(r1, r2); k++, v++) {  
        	Heibai.chess[k][v] = Heibai.chess[r1][c1];  
            change++;  
        }  
    }  
          
    /** 
     * �ı�������֮������ӵ���ɫ����б�ߡ������� 
     */
    public void paintChess3(int r1, int c1, int r2, int c2) {  
        for (int k = Math.max(r1, r2) - 1, v = Math.max(c1, c2) - 1; k > Math  
                .min(r1, r2); k--, v--) {  
        	Heibai.chess[k][v] = Heibai.chess[r1][c1];  
            change++;  
        }  
    }  
      
    /** 
     * �ı�������֮������ӵ���ɫ����б�ߡ������� 
     */
    public void paintChess4(int r1, int c1, int r2, int c2) {  
        for (int k = Math.min(r1, r2) + 1, v = Math.max(c1, c2) - 1; k <= Math  
                .max(r1, r2); k++, v--) {  
        	Heibai.chess[k][v] = Heibai.chess[r1][c1];  
            change++;  
        }  
    }  
          
    /** 
     * ���Ҽ���Ƿ�����ͬ��ɫ���ӣ�������Ҳ����ڣ��ı��м�������ɫ�����򷵻�NULL 
     * @param x 
     * @param y 
     * @return 
     */
    public int[] hengYou(int x, int y) {  
        int r = -2;  
        int i;  
        // ����  
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
            // System.out.println("���Ҳ���");  
            return null;  
        }  
    }  
          
    /** 
     * �������Ƿ�����ͬ��ɫ���ӣ�������Ҳ����ڣ��ı��м�������ɫ�����򷵻�NULL 
     */
    public int[] hengZuo(int x, int y) {  
        int r = -2;  
        int i;  
        // ����  
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
            // System.out.println("������");  
            return null;  
        }  
    }  
      
    /** 
     * ���ϼ���Ƿ�����ͬ��ɫ���ӣ�������Ҳ����ڣ��ı��м�������ɫ�����򷵻�NULL 
     */
    public int[] hengShang(int x, int y) {  
        int r = -2;  
        int i;  
        // ����  
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
            // System.out.println("���ϲ���");  
            return null;  
        }  
    }  
      
    /** 
     * ���ϼ���Ƿ�����ͬ��ɫ���ӣ�������Ҳ����ڣ��ı��м�������ɫ�����򷵻�NULL 
     */
    public int[] hengShang1(int x, int y) {  
        int r = -2;  
        int i;  
        // ����  
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
            // �ı��м����  
            paintChess(x, y, x, r);  
            return new int[] { x, r };  
        } else {  
            return null;  
        }  
    }  
      
    /** 
     * ���¼���Ƿ�����ͬ��ɫ���ӣ�������Ҳ����ڣ��ı��м�������ɫ�����򷵻�NULL 
     */
    public int[] hengXia(int x, int y) {  
        int r = -2;  
        int i;  
        // ����  
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
            // System.out.println("���²���");  
            return null;  
        }  
    }  
      
    /** 
     * ���¼���Ƿ�����ͬ��ɫ���ӣ�������Ҳ����ڣ��ı��м�������ɫ�����򷵻�NULL 
     */
    public int[] hengXia1(int x, int y) {  
        int r = -2;  
        int i;  
        // ����  
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
            // �ı��м����  
            paintChess(x, y, x, r);  
            return new int[] { x, r };  
        } else {  
            return null;  
        }  
    }  
      
    /** 
     * б���Ϸ��� 
     * @param x 
     * @param y 
     * @return 
     */
    public int[] xieyouS(int x, int y) {  
        // ����  
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
            // System.out.println("�����ϲ���");  
            return null;  
        }  
    }  
          
    /** 
     * б���·��� 
     *  
     * @param x 
     * @param y 
     * @return 
     */
    public int[] xieyouX(int x, int y) {  
        // ����  
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
            // System.out.println("�����²���");  
            return null;  
        }  
    }  
      
    /** 
     * б���Ϸ��� 
     *  
     * @param x 
     * @param y 
     * @return 
     */
    public int[] xiezuoS(int x, int y) {  
        // ����  
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
     * б���·��� 
     * @param x 
     * @param y 
     * @return 
     */
    public int[] xiezuoX(int x, int y) {  
        // ����  
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
     * ���Ҽ���Ƿ�����ͬ��ɫ���ӣ�������Ҳ����ڣ��ı��м�������ɫ�����򷵻�NULL 
     */
    public int[] hengYou1(int x, int y) {  
        int r = -2;  
        int i;  
        // ����  
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
            // �ı��м����  
            paintChess(x, y, r, y);  
            return new int[] { r, y };  
        } else {  
            return null;  
        }  
    }  
      
    /** 
     * �������Ƿ�����ͬ��ɫ���ӣ�������Ҳ����ڣ��ı��м�������ɫ�����򷵻�NULL 
     */
    public int[] hengZuo1(int x, int y) {  
        int r = -2;  
        int i;  
        // ����  
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
            // �ı��м����  
            paintChess(x, y, r, y);  
            return new int[] { r, y };  
        } else {  
            return null;  
        }  
    }  
      
    /** 
     * б���Ϸ���  
     * @param x 
     * @param y 
     * @return 
     */
    public int[] xieyou1(int x, int y) {  
        // ����  
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
            // �ı��м����  
            paintChess1(x, y, i, j);  
            return new int[] { r, s };  
        } else {  
            return null;  
        }  
    }  
      
    /** 
     * б���·��� 
     *  
     * @param x 
     * @param y 
     * @return 
     */
    public int[] xieyou2(int x, int y) {  
        // ����  
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
            // �ı��м����  
            paintChess2(x, y, i, j);  
            return new int[] { r, s };  
        } else {  
            return null;  
        }  
    }  
      
    /** 
     * б���Ϸ��� 
     *  
     * @param x 
     * @param y 
     * @return 
     */
    public int[] xiezuo1(int x, int y) {  
        // ����  
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
            // �ı��м����  
            paintChess3(x, y, i, j);  
            return new int[] { r, s };  
        } else {  
            return null;  
        }  
    }  
      
    /** 
     * б���·���  
     * @param x 
     * @param y 
     * @return 
     */
    public int[] xiezuo2(int x, int y) {  
        // ����  
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
            // �ı��м����  
            paintChess4(x, y, i, j);  
            return new int[] { r, s };  
        } else {  
            return null;  
        }  
    }  
}