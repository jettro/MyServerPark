class Status {
    String name
    
    static constraints = {
        name(blank:false, maxSize:50)
    }

    def String toString() {
        return name
    }


}
