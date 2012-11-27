package hr.openshift.tomcat.db_test;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.vaadin.terminal.gwt.server.WebApplicationContext;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Button.ClickEvent;

public class MainPanel extends Panel {

	private Label testResult1 = new Label("<i>Not Tested</i>");
	private Label testResult2 = new Label("<i>Not Tested</i>");
	private Label testResult3 = new Label("<i>Not Tested</i>");

	public MainPanel() {
		super();

		setWidth("990px");
		setCaption("Main Panel");
	}

	@Override
	public void attach() {
		super.attach();

		GridLayout layout = new GridLayout(3, 3);
		layout.setMargin(true);
		layout.setSpacing(true);
		
		final TestDbDao tdb = (TestDbDao)getBean("testDbDao");
		final TestDbDao tjeedb = (TestDbDao)getBean("testJeeDbDao");

		Button btn1 = new Button("Test DB");
		btn1.setDescription("Testing datasource");
		layout.addComponent(btn1, 0, 0);
		testResult1.setContentMode(Label.CONTENT_XHTML);
		layout.addComponent(testResult1, 1, 0);
		btn1.addListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				if(tdb.test().equals("Test str")){
					testResult1.setValue("<b>OK</b>");
				}else{
					testResult1.setValue("<b>OK</b>");
				}
				

			}
		});

		Button btn2 = new Button("Test DB");
		btn2.setDescription("Testing JNDI datasource");
		layout.addComponent(btn2, 0, 1);
		testResult2.setContentMode(Label.CONTENT_XHTML);
		layout.addComponent(testResult2, 1, 1);
		btn2.addListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				if(tjeedb.test().equals("Test str")){
					testResult2.setValue("<b>OK</b>");
				}else{
					testResult2.setValue("<b>OK</b>");
				}

			}
		});

		Button btn3 = new Button("Test DB");
		btn3.setDescription("Testing Faulted datasource");
		layout.addComponent(btn3, 0, 2);
		testResult3.setContentMode(Label.CONTENT_XHTML);
		layout.addComponent(testResult3, 1, 2);
		btn3.addListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				testResult3.setValue("<b>Not Implemented</b>");

			}
		});

		addComponent(layout);
	}
	
	public Object getBean(String s){
		ServletContext sc = ((WebApplicationContext) getApplication().getContext()).getHttpSession().getServletContext();
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
		
		return ac.getBean(s);
	}
}
