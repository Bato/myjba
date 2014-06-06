//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2014.06.06 um 05:08:08 PM CEST 
//


package de.mh.jba.rss;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für tCloudProtocol.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tCloudProtocol">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="xml-rpc"/>
 *     &lt;enumeration value="http-post"/>
 *     &lt;enumeration value="soap"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tCloudProtocol")
@XmlEnum
public enum TCloudProtocol {

    @XmlEnumValue("xml-rpc")
    XML_RPC("xml-rpc"),
    @XmlEnumValue("http-post")
    HTTP_POST("http-post"),
    @XmlEnumValue("soap")
    SOAP("soap");
    private final String value;

    TCloudProtocol(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TCloudProtocol fromValue(String v) {
        for (TCloudProtocol c: TCloudProtocol.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
