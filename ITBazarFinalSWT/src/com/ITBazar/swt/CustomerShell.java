package com.ITBazar.swt;

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
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.model.Customer;
import com.model.Order;
import com.service.CustomerService;
import com.service.CustomerServiceImpl;
import com.service.OrderService;
import com.service.OrderServiceImpl;



public class CustomerShell extends Shell {
	Shell shell = this;
	private static final Logger logger = Logger.getLogger(LoginShell.class);
	//private static final Logger logger1= Logger.getRootLogger();
	public static void main(String[] args)
	{
	 try
	 {
		 Display display= new Display();
		 CustomerShell shell = new CustomerShell(display);
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
	
	public CustomerShell(Display display)
	{
		super(display, SWT.SHELL_TRIM);
		createContents();
	}
	
	protected void createContents()
	{
		shell.setLayout(new GridLayout(2, false));
		shell.setText("Customer");
		 Text Customer_Id = new Text(shell, SWT.SINGLE | SWT.BORDER);
			Customer_Id.setText("");
			Customer_Id.setTextLimit(30);
		
		 	    
 	   Button button1=new Button(shell,SWT.PUSH);
	    button1.setText("View My Details");
	    
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
		button1.addSelectionListener(selObject);
		
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
				Customer customer= new Customer();
				CustomerService customerService = new CustomerServiceImpl();
				String customer1 = Customer_Id.getText();
				int number1 = Integer.parseInt(customer1);
				customer = customerService.getCustomer(number1);
				
				Text text = new Text(shell, SWT.NONE);
				text.setBounds(0, 100, 1000, 30);

				logger.info(customer);
				text.setText("" +customer);
				
				
			}
		});
		 Text Order_Id = new Text(shell, SWT.SINGLE | SWT.BORDER);
		Order_Id.setText("");
		Order_Id.setTextLimit(30);
		
		 Button button2=new Button(shell,SWT.PUSH);
		 button2.setText("View My Orders");
	
		final MySelectionListener selObject1 = new MySelectionListener();
		button2.addSelectionListener(selObject1);
		
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
				Order order= new Order();
				OrderService orderService= new OrderServiceImpl();
				
				String order1 = Order_Id.getText();
				int number1 = Integer.parseInt(order1);
				
				order = orderService.getOrderDetails(number1);
				logger.info(order);
				
				Text text1 = new Text(shell, SWT.NONE);
				text1.setBounds(0, 200, 1000, 30);
				
				text1.setText("" +order);
			}
		});
		
	
	    
	   
	    
	    Button button3=new Button(shell,SWT.PUSH);
	    button3.setText("LogOut");
	    
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




