package com.example.asriputri.cobavolley;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    String tag_json_obj = "json_obj_req";
    String url = "http://10.20.16.20/eatime.id/api/jabatan";
    private JabatanResponse data;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.tv_hello);
        getJabatan();
    }

    public void getJabatan() {
        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMessage("Loading...");
        dialog.show();
        StringRequest request = new StringRequest(Method.GET,
                url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new GsonBuilder().create();
                data = gson.fromJson(response, JabatanResponse.class);
                Toast.makeText(MainActivity.this, data.getData().get(0).getNamaJabatan(), Toast.LENGTH_SHORT).show();
                textView.setText(data.getData().get(0).getNamaJabatan());
                dialog.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("Volley", "Error" + error.getMessage());
                dialog.dismiss();
            }
        });
        AppController.getInstance().addToRequestQueue(request, tag_json_obj);
    }
}
