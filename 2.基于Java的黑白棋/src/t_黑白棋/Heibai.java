package t_�ڰ���;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Heibai extends JFrame{
	private  boolean a=true;
	private boolean b=false;
	public static void main(String args[]){ 
		Heibai hb=new Heibai();
		hb.showstartFrame(hb.a);
		
	}
	public void showstartFrame(boolean a){
		JPanel start=new JPanel();
		start.setSize(200,100);
		start.setLayout(new GridBagLayout());
		JButton dan=new JButton("������Ϸ");
		JButton shuang=new JButton("˫����Ϸ");
		JButton exit=new JButton("�˳���Ϸ");
		Dimension di=new Dimension(100,50);
		dan.setPreferredSize(di);
		shuang.setPreferredSize(di);
		exit.setPreferredSize(di);
		start.setVisible(a);
		start.add(dan);
		start.add(shuang);
		start.add(exit);
		this.setTitle("�ڰ���");
		this.add(start,BorderLayout.EAST);
		this.setSize(1000, 650);
		this.setLocationRelativeTo(null);
		this.setVisible(a);
		ActionListener danrende=new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
                start.setVisible(b);
                Heibai m=new Heibai();
                m.showframe1(a);
            }  
        };
        dan.addActionListener(danrende);
        ActionListener shuangren=new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
                start.setVisible(b);
                Heibai m=new Heibai();
                m.showframe(a);
            }  
        };
        shuang.addActionListener(shuangren);
        ActionListener tuichu=new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
                System.exit(0);
            }  
        };
        exit.addActionListener(tuichu);
	}
	public void showframe(boolean a){  
        //--------------------��Ϸ����----------------------  
        JPanel gamejp=new JPanel();  
        //--------------------�������----------------------  
        JPanel buttonjp=new JPanel();  
        //��ťͼ��  
        ImageIcon baizi=new ImageIcon("image/����.png");  
        ImageIcon heizi=new ImageIcon("image/����.png");  
        ImageIcon baizi1=new ImageIcon("image/����1.png");  
        ImageIcon heizi1=new ImageIcon("image/����1.png");  
        JButton baizibu=new JButton(baizi);  
        JButton heizibu=new JButton(heizi);  
        baizibu.setRolloverIcon(baizi1);  
        heizibu.setRolloverIcon(heizi1);  
        baizibu.setPressedIcon(baizi1);  
        heizibu.setPressedIcon(heizi1);  
        Dimension di=new Dimension(100,100);  
        baizibu.setPreferredSize(di);  
        heizibu.setPreferredSize(di);  
        //-----------------------��ǰ�������---------------------  
        final JLabel jilu=new JLabel("  ������  ");  
        //��������  
        Font jilufont=new Font("����",Font.BOLD,30);  
        jilu.setFont(jilufont);  
        //������¼���������ӵ���Ŀ  
        final JLabel baizila=new JLabel("2");  
        final JLabel heizila=new JLabel("2");  
        //����Label������ʹ�С  
        Font font=new Font("����",Font.BOLD,42);  
        baizila.setFont(font);  
        heizila.setFont(font);  
        //-----------------���¿��ֵķ���------------------  
        ImageIcon img=new ImageIcon("image/restart.jpg");  
        JButton bu=new JButton(img);  
        bu.setPreferredSize(new Dimension(100,40));  
        buttonjp.add(jilu);  
        buttonjp.add(baizibu);  
        buttonjp.add(baizila);  
        buttonjp.add(heizibu);  
        buttonjp.add(heizila);  
        buttonjp.add(bu);  
        this.setLayout(new GridLayout(1,2,600,0));  
        this.add(gamejp);  
        this.add(buttonjp);  
        this.setTitle("�ڰ���");  
        this.setSize(1000,650);  
        this.setResizable(false);  
        this.setLocationRelativeTo(null);  
        this.setDefaultCloseOperation(3);  
        //��ʾ����  
        this.setVisible(a);  
        //��ȡ����Ȩ��  
        Graphics g=this.getGraphics();  
        chess[3][3]=1;  
        chess[4][4]=1;  
        chess[3][4]=2;  
        chess[4][3]=2;  
        ChessListener lis=new ChessListener(g,this,jilu,baizila,heizila);  
        this.addMouseListener(lis);  
        //��ť������----------------���¿�ʼ  
        ActionListener bulis=new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                clear();  
                //�ػ�ķ���  
                repaint();  
                //���Ƴ�ʼ���ĸ�ͼƬ  
                chess[3][3]=1;  
                chess[4][4]=1;  
                chess[3][4]=2;  
                chess[4][3]=2;  
                //��״̬��Ϊ��ʼ״̬  
                ChessListener.stata=2;  
                jilu.setText("  ������  ");  
                baizila.setText("2");  
                heizila.setText("2");  
            }  
        };  
        //�����������������  
        ActionListener alilis=new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                ChessListener.stata=1;  
                jilu.setText("  ������  ");  
            }  
        };  
        //�����������������  
        ActionListener taozilis=new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                ChessListener.stata=2;  
                jilu.setText("  ������  ");  
            }  
        };  
        baizibu.addActionListener(alilis);  
        heizibu.addActionListener(taozilis);  
        bu.addActionListener(bulis);  
    }  
	public void showframe1(boolean a){  
        //--------------------��Ϸ����----------------------  
        JPanel gamejp=new JPanel();  
        //--------------------�������----------------------  
        JPanel buttonjp=new JPanel();  
        //��ťͼ��  
        ImageIcon baizi=new ImageIcon("image/����.png");  
        ImageIcon heizi=new ImageIcon("image/����.png");  
        ImageIcon baizi1=new ImageIcon("image/����1.png");  
        ImageIcon heizi1=new ImageIcon("image/����1.png");  
        JButton baizibu=new JButton(baizi);  
        JButton heizibu=new JButton(heizi);  
        baizibu.setRolloverIcon(baizi1);  
        heizibu.setRolloverIcon(heizi1);  
        baizibu.setPressedIcon(baizi1);  
        heizibu.setPressedIcon(heizi1);  
        Dimension di=new Dimension(100,100);  
        baizibu.setPreferredSize(di);  
        heizibu.setPreferredSize(di);  
        //-----------------------��ǰ�������---------------------  
        final JLabel jilu=new JLabel("  ������  ");  
        //��������  
        Font jilufont=new Font("����",Font.BOLD,30);  
        jilu.setFont(jilufont);  
        //������¼���������ӵ���Ŀ  
        final JLabel baizila=new JLabel("2");  
        final JLabel heizila=new JLabel("2");  
        //����Label������ʹ�С  
        Font font=new Font("����",Font.BOLD,42);  
        baizila.setFont(font);  
        heizila.setFont(font);  
        //-----------------���¿��ֵķ���------------------  
        ImageIcon img=new ImageIcon("image/restart.jpg");  
        JButton bu=new JButton(img);  
        bu.setPreferredSize(new Dimension(100,40));  
        buttonjp.add(jilu);  
        buttonjp.add(baizibu);  
        buttonjp.add(baizila);  
        buttonjp.add(heizibu);  
        buttonjp.add(heizila);  
        buttonjp.add(bu);  
        this.setLayout(new GridLayout(1,2,600,0));  
        this.add(gamejp);  
        this.add(buttonjp);  
        this.setTitle("�ڰ���");  
        this.setSize(1000,650);  
        this.setResizable(false);  
        this.setLocationRelativeTo(null);  
        this.setDefaultCloseOperation(3);  
        //��ʾ����  
        this.setVisible(a);  
        //��ȡ����Ȩ��  
        Graphics g=this.getGraphics();  
        chess[3][3]=1;  
        chess[4][4]=1;  
        chess[3][4]=2;  
        chess[4][3]=2;  
        ChessListener1 lis=new ChessListener1(g,this,jilu,baizila,heizila);  
        this.addMouseListener(lis);  
        //��ť������----------------���¿�ʼ  
        ActionListener bulis=new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                clear();  
                //�ػ�ķ���  
                repaint();  
                //���Ƴ�ʼ���ĸ�ͼƬ  
                chess[3][3]=1;  
                chess[4][4]=1;  
                chess[3][4]=2;  
                chess[4][3]=2;  
                //��״̬��Ϊ��ʼ״̬  
                ChessListener.stata=2;  
                jilu.setText("  ������  ");  
                baizila.setText("2");  
                heizila.setText("2");  
            }  
        };  
        //�����������������   
        bu.addActionListener(bulis);  
    }  
    /** 
     * ������̵ķ��� 
     */
    public void clear(){  
        for(int i=0;i<chess.length;i++){  
            for(int j=0;j<chess[i].length;j++){  
                chess[i][j]=0;  
            }  
        }  
    }  
    /** 
     * ��д�����paint���� 
     */
    public void paint(Graphics g){  
        super.paint(g);  
        Image back=new ImageIcon("image/1.jpg").getImage();  
        g.drawImage(back, 10,30,650,600, null);  
        //�ػ�����  
        //������  
      for(int i=0;i<rows;i++){  
          g.setColor(Color.BLUE);  
         g.drawLine(x,y+i*size,x+size*(rows-1),y+i*size);  
      }  
     //������  
      for(int j=0;j<cols;j++){  
          g.setColor(Color.BLUE);  
          g.drawLine(x+j*size,y,x+j*size,y+size*(cols-1));  
      }  
        //��������  
        for(int i=0;i<rows-1;i++){  
            for(int j=0;j<cols-1;j++){  
                int X=x+size/2+size*i;//���ӵĺ�����  
                int Y=y+size/2+size*j;//���ӵ�������  
                if(chess[i][j]==1){  
                    //������  
                    Image b=new ImageIcon("image/����1.PNG").getImage();  
                    g.drawImage(b, X-Chess_size/2, Y-Chess_size/2, Chess_size, Chess_size, null);  
                    //g.fillOval(X-size/2,Y-size/2,Chess_size,Chess_size);  
                }  
                else if(chess[i][j]==2){  
                    //������  
                    Image w=new ImageIcon("image/����1.PNG").getImage();  
                    g.drawImage(w, X-Chess_size/2, Y-Chess_size/2, Chess_size, Chess_size, null);  
                    //g.fillOval(X-size/2,Y-size/2,Chess_size,Chess_size);  
                }  
            }  
        }  
    }
    
	
	public final static int x=79;   //���̳�ʼ�������  
    public final static int y=83;   //���̳�ʼ��������  
    public final static int rows=9; //��������  
    public final static int cols=9; //��������  
    public final static int size=61;//���̸��Ӵ�С  
    public final static int Chess_size=56;//���Ӵ�С  
    public final static int chess[][]=new int[rows-1][cols-1];//����һ��8*8������
}