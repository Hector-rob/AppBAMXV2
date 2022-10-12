package com.application.app;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.application.app.modules.mensajedonacin.ui.MensajeDonaciNActivity;

import com.stripe.android.PaymentConfiguration;
import com.stripe.android.paymentsheet.PaymentSheet;
import com.stripe.android.paymentsheet.PaymentSheetResult;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Stripe extends AppCompatActivity {
    Button button;
    String SECRET_KEY ="sk_test_51LinQQIYo0YFVe74JGaQhgrowJ3xtEXjOfDwGdi4jvFj8jmcNpVHGJCt1W13GlVsdyNt6xt4opZye7om4P2MSbaQ00myVXsD7g";
    String PUBLISH_KEY ="pk_test_51LinQQIYo0YFVe74pyFxphWwAC4huLEjOe5xmZf3Z8BuzAabzWnVNbGRkMGWXlljZIfqbkPf5ApeRiwxnS2ClHP200VFZmUG50";
    PaymentSheet paymentSheet;
    String customerID;
    String EphericalKey;
    String ClientSecret;
    TextView money;
    Integer amt;
    HashMap<String, String> hashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stripe);

        button = findViewById(R.id.btn);
        money = findViewById(R.id.money);
        Intent intent = getIntent();
        amt = intent.getIntExtra("dinero",0);
        money.setText("Cantidad a donar: " + amt.toString());
        hashMap = (HashMap<String, String>)intent.getSerializableExtra("donor");
        Log.wtf("JSON",amt.toString());

        PaymentConfiguration.init(this, PUBLISH_KEY);
        paymentSheet = new PaymentSheet(this, paymentSheetResult -> {
            onPaymentResult(paymentSheetResult);

        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PaymentFlow();
            }
        });

        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                "https://api.stripe.com/v1/customers",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject object = new JSONObject(response);
                            customerID=object.getString("id");
                            Log.wtf("JSON",customerID);

                            getEphericalKey(customerID);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> header = new HashMap<>();
                header.put("Authorization","Bearer "+SECRET_KEY);
                return header;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(Stripe.this);
        requestQueue.add(stringRequest);


    }

    private void onPaymentResult(PaymentSheetResult paymentSheetResult) {
        if(paymentSheetResult instanceof PaymentSheetResult.Completed){
            Toast.makeText(this,"payment success",Toast.LENGTH_SHORT).show();
            Intent myIntent = new Intent(Stripe.this, MensajeDonaciNActivity.class);
            myIntent.putExtra("donation", hashMap); //Optional parameters
            Stripe.this.startActivity(myIntent);
        }
    }

    private void getEphericalKey(String customerID2) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                "https://api.stripe.com/v1/ephemeral_keys",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject object = new JSONObject(response);
                            EphericalKey=object.getString("id");
                            Log.wtf("JSON",EphericalKey);
                            getClientSecret(customerID2,EphericalKey);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> header = new HashMap<>();
                header.put("Authorization","Bearer "+SECRET_KEY);
                header.put("Stripe-Version","2022-08-01");
                return header;
            }

            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("customer",customerID2);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(Stripe.this);
        requestQueue.add(stringRequest);

    }

    private void getClientSecret(String customerID, String ephericalKey) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                "https://api.stripe.com/v1/payment_intents",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject object = new JSONObject(response);
                            ClientSecret=object.getString("client_secret");
                            Log.wtf("JSON",ClientSecret);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> header = new HashMap<>();
                header.put("Authorization","Bearer "+SECRET_KEY);
                return header;
            }

            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                money = findViewById(R.id.money);
                params.put("customer",customerID);
                params.put("amount",amt.toString() + "00");
                Log.wtf("JSON",money.getText().toString());
                params.put("currency","mxn");
                params.put("automatic_payment_methods[enabled]","true");
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(Stripe.this);
        requestQueue.add(stringRequest);
    }

    private void PaymentFlow() {
        paymentSheet.presentWithPaymentIntent(
                ClientSecret,new PaymentSheet.Configuration("BAMX",
                        new PaymentSheet.CustomerConfiguration(
                                customerID,
                                EphericalKey
                        ))

        );
    }
}