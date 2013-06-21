package testthread

import griffon.util.GriffonNameUtils
import groovy.beans.Bindable

import javax.swing.Icon

abstract class BaseDialogModel {
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
	
	protected abstract String getDialogTitle()

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
}