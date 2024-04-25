import java.awt.*; import java.awt.event.*; import javax.imageio.ImageIO; import javax.swing.*;
public class Mode_Order implements ActionListener{
	JFrame frm = new JFrame("Lots'a Pizza");
	Mode_Order(){
		button();
		Image();
		the_action();
		Container con = frm.getContentPane(); con.setBackground(Color.WHITE);
		frm.setSize(700,500); frm.setLayout(null); frm.setLocationRelativeTo(null); frm.setResizable(false); frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); frm.setLayout(null);
		frm.setVisible(true);
	}
	
	void Image() {
		String location [] = {"Dine.jpg","take.jpg", "delivery.jpg"};
		for (int i=0; i<location.length; i++) {
			try {
				Image image1 = ImageIO.read(this.getClass().getResource(location[i]));
				Image imageScaled1 = image1.getScaledInstance(200, 400, Image.SCALE_SMOOTH);
				ImageIcon imageIcon1 = new ImageIcon(imageScaled1);
				btnimg[i] = new JButton(imageIcon1);
				//lblimg1[i].setOpaque(false);	lblimg1[i].setContentAreaFilled(false);	lblimg1[i].setBorderPainted(false);
			}catch(Exception e) {System.out.println("Something went wrong! -_^");}
		}
		
		btnimg[0].setBounds(15,10,200,400);		frm.add(btnimg[0]);
		btnimg[1].setBounds(243,10,200,400);	frm.add(btnimg[1]);
		btnimg[2].setBounds(470,10,200,400);	frm.add(btnimg[2]);
	}
	
	JLabel img;
	JButton []btnimg = new JButton[3];
	JButton dine, take, delivery;
	void button() {
		dine = new JButton("Dine-In");		dine.setBounds(15,420,200,30);		dine.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));		dine.setBackground(new Color(255, 67,67));		dine.setForeground(Color.WHITE);	frm.add(dine);
		take = new JButton("Take-Out");		take.setBounds(240,420,200,30);		take.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));		take.setBackground(new Color(255, 67,67));		take.setForeground(Color.WHITE);	frm.add(take);
		delivery = new JButton("Delivery");	delivery.setBounds(470,420,200,30);	delivery.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));	delivery.setBackground(new Color(255, 67,67));	delivery.setForeground(Color.WHITE);frm.add(delivery);	
	}

	void the_action() {
		btnimg[0].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {if(e.getSource()==btnimg[0]){frm.dispose(); new Table_class();	}}});
		btnimg[1].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {if(e.getSource()==btnimg[1]){frm.dispose(); new FoodMenu_DineIn_TakeOut();	}}});
		btnimg[2].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {if(e.getSource()==btnimg[2]){frm.dispose(); new FoodMenu_Delivery();	}}});
		dine.addActionListener	   (new ActionListener() {public void actionPerformed(ActionEvent e) {if(e.getSource()==dine)	  {frm.dispose(); new Table_class();	}}});
		take.addActionListener	   (new ActionListener() {public void actionPerformed(ActionEvent e) {if(e.getSource()==take)	  {frm.dispose(); new FoodMenu_DineIn_TakeOut();	}}});
		delivery.addActionListener (new ActionListener() {public void actionPerformed(ActionEvent e) {if(e.getSource()==delivery) {frm.dispose(); new FoodMenu_Delivery();	}}});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {}

}
