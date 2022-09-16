package com.application.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.paypal.checkout.PayPalCheckout;
import com.paypal.checkout.approve.Approval;
import com.paypal.checkout.approve.OnApprove;
import com.paypal.checkout.config.CheckoutConfig;
import com.paypal.checkout.config.Environment;
import com.paypal.checkout.config.SettingsConfig;
import com.paypal.checkout.createorder.CreateOrder;
import com.paypal.checkout.createorder.CreateOrderActions;
import com.paypal.checkout.createorder.CurrencyCode;
import com.paypal.checkout.createorder.OrderIntent;
import com.paypal.checkout.createorder.UserAction;
import com.paypal.checkout.order.Amount;
import com.paypal.checkout.order.AppContext;
import com.paypal.checkout.order.CaptureOrderResult;
import com.paypal.checkout.order.OnCaptureComplete;
import com.paypal.checkout.order.Order;
import com.paypal.checkout.order.PurchaseUnit;
import com.paypal.checkout.paymentbutton.PayPalButton;
import com.paypal.checkout.paymentbutton.PaymentButtonContainer;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class PayPal extends AppCompatActivity {

    PaymentButtonContainer payPalButton;

    private static final String YOUR_CLIENT_ID ="AXayZci2tDIo6lcLCAnkkdQ34Nkp5NHii8XegJ5sChswt8r2Lh7KL0F_CMGQJDKy8Yz9ha-aiMUsjouU";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_pal);
        payPalButton = findViewById(R.id.payPalButton);
        PayPalCheckout.setConfig(new CheckoutConfig(
                getApplication(),
                YOUR_CLIENT_ID,
                Environment.SANDBOX,
                "com.application.app://paypalpay",
                CurrencyCode.USD,
                UserAction.PAY_NOW

        ));

        payPalButton.setup(
                new CreateOrder() {
                    @Override
                    public void create(@NotNull CreateOrderActions createOrderActions) {
                        ArrayList<PurchaseUnit> purchaseUnits = new ArrayList<>();
                        purchaseUnits.add(
                                new PurchaseUnit.Builder()
                                        .amount(
                                                new Amount.Builder()
                                                        .currencyCode(CurrencyCode.USD)
                                                        .value("10.00")
                                                        .build()
                                        )
                                        .build()
                        );
                        Order order = new Order(
                                OrderIntent.CAPTURE,
                                new AppContext.Builder()
                                        .userAction(UserAction.PAY_NOW)
                                        .build(),
                                purchaseUnits
                        );
                        createOrderActions.create(order, (CreateOrderActions.OnOrderCreated) null);
                    }
                },
                new OnApprove() {
                    @Override
                    public void onApprove(@NotNull Approval approval) {
                        approval.getOrderActions().capture(new OnCaptureComplete() {
                            @Override
                            public void onCaptureComplete(@NotNull CaptureOrderResult result) {
                                Log.i("CaptureOrder", String.format("CaptureOrderResult: %s", result));
                            }
                        });
                    }
                }
        );





    }
}