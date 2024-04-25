import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class MainUI implements ActionListener{
	JFrame frm = new JFrame("LOTS'A PIZZA");

	MainUI(){
		ImageIcon imgIcon1, imgIcon2;
		Image img1, imgScld1;
		JLabel 	PERSON, pizza, title, title2, subtitle;
		final JButton btn;
		
		title = new JLabel("LOTS'A PIZZA:");
		title.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		title.setBounds(250,0,200,20);
		title.setForeground(Color.RED);
		
		title2 = new JLabel("Dining, Takeout &");
		title2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		title2.setBounds(250,20,200,30);
		title2.setForeground(Color.RED);
		
		JLabel title3 = new JLabel("Delivery");
		title3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		title3.setBounds(250,40,200,30);
		title3.setForeground(Color.RED);
		
		subtitle = new JLabel("Order food online");
		subtitle.setBounds(250,70,100,20);
		subtitle.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		
		try {
		img1 = ImageIO.read(this.getClass().getResource("person.png"));
		imgScld1 = img1.getScaledInstance(80,80, Image.SCALE_SMOOTH);
		imgIcon1 = new ImageIcon(imgScld1);
		PERSON = new JLabel(imgIcon1);
		PERSON.setBounds(280,100,80,80);
		frm.getContentPane().add(PERSON);

		imgIcon2 = new ImageIcon(this.getClass().getResource("pizza.gif"));
		pizza = new JLabel(imgIcon2);
		pizza.setBounds(0,0,230,250);
		frm.getContentPane().add(pizza);
		
		}catch(Exception e) {System.out.println("Not found");}
		
		btn = new JButton("ORDER NOW>>>");
		btn.setBounds(250,180,170,50);
		btn.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		btn.setBackground(new Color(255, 67,67));
		btn.setForeground(Color.white);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btn){
					frm.dispose();
					new Mode_Order();	
				}
			}
		});
		
		frm.add(title); frm.add(title2); frm.add(title3); frm.add(subtitle); frm.add(btn);
		
		Container con = frm.getContentPane();
		con.setBackground(Color.white);
		
		frm.setSize(480,300);
		frm.setLayout(null);
		frm.setLocationRelativeTo(null);
		frm.setResizable(false);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setVisible(true);	
	}

	@Override
	public void actionPerformed(ActionEvent e) {}
}
