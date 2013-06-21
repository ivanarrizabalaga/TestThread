package testthread

import groovy.beans.Bindable

class SampleDialogModel extends BaseDialogModel{
	
	@Bindable String clickedText
	
	SampleDialogModel() {
		super()
		width = 400
		height = 150
		maxStatus = 75
		cancelable=true
	}

	@Override
	protected String getDialogTitle() {
		return "Sampling..."
	}
}