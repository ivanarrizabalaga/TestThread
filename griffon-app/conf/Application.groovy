application {
    title = 'TestThread'
    startupGroups = ['testThread']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "sampleDialog"
    'sampleDialog' {
        model      = 'testthread.SampleDialogModel'
        view       = 'testthread.SampleDialogView'
        controller = 'testthread.SampleDialogController'
    }

    // MVC Group for "testThread"
    'testThread' {
        model      = 'testthread.TestThreadModel'
        view       = 'testthread.TestThreadView'
        controller = 'testthread.TestThreadController'
    }

}
