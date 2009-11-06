class Vlan {
    String name
    String function
    
    static constraints = {
        name(blank:false, maxSize:50)
        function(blank:false, maxSize:100)
    }

    def String toString() {
        return name + ': ' + function
    }


}
