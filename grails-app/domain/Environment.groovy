class Environment {
    String name

    static hasMany = [servers:Server]

    static constraints = {
        name(blank:false, maxSize:50)
    }

    def String toString() {
        return name + ": " + servers.size();
    }


}
