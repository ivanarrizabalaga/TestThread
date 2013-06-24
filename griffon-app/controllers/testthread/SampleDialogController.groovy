package testthread

import griffon.transform.Threading
import java.awt.Window
import java.awt.event.WindowListener
import javax.swing.JDialog


class SampleDialogController{
    def model
    def view
	def builder

	protected dialog
	

	void mvcGroupInit(def args) {
		super.mvcGroupInit(args)
	}		

	@Threading(Threading.Policy.INSIDE_UITHREAD_SYNC)
	def show = { Window window = null ->
		window = window ?: Window.windows.find{ it.focused }
		if(!dialog || dialog.owner != window) {
			dialog = builder.dialog(
					owner: window,
					title: model.title,
					resizable: model.resizable,
					modal: model.modal,
					defaultCloseOperation: JDialog.DO_NOTHING_ON_CLOSE)
					{ container(view.dialog) }
			if(model.width > 0 && model.height > 0) {
				dialog.preferredSize = [model.width, model.height]
			}
			dialog.addWindowListener(windowListener)
			dialog.pack()
		}
		int x = window.x + (window.width - dialog.width) / 2
		int y = window.y + (window.height - dialog.height) / 2
				
		dialog.setLocation(x, y)				
		dialog.visible = true
	}

	@Threading(Threading.Policy.INSIDE_UITHREAD_SYNC)
	def hide = { evt = null ->
		dialog?.visible = false
		dialog?.dispose()
		dialog = null
	}
	
	@Threading(Threading.Policy.INSIDE_UITHREAD_SYNC)
	def okAction = {
		hide()
	}
	
	@Threading(Threading.Policy.INSIDE_UITHREAD_SYNC)
	def closeAction = {
		model.closed = true
		hide()
	}
	
	def windowListener = [
		windowClosed: { },
		windowOpened: {},
		windowClosing: { event -> closeAction() },
		windowIconified: { },
		windowDeiconified: { },
		windowActivated: { },
		windowDeactivated: { }
	 ] as WindowListener
	
 	@Threading(Threading.Policy.SKIP)
	def isClosed={
		 return model.closed
	}	
	
	def click1Action={ evt=null ->
		log.info evt.source.text
		model.clickedText=evt.source.text
	}
}
