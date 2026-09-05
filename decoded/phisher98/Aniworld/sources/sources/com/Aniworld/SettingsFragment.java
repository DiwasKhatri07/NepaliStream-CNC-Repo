package com.Aniworld;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.lagradost.cloudstream3.CommonActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: SettingsFragment.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Aniworld/classes.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\n\u001a\u0002H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f*\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002¢\u0006\u0002\u0010\u000fJ&\u0010\u0010\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J@\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0017b\u0016\b\u001b\u0012\u0012\b\u001c\u0012\u000e\b\fJ\u0004\b\b(\u001dJ\u0004\b\b(\u001eb\f\b\u001f\u0012\b\b\u001c\u0012\u0004\b\u0003\u0010.J\"\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\"H\u0003b\u0010\b\u001b\u0012\f\b\u001c\u0012\b\b\fJ\u0004\b\b(\u001dJ\u0010\u0010#\u001a\u00020\u00182\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010$\u001a\u00020\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/Aniworld/SettingsFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "plugin", "Lcom/Aniworld/AniworldPlugin;", "sharedPref", "Landroid/content/SharedPreferences;", "<init>", "(Lcom/Aniworld/AniworldPlugin;Landroid/content/SharedPreferences;)V", "res", "Landroid/content/res/Resources;", "findView", "T", "Landroid/view/View;", "name", "", "(Landroid/view/View;Ljava/lang/String;)Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "onViewCreated", "view", "Landroid/annotation/SuppressLint;", "value", "SetJavaScriptEnabled", "SetTextI18n", "Landroidx/annotation/RequiresApi;", "setupWebView", "webView", "Landroid/webkit/WebView;", "extractAndSaveCookie", "restartApp", "Aniworld"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSettingsFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SettingsFragment.kt\ncom/Aniworld/SettingsFragment\n+ 2 SharedPreferences.kt\nandroidx/core/content/SharedPreferencesKt\n*L\n1#1,191:1\n40#2,11:192\n40#2,11:203\n40#2,11:214\n*S KotlinDebug\n*F\n+ 1 SettingsFragment.kt\ncom/Aniworld/SettingsFragment\n*L\n79#1:192,11\n102#1:203,11\n156#1:214,11\n*E\n"})
public final class SettingsFragment extends BottomSheetDialogFragment {

    @NotNull
    private final Resources res;

    @NotNull
    private final SharedPreferences sharedPref;

    public SettingsFragment(@NotNull AniworldPlugin plugin, @NotNull SharedPreferences sharedPref) throws Exception {
        this.sharedPref = sharedPref;
        Resources resources = plugin.getResources();
        if (resources != null) {
            this.res = resources;
            return;
        }
        throw new Exception("Unable to read resources");
    }

    private final <T extends View> T findView(View view, String str) {
        return (T) view.findViewById(this.res.getIdentifier(str, "id", "com.phisher98"));
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int id = this.res.getIdentifier("settings_fragment", "layout", "com.phisher98");
        XmlResourceParser layout = this.res.getLayout(id);
        return inflater.inflate((XmlPullParser) layout, container, false);
    }

    public void onStart() {
        BottomSheetBehavior $this$onStart_u24lambda_u240;
        super.onStart();
        BottomSheetDialog dialog = getDialog();
        BottomSheetDialog bottomSheetDialog = dialog instanceof BottomSheetDialog ? dialog : null;
        if (bottomSheetDialog != null && ($this$onStart_u24lambda_u240 = bottomSheetDialog.getBehavior()) != null) {
            $this$onStart_u24lambda_u240.setState(3);
            $this$onStart_u24lambda_u240.setSkipCollapsed(true);
            $this$onStart_u24lambda_u240.setDraggable(false);
        }
    }

    @RequiresApi(23)
    @SuppressLint({"SetJavaScriptEnabled", "SetTextI18n"})
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        final EditText tokenInput = (EditText) findView(view, "tokenInput");
        Button addButton = (Button) findView(view, "addButton");
        Button resetButton = (Button) findView(view, "resetButton");
        Button loginButton = (Button) findView(view, "loginButton");
        final WebView webView = (WebView) findView(view, "authWebView");
        String savedToken = this.sharedPref.getString("serienstream_token", null);
        String str = savedToken;
        if (!(str == null || str.length() == 0)) {
            tokenInput.setText(savedToken);
        }
        setupWebView(webView);
        loginButton.setOnClickListener(new View.OnClickListener() { // from class: com.Aniworld.SettingsFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SettingsFragment.onViewCreated$lambda$0(webView, view2);
            }
        });
        addButton.setOnClickListener(new View.OnClickListener() { // from class: com.Aniworld.SettingsFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SettingsFragment.onViewCreated$lambda$1(tokenInput, this, view2);
            }
        });
        resetButton.setOnClickListener(new View.OnClickListener() { // from class: com.Aniworld.SettingsFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SettingsFragment.onViewCreated$lambda$2(this.f$0, tokenInput, view2);
            }
        });
    }

    static final void onViewCreated$lambda$0(WebView $webView, View it) {
        $webView.setVisibility(0);
        $webView.loadUrl("https://serienstream.to/login");
    }

    static final void onViewCreated$lambda$1(EditText $tokenInput, final SettingsFragment this$0, View it) {
        String token = StringsKt.trim($tokenInput.getText().toString()).toString();
        if (token.length() > 0) {
            SharedPreferences $this$edit$iv = this$0.sharedPref;
            SharedPreferences.Editor editor$iv = $this$edit$iv.edit();
            Intrinsics.checkExpressionValueIsNotNull(editor$iv, "editor");
            editor$iv.putString("serienstream_token", token);
            editor$iv.apply();
            Context ctx = this$0.getContext();
            if (ctx == null) {
                CommonActivity.showToast$default(CommonActivity.INSTANCE, "Error: Context is null", (Integer) null, 2, (Object) null);
                return;
            } else {
                new AlertDialog.Builder(ctx).setTitle("Save & Reload").setMessage("Changes have been saved. Do you want to restart the app to apply them?").setPositiveButton("Yes", new DialogInterface.OnClickListener() { // from class: com.Aniworld.SettingsFragment$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        SettingsFragment.onViewCreated$lambda$1$2(this.f$0, dialogInterface, i);
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: com.Aniworld.SettingsFragment$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.dismiss();
                    }
                }).show();
                return;
            }
        }
        CommonActivity.showToast$default(CommonActivity.INSTANCE, "Please enter a valid token", (Integer) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1$2(SettingsFragment this$0, DialogInterface dialogInterface, int i) {
        this$0.dismiss();
        this$0.restartApp();
    }

    static final void onViewCreated$lambda$2(SettingsFragment this$0, EditText $tokenInput, View it) {
        SharedPreferences $this$edit$iv = this$0.sharedPref;
        SharedPreferences.Editor editor$iv = $this$edit$iv.edit();
        Intrinsics.checkExpressionValueIsNotNull(editor$iv, "editor");
        editor$iv.remove("serienstream_token");
        editor$iv.apply();
        CookieManager $this$onViewCreated_u24lambda_u242_u241 = CookieManager.getInstance();
        $this$onViewCreated_u24lambda_u242_u241.setCookie("https://serienstream.to", "laravel_session=; domain=serienstream.to; path=/; Max-Age=0; expires=Thu, 01 Jan 1970 00:00:00 GMT");
        $this$onViewCreated_u24lambda_u242_u241.setCookie("https://serienstream.to", "remember_token=; domain=serienstream.to; path=/; Max-Age=0; expires=Thu, 01 Jan 1970 00:00:00 GMT");
        $this$onViewCreated_u24lambda_u242_u241.flush();
        WebStorage.getInstance().deleteAllData();
        $tokenInput.setText("");
        CommonActivity.showToast$default(CommonActivity.INSTANCE, "Token reset successfully. Restart the app.", (Integer) null, 2, (Object) null);
        this$0.dismiss();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private final void setupWebView(WebView webView) {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setUserAgentString("Mozilla/5.0 (Linux; Android 10; Mobile) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.90 Mobile Safari/537.36");
        CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true);
        webView.setWebViewClient(new C00111());
    }

    /* JADX INFO: renamed from: com.Aniworld.SettingsFragment$setupWebView$1 */
    /* JADX INFO: compiled from: SettingsFragment.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/Aniworld/SettingsFragment$setupWebView$1", "Landroid/webkit/WebViewClient;", "onPageFinished", "", "view", "Landroid/webkit/WebView;", "url", "", "Aniworld"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class C00111 extends WebViewClient {
        C00111() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(final WebView view, String url) {
            super.onPageFinished(view, url);
            if (url != null && !StringsKt.contains$default(url, "/login", false, 2, (Object) null) && view != null) {
                final SettingsFragment settingsFragment = SettingsFragment.this;
                view.postDelayed(new Runnable() { // from class: com.Aniworld.SettingsFragment$setupWebView$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        settingsFragment.extractAndSaveCookie(view);
                    }
                }, 1500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void extractAndSaveCookie(final WebView webView) {
        CookieManager cookieManager = CookieManager.getInstance();
        final String cookies = cookieManager.getCookie("https://serienstream.to");
        String str = cookies;
        if (!(str == null || str.length() == 0)) {
            try {
                if (StringsKt.contains$default(cookies, "laravel_session", false, 2, (Object) null) || StringsKt.contains$default(cookies, "remember_token", false, 2, (Object) null)) {
                    FragmentActivity activity = getActivity();
                    if (activity != null) {
                        activity.runOnUiThread(new Runnable() { // from class: com.Aniworld.SettingsFragment$$ExternalSyntheticLambda2
                            @Override // java.lang.Runnable
                            public final void run() {
                                SettingsFragment.extractAndSaveCookie$lambda$0(this.f$0, cookies, webView);
                            }
                        });
                        Unit unit = Unit.INSTANCE;
                    }
                } else {
                    CommonActivity.showToast$default(CommonActivity.INSTANCE, "Required cookies not found (need laravel_session or remember_token)", (Integer) null, 2, (Object) null);
                    Unit unit2 = Unit.INSTANCE;
                }
                return;
            } catch (Exception e) {
                CommonActivity.showToast$default(CommonActivity.INSTANCE, "Error extracting cookies: " + e.getMessage(), (Integer) null, 2, (Object) null);
                Unit unit3 = Unit.INSTANCE;
                return;
            }
        }
        CommonActivity.showToast$default(CommonActivity.INSTANCE, "No cookies found. Try logging in again.", (Integer) null, 2, (Object) null);
    }

    static final void extractAndSaveCookie$lambda$0(SettingsFragment this$0, String $cookies, WebView $webView) {
        try {
            EditText tokenInput = (EditText) this$0.findView(this$0.requireView(), "tokenInput");
            tokenInput.setText($cookies);
            SharedPreferences $this$edit$iv = this$0.sharedPref;
            SharedPreferences.Editor editor$iv = $this$edit$iv.edit();
            Intrinsics.checkExpressionValueIsNotNull(editor$iv, "editor");
            editor$iv.putString("serienstream_token", $cookies);
            editor$iv.apply();
            CommonActivity.showToast$default(CommonActivity.INSTANCE, "✓ Login successful! Cookie saved.", (Integer) null, 2, (Object) null);
            $webView.setVisibility(8);
            $webView.clearHistory();
            $webView.clearCache(true);
        } catch (Exception e) {
            CommonActivity.showToast$default(CommonActivity.INSTANCE, "Error saving cookie: " + e.getMessage(), (Integer) null, 2, (Object) null);
        }
    }

    private final void restartApp() {
        Context context = requireContext().getApplicationContext();
        PackageManager packageManager = context.getPackageManager();
        Intent intent = packageManager.getLaunchIntentForPackage(context.getPackageName());
        ComponentName componentName = intent != null ? intent.getComponent() : null;
        if (componentName != null) {
            Intent restartIntent = Intent.makeRestartActivityTask(componentName);
            context.startActivity(restartIntent);
            Runtime.getRuntime().exit(0);
        }
    }
}
