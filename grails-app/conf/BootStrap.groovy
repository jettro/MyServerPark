class BootStrap {

     def init = { servletContext ->
         def statussus = ['OK','WARNING','PROBLEM','COLD']
         statussus.each {
             statusName ->
                def newStatus = new Status(name: statusName)
             newStatus.save()
         }

         def vlans = [['Middleware','877'],['Backend','878'],['Beheer','879'],['Backup','888']]
         vlans.each {
             vlanFunction,vlanName ->
                def newVlan = new Vlan(name:vlanName,function:vlanFunction)
             newVlan.save()
         }

         def environments = ['Ontwikkel','Test','Acceptatie','Production']
         environments.each {
             name ->
                 def environment = new Environment(name:name)
                 environment.save()
         }

         def okStatus = Status.findByName("OK")
         def warningStatus = Status.findByName("WARNING")
         def errorStatus = Status.findByName("PROBLEM")
         def coldStatus = Status.findByName("COLD")

         def vlan877 = Vlan.findByName("877")
         def vlan878 = Vlan.findByName("878")
         def vlan879 = Vlan.findByName("879")
         def vlan888 = Vlan.findByName("888")

         def s1729 = new Server(name:"s1729",function:"svn + wiki",status:okStatus, externalIp:"77.245.92.78")
         s1729.addToNetworks (new NetworkDefinition(ipAddress:"10.2.7.2", vlan:vlan878))
         s1729.addToNetworks (new NetworkDefinition(ipAddress:"10.2.8.6", vlan:vlan879))
         s1729.addToNetworks (new NetworkDefinition(ipAddress:"10.2.187.10", vlan:vlan888))
         s1729.save()
         def s1731 = new Server(name:"s1731",function:"site 1",status:okStatus, externalIp:"77.245.92.75")
         s1731.addToNetworks (new NetworkDefinition(ipAddress:"10.2.6.2", vlan:vlan877))
         s1731.addToNetworks (new NetworkDefinition(ipAddress:"10.2.8.3", vlan:vlan879))
         s1731.addToNetworks (new NetworkDefinition(ipAddress:"10.2.187.7", vlan:vlan888))
         s1731.save()
         def s1732 = new Server(name:"s1732",function:"site 2",status:errorStatus, externalIp:"77.245.92.76")
         s1732.addToNetworks (new NetworkDefinition(ipAddress:"10.2.6.4", vlan:vlan877))
         s1732.addToNetworks (new NetworkDefinition(ipAddress:"10.2.8.4", vlan:vlan879))
         s1732.addToNetworks (new NetworkDefinition(ipAddress:"10.2.187.8", vlan:vlan888))
         s1732.save()
         def s1733 = new Server(name:"s1733",function:"standby",status:coldStatus, externalIp:"77.245.92.78")
         s1733.addToNetworks (new NetworkDefinition(ipAddress:"10.2.6.6", vlan:vlan877))
         s1733.addToNetworks (new NetworkDefinition(ipAddress:"10.2.8.5", vlan:vlan879))
         s1733.addToNetworks (new NetworkDefinition(ipAddress:"10.2.187.9", vlan:vlan888))
         s1733.save()
         def s1734 = new Server(name:"s1734",function:"database",status:warningStatus, externalIp:"77.245.92.79")
         s1734.addToNetworks (new NetworkDefinition(ipAddress:"10.2.7.4", vlan:vlan878))
         s1734.addToNetworks (new NetworkDefinition(ipAddress:"10.2.8.7", vlan:vlan879))
         s1734.addToNetworks (new NetworkDefinition(ipAddress:"10.2.187.11", vlan:vlan888))
         s1734.save()
         def s1735 = new Server(name:"s1735",function:"cms + importer",status:okStatus, externalIp:"77.245.92.80")
         s1735.addToNetworks (new NetworkDefinition(ipAddress:"10.2.7.6", vlan:vlan878))
         s1735.addToNetworks (new NetworkDefinition(ipAddress:"10.2.8.8", vlan:vlan879))
         s1735.addToNetworks (new NetworkDefinition(ipAddress:"10.2.187.12", vlan:vlan888))
         s1735.save()

         def ontwikkel = Environment.findByName("Ontwikkel")
         ontwikkel.addToServers (s1729)
         ontwikkel.addToServers (s1731)
         ontwikkel.addToServers (s1732)
         ontwikkel.addToServers (s1733)
         ontwikkel.addToServers (s1734)
         ontwikkel.addToServers (s1735)
     }
     def destroy = {
     }
} 