class Server {
    String name
    String function
    String externalIp

    // relationships
    Status status
    static hasMany = [networks:NetworkDefinition]

    static belongsTo = [environment:Environment]

    static constraints = {
        name(blank:false, maxSize:50)
        function(blank:false, maxSize:50)
        externalIp(matches : "(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)")
    }

    static mapping = {
        sort name:'desc'
    }

    def String toString() {
        return name
    }
}
