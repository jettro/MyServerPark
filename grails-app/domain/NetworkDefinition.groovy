class NetworkDefinition {
    String ipAddress
    Vlan vlan

    static belongsTo = [server:Server]

    static constraints = {
        ipAddress(matches : "(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)")
    }

    public String toString() {
        return vlan.name + ' ' + ipAddress
    }
}
