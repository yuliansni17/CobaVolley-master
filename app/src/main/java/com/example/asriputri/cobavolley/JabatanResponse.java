
package com.example.asriputri.cobavolley;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JabatanResponse implements Parcelable
{

    @SerializedName("status")
    @Expose
    private int status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<Jabatan> data = null;
    public final static Creator<JabatanResponse> CREATOR = new Creator<JabatanResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public JabatanResponse createFromParcel(Parcel in) {
            JabatanResponse instance = new JabatanResponse();
            instance.status = ((int) in.readValue((int.class.getClassLoader())));
            instance.message = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.data, (Jabatan.class.getClassLoader()));
            return instance;
        }

        public JabatanResponse[] newArray(int size) {
            return (new JabatanResponse[size]);
        }

    }
    ;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Jabatan> getData() {
        return data;
    }

    public void setData(List<Jabatan> data) {
        this.data = data;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(message);
        dest.writeList(data);
    }

    public int describeContents() {
        return  0;
    }

}
