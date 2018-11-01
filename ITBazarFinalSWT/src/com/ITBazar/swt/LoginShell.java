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
		
		Label label3=new Label(shell, SWT.NULL);
		label3.setText("User Type");

		Combo combo1 = new Combo(shell, SWT.V_SCROLL);
		combo1.add("Admin");
		combo1.add("Customer");
		
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
				
				{
					
					logger.info("button was clicked");
				
				}
				
			}
		});
		
	
	
		
		
		Button button1=new Button(shell,SWT.PUSH);
		button1.setText("Register");
		
		
		
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


