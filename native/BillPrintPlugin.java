package com.shop.menswearbilling;

import android.content.Context;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "BillPrint")
public class BillPrintPlugin extends Plugin {
    private WebView holder;

    @PluginMethod
    public void print(final PluginCall call) {
        final String html = call.getString("html", "");
        getActivity().runOnUiThread(() -> {
            holder = new WebView(getContext());
            holder.setWebViewClient(new WebViewClient() {
                @Override
                public void onPageFinished(WebView view, String url) {
                    PrintManager pm = (PrintManager) getActivity().getSystemService(Context.PRINT_SERVICE);
                    PrintDocumentAdapter adapter = view.createPrintDocumentAdapter("Bill");
                    pm.print("Bill", adapter, new PrintAttributes.Builder().build());
                    call.resolve();
                }
            });
            holder.loadDataWithBaseURL(null, html, "text/html", "UTF-8", null);
        });
    }
}
