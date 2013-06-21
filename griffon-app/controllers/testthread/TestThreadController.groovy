package testthread

class TestThreadController {
    def model
    def view
       
    def showDialog = { evt = null ->
		withMVCGroup("sampleDialog") {m,v,c->
			c.show()
		}
    }
    
}
