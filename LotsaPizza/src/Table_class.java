import java.awt.*; import java.awt.event.ActionEvent; import java.awt.event.ActionListener; import javax.imageio.ImageIO; import javax.swing.*;

public class Table_class implements ActionListener{
	JFrame tbl;
	
	Table_class(){
		tbl = new JFrame("Table Selection");	tbl.setBounds(100, 100, 800, 320);	tbl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	tbl.setLayout(null); tbl.setLocationRelativeTo(null); tbl.setResizable(false);
		showTBL();
		tbl.setVisible(true);
	}

	void showTBL() {
		JPanel cont = new JPanel(new GridLayout(2,5));
		cont.setBounds(10, 10, 765, 240); tbl.add(cont);
		JPanel []pan = new JPanel[10];
		final JButton []btnimg = new JButton[10];
		JLabel []lbl_tbl = new JLabel[10];
		pan[0] = new JPanel();  pan[0].setBackground(new Color(255, 250, 250)); cont.add(pan[0]);
		pan[1] = new JPanel();  pan[1].setBackground(new Color(255, 245, 245)); cont.add(pan[1] );
		pan[2] = new JPanel();  pan[2].setBackground(new Color(255, 250, 250)); cont.add(pan[2] );
		pan[3] = new JPanel();  pan[3].setBackground(new Color(255, 245, 245)); cont.add(pan[3] );
		pan[4] = new JPanel();  pan[4].setBackground(new Color(255, 250, 250));cont.add(pan[4] );
		pan[5] = new JPanel();  pan[5].setBackground(new Color(255, 245, 245)); cont.add(pan[5] );
		pan[6] = new JPanel();  pan[6].setBackground(new Color(255, 250, 250)); cont.add(pan[6] );
		pan[7] = new JPanel();  pan[7].setBackground(new Color(255, 245, 245)); cont.add(pan[7] );
		pan[8] = new JPanel();  pan[8].setBackground(new Color(255, 250, 250)); cont.add(pan[8] );
		pan[9] = new JPanel();  pan[9].setBackground(new Color(255, 245, 245)); cont.add(pan[9] );
		
		String location [] = {"tbl1.png", "tbl2.png", "tbl3.png", "tbl4.png", "tbl5.png", "tbl6.png", "tbl7.png", "tbl8.png", "tbl9.png", "tbl10.png"};
		int num=1;
		
		for(int i=0; i<10; i++) {
			lbl_tbl[i]= new JLabel("");
			lbl_tbl[i].setText("Table" + num);
			lbl_tbl[i].setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
			num++;
			pan[i].add(lbl_tbl[i]);
			
			try {
				Image image1 = ImageIO.read(this.getClass().getResource(location[i]));
				Image imageScaled1 = image1.getScaledInstance(90, 70, Image.SCALE_SMOOTH);
				ImageIcon imageIcon1 = new ImageIcon(imageScaled1);
				btnimg[i] = new JButton(imageIcon1);
			}catch(Exception e) {System.out.println("Something went wrong! -_^");}
			btnimg[i].setSize(90,70);
			btnimg[i].setOpaque(false); btnimg[i].setContentAreaFilled(false);	btnimg[i].setBorderPainted(false);
			pan[i].add(btnimg[i]);
			
			btnimg[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int tblNum[]= {1,2,3,4,5,6,7,8,9,10};
					int ans;
					for(int i=0; i<10; i++) {
					if(e.getSource()==btnimg[i])
						{
							ans = JOptionPane.showConfirmDialog(tbl,  "You've selected Table " + tblNum[i],"Table Selection", JOptionPane.OK_CANCEL_OPTION);
							if(ans==JOptionPane.OK_OPTION) {
								tbl.dispose(); 
								new FoodMenu_DineIn_TakeOut();
							}
							break;
						}
					}
				}});
		}
		
		final JButton bck = new JButton("Back"); bck.setBounds(10,255,100,20); tbl.add(bck);
		bck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==bck) {
					tbl.dispose();
					new Mode_Order();
			}}});
	}
	public void actionPerformed(ActionEvent e) {}
}
