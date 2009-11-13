import org.joda.time.*
import org.joda.time.contrib.hibernate.*

class Environment {
    String name
    DateTime lastDeploy

    static hasMany = [servers:Server,links:Link]

    static constraints = {
        name(blank:false, maxSize:50)
        lastDeploy(blank:true)
    }

    static mapping = {
        lastDeploy type:PersistentDateTime
    }

    def String toString() {
        return name + ": " + servers.size();
    }

}
