package org.ceia.qtip.shared.wrappers;

public class QtipContent {

	private QtipTitle title;
	private String content;
	private String contentAttribute;

	public QtipContent() {
		// TODO Auto-generated constructor stub
	}

	public QtipTitle getTitle() {
		if (title == null) {
			title = new QtipTitle();
		}
		return title;
	}

	public String getContent() {
		return content;
	}

	public QtipContent setContent(String content) {
		this.content = content;
		return this;
	}

	public String getContentAttribute() {
		return contentAttribute;
	}

	public QtipContent setContentAttribute(String contentAttribute) {
		this.contentAttribute = contentAttribute;
		return this;
	}

	public void setTitle(QtipTitle title) {
		this.title = title;
	}

}
