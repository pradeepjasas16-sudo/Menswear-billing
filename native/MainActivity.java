package com.shop.menswearbilling;

import android.os.Bundle;
import com.getcapacitor.BridgeActivity;

public class MainActivity extends BridgeActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        registerPlugin(BillPrintPlugin.class);
        super.onCreate(savedInstanceState);
    }
}
