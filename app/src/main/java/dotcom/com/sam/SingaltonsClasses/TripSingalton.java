package dotcom.com.sam.SingaltonsClasses;


import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import dotcom.com.sam.Response.VetNearMeResponse;

/**
 * Created by sanjay on 10/28/2017.
 */

public class TripSingalton implements Serializable, List<TripSingalton> {

    private static final TripSingalton ourInstance = new TripSingalton();

    public static TripSingalton getInstance() {
        return ourInstance;
    }

    public TripSingalton() {
    }

    public VetNearMeResponse getvetresponse() {
        return vetNearMeResponse;
    }

    public void VetNearMeResponse(VetNearMeResponse vetNearMeResponse) {
        this.vetNearMeResponse = vetNearMeResponse;
    }

    VetNearMeResponse vetNearMeResponse;

        public int VNM_Id;
        public String DoctorName;
        public String Qualification;
        public String WorkExperience;
        public String DoctorType;
        public String Description;
        public String Address;
        public String Cost;
        public String Availableday;
        public String AvailableTime;

    public int getVNM_Id() {
        return VNM_Id;
    }

    public void setVNM_Id(int VNM_Id) {
        this.VNM_Id = VNM_Id;
    }

    public String getDoctorName() {
        return DoctorName;
    }

    public void setDoctorName(String doctorName) {
        DoctorName = doctorName;
    }

    public String getQualification() {
        return Qualification;
    }

    public void setQualification(String qualification) {
        Qualification = qualification;
    }

    public String getWorkExperience() {
        return WorkExperience;
    }

    public void setWorkExperience(String workExperience) {
        WorkExperience = workExperience;
    }

    public String getDoctorType() {
        return DoctorType;
    }

    public void setDoctorType(String doctorType) {
        DoctorType = doctorType;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCost() {
        return Cost;
    }

    public void setCost(String cost) {
        Cost = cost;
    }

    public String getAvailableday() {
        return Availableday;
    }

    public void setAvailableday(String availableday) {
        Availableday = availableday;
    }

    public String getAvailableTime() {
        return AvailableTime;
    }

    public void setAvailableTime(String availableTime) {
        AvailableTime = availableTime;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }

    public String getCreatedate() {
        return Createdate;
    }

    public void setCreatedate(String createdate) {
        Createdate = createdate;
    }

    public String getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(String createdBy) {
        CreatedBy = createdBy;
    }

    public String getModifyDate() {
        return ModifyDate;
    }

    public void setModifyDate(String modifyDate) {
        ModifyDate = modifyDate;
    }

    public String getModifyBy() {
        return ModifyBy;
    }

    public void setModifyBy(String modifyBy) {
        ModifyBy = modifyBy;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getDeleteStatus() {
        return DeleteStatus;
    }

    public void setDeleteStatus(String deleteStatus) {
        DeleteStatus = deleteStatus;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getSR_Id() {
        return SR_Id;
    }

    public void setSR_Id(String SR_Id) {
        this.SR_Id = SR_Id;
    }

    public int getAtHomeFees() {
        return AtHomeFees;
    }

    public void setAtHomeFees(int atHomeFees) {
        AtHomeFees = atHomeFees;
    }

    public int getNearMeFees() {
        return NearMeFees;
    }

    public void setNearMeFees(int nearMeFees) {
        NearMeFees = nearMeFees;
    }

    public int getDiagnosticsFees() {
        return DiagnosticsFees;
    }

    public void setDiagnosticsFees(int diagnosticsFees) {
        DiagnosticsFees = diagnosticsFees;
    }

    public String Location;
        public String Link;
        public String Createdate;
        public String CreatedBy;
        public String ModifyDate;
        public String ModifyBy;
        public String Status;
        public String DeleteStatus;
        public String Type;
        public String Image;
        public String SR_Id;
        public int AtHomeFees;
        public int NearMeFees;
        public int DiagnosticsFees;

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @NonNull
    @Override
    public Iterator<TripSingalton> iterator() {
        return null;
    }

    @NonNull
    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @NonNull
    @Override
    public <T> T[] toArray(@NonNull T[] ts) {
        return null;
    }

    @Override
    public boolean add(TripSingalton tripSingalton) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(@NonNull Collection<?> collection) {
        return false;
    }

    @Override
    public boolean addAll(@NonNull Collection<? extends TripSingalton> collection) {
        return false;
    }

    @Override
    public boolean addAll(int i, @NonNull Collection<? extends TripSingalton> collection) {
        return false;
    }

    @Override
    public boolean removeAll(@NonNull Collection<?> collection) {
        return false;
    }

    @Override
    public boolean retainAll(@NonNull Collection<?> collection) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public TripSingalton get(int i) {
        return null;
    }

    @Override
    public TripSingalton set(int i, TripSingalton tripSingalton) {
        return null;
    }

    @Override
    public void add(int i, TripSingalton tripSingalton) {

    }

    @Override
    public TripSingalton remove(int i) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @NonNull
    @Override
    public ListIterator<TripSingalton> listIterator() {
        return null;
    }

    @NonNull
    @Override
    public ListIterator<TripSingalton> listIterator(int i) {
        return null;
    }

    @NonNull
    @Override
    public List<TripSingalton> subList(int i, int i1) {
        return null;
    }
}
