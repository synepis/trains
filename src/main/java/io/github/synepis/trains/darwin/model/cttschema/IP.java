//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.09.30 at 11:17:55 AM BST 
//


package io.github.synepis.trains.darwin.model.cttschema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * Defines aPassenger Intermediate Calling Point
 * 
 * <p>Java class for IP complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IP">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attGroup ref="{http://www.thalesgroup.com/rtti/XmlTimetable/v8}CallPtAttributes"/>
 *       &lt;attGroup ref="{http://www.thalesgroup.com/rtti/XmlTimetable/v8}SchedLocAttributes"/>
 *       &lt;attribute name="wta" use="required" type="{http://www.thalesgroup.com/rtti/PushPort/CommonTypes/v1}WTimeType" />
 *       &lt;attribute name="wtd" use="required" type="{http://www.thalesgroup.com/rtti/PushPort/CommonTypes/v1}WTimeType" />
 *       &lt;attribute name="rdelay" type="{http://www.thalesgroup.com/rtti/PushPort/CommonTypes/v1}DelayValueType" default="0" />
 *       &lt;attribute name="fd" type="{http://www.thalesgroup.com/rtti/PushPort/CommonTypes/v1}TiplocType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IP")
public class IP {

    @XmlAttribute(name = "wta", required = true)
    protected String wta;
    @XmlAttribute(name = "wtd", required = true)
    protected String wtd;
    @XmlAttribute(name = "rdelay")
    protected Short rdelay;
    @XmlAttribute(name = "fd")
    protected String fd;
    @XmlAttribute(name = "pta")
    protected String pta;
    @XmlAttribute(name = "ptd")
    protected String ptd;
    @XmlAttribute(name = "tpl", required = true)
    protected String tpl;
    @XmlAttribute(name = "act")
    protected String act;
    @XmlAttribute(name = "planAct")
    protected String planAct;
    @XmlAttribute(name = "can")
    protected Boolean can;
    @XmlAttribute(name = "plat")
    protected String plat;

    /**
     * Gets the value of the wta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWta() {
        return wta;
    }

    /**
     * Sets the value of the wta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWta(String value) {
        this.wta = value;
    }

    /**
     * Gets the value of the wtd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWtd() {
        return wtd;
    }

    /**
     * Sets the value of the wtd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWtd(String value) {
        this.wtd = value;
    }

    /**
     * Gets the value of the rdelay property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public short getRdelay() {
        if (rdelay == null) {
            return ((short) 0);
        } else {
            return rdelay;
        }
    }

    /**
     * Sets the value of the rdelay property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setRdelay(Short value) {
        this.rdelay = value;
    }

    /**
     * Gets the value of the fd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFd() {
        return fd;
    }

    /**
     * Sets the value of the fd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFd(String value) {
        this.fd = value;
    }

    /**
     * Gets the value of the pta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPta() {
        return pta;
    }

    /**
     * Sets the value of the pta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPta(String value) {
        this.pta = value;
    }

    /**
     * Gets the value of the ptd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPtd() {
        return ptd;
    }

    /**
     * Sets the value of the ptd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPtd(String value) {
        this.ptd = value;
    }

    /**
     * Gets the value of the tpl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTpl() {
        return tpl;
    }

    /**
     * Sets the value of the tpl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTpl(String value) {
        this.tpl = value;
    }

    /**
     * Gets the value of the act property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAct() {
        if (act == null) {
            return "  ";
        } else {
            return act;
        }
    }

    /**
     * Sets the value of the act property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAct(String value) {
        this.act = value;
    }

    /**
     * Gets the value of the planAct property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlanAct() {
        return planAct;
    }

    /**
     * Sets the value of the planAct property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlanAct(String value) {
        this.planAct = value;
    }

    /**
     * Gets the value of the can property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isCan() {
        if (can == null) {
            return false;
        } else {
            return can;
        }
    }

    /**
     * Sets the value of the can property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCan(Boolean value) {
        this.can = value;
    }

    /**
     * Gets the value of the plat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlat() {
        return plat;
    }

    /**
     * Sets the value of the plat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlat(String value) {
        this.plat = value;
    }

}
