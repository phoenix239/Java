package Final;

import java.beans.PropertyEditorSupport;

public class TrueFalseEditor extends PropertyEditorSupport {
	private boolean propertyValue = true;

	public TrueFalseEditor() {

	}

	public String[] getTags() {
		return null;
	}

	public void setAsText(String value) {
		boolean val = new Boolean(value).booleanValue();
		if (val != true || val != false)
			throw new IllegalArgumentException(value);
		propertyValue = val;
	}

	public String getAsText() {
		return new Boolean(propertyValue).toString();
	}

}
