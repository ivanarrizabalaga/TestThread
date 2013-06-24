package testthread

import griffon.util.GriffonNameUtils
import groovy.beans.Bindable

import javax.swing.Icon

class SampleDialogModel{
	
	@Bindable String clickedText
	def view

	@Bindable String title="No title"
	@Bindable int width = 0
	@Bindable int height = 0
	@Bindable int maxStatus = 0
	@Bindable boolean resizable = false
	@Bindable boolean modal = true
	@Bindable String statusMessage
	@Bindable Icon statusIcon
	@Bindable boolean cancelable=false		
	@Bindable boolean closed = false
	
	SampleDialogModel() {
		super()
		width = 400
		height = 150
		maxStatus = 75
		cancelable=true
	}	

	void mvcGroupInit(Map<String, Object> args) {
		title = GriffonNameUtils.capitalize(dialogTitle)
		statusMessage = " "
		statusIcon=null
	}

	def getStatusMessage(){
		if (this.statusMessage.length() > maxStatus){
			return this.statusMessage.substring(0, maxStatus)+" ..."
		}
		
		return this.statusMessage
	}	

	@Override
	protected String getDialogTitle() {
		return "Sampling..."
	}
}