import org.joda.time.DateTime

class BootStrap {
    def init = {servletContext ->
        def statussus = ['OK', 'WARNING', 'PROBLEM', 'COLD']
        statussus.each {
            statusName ->
            def newStatus = new Status(name: statusName)
            newStatus.save()
        }

        def vlans = [['Middleware', 'middle_dev'], ['Backend', 'backend_dev'], ['Beheer', 'maint_dev'], ['Backup', 'backup_dev']]
        vlans.each {
            vlanFunction, vlanName ->
            def newVlan = new Vlan(name: vlanName, function: vlanFunction)
            newVlan.save()
        }

        def environments = ['Development', 'Test', 'Acceptation', 'Production']
        environments.each {
            name ->
            def environment = new Environment(name: name, lastDeploy:new DateTime())
            environment.save()
        }

        def okStatus = Status.findByName("OK")
        def warningStatus = Status.findByName("WARNING")
        def errorStatus = Status.findByName("PROBLEM")
        def coldStatus = Status.findByName("COLD")

    }
    def destroy = {
    }
}