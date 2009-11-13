class Link {
    String title
    String url
    
    static constraints = {
        title(blank:false,maxSize:50)
        url(blank:false,maxSize:150)
    }

    static belongsTo = [environment:Environment]
}
