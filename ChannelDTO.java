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
public class ChannelDTO {
    private String channel_no;
    private String doctorno;
    private String patientno;
    private String roomno;
    private String date;

    public ChannelDTO() {
    }

    @Override
    public String toString() {
        return "ChannelDTO{" + "channel_no=" + channel_no + ", doctorno=" + doctorno + ", patientno=" + patientno + ", roomno=" + roomno + ", date=" + date + '}';
    }

    public String getChannel_no() {
        return channel_no;
    }

    public void setChannel_no(String channel_no) {
        this.channel_no = channel_no;
    }

    public String getDoctorno() {
        return doctorno;
    }

    public void setDoctorno(String doctorno) {
        this.doctorno = doctorno;
    }

    public String getPatientno() {
        return patientno;
    }

    public void setPatientno(String patientno) {
        this.patientno = patientno;
    }

    public String getRoomno() {
        return roomno;
    }

    public void setRoomno(String roomno) {
        this.roomno = roomno;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
}
