package dotcom.com.sam.Response;

import java.util.List;

public class DogcatpackageResponse {


    /**
     * success : true
     * Messege : Success
     * status : 200
     * response : [{"GroomingService_Id":2,"ListingTitle":"Elite Pet Grooming Services","CenterName":"Elite Pet Grooming Services Pvt. Ltd","OwnerName":"Sagar Girase","OwnerPhone":"12345678","OwnerEmail":"adhf@gmfsd.co","OwnerAddress":"Testing adddress ","ListingDesciption":null,"AtHomeFees":null,"SalonFees":null,"SearchLocations":null,"AgeUpto":5,"SizeUpto":4,"ServicesAt":"Salon","OpeningTime":null,"ClosingTime":null,"CloseDays":null,"Images":"01AANew.jpg","CreatedDate":null,"CreatedBy":null,"ModifyDate":null,"ModifyBy":null,"Status":"Active","SR_Id":4,"DeleteStatus":null,"PetType":"Dog","B_Id":null,"B_Ids":null,"GroomingPackages":[{"G_Packages_Id":1,"PackageTitle":"BASIC GROOMING","PackageDescription":"test","ServicesIncluded":"Nail Clipping, Ear Cleaning, Eye Cleaning","SalonPrice":2000,"AtHomePrice":3000,"HomeServices_Included":null,"SR_Id":null,"AddOnn_Id":null,"AddOnn_Ids":null,"Status":null,"DeleteStatus":null,"GroomingService_Id":2,"Pos_priority":null,"AddOns":[{"AddOnnId":1,"AddOnnName":"Ear Cleaning","AddOnAmount":200,"SR_Id":null,"G_Package_Id":null,"Status":null,"DeleteStatus":null,"Pos_priority":null},{"AddOnnId":2,"AddOnnName":"Nails Clipping","AddOnAmount":300,"SR_Id":null,"G_Package_Id":null,"Status":null,"DeleteStatus":null,"Pos_priority":null},{"AddOnnId":3,"AddOnnName":"Eye cleaning","AddOnAmount":500,"SR_Id":null,"G_Package_Id":null,"Status":null,"DeleteStatus":null,"Pos_priority":null}]},{"G_Packages_Id":2,"PackageTitle":"Advanced grooming","PackageDescription":"test","ServicesIncluded":"Nail Clipping, Ear Cleaning, Eye Cleaning","SalonPrice":3000,"AtHomePrice":4000,"HomeServices_Included":null,"SR_Id":null,"AddOnn_Id":null,"AddOnn_Ids":null,"Status":null,"DeleteStatus":null,"GroomingService_Id":2,"Pos_priority":null,"AddOns":[{"AddOnnId":2,"AddOnnName":"Nails Clipping","AddOnAmount":300,"SR_Id":null,"G_Package_Id":null,"Status":null,"DeleteStatus":null,"Pos_priority":null},{"AddOnnId":3,"AddOnnName":"Eye cleaning","AddOnAmount":500,"SR_Id":null,"G_Package_Id":null,"Status":null,"DeleteStatus":null,"Pos_priority":null}]},{"G_Packages_Id":3,"PackageTitle":"Premium","PackageDescription":" All Services Description","ServicesIncluded":"All Type","SalonPrice":200,"AtHomePrice":300,"HomeServices_Included":null,"SR_Id":null,"AddOnn_Id":null,"AddOnn_Ids":null,"Status":null,"DeleteStatus":null,"GroomingService_Id":2,"Pos_priority":null,"AddOns":[{"AddOnnId":1,"AddOnnName":"Ear Cleaning","AddOnAmount":200,"SR_Id":null,"G_Package_Id":null,"Status":null,"DeleteStatus":null,"Pos_priority":null},{"AddOnnId":2,"AddOnnName":"Nails Clipping","AddOnAmount":300,"SR_Id":null,"G_Package_Id":null,"Status":null,"DeleteStatus":null,"Pos_priority":null},{"AddOnnId":3,"AddOnnName":"Eye cleaning","AddOnAmount":500,"SR_Id":null,"G_Package_Id":null,"Status":null,"DeleteStatus":null,"Pos_priority":null}]}],"GroomingPackagedata":null,"AddOns":null,"totalAddon":null,"TotalAmount":null,"Groomingdata":null,"TimeSlot":[{"G_BookingTimeId":1,"BookingTime":"10:00 AM","CreatedDate":null,"CreatedBy":null,"ModifiedDate":null,"ModifiedBy":null,"Status":"Active","DeleteStatus":null,"SR_Id":4,"Field1":null},{"G_BookingTimeId":2,"BookingTime":"11:00 AM","CreatedDate":null,"CreatedBy":null,"ModifiedDate":null,"ModifiedBy":null,"Status":"Active","DeleteStatus":null,"SR_Id":4,"Field1":null},{"G_BookingTimeId":3,"BookingTime":"12:00 PM","CreatedDate":null,"CreatedBy":null,"ModifiedDate":null,"ModifiedBy":null,"Status":"Active","DeleteStatus":null,"SR_Id":4,"Field1":null},{"G_BookingTimeId":4,"BookingTime":"01:00 PM","CreatedDate":null,"CreatedBy":null,"ModifiedDate":null,"ModifiedBy":null,"Status":"Active","DeleteStatus":null,"SR_Id":4,"Field1":null},{"G_BookingTimeId":5,"BookingTime":"02:00 PM","CreatedDate":null,"CreatedBy":null,"ModifiedDate":null,"ModifiedBy":null,"Status":"Active","DeleteStatus":null,"SR_Id":4,"Field1":null}]}]
     */

    private boolean success;
    private String Messege;
    private int status;
    private List<ResponseBean> response;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessege() {
        return Messege;
    }

    public void setMessege(String Messege) {
        this.Messege = Messege;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<ResponseBean> getResponse() {
        return response;
    }

    public void setResponse(List<ResponseBean> response) {
        this.response = response;
    }

    public static class ResponseBean {
        /**
         * GroomingService_Id : 2
         * ListingTitle : Elite Pet Grooming Services
         * CenterName : Elite Pet Grooming Services Pvt. Ltd
         * OwnerName : Sagar Girase
         * OwnerPhone : 12345678
         * OwnerEmail : adhf@gmfsd.co
         * OwnerAddress : Testing adddress
         * ListingDesciption : null
         * AtHomeFees : null
         * SalonFees : null
         * SearchLocations : null
         * AgeUpto : 5
         * SizeUpto : 4
         * ServicesAt : Salon
         * OpeningTime : null
         * ClosingTime : null
         * CloseDays : null
         * Images : 01AANew.jpg
         * CreatedDate : null
         * CreatedBy : null
         * ModifyDate : null
         * ModifyBy : null
         * Status : Active
         * SR_Id : 4
         * DeleteStatus : null
         * PetType : Dog
         * B_Id : null
         * B_Ids : null
         * GroomingPackages : [{"G_Packages_Id":1,"PackageTitle":"BASIC GROOMING","PackageDescription":"test","ServicesIncluded":"Nail Clipping, Ear Cleaning, Eye Cleaning","SalonPrice":2000,"AtHomePrice":3000,"HomeServices_Included":null,"SR_Id":null,"AddOnn_Id":null,"AddOnn_Ids":null,"Status":null,"DeleteStatus":null,"GroomingService_Id":2,"Pos_priority":null,"AddOns":[{"AddOnnId":1,"AddOnnName":"Ear Cleaning","AddOnAmount":200,"SR_Id":null,"G_Package_Id":null,"Status":null,"DeleteStatus":null,"Pos_priority":null},{"AddOnnId":2,"AddOnnName":"Nails Clipping","AddOnAmount":300,"SR_Id":null,"G_Package_Id":null,"Status":null,"DeleteStatus":null,"Pos_priority":null},{"AddOnnId":3,"AddOnnName":"Eye cleaning","AddOnAmount":500,"SR_Id":null,"G_Package_Id":null,"Status":null,"DeleteStatus":null,"Pos_priority":null}]},{"G_Packages_Id":2,"PackageTitle":"Advanced grooming","PackageDescription":"test","ServicesIncluded":"Nail Clipping, Ear Cleaning, Eye Cleaning","SalonPrice":3000,"AtHomePrice":4000,"HomeServices_Included":null,"SR_Id":null,"AddOnn_Id":null,"AddOnn_Ids":null,"Status":null,"DeleteStatus":null,"GroomingService_Id":2,"Pos_priority":null,"AddOns":[{"AddOnnId":2,"AddOnnName":"Nails Clipping","AddOnAmount":300,"SR_Id":null,"G_Package_Id":null,"Status":null,"DeleteStatus":null,"Pos_priority":null},{"AddOnnId":3,"AddOnnName":"Eye cleaning","AddOnAmount":500,"SR_Id":null,"G_Package_Id":null,"Status":null,"DeleteStatus":null,"Pos_priority":null}]},{"G_Packages_Id":3,"PackageTitle":"Premium","PackageDescription":" All Services Description","ServicesIncluded":"All Type","SalonPrice":200,"AtHomePrice":300,"HomeServices_Included":null,"SR_Id":null,"AddOnn_Id":null,"AddOnn_Ids":null,"Status":null,"DeleteStatus":null,"GroomingService_Id":2,"Pos_priority":null,"AddOns":[{"AddOnnId":1,"AddOnnName":"Ear Cleaning","AddOnAmount":200,"SR_Id":null,"G_Package_Id":null,"Status":null,"DeleteStatus":null,"Pos_priority":null},{"AddOnnId":2,"AddOnnName":"Nails Clipping","AddOnAmount":300,"SR_Id":null,"G_Package_Id":null,"Status":null,"DeleteStatus":null,"Pos_priority":null},{"AddOnnId":3,"AddOnnName":"Eye cleaning","AddOnAmount":500,"SR_Id":null,"G_Package_Id":null,"Status":null,"DeleteStatus":null,"Pos_priority":null}]}]
         * GroomingPackagedata : null
         * AddOns : null
         * totalAddon : null
         * TotalAmount : null
         * Groomingdata : null
         * TimeSlot : [{"G_BookingTimeId":1,"BookingTime":"10:00 AM","CreatedDate":null,"CreatedBy":null,"ModifiedDate":null,"ModifiedBy":null,"Status":"Active","DeleteStatus":null,"SR_Id":4,"Field1":null},{"G_BookingTimeId":2,"BookingTime":"11:00 AM","CreatedDate":null,"CreatedBy":null,"ModifiedDate":null,"ModifiedBy":null,"Status":"Active","DeleteStatus":null,"SR_Id":4,"Field1":null},{"G_BookingTimeId":3,"BookingTime":"12:00 PM","CreatedDate":null,"CreatedBy":null,"ModifiedDate":null,"ModifiedBy":null,"Status":"Active","DeleteStatus":null,"SR_Id":4,"Field1":null},{"G_BookingTimeId":4,"BookingTime":"01:00 PM","CreatedDate":null,"CreatedBy":null,"ModifiedDate":null,"ModifiedBy":null,"Status":"Active","DeleteStatus":null,"SR_Id":4,"Field1":null},{"G_BookingTimeId":5,"BookingTime":"02:00 PM","CreatedDate":null,"CreatedBy":null,"ModifiedDate":null,"ModifiedBy":null,"Status":"Active","DeleteStatus":null,"SR_Id":4,"Field1":null}]
         */

        private int GroomingService_Id;
        private String ListingTitle;
        private String CenterName;
        private String OwnerName;
        private String OwnerPhone;
        private String OwnerEmail;
        private String OwnerAddress;
        private Object ListingDesciption;
        private Object AtHomeFees;
        private Object SalonFees;
        private Object SearchLocations;
        private int AgeUpto;
        private int SizeUpto;
        private String ServicesAt;
        private Object OpeningTime;
        private Object ClosingTime;
        private Object CloseDays;
        private String Images;
        private Object CreatedDate;
        private Object CreatedBy;
        private Object ModifyDate;
        private Object ModifyBy;
        private String Status;
        private int SR_Id;
        private Object DeleteStatus;
        private String PetType;
        private Object B_Id;
        private Object B_Ids;
        private Object GroomingPackagedata;
        private Object AddOns;
        private Object totalAddon;
        private Object TotalAmount;
        private Object Groomingdata;
        private List<GroomingPackagesBean> GroomingPackages;
        private List<TimeSlotBean> TimeSlot;

        public int getGroomingService_Id() {
            return GroomingService_Id;
        }

        public void setGroomingService_Id(int GroomingService_Id) {
            this.GroomingService_Id = GroomingService_Id;
        }

        public String getListingTitle() {
            return ListingTitle;
        }

        public void setListingTitle(String ListingTitle) {
            this.ListingTitle = ListingTitle;
        }

        public String getCenterName() {
            return CenterName;
        }

        public void setCenterName(String CenterName) {
            this.CenterName = CenterName;
        }

        public String getOwnerName() {
            return OwnerName;
        }

        public void setOwnerName(String OwnerName) {
            this.OwnerName = OwnerName;
        }

        public String getOwnerPhone() {
            return OwnerPhone;
        }

        public void setOwnerPhone(String OwnerPhone) {
            this.OwnerPhone = OwnerPhone;
        }

        public String getOwnerEmail() {
            return OwnerEmail;
        }

        public void setOwnerEmail(String OwnerEmail) {
            this.OwnerEmail = OwnerEmail;
        }

        public String getOwnerAddress() {
            return OwnerAddress;
        }

        public void setOwnerAddress(String OwnerAddress) {
            this.OwnerAddress = OwnerAddress;
        }

        public Object getListingDesciption() {
            return ListingDesciption;
        }

        public void setListingDesciption(Object ListingDesciption) {
            this.ListingDesciption = ListingDesciption;
        }

        public Object getAtHomeFees() {
            return AtHomeFees;
        }

        public void setAtHomeFees(Object AtHomeFees) {
            this.AtHomeFees = AtHomeFees;
        }

        public Object getSalonFees() {
            return SalonFees;
        }

        public void setSalonFees(Object SalonFees) {
            this.SalonFees = SalonFees;
        }

        public Object getSearchLocations() {
            return SearchLocations;
        }

        public void setSearchLocations(Object SearchLocations) {
            this.SearchLocations = SearchLocations;
        }

        public int getAgeUpto() {
            return AgeUpto;
        }

        public void setAgeUpto(int AgeUpto) {
            this.AgeUpto = AgeUpto;
        }

        public int getSizeUpto() {
            return SizeUpto;
        }

        public void setSizeUpto(int SizeUpto) {
            this.SizeUpto = SizeUpto;
        }

        public String getServicesAt() {
            return ServicesAt;
        }

        public void setServicesAt(String ServicesAt) {
            this.ServicesAt = ServicesAt;
        }

        public Object getOpeningTime() {
            return OpeningTime;
        }

        public void setOpeningTime(Object OpeningTime) {
            this.OpeningTime = OpeningTime;
        }

        public Object getClosingTime() {
            return ClosingTime;
        }

        public void setClosingTime(Object ClosingTime) {
            this.ClosingTime = ClosingTime;
        }

        public Object getCloseDays() {
            return CloseDays;
        }

        public void setCloseDays(Object CloseDays) {
            this.CloseDays = CloseDays;
        }

        public String getImages() {
            return Images;
        }

        public void setImages(String Images) {
            this.Images = Images;
        }

        public Object getCreatedDate() {
            return CreatedDate;
        }

        public void setCreatedDate(Object CreatedDate) {
            this.CreatedDate = CreatedDate;
        }

        public Object getCreatedBy() {
            return CreatedBy;
        }

        public void setCreatedBy(Object CreatedBy) {
            this.CreatedBy = CreatedBy;
        }

        public Object getModifyDate() {
            return ModifyDate;
        }

        public void setModifyDate(Object ModifyDate) {
            this.ModifyDate = ModifyDate;
        }

        public Object getModifyBy() {
            return ModifyBy;
        }

        public void setModifyBy(Object ModifyBy) {
            this.ModifyBy = ModifyBy;
        }

        public String getStatus() {
            return Status;
        }

        public void setStatus(String Status) {
            this.Status = Status;
        }

        public int getSR_Id() {
            return SR_Id;
        }

        public void setSR_Id(int SR_Id) {
            this.SR_Id = SR_Id;
        }

        public Object getDeleteStatus() {
            return DeleteStatus;
        }

        public void setDeleteStatus(Object DeleteStatus) {
            this.DeleteStatus = DeleteStatus;
        }

        public String getPetType() {
            return PetType;
        }

        public void setPetType(String PetType) {
            this.PetType = PetType;
        }

        public Object getB_Id() {
            return B_Id;
        }

        public void setB_Id(Object B_Id) {
            this.B_Id = B_Id;
        }

        public Object getB_Ids() {
            return B_Ids;
        }

        public void setB_Ids(Object B_Ids) {
            this.B_Ids = B_Ids;
        }

        public Object getGroomingPackagedata() {
            return GroomingPackagedata;
        }

        public void setGroomingPackagedata(Object GroomingPackagedata) {
            this.GroomingPackagedata = GroomingPackagedata;
        }

        public Object getAddOns() {
            return AddOns;
        }

        public void setAddOns(Object AddOns) {
            this.AddOns = AddOns;
        }

        public Object getTotalAddon() {
            return totalAddon;
        }

        public void setTotalAddon(Object totalAddon) {
            this.totalAddon = totalAddon;
        }

        public Object getTotalAmount() {
            return TotalAmount;
        }

        public void setTotalAmount(Object TotalAmount) {
            this.TotalAmount = TotalAmount;
        }

        public Object getGroomingdata() {
            return Groomingdata;
        }

        public void setGroomingdata(Object Groomingdata) {
            this.Groomingdata = Groomingdata;
        }

        public List<GroomingPackagesBean> getGroomingPackages() {
            return GroomingPackages;
        }

        public void setGroomingPackages(List<GroomingPackagesBean> GroomingPackages) {
            this.GroomingPackages = GroomingPackages;
        }

        public List<TimeSlotBean> getTimeSlot() {
            return TimeSlot;
        }

        public void setTimeSlot(List<TimeSlotBean> TimeSlot) {
            this.TimeSlot = TimeSlot;
        }

        public static class GroomingPackagesBean {
            /**
             * G_Packages_Id : 1
             * PackageTitle : BASIC GROOMING
             * PackageDescription : test
             * ServicesIncluded : Nail Clipping, Ear Cleaning, Eye Cleaning
             * SalonPrice : 2000
             * AtHomePrice : 3000
             * HomeServices_Included : null
             * SR_Id : null
             * AddOnn_Id : null
             * AddOnn_Ids : null
             * Status : null
             * DeleteStatus : null
             * GroomingService_Id : 2
             * Pos_priority : null
             * AddOns : [{"AddOnnId":1,"AddOnnName":"Ear Cleaning","AddOnAmount":200,"SR_Id":null,"G_Package_Id":null,"Status":null,"DeleteStatus":null,"Pos_priority":null},{"AddOnnId":2,"AddOnnName":"Nails Clipping","AddOnAmount":300,"SR_Id":null,"G_Package_Id":null,"Status":null,"DeleteStatus":null,"Pos_priority":null},{"AddOnnId":3,"AddOnnName":"Eye cleaning","AddOnAmount":500,"SR_Id":null,"G_Package_Id":null,"Status":null,"DeleteStatus":null,"Pos_priority":null}]
             */

            private int G_Packages_Id;
            private String PackageTitle;
            private String PackageDescription;
            private String ServicesIncluded;
            private int SalonPrice;
            private int AtHomePrice;
            private Object HomeServices_Included;
            private Object SR_Id;
            private Object AddOnn_Id;
            private Object AddOnn_Ids;
            private Object Status;
            private Object DeleteStatus;
            private int GroomingService_Id;
            private Object Pos_priority;
            private List<AddOnsBean> AddOns;

            public int getG_Packages_Id() {
                return G_Packages_Id;
            }

            public void setG_Packages_Id(int G_Packages_Id) {
                this.G_Packages_Id = G_Packages_Id;
            }

            public String getPackageTitle() {
                return PackageTitle;
            }

            public void setPackageTitle(String PackageTitle) {
                this.PackageTitle = PackageTitle;
            }

            public String getPackageDescription() {
                return PackageDescription;
            }

            public void setPackageDescription(String PackageDescription) {
                this.PackageDescription = PackageDescription;
            }

            public String getServicesIncluded() {
                return ServicesIncluded;
            }

            public void setServicesIncluded(String ServicesIncluded) {
                this.ServicesIncluded = ServicesIncluded;
            }

            public int getSalonPrice() {
                return SalonPrice;
            }

            public void setSalonPrice(int SalonPrice) {
                this.SalonPrice = SalonPrice;
            }

            public int getAtHomePrice() {
                return AtHomePrice;
            }

            public void setAtHomePrice(int AtHomePrice) {
                this.AtHomePrice = AtHomePrice;
            }

            public Object getHomeServices_Included() {
                return HomeServices_Included;
            }

            public void setHomeServices_Included(Object HomeServices_Included) {
                this.HomeServices_Included = HomeServices_Included;
            }

            public Object getSR_Id() {
                return SR_Id;
            }

            public void setSR_Id(Object SR_Id) {
                this.SR_Id = SR_Id;
            }

            public Object getAddOnn_Id() {
                return AddOnn_Id;
            }

            public void setAddOnn_Id(Object AddOnn_Id) {
                this.AddOnn_Id = AddOnn_Id;
            }

            public Object getAddOnn_Ids() {
                return AddOnn_Ids;
            }

            public void setAddOnn_Ids(Object AddOnn_Ids) {
                this.AddOnn_Ids = AddOnn_Ids;
            }

            public Object getStatus() {
                return Status;
            }

            public void setStatus(Object Status) {
                this.Status = Status;
            }

            public Object getDeleteStatus() {
                return DeleteStatus;
            }

            public void setDeleteStatus(Object DeleteStatus) {
                this.DeleteStatus = DeleteStatus;
            }

            public int getGroomingService_Id() {
                return GroomingService_Id;
            }

            public void setGroomingService_Id(int GroomingService_Id) {
                this.GroomingService_Id = GroomingService_Id;
            }

            public Object getPos_priority() {
                return Pos_priority;
            }

            public void setPos_priority(Object Pos_priority) {
                this.Pos_priority = Pos_priority;
            }

            public List<AddOnsBean> getAddOns() {
                return AddOns;
            }

            public void setAddOns(List<AddOnsBean> AddOns) {
                this.AddOns = AddOns;
            }

            public static class AddOnsBean {
                /**
                 * AddOnnId : 1
                 * AddOnnName : Ear Cleaning
                 * AddOnAmount : 200
                 * SR_Id : null
                 * G_Package_Id : null
                 * Status : null
                 * DeleteStatus : null
                 * Pos_priority : null
                 */

                private int AddOnnId;
                private String AddOnnName;
                private int AddOnAmount;
                private Object SR_Id;
                private Object G_Package_Id;
                private Object Status;
                private Object DeleteStatus;
                private Object Pos_priority;

                public int getAddOnnId() {
                    return AddOnnId;
                }

                public void setAddOnnId(int AddOnnId) {
                    this.AddOnnId = AddOnnId;
                }

                public String getAddOnnName() {
                    return AddOnnName;
                }

                public void setAddOnnName(String AddOnnName) {
                    this.AddOnnName = AddOnnName;
                }

                public int getAddOnAmount() {
                    return AddOnAmount;
                }

                public void setAddOnAmount(int AddOnAmount) {
                    this.AddOnAmount = AddOnAmount;
                }

                public Object getSR_Id() {
                    return SR_Id;
                }

                public void setSR_Id(Object SR_Id) {
                    this.SR_Id = SR_Id;
                }

                public Object getG_Package_Id() {
                    return G_Package_Id;
                }

                public void setG_Package_Id(Object G_Package_Id) {
                    this.G_Package_Id = G_Package_Id;
                }

                public Object getStatus() {
                    return Status;
                }

                public void setStatus(Object Status) {
                    this.Status = Status;
                }

                public Object getDeleteStatus() {
                    return DeleteStatus;
                }

                public void setDeleteStatus(Object DeleteStatus) {
                    this.DeleteStatus = DeleteStatus;
                }

                public Object getPos_priority() {
                    return Pos_priority;
                }

                public void setPos_priority(Object Pos_priority) {
                    this.Pos_priority = Pos_priority;
                }
            }
        }

        public static class TimeSlotBean {
            /**
             * G_BookingTimeId : 1
             * BookingTime : 10:00 AM
             * CreatedDate : null
             * CreatedBy : null
             * ModifiedDate : null
             * ModifiedBy : null
             * Status : Active
             * DeleteStatus : null
             * SR_Id : 4
             * Field1 : null
             */

            private int G_BookingTimeId;
            private String BookingTime;
            private Object CreatedDate;
            private Object CreatedBy;
            private Object ModifiedDate;
            private Object ModifiedBy;
            private String Status;
            private Object DeleteStatus;
            private int SR_Id;
            private Object Field1;

            public int getG_BookingTimeId() {
                return G_BookingTimeId;
            }

            public void setG_BookingTimeId(int G_BookingTimeId) {
                this.G_BookingTimeId = G_BookingTimeId;
            }

            public String getBookingTime() {
                return BookingTime;
            }

            public void setBookingTime(String BookingTime) {
                this.BookingTime = BookingTime;
            }

            public Object getCreatedDate() {
                return CreatedDate;
            }

            public void setCreatedDate(Object CreatedDate) {
                this.CreatedDate = CreatedDate;
            }

            public Object getCreatedBy() {
                return CreatedBy;
            }

            public void setCreatedBy(Object CreatedBy) {
                this.CreatedBy = CreatedBy;
            }

            public Object getModifiedDate() {
                return ModifiedDate;
            }

            public void setModifiedDate(Object ModifiedDate) {
                this.ModifiedDate = ModifiedDate;
            }

            public Object getModifiedBy() {
                return ModifiedBy;
            }

            public void setModifiedBy(Object ModifiedBy) {
                this.ModifiedBy = ModifiedBy;
            }

            public String getStatus() {
                return Status;
            }

            public void setStatus(String Status) {
                this.Status = Status;
            }

            public Object getDeleteStatus() {
                return DeleteStatus;
            }

            public void setDeleteStatus(Object DeleteStatus) {
                this.DeleteStatus = DeleteStatus;
            }

            public int getSR_Id() {
                return SR_Id;
            }

            public void setSR_Id(int SR_Id) {
                this.SR_Id = SR_Id;
            }

            public Object getField1() {
                return Field1;
            }

            public void setField1(Object Field1) {
                this.Field1 = Field1;
            }
        }
    }
}
