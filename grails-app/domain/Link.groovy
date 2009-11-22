class Link {
    String title
    String url
    
    static constraints = {
        title(blank:false,maxSize:50)
        url(url:true, nullable:false)
    }

    static belongsTo = [environment:Environment]

    static mapping = {
        sort title:"asc"
    }
}
