package com.phisher98.settings;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.lagradost.cloudstream3.CommonActivity;
import com.phisher98.StreamPlayPlugin;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: SettingsFragment.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\f\u0010\u0011\u001a\u00020\b*\u00020\u0012H\u0002J#\u0010\u0013\u001a\u0002H\u0014\"\b\b\u0000\u0010\u0014*\u00020\u0012*\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¢\u0006\u0002\u0010\u0015J&\u0010\u0016\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\bH\u0016J@\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u00122\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0017b\u0016\b \u0012\u0012\b!\u0012\u000e\b\fJ\u0004\b\b(\"J\u0004\b\b(#b\f\b$\u0012\b\b!\u0012\u0004\b\u0003\u0010.J\"\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020'H\u0003b\u0010\b \u0012\f\b!\u0012\b\b\fJ\u0004\b\b(\"J\u0010\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020*H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/phisher98/settings/SettingsFragment;", "Landroidx/fragment/app/DialogFragment;", "plugin", "Lcom/phisher98/StreamPlayPlugin;", "sharedPref", "Landroid/content/SharedPreferences;", "onDismissCallback", "Lkotlin/Function0;", "", "<init>", "(Lcom/phisher98/StreamPlayPlugin;Landroid/content/SharedPreferences;Lkotlin/jvm/functions/Function0;)V", "res", "Landroid/content/res/Resources;", "getDrawable", "Landroid/graphics/drawable/Drawable;", "name", "", "makeTvCompatible", "Landroid/view/View;", "findView", "T", "(Landroid/view/View;Ljava/lang/String;)Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onViewCreated", "view", "Landroid/annotation/SuppressLint;", "value", "SetJavaScriptEnabled", "SetTextI18n", "Landroidx/annotation/RequiresApi;", "setupWebView", "webView", "Landroid/webkit/WebView;", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class SettingsFragment extends DialogFragment {

    @Nullable
    private final Function0<Unit> onDismissCallback;

    @NotNull
    private final Resources res;

    @NotNull
    private final SharedPreferences sharedPref;

    public SettingsFragment(@NotNull StreamPlayPlugin plugin, @NotNull SharedPreferences sharedPref, @Nullable Function0<Unit> function0) throws Exception {
        this.sharedPref = sharedPref;
        this.onDismissCallback = function0;
        Resources resources = plugin.getResources();
        if (resources != null) {
            this.res = resources;
            return;
        }
        throw new Exception("Unable to read resources");
    }

    public /* synthetic */ SettingsFragment(StreamPlayPlugin streamPlayPlugin, SharedPreferences sharedPreferences, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(streamPlayPlugin, sharedPreferences, (i & 4) != 0 ? null : function0);
    }

    private final Drawable getDrawable(String name) throws Exception {
        int id = this.res.getIdentifier(name, "drawable", "com.phisher98");
        Drawable drawable = this.res.getDrawable(id, null);
        if (drawable != null) {
            return drawable;
        }
        throw new Exception("Drawable " + name + " not found");
    }

    private final void makeTvCompatible(View $this$makeTvCompatible) {
        int outlineId = this.res.getIdentifier("outline", "drawable", "com.phisher98");
        $this$makeTvCompatible.setBackground(this.res.getDrawable(outlineId, null));
    }

    private final <T extends View> T findView(View view, String str) {
        return (T) view.findViewById(this.res.getIdentifier(str, "id", "com.phisher98"));
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int id = this.res.getIdentifier("settings_fragment", "layout", "com.phisher98");
        XmlResourceParser layout = this.res.getLayout(id);
        View view = inflater.inflate((XmlPullParser) layout, container, false);
        int drawableId = this.res.getIdentifier("dialog_background", "drawable", "com.phisher98");
        if (drawableId != 0) {
            view.setBackground(this.res.getDrawable(drawableId, null));
        }
        return view;
    }

    public void onStart() {
        Window $this$onStart_u24lambda_u240;
        int width;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && ($this$onStart_u24lambda_u240 = dialog.getWindow()) != null) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            int maxDialogWidth = (int) (500.0f * displayMetrics.density);
            if (displayMetrics.widthPixels > 0 && displayMetrics.widthPixels > maxDialogWidth) {
                width = maxDialogWidth;
            } else {
                width = (int) (displayMetrics.widthPixels * 0.9f);
            }
            $this$onStart_u24lambda_u240.setLayout(width, -2);
            $this$onStart_u24lambda_u240.setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    @RequiresApi(23)
    @SuppressLint({"SetJavaScriptEnabled", "SetTextI18n"})
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        final EditText tokenInput = (EditText) findView(view, "tokenInput");
        Button addButton = (Button) findView(view, "addButton");
        Button resetButton = (Button) findView(view, "resetButton");
        Button loginButton = (Button) findView(view, "loginButton");
        tokenInput.setBackground(getDrawable("input_text_selector"));
        addButton.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#6200EE")));
        addButton.setTextColor(-1);
        resetButton.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#D32F2F")));
        resetButton.setTextColor(-1);
        loginButton.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#4285F4")));
        loginButton.setTextColor(-1);
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

    static final void onViewCreated$lambda$1(EditText $tokenInput, SettingsFragment this$0, View it) {
        String string = StringsKt.trim($tokenInput.getText().toString()).toString();
        if (string.length() > 0) {
            if (!StringsKt.startsWith$default(string, "ui=", false, 2, (Object) null)) {
                string = "ui=" + string;
            }
            SharedPreferences.Editor $this$onViewCreated_u24lambda_u241_u240 = this$0.sharedPref.edit();
            if ($this$onViewCreated_u24lambda_u241_u240 != null) {
                $this$onViewCreated_u24lambda_u241_u240.putString("token", string);
                $this$onViewCreated_u24lambda_u241_u240.apply();
            }
            CommonActivity.showToast$default(CommonActivity.INSTANCE, "Token saved successfully. Restart the app.", (Integer) null, 2, (Object) null);
            this$0.dismiss();
            return;
        }
        CommonActivity.showToast$default(CommonActivity.INSTANCE, "Please enter a valid token", (Integer) null, 2, (Object) null);
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
        webView.setWebViewClient(new C03171(webView));
    }

    /* JADX INFO: renamed from: com.phisher98.settings.SettingsFragment$setupWebView$1 */
    /* JADX INFO: compiled from: SettingsFragment.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/phisher98/settings/SettingsFragment$setupWebView$1", "Landroid/webkit/WebViewClient;", "onPageFinished", "", "view", "Landroid/webkit/WebView;", "url", "", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nSettingsFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SettingsFragment.kt\ncom/phisher98/settings/SettingsFragment$setupWebView$1\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,197:1\n184#2,2:198\n*S KotlinDebug\n*F\n+ 1 SettingsFragment.kt\ncom/phisher98/settings/SettingsFragment$setupWebView$1\n*L\n167#1:198,2\n*E\n"})
    public static final class C03171 extends WebViewClient {
        final /* synthetic */ WebView $webView;

        C03171(WebView $webView) {
            this.$webView = $webView;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(final WebView view, String url) {
            List listSplit$default;
            Sequence sequenceAsSequence;
            Sequence $this$firstOrNull$iv;
            Object element$iv;
            String it;
            super.onPageFinished(view, url);
            if (view != null) {
                final SettingsFragment settingsFragment = SettingsFragment.this;
                view.evaluateJavascript("(function() { return document.body.scrollHeight; })();", new ValueCallback() { // from class: com.phisher98.settings.SettingsFragment$setupWebView$1$$ExternalSyntheticLambda0
                    @Override // android.webkit.ValueCallback
                    public final void onReceiveValue(Object obj) {
                        SettingsFragment.C03171.onPageFinished$lambda$0(settingsFragment, view, (String) obj);
                    }
                });
            }
            CookieManager cookieManager = CookieManager.getInstance();
            String cookies = cookieManager.getCookie(url == null ? "" : url);
            String token = null;
            if (cookies != null && (listSplit$default = StringsKt.split$default(cookies, new String[]{";"}, false, 0, 6, (Object) null)) != null && (sequenceAsSequence = CollectionsKt.asSequence(listSplit$default)) != null && ($this$firstOrNull$iv = SequencesKt.map(sequenceAsSequence, new Function1() { // from class: com.phisher98.settings.SettingsFragment$setupWebView$1$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    return StringsKt.trim((String) obj).toString();
                }
            })) != null) {
                Iterator it2 = $this$firstOrNull$iv.iterator();
                do {
                    if (!it2.hasNext()) {
                        element$iv = null;
                        break;
                    } else {
                        element$iv = it2.next();
                        it = (String) element$iv;
                    }
                } while (!StringsKt.startsWith$default(it, "ui=", false, 2, (Object) null));
                String str = (String) element$iv;
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
                activity.runOnUiThread(new Runnable() { // from class: com.phisher98.settings.SettingsFragment$setupWebView$1$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        SettingsFragment.C03171.onPageFinished$lambda$3(settingsFragment2, finalToken, webView);
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

    public void onDismiss(@NotNull DialogInterface dialog) {
        super.onDismiss(dialog);
        Function0<Unit> function0 = this.onDismissCallback;
        if (function0 != null) {
            function0.invoke();
        }
    }
}
