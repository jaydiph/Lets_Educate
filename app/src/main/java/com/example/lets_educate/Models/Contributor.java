package com.example.lets_educate.Models;

public class Contributor {
    String InstituteName, InstituteAddress, SittingCapacity, NumberofComputers;
    String laborclass, projector, board;
    String ngoaddress,ngophoneno,ngoemail,ngoname,ngoid,datetime;

    public Contributor() {
    }

    public Contributor(String instituteName, String instituteAddress, String sittingCapacity,
                       String numberofComputers, String laborclass, String projector, String board) {
        InstituteName = instituteName;
        InstituteAddress = instituteAddress;
        SittingCapacity = sittingCapacity;
        NumberofComputers = numberofComputers;
        this.laborclass = laborclass;
        this.projector = projector;
        this.board = board;
    }

    public Contributor(String instituteName, String instituteAddress, String sittingCapacity,
                       String numberofComputers, String laborclass, String projector, String board,
                       String ngoemail,String ngoaddress,String ngoname,String ngophoneno,String ngoid,String datetime) {
        InstituteName = instituteName;
        InstituteAddress = instituteAddress;
        SittingCapacity = sittingCapacity;
        NumberofComputers = numberofComputers;
        this.laborclass = laborclass;
        this.projector = projector;
        this.board = board;
        this.ngoemail = ngoemail;
        this.ngoaddress = ngoaddress;
        this.ngoname = ngoname;
        this.ngophoneno = ngophoneno;
        this.ngoid = ngoid;
        this.datetime = datetime;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getNgoid() {
        return ngoid;
    }

    public void setNgoid(String ngoid) {
        this.ngoid = ngoid;
    }

    public String getNgoaddress() {
        return ngoaddress;
    }

    public void setNgoaddress(String ngoaddress) {
        this.ngoaddress = ngoaddress;
    }

    public String getNgophoneno() {
        return ngophoneno;
    }

    public void setNgophoneno(String ngophoneno) {
        this.ngophoneno = ngophoneno;
    }

    public String getNgoemail() {
        return ngoemail;
    }

    public void setNgoemail(String ngoemail) {
        this.ngoemail = ngoemail;
    }

    public String getNgoname() {
        return ngoname;
    }

    public void setNgoname(String ngoname) {
        this.ngoname = ngoname;
    }

    public String getInstituteName() {
        return InstituteName;
    }

    public void setInstituteName(String instituteName) {
        InstituteName = instituteName;
    }

    public String getInstituteAddress() {
        return InstituteAddress;
    }

    public void setInstituteAddress(String instituteAddress) {
        InstituteAddress = instituteAddress;
    }

    public String getSittingCapacity() {
        return SittingCapacity;
    }

    public void setSittingCapacity(String sittingCapacity) {
        SittingCapacity = sittingCapacity;
    }

    public String getNumberofComputers() {
        return NumberofComputers;
    }

    public void setNumberofComputers(String numberofComputers) {
        NumberofComputers = numberofComputers;
    }

    public String getLaborclass() {
        return laborclass;
    }

    public void setLaborclass(String laborclass) {
        this.laborclass = laborclass;
    }

    public String getProjector() {
        return projector;
    }

    public void setProjector(String projector) {
        this.projector = projector;
    }

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }
}
