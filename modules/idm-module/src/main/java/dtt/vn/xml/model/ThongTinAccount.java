package dtt.vn.xml.model;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ngay" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="thang" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nam" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="coquanquanly" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="congdan">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ten" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="cmt" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="diachi">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="xa" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                             &lt;element name="huyen" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                             &lt;element name="tinh" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                             &lt;element name="diachichitiet" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="dienthoai" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="fullname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="birthdate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="gender" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nativePlace" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="maritalStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nationality" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ethnicGroup" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="telNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="address" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="taxCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="insuranceCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="familyRegNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="workingPlace" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="personalId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "ngay",
    "thang",
    "nam",
    "coquanquanly",
    "congdan",
    "fullname",
    "email",
    "birthdate",
    "gender",
    "nativePlace",
    "maritalStatus",
    "nationality",
    "ethnicGroup",
    "telNo",
    "address",
    "taxCode",
    "insuranceCode",
    "familyRegNo",
    "workingPlace",
    "personalId"
})
@XmlRootElement(name = "ThongTinAccount")
public class ThongTinAccount {
	protected int ngay;
    protected int thang;
    protected int nam;
    @XmlElement(required = true)
    protected String coquanquanly;
    @XmlElement(required = true)
    protected ThongTinAccount.Congdan congdan;
    @XmlElement(required = true)
    protected String fullname;
    @XmlElement(required = true)
    protected String email;
    @XmlElement(required = true)
    protected String birthdate;
    @XmlElement(required = true)
    protected String gender;
    @XmlElement(required = true)
    protected String nativePlace;
    @XmlElement(required = true)
    protected String maritalStatus;
    @XmlElement(required = true)
    protected String nationality;
    @XmlElement(required = true)
    protected String ethnicGroup;
    @XmlElement(required = true)
    protected String telNo;
    @XmlElement(required = true)
    protected String address;
    @XmlElement(required = true)
    protected String taxCode;
    @XmlElement(required = true)
    protected String insuranceCode;
    @XmlElement(required = true)
    protected String familyRegNo;
    @XmlElement(required = true)
    protected String workingPlace;
    @XmlElement(required = true)
    protected String personalId;

    /**
     * Gets the value of the ngay property.
     * 
     */
    public int getNgay() {
        return ngay;
    }

    /**
     * Sets the value of the ngay property.
     * 
     */
    public void setNgay(int value) {
        this.ngay = value;
    }

    /**
     * Gets the value of the thang property.
     * 
     */
    public int getThang() {
        return thang;
    }

    /**
     * Sets the value of the thang property.
     * 
     */
    public void setThang(int value) {
        this.thang = value;
    }

    /**
     * Gets the value of the nam property.
     * 
     */
    public int getNam() {
        return nam;
    }

    /**
     * Sets the value of the nam property.
     * 
     */
    public void setNam(int value) {
        this.nam = value;
    }

    /**
     * Gets the value of the coquanquanly property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoquanquanly() {
        return coquanquanly;
    }

    /**
     * Sets the value of the coquanquanly property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoquanquanly(String value) {
        this.coquanquanly = value;
    }

    /**
     * Gets the value of the congdan property.
     * 
     * @return
     *     possible object is
     *     {@link ThongTinAccount.Congdan }
     *     
     */
    public ThongTinAccount.Congdan getCongdan() {
        return congdan;
    }

    /**
     * Sets the value of the congdan property.
     * 
     * @param value
     *     allowed object is
     *     {@link ThongTinAccount.Congdan }
     *     
     */
    public void setCongdan(ThongTinAccount.Congdan value) {
        this.congdan = value;
    }

    /**
     * Gets the value of the fullname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * Sets the value of the fullname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFullname(String value) {
        this.fullname = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the birthdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBirthdate() {
        return birthdate;
    }

    /**
     * Sets the value of the birthdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBirthdate(String value) {
        this.birthdate = value;
    }

    /**
     * Gets the value of the gender property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the value of the gender property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGender(String value) {
        this.gender = value;
    }

    /**
     * Gets the value of the nativePlace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNativePlace() {
        return nativePlace;
    }

    /**
     * Sets the value of the nativePlace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNativePlace(String value) {
        this.nativePlace = value;
    }

    /**
     * Gets the value of the maritalStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaritalStatus() {
        return maritalStatus;
    }

    /**
     * Sets the value of the maritalStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaritalStatus(String value) {
        this.maritalStatus = value;
    }

    /**
     * Gets the value of the nationality property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * Sets the value of the nationality property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNationality(String value) {
        this.nationality = value;
    }

    /**
     * Gets the value of the ethnicGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEthnicGroup() {
        return ethnicGroup;
    }

    /**
     * Sets the value of the ethnicGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEthnicGroup(String value) {
        this.ethnicGroup = value;
    }

    /**
     * Gets the value of the telNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelNo() {
        return telNo;
    }

    /**
     * Sets the value of the telNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelNo(String value) {
        this.telNo = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * Gets the value of the taxCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaxCode() {
        return taxCode;
    }

    /**
     * Sets the value of the taxCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaxCode(String value) {
        this.taxCode = value;
    }

    /**
     * Gets the value of the insuranceCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInsuranceCode() {
        return insuranceCode;
    }

    /**
     * Sets the value of the insuranceCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInsuranceCode(String value) {
        this.insuranceCode = value;
    }

    /**
     * Gets the value of the familyRegNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFamilyRegNo() {
        return familyRegNo;
    }

    /**
     * Sets the value of the familyRegNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFamilyRegNo(String value) {
        this.familyRegNo = value;
    }

    /**
     * Gets the value of the workingPlace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkingPlace() {
        return workingPlace;
    }

    /**
     * Sets the value of the workingPlace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkingPlace(String value) {
        this.workingPlace = value;
    }

    /**
     * Gets the value of the personalId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersonalId() {
        return personalId;
    }

    /**
     * Sets the value of the personalId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonalId(String value) {
        this.personalId = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="ten" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="cmt" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="diachi">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="xa" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
     *                   &lt;element name="huyen" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
     *                   &lt;element name="tinh" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
     *                   &lt;element name="diachichitiet" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="dienthoai" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "ten",
        "cmt",
        "diachi",
        "dienthoai",
        "email"
    })
    public static class Congdan {

        @XmlElement(required = true)
        protected String ten;
        @XmlElement(required = true)
        protected String cmt;
        @XmlElement(required = true)
        protected ThongTinAccount.Congdan.Diachi diachi;
        @XmlElement(required = true)
        protected String dienthoai;
        @XmlElement(required = true)
        protected String email;

        /**
         * Gets the value of the ten property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTen() {
            return ten;
        }

        /**
         * Sets the value of the ten property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTen(String value) {
            this.ten = value;
        }

        /**
         * Gets the value of the cmt property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCmt() {
            return cmt;
        }

        /**
         * Sets the value of the cmt property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCmt(String value) {
            this.cmt = value;
        }

        /**
         * Gets the value of the diachi property.
         * 
         * @return
         *     possible object is
         *     {@link ThongTinAccount.Congdan.Diachi }
         *     
         */
        public ThongTinAccount.Congdan.Diachi getDiachi() {
            return diachi;
        }

        /**
         * Sets the value of the diachi property.
         * 
         * @param value
         *     allowed object is
         *     {@link ThongTinAccount.Congdan.Diachi }
         *     
         */
        public void setDiachi(ThongTinAccount.Congdan.Diachi value) {
            this.diachi = value;
        }

        /**
         * Gets the value of the dienthoai property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDienthoai() {
            return dienthoai;
        }

        /**
         * Sets the value of the dienthoai property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDienthoai(String value) {
            this.dienthoai = value;
        }

        /**
         * Gets the value of the email property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEmail() {
            return email;
        }

        /**
         * Sets the value of the email property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEmail(String value) {
            this.email = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="xa" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
         *         &lt;element name="huyen" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
         *         &lt;element name="tinh" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
         *         &lt;element name="diachichitiet" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "xa",
            "huyen",
            "tinh",
            "diachichitiet"
        })
        public static class Diachi {

            @XmlElement(required = true)
            protected Object xa;
            @XmlElement(required = true)
            protected Object huyen;
            @XmlElement(required = true)
            protected Object tinh;
            @XmlElement(required = true)
            protected String diachichitiet;

            /**
             * Gets the value of the xa property.
             * 
             * @return
             *     possible object is
             *     {@link Object }
             *     
             */
            public Object getXa() {
                return xa;
            }

            /**
             * Sets the value of the xa property.
             * 
             * @param value
             *     allowed object is
             *     {@link Object }
             *     
             */
            public void setXa(Object value) {
                this.xa = value;
            }

            /**
             * Gets the value of the huyen property.
             * 
             * @return
             *     possible object is
             *     {@link Object }
             *     
             */
            public Object getHuyen() {
                return huyen;
            }

            /**
             * Sets the value of the huyen property.
             * 
             * @param value
             *     allowed object is
             *     {@link Object }
             *     
             */
            public void setHuyen(Object value) {
                this.huyen = value;
            }

            /**
             * Gets the value of the tinh property.
             * 
             * @return
             *     possible object is
             *     {@link Object }
             *     
             */
            public Object getTinh() {
                return tinh;
            }

            /**
             * Sets the value of the tinh property.
             * 
             * @param value
             *     allowed object is
             *     {@link Object }
             *     
             */
            public void setTinh(Object value) {
                this.tinh = value;
            }

            /**
             * Gets the value of the diachichitiet property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDiachichitiet() {
                return diachichitiet;
            }

            /**
             * Sets the value of the diachichitiet property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDiachichitiet(String value) {
                this.diachichitiet = value;
            }

        }

    }
}
