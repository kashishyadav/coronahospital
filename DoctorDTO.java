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
public class DoctorDTO {
    
    private String doctor_no;
    private String name;
    private String specialization;
    private String qualification;
    private int channelfee;
    private int phone;
    private int room;
    private int log_id;

    public DoctorDTO() {
    }
    public DoctorDTO(String doctor_no,String name)
    {
        this.doctor_no=doctor_no;
        this.name=name;
    }

    @Override
    public String toString() {
        return "DoctorDTO{" + "doctor_no=" + doctor_no + ", name=" + name + ", specialization=" + specialization + ", qualification=" + qualification + ", channelfee=" + channelfee + ", phone=" + phone + ", room=" + room + ", log_id=" + log_id + '}';
    }

    public String getDoctor_no() {
        return doctor_no;
    }

    public void setDoctor_no(String doctor_no) {
        this.doctor_no = doctor_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public int getChannelfee() {
        return channelfee;
    }

    public void setChannelfee(int channelfee) {
        this.channelfee = channelfee;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getLog_id() {
        return log_id;
    }

    public void setLog_id(int log_id) {
        this.log_id = log_id;
    }
    
    
}
