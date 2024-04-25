import java.awt.*; import java.awt.event.ActionEvent; import java.awt.event.ActionListener; import javax.imageio.ImageIO; import javax.swing.*;

public class FoodMenu_Delivery implements ActionListener{
	JFrame frm1, frm2, frm3;
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
	FoodMenu_Delivery(){ theInterface();}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
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
		
		for(int i =0; i<prdct.length; i++) {
			chck[i] += Integer.parseInt(qnty[i].getText());
			prtlQnty[i] = chck[i];
			if(prtlQnty[i]>0) {
				int total = prtlQnty[i]*prc[i];
				sum = sum + prtlQnty[i]*prc[i];
				cnvrt_subttl = String.valueOf(total);
				smmry.append(prdct[i]+cnvrt_subttl+" php"+"\n");
				smmry.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
				ttl_Pcs = ttl_Pcs + chck[i];
			}
			convert =String.valueOf(ttl_Pcs);
		}
		
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
					frm2.dispose();
					theInterface();
					for(int i=0; i<qnty.length; i++) {qnty[i].setText(StrngQ[i]);}
					sum = 0;
					ttl_Pcs = 0;
					chck[0] = 0; chck[1] = 0; chck[2] = 0; chck[3] = 0; chck[4] = 0; chck[5] = 0; chck[6] = 0;chck[7] = 0; chck[8] = 0;chck[9] = 0; chck[10] = 0; chck[11] = 0;
					chck[12] = 0; chck[13] = 0;chck[14] = 0; chck[15] = 0; chck[16] = 0; chck[17] = 0; chck[18] = 0; chck[19] = 0;chck[20] = 0; chck[21] = 0; chck[22] = 0;
				}
			}});
		
		final JButton next = new JButton("Next"); next.setBounds(200,430,100,20); frm2.add(next);
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==next) {
					String the_smmry = smmry.getText();
					if(the_smmry.isEmpty()) JOptionPane.showMessageDialog(frm2, "You havn't ordered anything yet!", "Notice", JOptionPane.ERROR_MESSAGE);
					else {
						frm2.setVisible(false);
						Fill_Up_Form();
					}
				}
			}});
		
		frm2.setBounds(100, 100, 325, 500);	frm2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); frm2.getContentPane().setLayout(null);	frm2.setLocationRelativeTo(null); frm2.setResizable(false);
		Container con = frm2.getContentPane();	con.setBackground(Color.white);
		frm2.setVisible(true);
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	void Fill_Up_Form(){
		frm3 = new JFrame("Delivery Details");
		guiShow();
		the_event();
		Container con = frm3.getContentPane(); con.setBackground(Color.white);
		frm3.setSize(315,480); frm3.setLayout(null); frm3.setLocationRelativeTo(null); frm3.setResizable(false); frm3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm3.setVisible(true);
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	void guiShow(){
		JLabel dlvryDet = new JLabel("Delivery Details"); 	dlvryDet.setBounds(10, 10, 129, 28);		dlvryDet.setFont(new Font("Tahoma", Font.BOLD, 15));	frm3.add(dlvryDet);
		JLabel Full_Nm = new JLabel("Full Name");			Full_Nm.setBounds(10, 60, 67, 13);			Full_Nm.setFont(new Font("Tahoma", Font.PLAIN, 13));	frm3.add(Full_Nm);
		
		JLabel Frst_Nm = new JLabel("First Name");			Frst_Nm.setBounds(10, 102, 67, 13);			Frst_Nm.setFont(new Font("Tahoma", Font.PLAIN, 10));	frm3.add(Frst_Nm);
		txt_Frst_Nm = new JTextField();						txt_Frst_Nm.setBounds(10, 79, 129, 19);		frm3.add(txt_Frst_Nm);	txt_Frst_Nm.setColumns(10);
		
		JLabel Lst_Nm = new JLabel("Last Name");			Lst_Nm.setBounds(149, 102, 67, 13);			Lst_Nm.setFont(new Font("Tahoma", Font.PLAIN, 10));		frm3.add(Lst_Nm);
		txt_Lst_Nm = new JTextField();						txt_Lst_Nm.setBounds(149, 79, 134, 19);		frm3.add(txt_Lst_Nm);	txt_Lst_Nm.setColumns(10);
		
		JLabel addrss = new JLabel("Address");				addrss.setBounds(10, 125, 67, 13);			addrss.setFont(new Font("Tahoma", Font.PLAIN, 13));		frm3.add(addrss);
		txt_addrss = new JTextField();						txt_addrss.setBounds(10, 139, 273, 19);		frm3.add(txt_addrss);	txt_addrss.setColumns(10);
		
		JLabel Strt_adddrs = new JLabel("Street Address");	Strt_adddrs.setBounds(10, 168, 96, 13);		Strt_adddrs.setFont(new Font("Tahoma", Font.PLAIN, 13));frm3.add(Strt_adddrs);
		txt_Strt_adddrs = new JTextField();					txt_Strt_adddrs.setBounds(10, 182, 273, 19);frm3.add(txt_Strt_adddrs);	txt_Strt_adddrs.setColumns(10);
		
		JLabel Strt_adddrs1 = new JLabel("Street Address Line 2");	Strt_adddrs1.setBounds(10, 209, 129, 13);	Strt_adddrs1.setFont(new Font("Tahoma", Font.PLAIN, 13));	frm3.add(Strt_adddrs1);
		
		JLabel city = new JLabel("City");				city.setBounds(10, 242, 45, 13);			frm3.add(city);
		txt_city = new JTextField();					txt_city.setBounds(10, 223, 129, 19);		frm3.add(txt_city);	txt_city.setColumns(10);
		
		JLabel prvnce = new JLabel("State/Province");	prvnce.setBounds(149, 242, 113, 13);		frm3.add(prvnce);
		txt_prvnce = new JTextField();					txt_prvnce.setBounds(149, 223, 134, 19);	frm3.add(txt_prvnce);	txt_prvnce.setColumns(10);
		
		JLabel zip_cd = new JLabel("Zip Code");			zip_cd.setBounds(10, 280, 55, 13);			frm3.add(zip_cd);
		txt_zip_cd = new JTextField();					txt_zip_cd.setBounds(10, 258, 129, 19);		frm3.add(txt_zip_cd);	txt_zip_cd.setColumns(10);
		
		JLabel phn_Num = new JLabel("Phone Number");	phn_Num.setBounds(10, 303, 113, 13);		phn_Num.setFont(new Font("Tahoma", Font.PLAIN, 13));frm3.add(phn_Num);
		txt_phn_Num = new JTextField();					txt_phn_Num.setBounds(10, 321, 129, 19);	frm3.add(txt_phn_Num);	txt_phn_Num.setColumns(10);
		
		JLabel eml = new JLabel("E-mail");				eml.setBounds(10, 345, 45, 13);				eml.setFont(new Font("Tahoma", Font.PLAIN, 13));	frm3.add(eml);
		txt_eml = new JTextField();						txt_eml.setBounds(10, 362, 129, 19);		frm3.add(txt_eml);	txt_eml.setColumns(10);
		
		bck = new JButton("Back");				bck.setBounds(10,410,100,20);			frm3.add(bck);
		place_rdr = new JButton("Place Order");	place_rdr.setBounds(180,410,110,20);	frm3.add(place_rdr);
		
		JLabel lbl_pmnt = new JLabel("Payment Method");	lbl_pmnt.setBounds(149, 303, 113, 13);		lbl_pmnt.setFont(new Font("Tahoma", Font.PLAIN, 13));frm3.add(lbl_pmnt);
		Cash = new JRadioButton("Cash");   Cash.setBounds(149,318,80,20); frm3.add(Cash); 	Cash.setOpaque(false);
		GCash = new JRadioButton("GCash"); GCash.setBounds(149,338,80,20); frm3.add(GCash);	GCash.setOpaque(false);
		ButtonGroup pay_m = new ButtonGroup();
		pay_m.add(Cash); pay_m.add(GCash);
		
		frmGCash = new JFrame("GCash");
		frmGCash.setSize(300,200-30); frmGCash.setLayout(null); frmGCash.setLocationRelativeTo(null); frmGCash.setResizable(false);
		frmGCash.setVisible(false);
		
		JPanel panel = new JPanel();						 panel.setBounds(0, 0, 300, 200); 	 panel.setLayout(null); panel.setBackground(Color.CYAN); frmGCash.add(panel);
		JLabel lbl_Num = new JLabel("Enter GCash Number: "); lbl_Num.setBounds(10, 10, 123, 13); lbl_Num.setFont(new Font("Tahoma", Font.PLAIN, 12)); panel.add(lbl_Num);
		
		txt_Num = new JTextField(); 				 txt_Num.setBounds(10, 39, 215, 19); panel.add(txt_Num);
		ok_btn = new JButton("Ok"); 						 ok_btn.setBounds(174, 132-30, 85, 21); panel.add(ok_btn);
		ok_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num = txt_Num.getText();
				if (e.getSource()==ok_btn) 	{
					if (num.isEmpty()) JOptionPane.showMessageDialog(frmGCash, "Please enter valid GCash Number!", "Notice", JOptionPane.ERROR_MESSAGE);
					else frmGCash.setVisible(false);		
				}
			}});
	}
	
	JFrame frmGCash;
	JTextField txt_Num;
	JTextField txt_Frst_Nm, txt_Lst_Nm, txt_addrss, txt_Strt_adddrs, txt_city, txt_prvnce, txt_zip_cd, txt_cntry, txt_phn_Num, txt_eml;
	JButton bck, place_rdr, ok_btn;
	JRadioButton Cash, GCash;
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	void the_event() {
		Cash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String txt1=txt_Frst_Nm.getText(); String txt2=txt_Lst_Nm.getText(); String txt3=txt_addrss.getText(); String txt4=txt_Strt_adddrs.getText(); String txt5=txt_city.getText();
				String txt6=txt_prvnce.getText(); String txt7=txt_zip_cd.getText(); String txt8=txt_phn_Num.getText(); String txt9=txt_eml.getText();
				if (Cash.isSelected() && !txt1.isEmpty() || !txt2.isEmpty() || !txt3.isEmpty() || !txt4.isEmpty() || !txt5.isEmpty() || !txt6.isEmpty() || !txt7.isEmpty() || !txt8.isEmpty() || !txt9.isEmpty()) {
					place_rdr.setBackground(Color.RED);
					place_rdr.setForeground(Color.WHITE);
				}else {
					place_rdr.setBackground(Color.GRAY);
					place_rdr.setForeground(Color.BLACK);
				}
			}});
		
		GCash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (GCash.isSelected()) frmGCash.setVisible(true);
			}});
		
		ok_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num = txt_Num.getText();
				String txt1=txt_Frst_Nm.getText(); String txt2=txt_Lst_Nm.getText(); String txt3=txt_addrss.getText(); String txt4=txt_Strt_adddrs.getText(); String txt5=txt_city.getText();
				String txt6=txt_prvnce.getText(); String txt7=txt_zip_cd.getText(); String txt8=txt_phn_Num.getText(); String txt9=txt_eml.getText();
				if (e.getSource()==ok_btn) {	
					if(!num.isEmpty() && !txt1.isEmpty() || !txt2.isEmpty() || !txt3.isEmpty() || !txt4.isEmpty() || !txt5.isEmpty() || !txt6.isEmpty() || !txt7.isEmpty() || !txt8.isEmpty() || !txt9.isEmpty()) {
						frmGCash.setVisible(false);
						place_rdr.setBackground(Color.RED);
						place_rdr.setForeground(Color.WHITE);
					}
				}
			}});

		bck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==bck) {
					frm3.setVisible(false);
					frm2.setVisible(true);
					place_rdr.setBackground(Color.GRAY);
					place_rdr.setForeground(Color.BLACK);
				}
			}});
		
		place_rdr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String txt1=txt_Frst_Nm.getText(); String txt2=txt_Lst_Nm.getText(); String txt3=txt_addrss.getText(); String txt4=txt_Strt_adddrs.getText(); String txt5=txt_city.getText();
			String txt6=txt_prvnce.getText(); String txt7=txt_zip_cd.getText(); String txt8=txt_phn_Num.getText(); String txt9=txt_eml.getText();
				if (e.getSource()==place_rdr) {
						if(txt1.isEmpty() || txt2.isEmpty() || txt3.isEmpty() || txt4.isEmpty() || txt5.isEmpty() || txt6.isEmpty() || txt7.isEmpty() || txt8.isEmpty() || txt9.isEmpty()) {
							JOptionPane.showMessageDialog(frm3, "Field must not be empty!", "Notice", JOptionPane.ERROR_MESSAGE);	
						}
						else {
							if(!Cash.isSelected() && !GCash.isSelected()) JOptionPane.showMessageDialog(frm3, "You haven't selected any payment method!", "Notice", JOptionPane.ERROR_MESSAGE);
							else {
							int user_ans = JOptionPane.showConfirmDialog(frm3, "Would you like to place your order now?","Select an Option", JOptionPane.OK_CANCEL_OPTION);
							if(user_ans==JOptionPane.OK_OPTION) {
								JOptionPane.showMessageDialog(frm3, "Thank you!", "Lots'a Pizza", JOptionPane.INFORMATION_MESSAGE);
								frm3.dispose();
								new MainUI();
								}
							else JOptionPane.showMessageDialog(frm3, "Cancelled", "Lots'a Pizza", JOptionPane.INFORMATION_MESSAGE);
							}
						}
						
					
				}
			}});	
	}
}