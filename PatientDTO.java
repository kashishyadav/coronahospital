/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coronahospital.dto;

/**
 *
 * @author SUDHANSHU YADAV
 */
public class PatientDTO {
    
    private String patient_no;
    private String name;
    private String phone;
    private String address;

    public PatientDTO() {
    }
    public PatientDTO(String patient_no,String name) {
        this.patient_no=patient_no;
        this.name=name;
    }

    @Override
    public String toString() {
        return "PatientDTO{" + "patient_no=" + patient_no + ", name=" + name + ", phone=" + phone + ", address=" + address + '}';
    }

    public String getPatient_no() {
        return patient_no;
    }

    public void setPatient_no(String patient_no) {
        this.patient_no = patient_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
}
