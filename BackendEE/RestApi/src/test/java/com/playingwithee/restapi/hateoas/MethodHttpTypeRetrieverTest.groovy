package com.playingwithee.restapi.hateoas

import com.playingwithee.restapi.authors.AuthorsResource
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class MethodHttpTypeRetrieverTest extends Specification {

    def "should retrieve GET http type"() {
        when:
            def retrivedHttpType = MethodHttpTypeRetriever.get(AuthorsResource.class, "getAuthorDetails")
        then:
            retrivedHttpType == "GET"
    }

    def "should retrieve UNKNOWN because method doesn't exists"() {
        when:
            def retrivedHttpType = MethodHttpTypeRetriever.get(AuthorsResource.class, "getAuthorDetailsssssss")
        then:
            retrivedHttpType == "UNKNOWN"
    }

    def "should retrieve UNKNOWN because method doesn't have valid annotation"() {
        when:
            def retrivedHttpType = MethodHttpTypeRetriever.get(MethodHttpTypeRetriever.class, "get")
        then:
            retrivedHttpType == "UNKNOWN"
    }

}
