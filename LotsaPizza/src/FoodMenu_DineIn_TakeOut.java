import java.awt.*; import java.awt.event.ActionEvent; import java.awt.event.ActionListener; import javax.imageio.ImageIO; import javax.swing.*;

public class FoodMenu_DineIn_TakeOut implements ActionListener{
	JFrame frm1, frm2;
	JPanel panel1, panel2, panel3;//container of three tabs
	JTextArea smmry;
	int sum = 0;//revealed the total amount of selected items
	String convert, cnvrt_subttl;
	boolean toVrfy;
	JButton nxt;
	String [] StrngQ = new String[23];//container of textfield to string
	JTextField []qnty = new JTextField[23];//container of quantity based on users
	int []prtlQnty = new int[23]; //final container of quantity based on users
	int []prc =	   {389,389,410, //prices for products
            		230,265,350,
            		230,265,350,
            		230,265,350,
            		325,400,
            		210,245,315,
            		210,245,315,
            		210,245,315};
	int chck[] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	String[] prdct = {
			"    Pure Beef Supreme...................................",
			"    Hawaiian Extreme.....................................",
			"    Manhattan De Luxe..................................",
			"    Just Pepperoni Medium...........................",
			"    Just Pepperoni Large................................",
			"    Just Pepperoni Extra Large.......................",
			"    Pure Beef Special Medium........................",
			"    Pure Beef Special Large.............................",
			"    Pure Beef Special Extra Large...................",
			"    Hawaiian Delight Medium........................",
			"    Hawaiian Delight Large.............................",
			"    Hawaiian Delight Extra Large..................",
			"    Great Manhattan Large............................",
			"    Great Manhattan Extra Large..................",
			"    Roast Beef 'N Cheese Medium................",
			"    Roast Beef 'N Cheese Large.....................",
			"    Roast Beef 'N Cheese Extra Large...........",
			"    Double wHAMmy Medium......................",
			"    Double wHAMmy Large...........................",
			"    Double wHAMmy Extra Large.................",
			"    Bacon Blaze Medium................................",
			"    Bacon Blaze Large....................................",
			"    Bacon Blaze Extra Large.........................."    };
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	FoodMenu_DineIn_TakeOut(){ theInterface();}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	void theInterface(){
		frm1 = new JFrame("Main Menu ");	frm1.setBounds(100, 100, 680, 440);	frm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	frm1.getContentPane().setLayout(null);	frm1.setLocationRelativeTo(null);	frm1.setResizable(false);
		Container con = frm1.getContentPane();	con.setBackground(Color.white);
		
		panel1 = new JPanel();		panel1.setLayout(null);		panel1.setBackground(Color.white);
		panel2 = new JPanel();		panel2.setLayout(null);		panel2.setBackground(Color.white);
		panel3 = new JPanel();		panel3.setLayout(null);		panel3.setBackground(Color.white);
		JTabbedPane tab = new JTabbedPane();
					tab.setBounds(10,0,645,390-40);
					tab.add("Premium", panel1);	tab.add("Best Seller", panel2);	tab.add("Classics", panel3);
			frm1.add(tab);
			premium();	bestSellers();	classics();//launch the 3 tabs

		final JButton rst = new JButton("Reset"); rst.setBounds(290,395-40,100,30);	
		rst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==rst){
					for(int i=0; i<qnty.length; i++) {
						qnty[i].setText(null);
						chck[i] = 0;
					}
				}
			}
		});
		frm1.add(rst);
		
		nxt = new JButton("Next"); nxt.setBounds(555,395-40,100,30);	
		nxt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==nxt)
					frm1.setVisible(false);
					for(int i=0; i<qnty.length; i++) {
						StrngQ[i] = qnty[i].getText();
							if (StrngQ[i].isEmpty()) {
								qnty[i].setText("0");
								toVrfy = true;
							}
						}if(toVrfy==true) frmSmmry();
			}
		});
		frm1.add(nxt);		
		
		final JButton bck = new JButton("Back"); bck.setBounds(10,395-40,100,30);	
		bck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==bck) {
					frm1.dispose();
					new Mode_Order();
				}
			}
		});
		frm1.add(bck);
		
		frm1.setVisible(true);
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	void premium() {
		String [] locate = {"PureBeefSupreme.png","HawaiianSupreme.png","ManhattanDeluxeSupreme.png"};
		JLabel []lblimg = new JLabel[3];
		JLabel beefSup, hawExt,deLux;
		JLabel pbs,haw,man;
		JLabel lblQ1, lblQ2, lblQ3;
		int prmBndY = 40;

		for (int i=0; i<locate.length; i++) {
			try {
				Image image = ImageIO.read(this.getClass().getResource(locate[i]));
				Image imageScaled = image.getScaledInstance(200, 150, Image.SCALE_SMOOTH);
				ImageIcon imageIcon = new ImageIcon(imageScaled);
				lblimg[i] = new JLabel(imageIcon);
			}catch(Exception e) {System.out.println("Something went wrong! -_^");}
		}
			
		lblimg[0].setBounds(0,prmBndY,200,150);		panel1.add(lblimg[0]);
		lblimg[1].setBounds(215,prmBndY,200,150);	panel1.add(lblimg[1]);
		lblimg[2].setBounds(435,prmBndY,200,150);	panel1.add(lblimg[2]);
			
		beefSup = new JLabel("Pure Beef Supreme"); 	   beefSup.setBounds(40,230-40,120,20);	 	panel1.add(beefSup);
		hawExt = new JLabel("Hawaiian Supreme");	   hawExt.setBounds(265,230-40,120,20);   	panel1.add(hawExt);
		deLux = new JLabel("Manhattan DeluxeSupreme"); deLux.setBounds(475,230-40,180,20); 	 	panel1.add(deLux);
			
		lblQ1 = new JLabel("Quantity: ");		lblQ1.setBounds(40+50,250-40,100,20);		panel1.add(lblQ1);
		lblQ2 = new JLabel("Quantity: ");		lblQ2.setBounds(265+50,250-40,100,20);		panel1.add(lblQ2);
		lblQ3 = new JLabel("Quantity: ");		lblQ3.setBounds(475+50,250-40,100,20);		panel1.add(lblQ3);
		
		pbs = new JLabel("Php 389");	pbs.setBounds(40,250-20,70,20);			panel1.add(pbs);
		haw = new JLabel("Php 389");	haw.setBounds(265,250-20,70,20);		panel1.add(haw);
		man = new JLabel("Php 410");	man.setBounds(475,250-20,70,20);		panel1.add(man);
		
		qnty[0] = new JTextField();		qnty[0].setBounds(95,260-30,30,20);		panel1.add(qnty[0]);
		qnty[1] = new JTextField();		qnty[1].setBounds(320,260-30,30,20);	panel1.add(qnty[1]);
		qnty[2] = new JTextField();		qnty[2].setBounds(530,260-30,30,20);	panel1.add(qnty[2]);

	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	void bestSellers() {
		String [] locate1 = {"JustPepperoni.png","PureBeefSpecial.png","HawaiianDelight.png","GreatManhattan.png"};
		JLabel []lblimg1 = new JLabel[4];
		JLabel pepp, beefSp, hawDel, manh;
		JLabel peppM,peppL,peppEL,  beefSpM,beefSpL,beefSpEL,  hawDelM,hawDelL,hawDelEL,  manhL,manhEL;
		JLabel lblQ1, lblQ2, lblQ3, lblQ4;
		int bstBndY = 40;
		
		for (int i=0; i<locate1.length; i++) {
			try {
				Image image1 = ImageIO.read(this.getClass().getResource(locate1[i]));
				Image imageScaled1 = image1.getScaledInstance(180, 130, Image.SCALE_SMOOTH);
				ImageIcon imageIcon1 = new ImageIcon(imageScaled1);
				lblimg1[i] = new JLabel(imageIcon1);
			}catch(Exception e) {System.out.println("Something went wrong! -_^");}
		}
		
		lblimg1[0].setBounds(0,bstBndY,180,130);		panel2.add(lblimg1[0]);
		lblimg1[1].setBounds(150,bstBndY,180,130);		panel2.add(lblimg1[1]);
		lblimg1[2].setBounds(310,bstBndY,180,130);		panel2.add(lblimg1[2]);
		lblimg1[3].setBounds(465,bstBndY,180,130);		panel2.add(lblimg1[3]);
		
		pepp = new JLabel("Just Pepperoni");		pepp.setBounds(40,210-40,120,20);		panel2.add(pepp);
		beefSp = new JLabel("Pure Beef Special");	beefSp.setBounds(190,210-40,120,20);	panel2.add(beefSp);
		hawDel = new JLabel("Hawaiian Delight");	hawDel.setBounds(350,210-40,180,20);	panel2.add(hawDel);
		manh = new JLabel("Great Manhattan");		manh.setBounds(505,210-40,180,20);		panel2.add(manh);
		
		lblQ1 = new JLabel("Quantity: ");	lblQ1.setBounds(70+30,230-40,100,20);		panel2.add(lblQ1);
		lblQ2 = new JLabel("Quantity: ");	lblQ2.setBounds(210+40,230-40,100,20);		panel2.add(lblQ2);
		lblQ3 = new JLabel("Quantity: ");	lblQ3.setBounds(370+40,230-40,100,20);		panel2.add(lblQ3);
		lblQ4 = new JLabel("Quantity: ");	lblQ4.setBounds(555,230-40,100,20);			panel2.add(lblQ4);   
		
		peppM = new JLabel("Php 230  M");	peppM.setBounds(40,250-40,70,20);		panel2.add(peppM);
		peppL = new JLabel("Php 265  L");	peppL.setBounds(40,270-40,70,20);		panel2.add(peppL);
		peppEL = new JLabel("Php 350 XL");	peppEL.setBounds(40,290-40,70,20);		panel2.add(peppEL);
		
		beefSpM = new JLabel("Php 230  M");		beefSpM.setBounds(190,250-40,70,20);		panel2.add(beefSpM);
		beefSpL = new JLabel("Php 265  L");		beefSpL.setBounds(190,270-40,70,20);		panel2.add(beefSpL);
		beefSpEL = new JLabel("Php 350 XL");	beefSpEL.setBounds(190,290-40,70,20);		panel2.add(beefSpEL);
		
		hawDelM = new JLabel("Php 230  M");		hawDelM.setBounds(350,250-40,70,20);		panel2.add(hawDelM);
		hawDelL = new JLabel("Php 265  L");		hawDelL.setBounds(350,270-40,70,20);		panel2.add(hawDelL);
		hawDelEL = new JLabel("Php 350 XL");	hawDelEL.setBounds(350,290-40,70,20);		panel2.add(hawDelEL);
		
		manhL = new JLabel("Php 325  L");		manhL.setBounds(535-30,250-40,70,20);		panel2.add(manhL);
		manhEL = new JLabel("Php 400 XL");		manhEL.setBounds(535-30,270-40,70,20);		panel2.add(manhEL); 
		
		qnty[3]  = new JTextField();		qnty[3].setBounds(70+35,250-40,30,20);		panel2.add(qnty[3]);
		qnty[4]  = new JTextField();		qnty[4].setBounds(70+35,270-40,30,20);		panel2.add(qnty[4]);
		qnty[5]  = new JTextField();		qnty[5].setBounds(70+35,290-40,30,20);		panel2.add(qnty[5]);
		qnty[6]  = new JTextField();		qnty[6].setBounds(210+45,250-40,30,20);		panel2.add(qnty[6]);
		qnty[7]  = new JTextField();		qnty[7].setBounds(210+45,270-40,30,20);		panel2.add(qnty[7]);
		qnty[8]  = new JTextField();		qnty[8].setBounds(210+45,290-40,30,20);		panel2.add(qnty[8]);
		qnty[9]  = new JTextField();		qnty[9].setBounds(370+45,250-40,30,20);		panel2.add(qnty[9]);
		qnty[10] = new JTextField();		qnty[10].setBounds(370+45,270-40,30,20);	panel2.add(qnty[10]);
		qnty[11] = new JTextField();		qnty[11].setBounds(370+45,290-40,30,20);	panel2.add(qnty[11]);
		qnty[12] = new JTextField();		qnty[12].setBounds(555+15,250-40,30,20);		panel2.add(qnty[12]);
		qnty[13] = new JTextField();		qnty[13].setBounds(555+15,270-40,30,20);		panel2.add(qnty[13]);	 
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	void classics() {
		String [] locate2 = {"RoastBeefNCheese.png","DoubleWhammy.png","BaconBlaze.png"};
		JLabel []lblimg2 = new JLabel[4];
		JLabel rst, wmmy, bcn;
		JLabel lblQ1, lblQ2, lblQ3;
		JLabel rstM,rstL,rstEL,  wmmyM,wmmyL,wmmyEL,  bcnM,bcnL,bcnEL;
		int clsscBndY = 40;
		
		for (int i=0; i<locate2.length; i++) {
			try {
				Image image2 = ImageIO.read(this.getClass().getResource(locate2[i]));
				Image imageScaled2 = image2.getScaledInstance(200, 150, Image.SCALE_SMOOTH);
				ImageIcon imageIcon2 = new ImageIcon(imageScaled2);
				lblimg2[i] = new JLabel(imageIcon2);
			}catch(Exception e) {System.out.println("Something went wrong! -_^");}
		}
		
		lblimg2[0].setBounds(0,clsscBndY,200,150);		panel3.add(lblimg2[0]);
		lblimg2[1].setBounds(220,clsscBndY,200,150);	panel3.add(lblimg2[1]);
		lblimg2[2].setBounds(440,clsscBndY,200,150);	panel3.add(lblimg2[2]);
		
		rst = new JLabel("Roast Beef N Cheese");	rst.setBounds(40,230-40,120,20);		panel3.add(rst);
		wmmy = new JLabel("Double Whammy");			wmmy.setBounds(265,230-40,120,20);		panel3.add(wmmy);
		bcn = new JLabel("Bacon Blaze");			bcn.setBounds(505,230-40,180,20);		panel3.add(bcn);
		
		lblQ1 = new JLabel("Quantity: ");		lblQ1.setBounds(70,250-40,100,20);		panel3.add(lblQ1);
		lblQ2 = new JLabel("Quantity: ");		lblQ2.setBounds(285,250-40,100,20);		panel3.add(lblQ2);
		lblQ3 = new JLabel("Quantity: ");		lblQ3.setBounds(525,250-40,100,20);		panel3.add(lblQ3);
		
		rstM = new JLabel("Php 210  M");		rstM.setBounds(40,270-40,70,20);		panel3.add(rstM);
		rstL = new JLabel("Php 245  L");		rstL.setBounds(40,290-40,70,20);		panel3.add(rstL);
		rstEL = new JLabel("Php 315 XL");		rstEL.setBounds(40,310-40,70,20);		panel3.add(rstEL);
		
		wmmyM = new JLabel("Php 210  M");	wmmyM.setBounds(265,270-40,70,20);	panel3.add(wmmyM);
		wmmyL = new JLabel("Php 245  L");	wmmyL.setBounds(265,290-40,70,20);	panel3.add(wmmyL);
		wmmyEL = new JLabel("Php 315 XL");	wmmyEL.setBounds(265,310-40,70,20);	panel3.add(wmmyEL);
		
		bcnM = new JLabel("Php 210  M");		bcnM.setBounds(505,270-40,70,20);	panel3.add(bcnM);
		bcnL = new JLabel("Php 245  L");		bcnL.setBounds(505,290-40,70,20);	panel3.add(bcnL);
		bcnEL = new JLabel("Php 315 XL");		bcnEL.setBounds(505,310-40,70,20);	panel3.add(bcnEL);
	
		qnty[14] = new JTextField();		qnty[14].setBounds(70+35,270-40,30,20);		panel3.add(qnty[14]);
		qnty[15] = new JTextField();		qnty[15].setBounds(70+35,290-40,30,20);		panel3.add(qnty[15]);
		qnty[16] = new JTextField();		qnty[16].setBounds(70+35,310-40,30,20);		panel3.add(qnty[16]);
		qnty[17] = new JTextField();		qnty[17].setBounds(285+45,270-40,30,20);	panel3.add(qnty[17]);
		qnty[18] = new JTextField();		qnty[18].setBounds(285+45,290-40,30,20);	panel3.add(qnty[18]);
		qnty[19] = new JTextField();		qnty[19].setBounds(285+45,310-40,30,20);	panel3.add(qnty[19]);
		qnty[20] = new JTextField();		qnty[20].setBounds(525+45,270-40,30,20);	panel3.add(qnty[20]);
		qnty[21] = new JTextField();		qnty[21].setBounds(525+45,290-40,30,20);	panel3.add(qnty[21]);
		qnty[22] = new JTextField();		qnty[22].setBounds(525+45,310-40,30,20);	panel3.add(qnty[22]);
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public void actionPerformed(ActionEvent e) {}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	int ttl_Pcs = 0;
public void frmSmmry() {
		frm2 = new JFrame("Summary");
		smmry = new JTextArea(); smmry.setBounds(10,0,290,370); smmry.setEditable(false); smmry.setBackground(new Color(247,247,247)); frm2.add(smmry);
		
		try {
		chck[0] += Integer.parseInt(qnty[0].getText());  chck[1] += Integer.parseInt(qnty[1].getText());  chck[2] += Integer.parseInt(qnty[2].getText());  chck[3] += Integer.parseInt(qnty[3].getText());  chck[4] += Integer.parseInt(qnty[4].getText());  chck[5] += Integer.parseInt(qnty[5].getText());  chck[6] += Integer.parseInt(qnty[6].getText());
		chck[7] += Integer.parseInt(qnty[7].getText());  chck[8] += Integer.parseInt(qnty[8].getText());  chck[9]+= Integer.parseInt(qnty[9].getText());  chck[10]+= Integer.parseInt(qnty[10].getText()); chck[11]+= Integer.parseInt(qnty[11].getText()); chck[12]+= Integer.parseInt(qnty[12].getText()); chck[13]+= Integer.parseInt(qnty[13].getText()); chck[14]+= Integer.parseInt(qnty[14].getText());
		chck[15]+= Integer.parseInt(qnty[15].getText()); chck[16]+= Integer.parseInt(qnty[16].getText()); chck[17]+= Integer.parseInt(qnty[17].getText()); chck[18]+= Integer.parseInt(qnty[18].getText()); chck[19]+= Integer.parseInt(qnty[19].getText()); chck[20]+= Integer.parseInt(qnty[20].getText()); chck[21]+= Integer.parseInt(qnty[21].getText()); chck[22]+= Integer.parseInt(qnty[22].getText());
		
		prtlQnty[0]  = chck[0];  prtlQnty[1]  = chck[1];  prtlQnty[2]  = chck[2];  prtlQnty[3]  = chck[3];  prtlQnty[4]  = chck[4];  prtlQnty[5]  = chck[5];  prtlQnty[6]  = chck[6];  prtlQnty[7]  = chck[7];  prtlQnty[8]  = chck[8];  prtlQnty[9]  = chck[9]; prtlQnty[10] = chck[10]; prtlQnty[11] = chck[11]; 
		prtlQnty[12] = chck[12]; prtlQnty[13] = chck[13]; prtlQnty[14] = chck[14]; prtlQnty[15] = chck[15]; prtlQnty[16] = chck[16]; prtlQnty[17] = chck[17]; prtlQnty[18] = chck[18]; prtlQnty[19] = chck[19]; prtlQnty[20] = chck[20]; prtlQnty[21] = chck[21]; prtlQnty[22] = chck[22];
		
		for(int i =0; i<prdct.length; i++) {
			if(prtlQnty[i]>0) {
				int total = prtlQnty[i]*prc[i];
				sum = sum + prtlQnty[i]*prc[i];
				cnvrt_subttl = String.valueOf(total);
				smmry.append(prdct[i]+cnvrt_subttl+" php"+"\n");
				smmry.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
				ttl_Pcs = ttl_Pcs + chck[i];
			}
		}
		convert =String.valueOf(ttl_Pcs);
		}catch(NumberFormatException e1) {
			JOptionPane.showMessageDialog(frm2, "Please Enter Valid Number for Quantity!", "Notice", JOptionPane.ERROR_MESSAGE);
			for(int i =0; i<prdct.length; i++) {
				qnty[i].setText("0");
			}
			frmSmmry();
			frm2.setVisible(false);
		}
		
		JLabel ttl = new JLabel("Total Amount:");		ttl.setBounds(150,380,90,20);		frm2.add(ttl);
		JLabel totalPHP = new JLabel("");				totalPHP.setBounds(230,380,90,20);	frm2.add(totalPHP);
		totalPHP.setText(sum + ".00" + " php");
		
		JLabel pcs = new JLabel("Total Pieces:");		pcs.setBounds(10,380,80,20);		frm2.add(pcs);
		JLabel totalpcs = new JLabel("");		totalpcs.setBounds(90,380,90,20);	frm2.add(totalpcs);
		if (convert.equals("1")) totalpcs.setText(convert + "pc.");
		else if (convert.equals("0")) totalpcs.setText(convert + "");
		else totalpcs.setText(convert + "pcs.");
		
		final JButton bck = new JButton("Back"); bck.setBounds(10,430,100,20); frm2.add(bck);
		bck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==bck) {
					nxt_swtch_func=false;
					frm2.dispose();
					theInterface();
					for(int i=0; i<qnty.length; i++) {
						qnty[i].setText(StrngQ[i]);
						chck[i] = 0;
						}
					sum = 0;
					ttl_Pcs = 0;
					
				}
			}});
		
		next = new JButton("Next"); next.setBounds(200,430,100,20); frm2.add(next);
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==next) {	
					String the_smmry = smmry.getText();
					if(the_smmry.isEmpty()) JOptionPane.showMessageDialog(frm2, "You havn't ordered anything yet!", "Notice", JOptionPane.ERROR_MESSAGE);
					else {
						if(nxt_swtch_func==false) pymnt_meth();
	
					}
				}
				if(nxt_swtch_func==false) {
					next.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent a) {
							if (a.getSource()==next) {
								int user_ans = JOptionPane.showConfirmDialog(frm2, "Would you like to place your order now?","Select an Option", JOptionPane.OK_CANCEL_OPTION);
								if(user_ans==JOptionPane.OK_OPTION) {
									JOptionPane.showMessageDialog(frm2, "Thank you!", "Lots'a Pizza", JOptionPane.INFORMATION_MESSAGE);
									frm2.dispose();
									new MainUI();
									}
								else JOptionPane.showMessageDialog(frm2, "Cancelled", "Lots'a Pizza", JOptionPane.INFORMATION_MESSAGE);
							}
						}});
				}
			}});
		
		frm2.setBounds(100, 100, 325, 500);	frm2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); frm2.getContentPane().setLayout(null);	frm2.setLocationRelativeTo(null); frm2.setResizable(false);
		Container con = frm2.getContentPane();	con.setBackground(Color.white);
		frm2.setVisible(true);
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
boolean nxt_swtch_func = false;
JFrame frmPaymeth;
JButton next, plcOrder;
	void pymnt_meth() {
		frmPaymeth = new JFrame("Payment Method");
		frmPaymeth.setBounds(620,300,300,200-30); frmPaymeth.getContentPane().setLayout(null); frmPaymeth.setLocationRelativeTo(null); frmPaymeth.setResizable(false);
		frmPaymeth.setVisible(true);

		JLabel lblSPM = new JLabel("Please select your payment method: ");	lblSPM.setBounds(23, 22, 207, 21);		lblSPM.setFont(new Font("Tahoma", Font.PLAIN, 12));		frmPaymeth.add(lblSPM);
		final JRadioButton rdbtn_cash = new JRadioButton("Cash");					rdbtn_cash.setBounds(91, 47, 103, 21);	rdbtn_cash.setFont(new Font("Tahoma", Font.BOLD, 12));	rdbtn_cash.setOpaque(false);	frmPaymeth.add(rdbtn_cash);
		final JRadioButton rdbtn_Gcash = new JRadioButton("GCash");				rdbtn_Gcash.setBounds(91, 68, 103, 21);	rdbtn_Gcash.setFont(new Font("Tahoma", Font.BOLD, 12));	rdbtn_Gcash.setOpaque(false);	frmPaymeth.add(rdbtn_Gcash);
		ButtonGroup pay_m = new ButtonGroup();
		pay_m.add(rdbtn_cash); pay_m.add(rdbtn_Gcash);

		final JButton ok_btn_frmPaymeth = new JButton("Ok");	ok_btn_frmPaymeth.setBounds(191, 100, 85, 21);	frmPaymeth.add(ok_btn_frmPaymeth);
		ok_btn_frmPaymeth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==ok_btn_frmPaymeth) {
					if(!rdbtn_cash.isSelected() && !rdbtn_Gcash.isSelected()) {
						JOptionPane.showMessageDialog(frmPaymeth, "You haven't selected any payment method!", "Notice", JOptionPane.ERROR_MESSAGE);
					}else {
						if(rdbtn_Gcash.isSelected()) {
							frmPaymeth.setVisible(false);
							gcashfrm();
						}
						else if  (rdbtn_cash.isSelected()){
							frmPaymeth.dispose();
							nxt_swtch_func = true;
							next.setText("Place Order");
							next.setBounds(180,430,120,20);
							next.setBackground(Color.red);
							next.setForeground(Color.WHITE);
						}
					}
				}
			}});
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	JTextField txt_Num;
	JRadioButton Cash, GCash;
	JButton ok_btn_frmGCash;
		void gcashfrm() {
			final JFrame frmGCash = new JFrame("GCash");
			frmGCash.setSize(300,200-30); frmGCash.setLayout(null); frmGCash.setLocationRelativeTo(null); frmGCash.setResizable(false);
			frmGCash.setVisible(true);

			JPanel panel = new JPanel();						 panel.setBounds(0, 0, 300, 200); 	 panel.setLayout(null); panel.setBackground(Color.CYAN); frmGCash.add(panel);
			JLabel lbl_Num = new JLabel("Enter GCash Number: "); lbl_Num.setBounds(10, 10, 123, 13); lbl_Num.setFont(new Font("Tahoma", Font.PLAIN, 12)); panel.add(lbl_Num);

			txt_Num = new JTextField(); 	txt_Num.setBounds(10, 39, 215, 19); panel.add(txt_Num);
			ok_btn_frmGCash = new JButton("Ok"); 	ok_btn_frmGCash.setBounds(174, 132-30, 85, 21); panel.add(ok_btn_frmGCash);
			ok_btn_frmGCash.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String num = txt_Num.getText();
					if (e.getSource()==ok_btn_frmGCash) 	{
						if (num.isEmpty()) {
							JOptionPane.showMessageDialog(frmGCash, "Please enter valid GCash Number!", "Notice", JOptionPane.ERROR_MESSAGE);
						}else {
							frmGCash.setVisible(false);
							nxt_swtch_func = true;
							frmPaymeth.dispose();
							frmGCash.dispose();
							next.setText("Place Order");
							next.setBounds(180,430,120,20);
							next.setBackground(Color.red);
							next.setForeground(Color.WHITE);
						}
							
					}
				}});
			
			
		}
}
