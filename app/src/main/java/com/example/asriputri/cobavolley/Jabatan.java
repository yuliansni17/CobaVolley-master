
package com.example.asriputri.cobavolley;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Jabatan implements Parcelable
{

    @SerializedName("id_jabatan")
    @Expose
    private String idJabatan;
    @SerializedName("nama_jabatan")
    @Expose
    private String namaJabatan;
    @SerializedName("status")
    @Expose
    private String status;
    public final static Creator<Jabatan> CREATOR = new Creator<Jabatan>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Jabatan createFromParcel(Parcel in) {
            Jabatan instance = new Jabatan();
            instance.idJabatan = ((String) in.readValue((String.class.getClassLoader())));
            instance.namaJabatan = ((String) in.readValue((String.class.getClassLoader())));
            instance.status = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Jabatan[] newArray(int size) {
            return (new Jabatan[size]);
        }

    }
    ;

    public String getIdJabatan() {
        return idJabatan;
    }

    public void setIdJabatan(String idJabatan) {
        this.idJabatan = idJabatan;
    }

    public String getNamaJabatan() {
        return namaJabatan;
    }

    public void setNamaJabatan(String namaJabatan) {
        this.namaJabatan = namaJabatan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(idJabatan);
        dest.writeValue(namaJabatan);
        dest.writeValue(status);
    }

    public int describeContents() {
        return  0;
    }

}
