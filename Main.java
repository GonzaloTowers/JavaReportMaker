package informes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Main implements ActionListener{
	
	static int iDegreeWhite = 180;
	static int iDegreeBlack = 0;
        static boolean isTable = false;
        static String current_tabla = "---";

	Main() {
	    final JFrame f = new JFrame("Company Software v1.0");
	    f.setSize(600, 400);
	    f.setLayout(new BorderLayout());
	    f.setLocationRelativeTo(null);

	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    JMenuBar jmb = new JMenuBar();

	    JMenu jmFile = new JMenu("File");
	    JMenuItem jmiOpen = new JMenuItem("Load File");
	    JMenuItem jmiClose = new JMenuItem("New");
	    JMenuItem jmiSave = new JMenuItem("Save As");
	    JMenuItem jmiExit = new JMenuItem("Close");
	    jmFile.add(jmiOpen);
	    jmFile.add(jmiClose);
	    jmFile.add(jmiSave);
	    jmFile.addSeparator();
	    jmFile.add(jmiExit);
	    jmb.add(jmFile);

	    JMenu jmOptions = new JMenu("Options");
	    JMenu a = new JMenu("A");
	    JMenuItem b = new JMenuItem("B");
	    JMenuItem c = new JMenuItem("C");
	    JMenuItem d = new JMenuItem("D");
	    a.add(b);
	    a.add(c);
	    a.add(d);
	    jmOptions.add(a);

	    JMenu e = new JMenu("E");
	    e.add(new JMenuItem("F"));
	    e.add(new JMenuItem("G"));
	    jmOptions.add(e);

	    jmb.add(jmOptions);

	    JMenu jmHelp = new JMenu("Help");
	    JMenuItem jmiAbout = new JMenuItem("About");
	    jmHelp.add(jmiAbout);
	    jmb.add(jmHelp);

	    jmiOpen.addActionListener(this);
	    jmiClose.addActionListener(this);
	    jmiSave.addActionListener(this);
	    jmiExit.addActionListener(this);
	    b.addActionListener(this);
	    c.addActionListener(this);
	    d.addActionListener(this);
	    jmiAbout.addActionListener(this);
	    jmb.setPreferredSize(new Dimension(f.getWidth(),30));
	    
	    JPanel cabecera = new JPanel(){
            private static final long serialVersionUID = 1L;

            protected void paintComponent(Graphics pGraphics){
                Graphics2D pGraphicsGradientRender = (Graphics2D) pGraphics;
                pGraphicsGradientRender.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                GradientPaint pGradient = new GradientPaint(0, 0, new Color(255, 255, 255, iDegreeWhite), 0, getHeight(), new Color(0, 0, 0, iDegreeBlack));
                pGraphicsGradientRender.setPaint(pGradient);
                pGraphicsGradientRender.fillRect(0, 0, getWidth(), getHeight());
                super.paintComponent(pGraphics);
            }
        };
        cabecera.setOpaque(true);
	    cabecera.setPreferredSize(new Dimension(f.getWidth(),50));
	    cabecera.setBackground(new Color(49,55,64));
	    JLabel label = new JLabel();
	    //FONT
	    Font mainFont = null;
		try {
			mainFont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Roboto-Regular.ttf"));
			GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
			genv.registerFont(mainFont);
			mainFont = mainFont.deriveFont(20f);
			label.setFont(mainFont);
		} catch (FontFormatException | IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	    label.setText("ReportMaker v.UI by GonzaloTowers");
	    label.setForeground(Color.WHITE);
	    //cabecera.add(label, JLabel.CENTER);
            //ImageIcon iconLabel = new ImageIcon("resources/towerlogomin.png");
            cabecera.add(label, JLabel.CENTER);
            /*SET ICON IMAGE TO HEADER*/
            /*label.setIcon(new ImageIcon(this.getClass().getResource("towerlogomin.png")));*/
	    final JPanel rightArea = new JPanel(new BorderLayout());
	    rightArea.setPreferredSize(new Dimension(f.getWidth()-200,f.getHeight()));
	    rightArea.setBackground(new Color(233,233,233));
            JLabel labelFile = new JLabel("No files opened");
            labelFile.setForeground(new Color(157,157,157));
            ImageIcon iconMiddle = new ImageIcon("resources/file.png");
            rightArea.add(labelFile, JLabel.CENTER);
            labelFile.setIcon(iconMiddle);
	    
	    JPanel rightAreaTop = new JPanel();
	    rightAreaTop.setPreferredSize(new Dimension(rightArea.getWidth(),50));
	    rightAreaTop.setBackground(new Color(101,106,115));
	    
	    rightArea.add(rightAreaTop, BorderLayout.NORTH);
	    
	    JPanel leftArea = new JPanel(new GridLayout(4,1));
	    leftArea.setPreferredSize(new Dimension(200,f.getHeight()));
	    leftArea.setBackground(new Color(101,106,115));
	    
	    JButton button1 = new JButton("Load File");
	    button1.setPreferredSize(new Dimension(150,50));
	    button1.setBorder(new LineBorder(Color.WHITE, 2));
            button1.setBackground(new Color(101,106,115));
            button1.setForeground(Color.WHITE);
            
            button1.setIcon(new ImageIcon(this.getClass().getResource("load-file.png")));
            
            JButton button2 = new JButton("New Table");
	    button2.setPreferredSize(new Dimension(190,50));
	    button2.setBorder(new LineBorder(Color.WHITE, 2));
            button2.setBackground(new Color(101,106,115));
            button2.setForeground(Color.WHITE);
            
            button2.setIcon(new ImageIcon(this.getClass().getResource("tabla.png")));
            
            JButton button3 = new JButton("Generate Graphic");
	    button3.setPreferredSize(new Dimension(190,50));
	    button3.setBorder(new LineBorder(Color.WHITE, 2));
            button3.setBackground(new Color(101,106,115));
            button3.setForeground(Color.WHITE);
            
            button3.setIcon(new ImageIcon(this.getClass().getResource("grafico.png")));
            
            button3.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(!isTable){
                        JOptionPane.showMessageDialog(new JFrame(),
                        "There is no table to extract the graphic. To generate a graphic, a existing table is needed.",
                        "Error",
                        JOptionPane.WARNING_MESSAGE);
                    }else{
                        
                    }
                }  
            });
            
	    JButton button4 = new JButton("Save As");
	    button4.setPreferredSize(new Dimension(150,50));
	    button4.setBorder(new LineBorder(Color.WHITE, 2));
            button4.setBackground(new Color(34,34,34));
            button4.setForeground(Color.WHITE);
            
            button4.setIcon(new ImageIcon(this.getClass().getResource("save-file.png")));
            
            button4.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    GridOpSave fsv = new GridOpSave("Save As");
                    String [] args = {};
                    fsv.main(args);
                }  
            });
	    
	    leftArea.add(button1);
	    leftArea.add(button2);
	    leftArea.add(button3);
	    leftArea.add(button4);
            
            button1.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    FileChooser fch = new FileChooser();
                    String [] args = {};
                    fch.main(args);
                }
            });
	    
	    //HIDDEN PANELS
	    JPanel panel1 = new JPanel(new BorderLayout());
	    panel1.setPreferredSize(new Dimension(f.getWidth()-200,f.getHeight()));
	    panel1.setBackground(Color.GRAY);
	    
	    f.add(cabecera, BorderLayout.NORTH);
	    f.add(rightArea, BorderLayout.EAST);
	    f.add(leftArea, BorderLayout.WEST);
	    
	    f.addWindowStateListener(new WindowStateListener() {
			
			@Override
			public void windowStateChanged(WindowEvent arg0) {
				// TODO Auto-generated method stub
                                leftArea.setPreferredSize(new Dimension(200,f.getHeight()));
				rightArea.setPreferredSize(new Dimension(f.getWidth()-200,f.getHeight()));
				f.revalidate();
				f.repaint();
			}
		});
	    
	    f.addComponentListener(new ComponentListener(){

			@Override
			public void componentHidden(ComponentEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentMoved(ComponentEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentResized(ComponentEvent arg0) {
				// TODO Auto-generated method stub
                                leftArea.setPreferredSize(new Dimension(200,f.getHeight()));
				rightArea.setPreferredSize(new Dimension(f.getWidth()-200,f.getHeight()));
				f.revalidate();
				f.repaint();
			}

			@Override
			public void componentShown(ComponentEvent arg0) {
				// TODO Auto-generated method stub
				
			}
	    	
	    });

            //SCREEN SIZE
            Dimension screenSz = Toolkit.getDefaultToolkit().getScreenSize();
            double screenWidth = screenSz.getWidth();
            double screenHeight = screenSz.getHeight();
            
	    f.setJMenuBar(jmb);
	    f.setVisible(true);
	    f.setMinimumSize(new Dimension(600,400));
            f.setSize(new Dimension(900,600));
            //OPEN WITH CURRENT SIZE
            leftArea.setPreferredSize(new Dimension(200,f.getHeight()));
            rightArea.setPreferredSize(new Dimension(f.getWidth()-200,f.getHeight()));
            f.revalidate();
            f.repaint();
	  }
	  public void actionPerformed(ActionEvent ae) {
	    String comStr = ae.getActionCommand();
	    System.out.println(comStr + " Selected");
	    if(comStr.equals("Close")){
	    	//Cerrar sesion
	    	System.exit(0);
	    }
            if(comStr.equals("Load File")){
                FileChooser fch = new FileChooser();
                String [] args = {};
                fch.main(args);
            }
            if(comStr.equals("Save As")){
                GridOpSave fsv = new GridOpSave("Save As");
                String [] args = {};
                fsv.main(args);
            }
	  }
	  public static void main(String args[]) {
	    new Main();
	  }
}
