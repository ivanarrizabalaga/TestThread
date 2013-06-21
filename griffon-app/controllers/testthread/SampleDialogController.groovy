package testthread

class SampleDialogController extends BaseDialogController{
    def model
    def view

	void mvcGroupInit(def args) {
		super.mvcGroupInit(args)
	}
	
	def click1Action={ evt=null ->
		log.info evt.source.text
		model.clickedText=evt.source.text
	}
}
