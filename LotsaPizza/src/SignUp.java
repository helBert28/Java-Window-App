import java.awt.*; import java.awt.event.*; import java.util.Arrays; import javax.imageio.ImageIO; import javax.swing.*;
public class SignUp implements ActionListener{
	public SignUp (){
		final JFrame frm = new JFrame("Sign Up Page");
		Container con1 = frm.getContentPane(); con1.setBackground(Color.white);
		
		try {
			Image img1 = ImageIO.read(this.getClass().getResource("person1.png"));
			Image imgScld1 = img1.getScaledInstance(215,215, Image.SCALE_SMOOTH);
			ImageIcon imgIcon = new ImageIcon(imgScld1);
			JLabel banner = new JLabel(imgIcon);
			banner.setBounds(0,40,215,215);
			frm.getContentPane().add(banner);
		}catch(Exception e) {System.out.println("Not found");}
		
		JLabel title = new JLabel("Sign Up"); 		  		   title.setBounds(280,0,100,25);	  title.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20)); 
		final JLabel email = new JLabel("Email Address");    		   email.setBounds(230,25,200,20);	  email.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		final JTextField fldEmail = new JTextField(""); 	   		   fldEmail.setBounds(230,45,180,25); fldEmail.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		final JLabel FName = new JLabel("First Name");       		   FName.setBounds(230,70,90,20);	  FName.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		final JTextField fName = new JTextField(""); 		   		   fName.setBounds(230,90,85,25); 	  fName.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		final JLabel LName = new JLabel("Last Name"); 	    	   LName.setBounds(325,70,95,20);	  LName.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		final JTextField lName = new JTextField("");		    	   lName.setBounds(325,90,85,25); 	  lName.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		final JLabel pass = new JLabel("Password");		           pass.setBounds(230,115,200,20);	  pass.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		final JPasswordField fldPass = new JPasswordField(); 		   fldPass.setBounds(230,135,180,25); fldPass.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12)); fldPass.setEchoChar('#');
		final JLabel pass1 = new JLabel("Re-type Password"); 		   pass1.setBounds(230,160,200,20);	  pass1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		final JLabel lblShow = new JLabel("Show");		   		   lblShow.setBounds(410,128,40,20);  lblShow.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 9));
		final JPasswordField fldPass1 = new JPasswordField();		   fldPass1.setBounds(230,180,180,25);fldPass1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));fldPass1.setEchoChar('#');
		final JLabel lblShow1 = new JLabel("Show"); 		   		   lblShow1.setBounds(410,173,40,20); lblShow1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 9));
		final JTextField line1 = new JTextField(); 		   		   line1.setBounds(230,250,90,2);
		final JTextField line2 = new JTextField(); 		   		   line2.setBounds(340,250,90,2);
		final JLabel lblOr = new JLabel("or"); 	 				   lblOr.setBounds(324,245,20,20);
		final JLabel crtAcc = new JLabel("Already have an account?");crtAcc.setBounds(230,300,150,14);  crtAcc.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		
		final JCheckBox show = new JCheckBox(); show.setBounds(410,135,20,30); show.setOpaque(false);
		show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						if(show.isSelected()) {
							fldPass.setEchoChar((char)0);
							lblShow.setText("Hide");
						}else{
							fldPass.setEchoChar('#');
							lblShow.setText("Show");
						}
					}});
		
		final JCheckBox show1 = new JCheckBox(); show1.setBounds(410,180,20,30); show1.setOpaque(false);	
		show1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						if(show1.isSelected()) {
							fldPass1.setEchoChar((char)0);
							lblShow1.setText("Hide");
						}else{
							fldPass1.setEchoChar('#');
							lblShow1.setText("Show");
						}
					}});
		
		JButton btnLog = new JButton("Sign up"); btnLog.setBounds(230,210,90,25); btnLog.setBackground(new Color(255, 67,67)); btnLog.setForeground(Color.white); btnLog.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		btnLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String urEmail = fldEmail.getText();
				String urFName = fName.getText();
				String urLName = lName.getText();
				if(urEmail.isEmpty() || urFName.isEmpty() || urLName.isEmpty() || fldPass.getPassword().length==0 || fldPass1.getPassword().length==0) {
					JOptionPane.showMessageDialog(frm, "Field must not be empty!","Notice", JOptionPane.ERROR_MESSAGE);
				}else {
					if (!(Arrays.equals(fldPass1.getPassword(),fldPass.getPassword())) ) {
						JOptionPane.showMessageDialog(frm, "Password not matched!","Notice", JOptionPane.ERROR_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(frm, "Account Created Succesfully!","Notice", JOptionPane.INFORMATION_MESSAGE);
						frm.dispose();
						new MainUI();
					}
				}
			}});
		
		try {
			Image img2 = ImageIO.read(this.getClass().getResource("google.png"));
			Image imgScld2 = img2.getScaledInstance(30,30, Image.SCALE_SMOOTH);
			ImageIcon imgIconG = new ImageIcon(imgScld2);
			JButton btnG = new JButton(imgIconG); btnG.setBounds(280,260,30,30); btnG.setOpaque(false); btnG.setContentAreaFilled(false); btnG.setBorderPainted(false);
			btnG.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(frm, "Account Connected Successfully!","Notice", JOptionPane.INFORMATION_MESSAGE);
					frm.dispose();
					new MainUI();
				}
			});
			frm.getContentPane().add(btnG);
			
			Image img3 = ImageIO.read(this.getClass().getResource("facebook.png"));
			Image imgScld3 = img3.getScaledInstance(65,40, Image.SCALE_SMOOTH);
			ImageIcon imgIconFB = new ImageIcon(imgScld3);
			JButton btnFB = new JButton(imgIconFB); btnFB.setBounds(340,255,65,40); btnFB.setOpaque(false); btnFB.setContentAreaFilled(false); btnFB.setBorderPainted(false);
			btnFB.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(frm, "Account Connected Successfully!","Notice", JOptionPane.INFORMATION_MESSAGE);
					frm.dispose();
					new MainUI();
				}
			});
			frm.getContentPane().add(btnFB);
		}catch(Exception e) {System.out.println("Not found");}
		
		
		final JButton btnSign_In = new JButton("Sign In"); btnSign_In.setBounds(340,295,100,20); btnSign_In.setOpaque(false); btnSign_In.setContentAreaFilled(false); btnSign_In.setBorderPainted(false);	 btnSign_In.setForeground(new Color(255, 67,67));
		btnSign_In.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnSign_In){
					frm.dispose();
					new SignIn();	
				}}});
		
		frm.add(title); frm.add(email); frm.add(fldEmail);  frm.add(FName);  frm.add(fName); frm.add(LName);frm.add(lName);
		frm.add(pass); frm.add(fldPass); frm.add(pass1); frm.add(fldPass1); frm.add(lblShow);frm.add(show);frm.add(lblShow1);frm.add(show1); frm.add(btnLog);
		frm.add(line1); frm.add(line2); frm.add(lblOr); frm.add(crtAcc); frm.add(btnSign_In);
		
		frm.setSize(480,360); frm.setLayout(null); frm.setLocationRelativeTo(null); frm.setResizable(false); frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {}
}