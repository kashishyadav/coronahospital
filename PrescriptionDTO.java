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
public class PrescriptionDTO {
    private String pre_id;
    private String channel_id;
    private String doctorname;
    private String detype;
    private String prescription;

    public PrescriptionDTO() {
    }

    @Override
    public String toString() {
        return "PrescriptionDTO{" + "pre_id=" + pre_id + ", channel_id=" + channel_id + ", doctorname=" + doctorname + ", detype=" + detype + ", prescription=" + prescription + '}';
    }

    public String getPre_id() {
        return pre_id;
    }

    public void setPre_id(String pre_id) {
        this.pre_id = pre_id;
    }

    public String getChannel_id() {
        return channel_id;
    }

    public void setChannel_id(String channel_id) {
        this.channel_id = channel_id;
    }

    public String getDoctorname() {
        return doctorname;
    }

    public void setDoctorname(String doctorname) {
        this.doctorname = doctorname;
    }

    public String getDetype() {
        return detype;
    }

    public void setDetype(String detype) {
        this.detype = detype;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }
    
    
}
