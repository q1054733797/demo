
package com.demo.practice.test;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.demo.springboot package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Test01_QNAME = new QName("http://springboot.demo.com/", "test01");
    private final static QName _Test01Response_QNAME = new QName("http://springboot.demo.com/", "test01Response");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.demo.springboot
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Test01 }
     * 
     */
    public Test01 createTest01() {
        return new Test01();
    }

    /**
     * Create an instance of {@link Test01Response }
     * 
     */
    public Test01Response createTest01Response() {
        return new Test01Response();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Test01 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://springboot.demo.com/", name = "test01")
    public JAXBElement<Test01> createTest01(Test01 value) {
        return new JAXBElement<Test01>(_Test01_QNAME, Test01 .class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Test01Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://springboot.demo.com/", name = "test01Response")
    public JAXBElement<Test01Response> createTest01Response(Test01Response value) {
        return new JAXBElement<Test01Response>(_Test01Response_QNAME, Test01Response.class, null, value);
    }

}
