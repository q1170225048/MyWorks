package t_�ڰ���;

import java.awt.Font;
import java.awt.Graphics;  
import java.awt.event.MouseAdapter;  
import java.awt.event.MouseEvent;  
      
import javax.swing.JLabel;  
import javax.swing.JOptionPane;  
      
public class ChessListener1 extends MouseAdapter{  
    private Graphics g;        //���������󴫹���  
    private int xiafa;         //��¼��ǰ���ӵ��·�  
    public  static int stata=2;//�ж��º��廹�ǰ��� 
    private int x1,y1;         //��¼������ĺ������������  
    private JLabel jilu;       //��ǰ�����ӵ���  
    private JLabel alila;      //����������  
    private JLabel taozila;    //����������  
    private Heibai ch;          //����ˢ������  
    private int   te=0;        //�������  
    private int   change;      //��¼�ı��������Ŀ  
    int N = 8, D = 50, A = 50, R = 20, MAX = 100000000, LEVEL, OL=5;
    int cx=-1, cy=-1;
    int all=4;
    boolean turn=true, p1, p2;
    Font fsib30 = new Font("����",Font.ITALIC+Font.BOLD,20);
    public ChessListener1(Graphics g,Heibai ch,JLabel jilu,JLabel baizila,JLabel heizila){  
        this.g=g;  
        this.ch=ch;  
        this.jilu=jilu;  
        this.alila=baizila;  
        this.taozila=heizila;  
    }  
          
    //���������  
    public void mouseClicked(MouseEvent e){  
        int a=1;            //��¼���µ���  
        String s = null;         
        x1=e.getX();  
        y1=e.getY(); 
        for(int i=0;i<Heibai.rows-1;i++){  
            for(int j=0;j<Heibai.cols-1;j++){  
                int x2=Heibai.x+Heibai.size/2+Heibai.size*i;//�õ��������������ڵ�ĺ�����  
                int y2=Heibai.y+Heibai.size/2+Heibai.size*j;//�õ��������������ڵ��������  
                //�������������̸��ӵ�������  
                if(Math.abs(x1-x2)<Heibai.size/3&&Math.abs(y1-y2)<Heibai.size/3){  
                    if(Heibai.chess[i][j]==0){  
                        if(!turn){  
                            //Image b=new ImageIcon("image/ali.jpg").getImage();  
                            //g.drawImage(b, x2-Chess.Chess_size/2, y2-Chess.Chess_size/2, Chess.Chess_size, Chess.Chess_size, null);  
                            //g.setColor(Color.BLACK);  
                        	go();
                            stata=2;  
                            jilu.setText("  ������  ");  
                            alila.setText(judge()[0]+"");  
                            taozila.setText(judge()[1]+"");
                            a=1;  
                            s="����";  
                            ch.update(g); 
                            all++;
                        }  
                        else{  
                            //Image w=new ImageIcon("image/ali.jpg").getImage();  
                            //g.drawImage(w, x2-Chess.Chess_size/2, y2-Chess.Chess_size/2, Chess.Chess_size, Chess.Chess_size, null);  
                            //g.setColor(Color.WHITE);  
                    		turn = false;
                    		Heibai.chess[i][j]=3-stata;
                    		stata=1;
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
                                 turn=true;
                                 //ˢ������  
                                 ch.update(g);  
                                 JOptionPane.showMessageDialog(null, "���ܷ���");  
                             }  
                             else{  
                                 // �ı��м�����ɫ  
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
                                 alila.setText(judge()[0]+"");  
                                 taozila.setText(judge()[1]+"");  
                                 System.out.println("�ı���"+change+"����");  
                                 change=0;  
                                 //�жϵ�ǰ�������  
                                 
                                     jilu.setText("  ������  ");  
                                     a=2;  
                                     s="����";  
                                 xiafa=Check(a);  
                                 //�����ǰ������˻��м����·�  
                                 System.out.println(s+"��"+xiafa+"���·�");  
                    		
                    	}
                        	
                    }  
                        //g.fillOval(x2-Chess.size/2, y2-Chess.size/2, Chess.Chess_size, Chess.Chess_size);  
                        //--------------���8�����򶼲��ܸı������򲻸ı�����״̬--------------  
                        	xiafa=Check(a);
                            if(xiafa==0&&full()==false){//����������Ӳ�������δ��  
                                te++;  
                                JOptionPane.showMessageDialog(null, s+"�������ӣ�����!");  
                                if(stata==1){//������겻��������������������  
                                    stata=2;  
                                    turn=false;
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
                            if(judge()[0]==0){//�������û���������ӻ�ʤ  
                                JOptionPane.showMessageDialog(null,"��Ϸ���������ӻ�ʤ");  
                            }  
                            else if(judge()[1]==0){//�������û���������ʤ  
                                JOptionPane.showMessageDialog(null, "��Ϸ���������ӻ�ʤ");  
                            }  
                            if(full()){  
                                if(judge()[0]>judge()[1]){//���������ӽ϶࣬�����ʤ  
                                    JOptionPane.showMessageDialog(null, "��Ϸ���������ӻ�ʤ");  
                                }  
                                else if(judge()[0]<judge()[1]){//������ӵ��ӽ϶࣬�����ӻ�ʤ  
                                    JOptionPane.showMessageDialog(null, "��Ϸ���������ӻ�ʤ");  
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
        if (r != -2 && Heibai.chess[x][y - 1] != Heibai.chess[x][i]) {  
      
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
      
        if (r != -2 && Heibai.chess[x][y + 1] != Heibai.chess[x][i]) {  
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
    
    public void go(){
    	int a, b;
    	boolean flag = true;
    	turn = true;
    	while (flag && all < 64)
    	{
    		if (can(0, 0, 3 - stata) || can(0, 7, 3 - stata) || can(7, 0, 3 - stata) || can(7, 7, 3 - stata))
    			LEVEL = OL + 1;
    		else
    			LEVEL = OL;
    		if (all > 40 && all <= 50)
    			LEVEL += (all - 40)/3;
    		if (all > 50)
    			LEVEL = 64 - all;
    		if (stata == 1)
    			find(3 - stata, LEVEL, true, 0 - MAX);
    		else
    			find(3 - stata, LEVEL, true, MAX);

    		put(cx, cy, 3 - stata);
    		ch.update(g);
    		all++;
    		for (a=0; a<N && flag; a++)
    			for (b=0; b<N; b++)
    				if (can(a, b, stata))
    				{
    					flag = false;
    					break;
    				}
    	}
    }
    public boolean can(int x, int y, int z){
    	int i;
    	if (Heibai.chess[x][y] != 0)
    		return false;
    	if (x > 0 && Heibai.chess[x-1][y] == 3 - z)
    	{
    		for (i=2; x-i>=0 && Heibai.chess[x-i][y]==3-z; i++);
    		if (x - i >= 0 && Heibai.chess[x-i][y] == z)
    			return true;
    	}
    	if (x < N - 1 && Heibai.chess[x+1][y] == 3 - z)
    	{
    		for (i=2; x+i<N && Heibai.chess[x+i][y]==3-z; i++);
    		if (x + i < N && Heibai.chess[x+i][y] == z)
    			return true;
    	}
    	if (y > 0 && Heibai.chess[x][y-1] == 3 - z)
    	{
    		for (i=2; y-i>=0 && Heibai.chess[x][y-i]==3-z; i++);
    		if (y - i >= 0 && Heibai.chess[x][y-i] == z)
    			return true;
    	}
    	if (y < N - 1 && Heibai.chess[x][y+1] == 3 - z)
    	{
    		for (i=2; y+i<N && Heibai.chess[x][y+i]==3-z; i++);
    		if (y + i < N && Heibai.chess[x][y+i] == z)
    			return true;
    	}
    	if (x > 0 && y > 0 && Heibai.chess[x-1][y-1] == 3 - z)
    	{
    		for (i=2; x-i>=0 && y-i>=0 && Heibai.chess[x-i][y-i]==3-z; i++);
    		if (x - i >= 0 && y - i >= 0 && Heibai.chess[x-i][y-i] == z)
    			return true;
    	}
    	if (x < N - 1 && y < N - 1 && Heibai.chess[x+1][y+1] == 3 - z)
    	{
    		for (i=2; x+i<N && y+i<N && Heibai.chess[x+i][y+i]==3-z; i++);
    		if (x + i < N && y + i < N && Heibai.chess[x+i][y+i] == z)
    			return true;
    	}
    	if (x > 0 && y < N - 1 && Heibai.chess[x-1][y+1] == 3 - z)
    	{
    		for (i=2; x-i>=0 && y+i<N && Heibai.chess[x-i][y+i]==3-z; i++);
    		if (x - i >= 0 && y + i < N && Heibai.chess[x-i][y+i] == z)
    			return true;
    	}
    	if (x < N - 1 && y > 0 && Heibai.chess[x+1][y-1] == 3 - z)
    	{
    		for (i=2; x+i<N && y-i>=0 && Heibai.chess[x+i][y-i]==3-z; i++);
    		if (x + i < N && y - i >= 0 && Heibai.chess[x+i][y-i] == z)
    			return true;
    	}
    	return false;
    }
    public void put(int x, int y, int z){
    	int i;
    	Heibai.chess[x][y] = z;
    	if (x > 0 && Heibai.chess[x-1][y] == 3 - z)
    	{
    		for (i=2; x-i>=0 && Heibai.chess[x-i][y]==3-z; i++);
    		if (x - i >= 0 && Heibai.chess[x-i][y] == z)
    			for (i=1; Heibai.chess[x-i][y]==3-z; Heibai.chess[x-i][y]=z, i++);
    	}
    	if (x < N - 1 && Heibai.chess[x+1][y] == 3 - z)
    	{
    		for (i=2; x+i<N && Heibai.chess[x+i][y]==3-z; i++);
    		if (x + i < N && Heibai.chess[x+i][y] == z)
    			for (i=1; Heibai.chess[x+i][y]==3-z; Heibai.chess[x+i][y]=z, i++);
    	}
    	if (y > 0 && Heibai.chess[x][y-1] == 3 - z)
    	{
    		for (i=2; y-i>=0 && Heibai.chess[x][y-i]==3-z; i++);
    		if (y - i >= 0 && Heibai.chess[x][y-i] == z)
    			for (i=1; Heibai.chess[x][y-i]==3-z; Heibai.chess[x][y-i]=z, i++);
    	}
    	if (y < N - 1 && Heibai.chess[x][y+1] == 3 - z)
    	{
    		for (i=2; y+i<N && Heibai.chess[x][y+i]==3-z; i++);
    		if (y + i < N && Heibai.chess[x][y+i] == z)
    			for (i=1; Heibai.chess[x][y+i]==3-z; Heibai.chess[x][y+i]=z, i++);
    	}
    	if (x > 0 && y > 0 && Heibai.chess[x-1][y-1] == 3 - z)
    	{
    		for (i=2; x-i>=0 && y-i>=0 && Heibai.chess[x-i][y-i]==3-z; i++);
    		if (x - i >= 0 && y - i >= 0 && Heibai.chess[x-i][y-i] == z)
    			for (i=1; Heibai.chess[x-i][y-i]==3-z; Heibai.chess[x-i][y-i]=z, i++);
    	}
    	if (x < N - 1 && y < N - 1 && Heibai.chess[x+1][y+1] == 3 - z)
    	{
    		for (i=2; x+i<N && y+i<N && Heibai.chess[x+i][y+i]==3-z; i++);
    		if (x + i < N && y + i < N && Heibai.chess[x+i][y+i] == z)
    			for (i=1; Heibai.chess[x+i][y+i]==3-z; Heibai.chess[x+i][y+i]=z, i++);
    	}
    	if (x > 0 && y < N - 1 && Heibai.chess[x-1][y+1] == 3 - z)
    	{
    		for (i=2; x-i>=0 && y+i<N && Heibai.chess[x-i][y+i]==3-z; i++);
    		if (x - i >= 0 && y + i < N && Heibai.chess[x-i][y+i] == z)
    			for (i=1; Heibai.chess[x-i][y+i]==3-z; Heibai.chess[x-i][y+i]=z, i++);
    	}
    	if (x < N - 1 && y > 0 && Heibai.chess[x+1][y-1] == 3 - z)
    	{
    		for (i=2; x+i<N && y-i>=0 && Heibai.chess[x+i][y-i]==3-z; i++);
    		if (x + i < N && y - i >= 0 && Heibai.chess[x+i][y-i] == z)
    			for (i=1; Heibai.chess[x+i][y-i]==3-z; Heibai.chess[x+i][y-i]=z, i++);
    	}
    }
    public int get(int x, int y){
    	int i;
    	int a, b, c, d;
    	int temp = Heibai.chess[x][y];
    	a = b = c = d = 0;
    	for (i=1; x-i>=0 && Heibai.chess[x-i][y]==temp; i++);
    	if (x - i < 0)
    		a = 1;
    	for (i=1; x+i<N && Heibai.chess[x+i][y]==temp; i++);
    	if (x + i >= N)
    		a = 1;
    	for (i=1; y-i>=0 && Heibai.chess[x][y-i]==temp; i++);
    	if (y - i < 0)
    		b = 1;
    	for (i=1; y+i<N && Heibai.chess[x][y+i]==temp; i++);
    	if (y + i >= N)
    		b = 1;
    	for (i=1; x-i>=0 && y-i>=0 && Heibai.chess[x-i][y-i]==temp; i++);
    	if (x - i < 0 || y - i < 0)
    		c = 1;
    	for (i=1; x+i<N && y+i<N && Heibai.chess[x+i][y+i]==temp; i++);
    	if (x + i >= N || y + i >= N)
    		c = 1;
    	for (i=1; x-i>=0 && y+i<N && Heibai.chess[x-i][y+i]==temp; i++);
    	if (x - i < 0 || y + i >= N)
    		d = 1;
    	for (i=1; x+i<N && y-i>=0 && Heibai.chess[x+i][y-i]==temp; i++);
    	if (x + i >= N || y - i < 0)
    		d = 1;
    	return a + b + c + d;
    }
    public boolean inside(int x, int y){
    	int i, j;
    	for (i=x-1; i<=x+1; i++)
    		for (j=y-1; j<=y+1; j++)
    			if (i >= 0 && i < N && j >= 0 && j < N && Heibai.chess[i][j] == 0)
    				return false;
    	return true;
    }
    public int test(){
    	int ans = 0;
    	int i, j;
    	int sum, c;
    	for (i=0; i<N; i++)
    		for (j=0; j<N; j++)
    		{
    			if (Heibai.chess[i][j] == 0){
    				if (can(i, j, 1))
    					ans += 10;
    				if (can(i, j, 2))
    					ans -= 10;
    				continue;
    			}
    			sum = get(i, j);
    			if (Heibai.chess[i][j] == 1)
    				c = 1;
    			else
    				c = -1;
    			if (all >= 64)
    			{
    				ans += 10000*c;
    				continue;
    			}
    			if (inside(i, j))
    				ans += 8*c;
    			else
    				ans -= 8*c;
    			if (sum == 4)
    				ans += 30000*c;
    			if (i == 0 || i == 7)
    			{
    				if (j == 1 && Heibai.chess[i][0] != 1)
    					ans -= 30*c;
    				else if (j == 6 && Heibai.chess[i][7] != 1)
    					ans -= 30*c;
    				else
    					ans += 10*c;
    			}
    			if (j == 0 || j == 7)
    			{
    				if (i == 1 && Heibai.chess[0][j] != 1)
    					ans -= 30*c;
    				else if (i == 6 && Heibai.chess[7][j] != 1)
    					ans -= 30*c;
    				else
    					ans += 10*c;
    			}
    			if ((i == 0 && j == 0) || (i == 0 && j == 7) || (i == 7 && j == 0) || (i == 7 && j == 7))
    				ans += 100000*c;
    			if ((i == 1 && j == 1) && Heibai.chess[0][0] == 0)
    				ans -= 200*c;
    			if ((i == 1 && j == 6) && Heibai.chess[0][7] == 0)
    				ans -= 200*c;
    			if ((i == 6 && j == 1) && Heibai.chess[7][0] == 0)
    				ans -= 200*c;
    			if ((i == 6 && j == 6) && Heibai.chess[7][7] == 0)
    				ans -= 200*c;
    		}
    	return ans;
    }
    public int find(int x, int step, boolean flag, int last){
    	if (step == 0 || all >= 64)
    		return test();
    	int i, j, a, b;
    	int big = 0 - MAX, small = MAX, t;
    	int temp[][] = new int[N][N];
    	boolean h = false;
    	for (i=0; i<N; i++)
    		for (j=0; j<N; j++)
    			temp[i][j] = Heibai.chess[i][j];
    	for (i=0; i<N; i++)
    		for (j=0; j<N; j++)
    			if (can(i, j, x))
    			{
    				h = true;
    				put(i, j, x);
    				all++;
    				if (x == 1)
    					t = find(3 - x, step - 1, false, big);
    				else
    					t = find(3 - x, step - 1, false, small);
    				if (x == 1 && t > big)
    				{
    					big = t;
    					if (flag)
    					{
    						cx = i;
    						cy = j;
    					}
    				}
    				if (x == 2 && t < small)
    				{
    					small = t;
    					if (flag)
    					{
    						cx = i;
    						cy = j;
    					}
    				}
    				for (a=0; a<N; a++)
    					for (b=0; b<N; b++)
    						Heibai.chess[a][b] = temp[a][b];
    				all--;
    				if (x == 1 && big >= last)
    					return big;
    				if (x == 2 && small <= last)
    					return small;
    			}
    	if (h == false)
    		return test();
    	if (x == 1)
    		return big;
    	else
    		return small;
    }
}