package testthread


actions {
	action(id: 'click1Action',
			name: "Click 1",
			closure: controller.click1Action
			)
	action(id: 'click2Action',
		name: "Click 2",
		closure: controller.click1Action
		)
	action(id: 'click3Action',
		name: "Click 3",
		closure: controller.click1Action
		)
}

build(BaseDialogView)

//  this.dialog.add{
panel(id: 'dialogContent', preferredSize:[model.width, model.height]) {
	migLayout (layoutConstraints: "fillx")
	button(click1Action)
	button(click2Action)
	button(click3Action,constraints:"wrap")
	label(text: bind{model.clickedText},constraints:"wrap")
}




this.dialog.add(this.dialogContent)
