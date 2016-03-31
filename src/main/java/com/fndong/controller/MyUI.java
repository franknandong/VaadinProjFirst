package com.fndong.controller;

import java.io.File;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.FilesystemContainer;
import com.vaadin.data.util.TextFileProperty;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
@Widgetset("com.fndong.controller.MyAppWidgetset")
public class MyUI extends UI {
	FilesystemContainer docs = new FilesystemContainer(new File("C:\\tmp\\Docs"));
	Table docList = new Table("Documents",docs);
	/*Label docView = new Label("",ContentMode.TEXT);*/
	DocEditor docEditor = new DocEditor();

    @Override
    protected void init(VaadinRequest vaadinRequest) {
	HorizontalSplitPanel split = new HorizontalSplitPanel();
	setContent(split);
	split.addComponent(docList);
	split.addComponent(docEditor);
	split.setSizeFull();
	docList.addValueChangeListener(new ValueChangeListener()
	{
			public void valueChange(ValueChangeEvent event){
				docEditor.setPropertyDataSource(new TextFileProperty((File)event.getProperty().getValue()));
				}
			});
		docList.setImmediate(true);
		docList.setSelectable(true);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
