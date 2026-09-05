package com.phisher98.settings;

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
import android.webkit.ValueCallback;
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
import com.phisher98.SuperStreamPlugin;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: SettingsFragment.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/SuperStream/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\n\u001a\u0002H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f*\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002¢\u0006\u0002\u0010\u000fJ&\u0010\u0010\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J@\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0017b\u0016\b\u001b\u0012\u0012\b\u001c\u0012\u000e\b\fJ\u0004\b\b(\u001dJ\u0004\b\b(\u001eb\f\b\u001f\u0012\b\b\u001c\u0012\u0004\b\u0003\u0010.J\"\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\"H\u0003b\u0010\b\u001b\u0012\f\b\u001c\u0012\b\b\fJ\u0004\b\b(\u001dJ\b\u0010#\u001a\u00020\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/phisher98/settings/SettingsFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "plugin", "Lcom/phisher98/SuperStreamPlugin;", "sharedPref", "Landroid/content/SharedPreferences;", "<init>", "(Lcom/phisher98/SuperStreamPlugin;Landroid/content/SharedPreferences;)V", "res", "Landroid/content/res/Resources;", "findView", "T", "Landroid/view/View;", "name", "", "(Landroid/view/View;Ljava/lang/String;)Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "onViewCreated", "view", "Landroid/annotation/SuppressLint;", "value", "SetJavaScriptEnabled", "SetTextI18n", "Landroidx/annotation/RequiresApi;", "setupWebView", "webView", "Landroid/webkit/WebView;", "restartApp", "SuperStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSettingsFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SettingsFragment.kt\ncom/phisher98/settings/SettingsFragment\n+ 2 SharedPreferences.kt\nandroidx/core/content/SharedPreferencesKt\n*L\n1#1,191:1\n40#2,11:192\n*S KotlinDebug\n*F\n+ 1 SettingsFragment.kt\ncom/phisher98/settings/SettingsFragment\n*L\n80#1:192,11\n*E\n"})
public final class SettingsFragment extends BottomSheetDialogFragment {

    @NotNull
    private final Resources res;

    @NotNull
    private final SharedPreferences sharedPref;

    public SettingsFragment(@NotNull SuperStreamPlugin plugin, @NotNull SharedPreferences sharedPref) throws Exception {
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
        String savedToken = this.sharedPref.getString("token", null);
        String str = savedToken;
        if (!(str == null || str.length() == 0)) {
            tokenInput.setText(savedToken);
        }
        setupWebView(webView);
        loginButton.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.settings.SettingsFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SettingsFragment.onViewCreated$lambda$0(webView, view2);
            }
        });
        addButton.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.settings.SettingsFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SettingsFragment.onViewCreated$lambda$1(tokenInput, this, view2);
            }
        });
        resetButton.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.settings.SettingsFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SettingsFragment.onViewCreated$lambda$2(this.f$0, tokenInput, view2);
            }
        });
    }

    static final void onViewCreated$lambda$0(WebView $webView, View it) {
        $webView.setVisibility(0);
        $webView.loadUrl("https://www.febbox.com/login/google?jump=%2F");
    }

    static final void onViewCreated$lambda$1(EditText $tokenInput, final SettingsFragment this$0, View it) {
        String token = StringsKt.trim($tokenInput.getText().toString()).toString();
        if (token.length() > 0) {
            String finalToken = StringsKt.startsWith$default(token, "ui=", false, 2, (Object) null) ? token : "ui=" + token;
            SharedPreferences $this$edit$iv = this$0.sharedPref;
            SharedPreferences.Editor editor$iv = $this$edit$iv.edit();
            Intrinsics.checkExpressionValueIsNotNull(editor$iv, "editor");
            editor$iv.putString("token", finalToken);
            editor$iv.apply();
            Context ctx = this$0.getContext();
            if (ctx == null) {
                CommonActivity.showToast$default(CommonActivity.INSTANCE, "Error: Context is null", (Integer) null, 2, (Object) null);
                return;
            } else {
                new AlertDialog.Builder(ctx).setTitle("Save & Reload").setMessage("Changes have been saved. Do you want to restart the app to apply them?").setPositiveButton("Yes", new DialogInterface.OnClickListener() { // from class: com.phisher98.settings.SettingsFragment$$ExternalSyntheticLambda3
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        SettingsFragment.onViewCreated$lambda$1$2(this.f$0, dialogInterface, i);
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: com.phisher98.settings.SettingsFragment$$ExternalSyntheticLambda4
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
        SharedPreferences.Editor $this$onViewCreated_u24lambda_u242_u240 = this$0.sharedPref.edit();
        if ($this$onViewCreated_u24lambda_u242_u240 != null) {
            $this$onViewCreated_u24lambda_u242_u240.remove("token");
            $this$onViewCreated_u24lambda_u242_u240.apply();
        }
        CookieManager $this$onViewCreated_u24lambda_u242_u241 = CookieManager.getInstance();
        $this$onViewCreated_u24lambda_u242_u241.setCookie("https://febbox.com", "ui=; domain=febbox.com; path=/; Max-Age=0; expires=Thu, 01 Jan 1970 00:00:00 GMT");
        $this$onViewCreated_u24lambda_u242_u241.setCookie("https://www.febbox.com", "ui=; domain=www.febbox.com; path=/; Max-Age=0; expires=Thu, 01 Jan 1970 00:00:00 GMT");
        $this$onViewCreated_u24lambda_u242_u241.flush();
        WebStorage.getInstance().deleteAllData();
        $tokenInput.setText("ui=");
        CommonActivity.showToast$default(CommonActivity.INSTANCE, "Token reset successfully. Restart the app.", (Integer) null, 2, (Object) null);
        this$0.dismiss();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private final void setupWebView(WebView webView) {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setUserAgentString("Mozilla/5.0 (Linux; Android 10; Mobile) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.90 Mobile Safari/537.36");
        CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true);
        webView.setWebViewClient(new C00231(webView));
    }

    /* JADX INFO: renamed from: com.phisher98.settings.SettingsFragment$setupWebView$1 */
    /* JADX INFO: compiled from: SettingsFragment.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/phisher98/settings/SettingsFragment$setupWebView$1", "Landroid/webkit/WebViewClient;", "onPageFinished", "", "view", "Landroid/webkit/WebView;", "url", "", "SuperStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nSettingsFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SettingsFragment.kt\ncom/phisher98/settings/SettingsFragment$setupWebView$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,191:1\n1739#2:192\n1814#2,3:193\n1#3:196\n*S KotlinDebug\n*F\n+ 1 SettingsFragment.kt\ncom/phisher98/settings/SettingsFragment$setupWebView$1\n*L\n152#1:192\n152#1:193,3\n*E\n"})
    public static final class C00231 extends WebViewClient {
        final /* synthetic */ WebView $webView;

        C00231(WebView $webView) {
            this.$webView = $webView;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(final WebView view, String url) {
            Iterable iterableSplit$default;
            Object next;
            String it;
            super.onPageFinished(view, url);
            if (view != null) {
                final SettingsFragment settingsFragment = SettingsFragment.this;
                view.evaluateJavascript("(function() { return document.body.scrollHeight; })();", new ValueCallback() { // from class: com.phisher98.settings.SettingsFragment$setupWebView$1$$ExternalSyntheticLambda0
                    @Override // android.webkit.ValueCallback
                    public final void onReceiveValue(Object obj) {
                        SettingsFragment.C00231.onPageFinished$lambda$0(settingsFragment, view, (String) obj);
                    }
                });
            }
            CookieManager cookieManager = CookieManager.getInstance();
            String cookies = cookieManager.getCookie(url == null ? "" : url);
            String token = null;
            if (cookies != null && (iterableSplit$default = StringsKt.split$default(cookies, new String[]{";"}, false, 0, 6, (Object) null)) != null) {
                Iterable $this$map$iv = iterableSplit$default;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    String it2 = (String) item$iv$iv;
                    destination$iv$iv.add(StringsKt.trim(it2).toString());
                }
                Iterator it3 = ((List) destination$iv$iv).iterator();
                do {
                    if (!it3.hasNext()) {
                        next = null;
                        break;
                    } else {
                        next = it3.next();
                        it = (String) next;
                    }
                } while (!StringsKt.startsWith$default(it, "ui=", false, 2, (Object) null));
                String str = (String) next;
                if (str != null) {
                    token = StringsKt.removePrefix(str, "ui=");
                }
            }
            String str2 = token;
            if ((str2 == null || str2.length() == 0) || view == null) {
                return;
            }
            final String finalToken = "ui=" + token;
            FragmentActivity activity = SettingsFragment.this.getActivity();
            if (activity != null) {
                final SettingsFragment settingsFragment2 = SettingsFragment.this;
                final WebView webView = this.$webView;
                activity.runOnUiThread(new Runnable() { // from class: com.phisher98.settings.SettingsFragment$setupWebView$1$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        SettingsFragment.C00231.onPageFinished$lambda$3(settingsFragment2, finalToken, webView);
                    }
                });
            }
        }

        static final void onPageFinished$lambda$0(SettingsFragment this$0, WebView $view, String value) {
            Float height = StringsKt.toFloatOrNull(StringsKt.replace$default(value, "\"", "", false, 4, (Object) null));
            if (height != null) {
                float density = this$0.getResources().getDisplayMetrics().density;
                ViewGroup.LayoutParams layoutParams = $view.getLayoutParams();
                layoutParams.height = (int) (height.floatValue() * density);
                $view.setLayoutParams(layoutParams);
            }
        }

        static final void onPageFinished$lambda$3(SettingsFragment this$0, String $finalToken, WebView $webView) {
            EditText tokenInput = (EditText) this$0.requireView().findViewById(this$0.res.getIdentifier("tokenInput", "id", "com.phisher98"));
            tokenInput.setText($finalToken);
            SharedPreferences.Editor $this$onPageFinished_u24lambda_u243_u240 = this$0.sharedPref.edit();
            if ($this$onPageFinished_u24lambda_u243_u240 != null) {
                $this$onPageFinished_u24lambda_u243_u240.putString("token", $finalToken);
                $this$onPageFinished_u24lambda_u243_u240.apply();
            }
            CommonActivity.showToast$default(CommonActivity.INSTANCE, "Login successful!", (Integer) null, 2, (Object) null);
            $webView.setVisibility(8);
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
