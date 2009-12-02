import org.joda.time.DateTime
import org.joda.time.contrib.hibernate.PersistentDateTime

class Comment {
    String name
    String content
    DateTime dateCreated

    static belongsTo = [server:Server]

    static mapping = {
        content type: "text"
        dateCreated type: PersistentDateTime, lazy: false        
    }

    static constraints = {
        name(blank:false, maxSize:50)
        content(blank:false, widget:"textarea")
    }
}
