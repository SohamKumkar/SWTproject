package com.ITBazar.swt;

import org.apache.log4j.Logger;
//import org.apache.log4j.Logger;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;



public class LoginShell extends Shell {
	Shell shell = this;
	private static final Logger logger = Logger.getLogger(LoginShell.class);
	//private static final Logger logger1= Logger.getRootLogger();
	public static void main(String[] args)
	{
	 try
	 {
		 Display display= new Display();
		 LoginShell shell = new LoginShell(display);
		 shell.open();
		 shell.layout();
		 while(!shell.isDisposed())
			{
				if(!display.readAndDispatch())
				{
					display.sleep();
				}
			}
		 display.dispose();
	 } catch (Exception e){
		 e.printStackTrace();
	 }
	}
	
	public LoginShell(Display display)
	{
		super(display, SWT.SHELL_TRIM);
		createContents();
	}
	
	protected void createContents()
	{
		shell.setLayout(new GridLayout(2, false));
		shell.setText("IT Bazar");
		
		Label label1=new Label(shell, SWT.NULL);
		label1.setText("User Name: ");

		 Text username = new Text(shell, SWT.SINGLE | SWT.BORDER);
		username.setText("");
		username.setTextLimit(30);

		 Label label2=new Label(shell, SWT.NULL);
		label2.setText("Password: ");

		 Text password = new Text(shell, SWT.SINGLE | SWT.BORDER);
		System.out.println(password.getEchoChar());
		password.setEchoChar('*');
		password.setTextLimit(30);
		
		
		
		Button button=new Button(shell,SWT.PUSH);
		button.setText("Login");
		class MySelectionListener implements SelectionListener
		{
			
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				logger.info("Login Successfully");
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent e)
			{
				
			}
		}
		
		final MySelectionListener selObject = new MySelectionListener();
		button.addSelectionListener(selObject);
		
		button.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});	
		
		button.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				e.doit= true;
				if((username.getText()).equals((password.getText())))
				{
				
					Text text9 = new Text(shell, SWT.NONE);
					text9.setBounds(0, 310, 1000, 30);
					text9.setText("You are logged in successfully");
					logger.info("button was clicked");
				
				}
				return;
			}
		});
		Button button1=new Button(shell,SWT.PUSH);
		button1.setText("Register");
//		class MySelectionListener1 implements SelectionListener
//		{
//			
//			@Override
//			public void widgetSelected(SelectionEvent e)
//			{
//				logger.info("Login Successfully");
//			}
//			@Override
//			public void widgetDefaultSelected(SelectionEvent e)
//			{
//				
//			}
//		}
		
		final MySelectionListener selObject1 = new MySelectionListener();
		button1.addSelectionListener(selObject1);
		
		button1.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});	
		
		button1.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				Label label3=new Label(shell, SWT.NULL);
				label3.setText("Please Fill The details");
				label3.setBounds(0, 120, 200, 30);
				
				Label label4=new Label(shell, SWT.NULL);
				label4.setText("Name:");
				label4.setBounds(0, 160, 40, 30);
					Text text = new Text(shell, SWT.BORDER);
					text.setBounds(100, 160, 100, 20);
					text.setText("");
					
					Label label5=new Label(shell, SWT.NULL);
					label5.setText("Address:");
					label5.setBounds(0, 200, 50, 30);	
					Text text1 = new Text(shell, SWT.BORDER);
					text1.setBounds(100, 200, 100, 20);
					text1.setText("");
					Label label6=new Label(shell, SWT.NULL);
					label6.setText("Mobile No:");
					label6.setBounds(0, 240, 60, 30);	
					Text text2 = new Text(shell, SWT.BORDER);
					text2.setBounds(100, 240, 100, 20);
					text2.setText("");
					Label label7=new Label(shell, SWT.NULL);
					label7.setText("Email ID:");
					label7.setBounds(0, 280, 60, 30);	
					Text text3 = new Text(shell, SWT.BORDER);
					text3.setBounds(100, 280, 100, 20);
					text3.setText("");
					//logger.info("button was clicked")
			}
		});
	
		Button button2=new Button(shell,SWT.PUSH);
		button2.setText("Submit Your Details");
		button2.setBounds(0, 280, 150, 30);
		final MySelectionListener selObject2 = new MySelectionListener();
		button2.addSelectionListener(selObject2);
		
		button2.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});	
		
		button2.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				
				
					Text text9 = new Text(shell, SWT.NONE);
					text9.setBounds(0, 350, 1000, 30);
					text9.setText("Your Account is created successfully");
					
			}
		});
		
		
		
		
		shell.addListener(SWT.Close,new Listener() {
			public void handleEvent(Event event){
				int style = SWT.APPLICATION_MODAL |SWT.YES|SWT.NO;
				MessageBox messageBox = new MessageBox(shell,style);
				messageBox.setText("confirmation");
				messageBox.setMessage("Do you want to close window");
				if(messageBox.open()==SWT.YES)
					event.doit=true;
				else event.doit=false;
			}
		
		});
	}
	
	@Override
	protected void checkSubclass()
	{
		
	}
	}


