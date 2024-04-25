import java.awt.*; import java.awt.event.*; import java.util.Arrays; import javax.imageio.ImageIO;  import javax.swing.*; 
public class SignIn implements ActionListener{
	SignIn (){
		final JFrame frm = new JFrame("Sign In Page");
		Container con = frm.getContentPane(); con.setBackground(Color.white);
		
		try {
			Image img1 = ImageIO.read(this.getClass().getResource("person1.png"));
			Image imgScld1 = img1.getScaledInstance(200,200, Image.SCALE_SMOOTH);
			ImageIcon imgIcon = new ImageIcon(imgScld1);
			JLabel banner = new JLabel(imgIcon);
			banner.setBounds(0,20,200,200);
			frm.getContentPane().add(banner);
		}catch(Exception e) {System.out.println("Something went wrong! -_^");}
		  
		JLabel title = new JLabel("Sign In");				 title.setBounds(280,0,100,25);		title.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20)); 							frm.add(title);
		JLabel email = new JLabel("Email Address");			 email.setBounds(230,30,200,20);	email.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));								frm.add(email);
		final JTextField fldEmail = new JTextField("");			 fldEmail.setBounds(230,50,180,25);	fldEmail.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));								frm.add(fldEmail);
		JLabel pass = new JLabel("Password");				 pass.setBounds(230,75,200,20);		pass.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));									frm.add(pass);
		final JPasswordField fldPass = new JPasswordField();		 fldPass.setBounds(230,95,180,25);	fldPass.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));	fldPass.setEchoChar('#');	frm.add(fldPass);
		final JLabel lblShow = new JLabel("Show");				 lblShow.setBounds(410,86,40,20);	lblShow.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 9));								frm.add(lblShow);
		JLabel crtAcc = new JLabel("Don't have an account?");crtAcc.setBounds(230,225,130,20);	crtAcc.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));								frm.add(crtAcc);
		JTextField line1 = new JTextField();				 line1.setBounds(230,170,90,2);																									frm.add(line1);
		JTextField line2 = new JTextField();				 line2.setBounds(340,170,90,2);																		 							frm.add(line2);
		JLabel lblOr = new JLabel("or");					 lblOr.setBounds(324,160,20,20); 																								frm.add(lblOr);
		    
		final JCheckBox show = new JCheckBox(); show.setBounds(410,94,20,30); show.setOpaque(false);
		show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						if(show.isSelected()) {
							fldPass.setEchoChar((char)0);
							lblShow.setText("Hide");
						}else{
							fldPass.setEchoChar('#');
							lblShow.setText("Show");
						}}});
		frm.add(show);

		JButton btnLog = new JButton("Sign in"); btnLog.setBounds(230,130,80,25); btnLog.setBackground(new Color(255, 67,67)); btnLog.setForeground(Color.white); btnLog.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		btnLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char[] urpass = fldPass.getPassword();
				String urEmail = fldEmail.getText();
				String CorEmail = "admin@pizzaLotsa.com";
				String CorPass = "admin";
				char[] corpass = CorPass.toCharArray();
				if(!urEmail.isEmpty() || urEmail.equals(CorEmail)) {
					if(Arrays.equals(urpass, corpass)) {
						JOptionPane.showMessageDialog(frm, "Welcome!","Notice", JOptionPane.INFORMATION_MESSAGE);
						frm.dispose();
						new MainUI();}
					else {	JOptionPane.showMessageDialog(frm, "Incorrect Email/ Password!","Notice", JOptionPane.ERROR_MESSAGE);
							fldEmail.setText("");
							fldPass.setText(""); }
				}else JOptionPane.showMessageDialog(frm, "Field must not be empty!","Notice", JOptionPane.ERROR_MESSAGE);}});
		frm.add(btnLog);
				
		try {
			Image img2 = ImageIO.read(this.getClass().getResource("google.png"));
			Image imgScld2 = img2.getScaledInstance(30,30, Image.SCALE_SMOOTH);
			ImageIcon imgIconG = new ImageIcon(imgScld2);
			JButton btnG = new JButton(imgIconG);	btnG.setBounds(280,185,30,30);	btnG.setOpaque(false);	btnG.setContentAreaFilled(false);	btnG.setBorderPainted(false);
			btnG.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(frm, "Account Signed In Successfully!","Notice", JOptionPane.INFORMATION_MESSAGE);
					frm.dispose();
					new MainUI();}});	frm.getContentPane().add(btnG);
			
			Image img3 = ImageIO.read(this.getClass().getResource("facebook.png"));
			Image imgScld3 = img3.getScaledInstance(65,40, Image.SCALE_SMOOTH);
			ImageIcon imgIconFB = new ImageIcon(imgScld3);
			JButton btnFB = new JButton(imgIconFB);	btnFB.setBounds(340,180,65,40);	btnFB.setOpaque(false);	btnFB.setContentAreaFilled(false); btnFB.setBorderPainted(false);
			btnFB.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(frm, "Account Signed In Successfully!","Notice", JOptionPane.INFORMATION_MESSAGE);
					frm.dispose();
					new MainUI();}}); frm.getContentPane().add(btnFB);		
		}catch(Exception e) {System.out.println("Something went wrong! -_^");}
		
		final JButton btnSign_Up = new JButton("Sign Up");
			btnSign_Up.setBounds(330,225,100,20); btnSign_Up.setOpaque(false); btnSign_Up.setContentAreaFilled(false); btnSign_Up.setBorderPainted(false); btnSign_Up.setForeground(new Color(255, 67,67));
			btnSign_Up.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnSign_Up){
					frm.dispose();
					new SignUp();}}});
		frm.add(btnSign_Up);
		
		frm.setSize(480,300); frm.setLayout(null); frm.setLocationRelativeTo(null); frm.setResizable(false); frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
		frm.setVisible(true);	
	}
	@Override
	public void actionPerformed(ActionEvent e) {}
}