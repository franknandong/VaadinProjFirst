package com.fndong.controller;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.util.TextFileProperty;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.RichTextArea;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TextArea;

public class DocEditor extends CustomComponent {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private AbsoluteLayout mainLayout;
	@AutoGenerated
	private TabSheet tabSheet_editor;
	@AutoGenerated
	private TextArea textArea_html;
	@AutoGenerated
	private RichTextArea richTextArea_wysiwyg;
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public DocEditor() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		// TODO add user code here
	}

	public void setPropertyDataSource(TextFileProperty doc) {
		// TODO Auto-generated method stub
		textArea_html.setPropertyDataSource(doc);
		richTextArea_wysiwyg.setPropertyDataSource(doc);
	}

	@AutoGenerated
	private AbsoluteLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new AbsoluteLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("580px");
		mainLayout.setHeight("320px");
		
		// top-level component properties
		setWidth("580px");
		setHeight("320px");
		
		// tabSheet_editor
		tabSheet_editor = buildTabSheet_editor();
		mainLayout.addComponent(tabSheet_editor, "top:20.0px;right:67.0px;");
		
		return mainLayout;
	}

	@AutoGenerated
	private TabSheet buildTabSheet_editor() {
		// common part: create layout
		tabSheet_editor = new TabSheet();
		tabSheet_editor.setImmediate(true);
		tabSheet_editor.setWidth("-1px");
		tabSheet_editor.setHeight("100.0%");
		
		// richTextArea_wysiwyg
		richTextArea_wysiwyg = new RichTextArea();
		richTextArea_wysiwyg.setImmediate(false);
		richTextArea_wysiwyg.setWidth("100.0%");
		richTextArea_wysiwyg.setHeight("100.0%");
		tabSheet_editor.addTab(richTextArea_wysiwyg, "WYSIWYG", null);
		
		// textArea_html
		textArea_html = new TextArea();
		textArea_html.setImmediate(false);
		textArea_html.setWidth("100.0%");
		textArea_html.setHeight("100.0%");
		tabSheet_editor.addTab(textArea_html, "HTML", null);
		
		return tabSheet_editor;
	}

}