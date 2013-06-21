package testthread

import java.awt.Color
import javax.swing.KeyStroke


actions {
	action(id: 'closeAction',
			name: "Cancelar",
			closure: controller.closeAction,
			mnemonic: "C",
			shortDescription: "Cerrar"
			)

	action(id:'okAction',
			name:"Ok",
			closure: controller.okAction,
			mnemonic:"O",
			shortDescription:"Ok"
			)
}

//Panel principal del dialogo
panel(id:'dialog',name:'dialog'){

	migLayout(layoutConstraints:"fill")

	bannerPanel(id:'dialogFooter',constraints:'south,growx',
			startColor: new Color(212,212,212),endColor: new Color (175,175,175),vertical: true){

				migLayout (layoutConstraints: "fillx")
				label(id:'statusMessage', text:bind{model.statusMessage},constraints:"dock west",icon:bind{model.statusIcon})
				hbox(constraints:"dock east"){
					hglue()
					hbox(id:'buttonPanel'){}
					button(id:'ok', okAction)
					hstrut(3)
					button(id:'close', closeAction, visible:bind{model.cancelable})					
				}
			}

	//capturar la pulsacion de la tecla ESC
	keyStrokeAction(component: current,
			keyStroke: 'ESCAPE',
			condition: 'in focused window',
			action: closeAction)

	//capturar pulsacion tecla ENTER
	keyStrokeAction(component: current,
			keyStroke: KeyStroke.getKeyStroke("ENTER"),
			condition: 'in focused window',
			action: okAction)
}
