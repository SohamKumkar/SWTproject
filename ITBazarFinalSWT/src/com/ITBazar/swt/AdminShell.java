package com.ITBazar.swt;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.model.HardwareDetails;
import com.model.SoftwareDetails;
import com.service.SoftwareDetailsService;
import com.service.HardwareDetailsService;
import com.service.HardwareDetailsServiceImpl;
import com.service.SoftwareDetailsService;
import com.service.SoftwareDetailsServiceImpl;



public class AdminShell extends Shell {
	Shell shell = this;
	private static final Logger logger = Logger.getLogger(LoginShell.class);
	//private static final Logger logger1= Logger.getRootLogger();
	public static void main(String[] args)
	{
	 try
	 {
		 Display display= new Display();
		 AdminShell shell = new AdminShell(display);
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
	
	public AdminShell(Display display)
	{
		super(display, SWT.SHELL_TRIM);
		createContents();
	}
	
	protected void createContents()
	{
		shell.setSize(3000,3000);
		shell.setText("Admin");
		
		
	    Button button7=new Button(shell,SWT.PUSH);
	    button7.setText("View All Hardware");
	    button7.setBounds(0, 0, 150, 50);
	    
	    class MySelectionListener implements SelectionListener
		{
			
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				logger.info(" widget selectedby Mylistener");
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent e)
			{
				
			}
		}
	    
	    final MySelectionListener selObject = new MySelectionListener();
		button7.addSelectionListener(selObject);
		
		button7.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});	
		
		button7.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				List<HardwareDetails> allHardware= new ArrayList<HardwareDetails>();
				HardwareDetailsService hardwareDetailsService = new HardwareDetailsServiceImpl();
			
				allHardware=hardwareDetailsService.getAllHardwareDetails();
				Composite composite1 = new Composite(shell,SWT.BORDER);
				Composite composite2 = new Composite(composite1,SWT.BORDER);
				composite2.setBounds(0, 70, 1500, 200);
				composite1.setBounds(40, 100, 1800, 300);
				composite1.setBackground(new Color(Display.getDefault(),0,127,0));
				org.eclipse.swt.widgets.List list = new org.eclipse.swt.widgets.List(composite2,SWT.MULTI);
				for(HardwareDetails hd : allHardware)
				{
					System.out.println(hd);
					list.add(""+hd);
				}
				list.setSize(2300,2300);
			}
		});
		
		  Button button8=new Button(shell,SWT.PUSH);
		    button8.setText("View All Software");
		    button8.setBounds(150, 0, 150, 50);
				 
		    class MySelectionListener1 implements SelectionListener
			{
				
				@Override
				public void widgetSelected(SelectionEvent e)
				{
					logger.info(" widget selectedby Mylistener");
				}
				@Override
				public void widgetDefaultSelected(SelectionEvent e)
				{
					
				}
			}
		    
		    final MySelectionListener1 selObject1 = new MySelectionListener1();
			button8.addSelectionListener(selObject1);
			
			button8.addSelectionListener(new SelectionListener() {
				
				@Override
				public void widgetSelected(SelectionEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
					// TODO Auto-generated method stub
					
				}
			});	
			
			button8.addSelectionListener(new SelectionAdapter() {
				
				@Override
				public void widgetSelected(SelectionEvent e)
				{
					List<SoftwareDetails> allSoftware= new ArrayList<SoftwareDetails>();
					SoftwareDetailsService softwareDetailsService = new SoftwareDetailsServiceImpl();
				
					allSoftware=softwareDetailsService.getAllSoftware();
					Composite composite1 = new Composite(shell,SWT.BORDER);
					Composite composite2 = new Composite(composite1,SWT.BORDER);
					composite2.setBounds(0, 80, 1500, 200);
					composite1.setBounds(40, 380, 1800, 300);
					composite1.setBackground(new Color(Display.getDefault(),0,127,0));
					org.eclipse.swt.widgets.List list = new org.eclipse.swt.widgets.List(composite2,SWT.MULTI);
					for(SoftwareDetails hd : allSoftware)
					{
						System.out.println(hd);
						list.add(""+hd);
					}
					list.setSize(2300,2300);
				}
			});
			
	  
//	    
//	    Button button9=new Button(shell,SWT.PUSH);
//	    button9.setText("LogOut");
//	    button9.setBounds(300, 0, 150, 50);

//	    shell.addListener(SWT.Close,new Listener() {
//			public void handleEvent(Event event){
//				int style = SWT.APPLICATION_MODAL |SWT.YES|SWT.NO;
//				MessageBox messageBox = new MessageBox(shell,style);
//				messageBox.setText("confirmation");
//				messageBox.setMessage("Do you want to close window");
//				if(messageBox.open()==SWT.YES)
//					event.doit=true;
//				else event.doit=false;
//			}
//		
//		});

	}
	
	
	@Override
	protected void checkSubclass()
	{
		
	}
	}



