class Comment {
    String name
    String content

    static belongsTo = [server:Server]

    static mapping = {
        content type: "text"
    }

    static constraints = {
        name(blank:false, maxSize:50)
        content(blank:false, widget:"textarea")
    }
}
