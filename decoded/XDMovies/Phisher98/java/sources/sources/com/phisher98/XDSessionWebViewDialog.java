package com.phisher98;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.lagradost.api.Log;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import okhttp3.CookieJar;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: compiled from: XDSessionWebViewDialog.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/XDMovies/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000s\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\u0018\u0018\u0000 12\u00020\u0001:\u000212B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\bH\u0016J$\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020 2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010'\u001a\u00020\bH\u0016J \u0010(\u001a\u00020\fH\u0003b\u0016\b)\u0012\u0012\b*\u0012\u000e\b\fJ\u0004\b\b(+J\u0004\b\b(,J\u0010\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020\u0003H\u0002J\u0012\u0010/\u001a\u00020\b2\b\u00100\u001a\u0004\u0018\u00010\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019¨\u00063"}, d2 = {"Lcom/phisher98/XDSessionWebViewDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "baseUrl", "", "sessionId", "fingerprint", "onResult", "Lkotlin/Function1;", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "webView", "Landroid/webkit/WebView;", "statusText", "Landroid/widget/TextView;", "progressBar", "Landroid/widget/ProgressBar;", "handler", "Landroid/os/Handler;", "resolved", "", "elapsedMs", "", "timeoutRunnable", "com/phisher98/XDSessionWebViewDialog$timeoutRunnable$1", "Lcom/phisher98/XDSessionWebViewDialog$timeoutRunnable$1;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onResume", "buildWebView", "Landroid/annotation/SuppressLint;", "value", "SetJavaScriptEnabled", "JavascriptInterface", "updateStatus", "msg", "resolve", "url", "Companion", "AndroidBridge", "XDMovies"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nXDSessionWebViewDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 XDSessionWebViewDialog.kt\ncom/phisher98/XDSessionWebViewDialog\n+ 2 Color.kt\nandroidx/core/graphics/ColorKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,407:1\n432#2:408\n432#2:409\n1#3:410\n*S KotlinDebug\n*F\n+ 1 XDSessionWebViewDialog.kt\ncom/phisher98/XDSessionWebViewDialog\n*L\n181#1:408\n198#1:409\n*E\n"})
public final class XDSessionWebViewDialog extends BottomSheetDialogFragment {
    private static final long POLL_INTERVAL_MS = 1000;

    @NotNull
    private static final String TAG = "XDSession_WebView";
    private static final long TIMEOUT_MS = 120000;

    @NotNull
    private final String baseUrl;
    private long elapsedMs;

    @NotNull
    private final String fingerprint;

    @NotNull
    private final Function1<String, Unit> onResult;

    @Nullable
    private ProgressBar progressBar;
    private boolean resolved;

    @NotNull
    private final String sessionId;

    @Nullable
    private TextView statusText;

    @Nullable
    private WebView webView;

    @NotNull
    private final Handler handler = new Handler(Looper.getMainLooper());

    @NotNull
    private final XDSessionWebViewDialog$timeoutRunnable$1 timeoutRunnable = new Runnable() { // from class: com.phisher98.XDSessionWebViewDialog$timeoutRunnable$1
        @Override // java.lang.Runnable
        public void run() {
            if (this.this$0.resolved || !this.this$0.isAdded()) {
                return;
            }
            this.this$0.elapsedMs += 1000;
            long secs = this.this$0.elapsedMs / 1000;
            long remaining = (120000 - this.this$0.elapsedMs) / 1000;
            this.this$0.updateStatus("🔓 " + secs + "s elapsed — " + remaining + "s remaining — waiting for Turnstile…");
            if (this.this$0.elapsedMs < 120000) {
                this.this$0.handler.postDelayed(this, 1000L);
            } else {
                Log.INSTANCE.e("XDSession_WebView", "Timed out after 120s");
                this.this$0.resolve(null);
            }
        }
    };

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.phisher98.XDSessionWebViewDialog$timeoutRunnable$1] */
    public XDSessionWebViewDialog(@NotNull String baseUrl, @NotNull String sessionId, @NotNull String fingerprint, @NotNull Function1<? super String, Unit> function1) {
        this.baseUrl = baseUrl;
        this.sessionId = sessionId;
        this.fingerprint = fingerprint;
        this.onResult = function1;
    }

    /* JADX INFO: compiled from: XDSessionWebViewDialog.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0007b\u0002\b\u000fR\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/phisher98/XDSessionWebViewDialog$AndroidBridge;", "", "<init>", "(Lcom/phisher98/XDSessionWebViewDialog;)V", "isolatedApp", "Lcom/lagradost/nicehttp/Requests;", "getIsolatedApp", "()Lcom/lagradost/nicehttp/Requests;", "isolatedApp$delegate", "Lkotlin/Lazy;", "onTurnstileToken", "", "token", "", "fp", "Landroid/webkit/JavascriptInterface;", "XDMovies"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nXDSessionWebViewDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 XDSessionWebViewDialog.kt\ncom/phisher98/XDSessionWebViewDialog$AndroidBridge\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,407:1\n296#2,2:408\n1#3:410\n*S KotlinDebug\n*F\n+ 1 XDSessionWebViewDialog.kt\ncom/phisher98/XDSessionWebViewDialog$AndroidBridge\n*L\n78#1:408,2\n*E\n"})
    public final class AndroidBridge {

        /* JADX INFO: renamed from: isolatedApp$delegate, reason: from kotlin metadata */
        @NotNull
        private final Lazy isolatedApp = LazyKt.lazy(new Function0() { // from class: com.phisher98.XDSessionWebViewDialog$AndroidBridge$$ExternalSyntheticLambda1
            public final Object invoke() {
                return XDSessionWebViewDialog.AndroidBridge.isolatedApp_delegate$lambda$0();
            }
        });

        public AndroidBridge() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Requests getIsolatedApp() {
            return (Requests) this.isolatedApp.getValue();
        }

        static final Requests isolatedApp_delegate$lambda$0() {
            return new Requests(MainActivityKt.getApp().getBaseClient().newBuilder().cookieJar(CookieJar.NO_COOKIES).build(), (Map) null, (String) null, (Map) null, (Map) null, 0, (TimeUnit) null, 0L, (ResponseParser) null, 510, (DefaultConstructorMarker) null);
        }

        @JavascriptInterface
        public final void onTurnstileToken(@NotNull final String token, @NotNull final String fp) {
            Log.INSTANCE.d(XDSessionWebViewDialog.TAG, "Got Turnstile Token natively!");
            final XDSessionWebViewDialog xDSessionWebViewDialog = XDSessionWebViewDialog.this;
            new Thread(new Runnable() { // from class: com.phisher98.XDSessionWebViewDialog$AndroidBridge$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    XDSessionWebViewDialog.AndroidBridge.onTurnstileToken$lambda$0(xDSessionWebViewDialog, this, fp, token);
                }
            }).start();
        }

        /* JADX WARN: Code duplicated, block: B:18:0x0066  */
        static final void onTurnstileToken$lambda$0(XDSessionWebViewDialog xDSessionWebViewDialog, AndroidBridge androidBridge, String str, String str2) {
            String string;
            XDSessionWebViewDialog xDSessionWebViewDialog2;
            Object obj;
            List listSplit$default;
            Object next;
            String cookie = CookieManager.getInstance().getCookie(xDSessionWebViewDialog.baseUrl);
            String str3 = null;
            if (cookie == null || (listSplit$default = StringsKt.split$default(cookie, new String[]{";"}, false, 0, 6, (Object) null)) == null) {
                string = "";
            } else {
                Iterator it = listSplit$default.iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!StringsKt.startsWith$default(StringsKt.trim((String) next).toString(), "cf_clearance=", false, 2, (Object) null));
                String str4 = (String) next;
                if (str4 == null || (string = StringsKt.trim(str4).toString()) == null) {
                    string = "";
                }
            }
            String str5 = string;
            boolean z = true;
            String string2 = (str5.length() > 0 ? new StringBuilder().append("sid=").append(xDSessionWebViewDialog.sessionId).append("; ").append(str5) : new StringBuilder().append("sid=").append(xDSessionWebViewDialog.sessionId)).toString();
            int i = 0;
            boolean z2 = false;
            while (true) {
                if (z2 || i >= 20 || xDSessionWebViewDialog.resolved) {
                    xDSessionWebViewDialog2 = xDSessionWebViewDialog;
                    break;
                }
                i++;
                try {
                    xDSessionWebViewDialog2 = xDSessionWebViewDialog;
                    try {
                        NiceResponse niceResponse = (NiceResponse) BuildersKt.runBlockingK$default(str3, new XDSessionWebViewDialog$AndroidBridge$onTurnstileToken$1$resp$1(androidBridge, xDSessionWebViewDialog2, string2, str, str2, null), z ? 1 : 0, str3);
                        String text = niceResponse.getText();
                        Log.INSTANCE.d(XDSessionWebViewDialog.TAG, "Session complete response [" + niceResponse.getCode() + "]: " + text);
                        if (niceResponse.getCode() == 400) {
                            Log.INSTANCE.e(XDSessionWebViewDialog.TAG, "Got 400 from /api/session/complete — session rejected, aborting");
                            xDSessionWebViewDialog2.resolve(str3);
                            z2 = true;
                            i = i;
                            break;
                        }
                        try {
                            Result.Companion companion = Result.Companion;
                            obj = Result.constructor-impl(new JSONObject(text));
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        if (Result.isFailure-impl(obj)) {
                            obj = str3;
                        }
                        JSONObject jSONObject = (JSONObject) obj;
                        String strOptString = jSONObject != null ? jSONObject.optString("token") : str3;
                        if (strOptString == null) {
                            strOptString = "";
                        }
                        String strOptString2 = jSONObject != null ? jSONObject.optString("error") : str3;
                        if (strOptString2 == null) {
                            strOptString2 = "";
                        }
                        if (strOptString.length() > 0) {
                            Log.INSTANCE.d(XDSessionWebViewDialog.TAG, "Session complete posted successfully");
                            xDSessionWebViewDialog2.resolve("COMPLETE:" + strOptString);
                            z2 = true;
                            str3 = null;
                        } else if (StringsKt.contains(strOptString2, "wait", z) || StringsKt.contains(strOptString2, "timer", z)) {
                            Log.INSTANCE.d(XDSessionWebViewDialog.TAG, "Server timer not ready. Retrying in 1s... (" + i + "/20)");
                            xDSessionWebViewDialog2.updateStatus("Waiting for server timer... (" + i + "/20)");
                            Thread.sleep(XDSessionWebViewDialog.POLL_INTERVAL_MS);
                            str3 = null;
                            z = true;
                        } else {
                            Log.INSTANCE.e(XDSessionWebViewDialog.TAG, "Unknown error or missing token: " + text);
                            xDSessionWebViewDialog2.resolve("COMPLETE");
                            z2 = true;
                            str3 = null;
                            z = true;
                        }
                    } catch (Exception e) {
                        e = e;
                        Log.INSTANCE.e(XDSessionWebViewDialog.TAG, "onTurnstileToken error: " + e);
                        xDSessionWebViewDialog2.resolve(null);
                        z2 = true;
                        str3 = null;
                        z = true;
                    }
                    e = e;
                } catch (Exception e2) {
                    e = e2;
                    xDSessionWebViewDialog2 = xDSessionWebViewDialog;
                }
                Log.INSTANCE.e(XDSessionWebViewDialog.TAG, "onTurnstileToken error: " + e);
                xDSessionWebViewDialog2.resolve(null);
                z2 = true;
                str3 = null;
                z = true;
            }
            if (z2) {
                return;
            }
            Log.INSTANCE.e(XDSessionWebViewDialog.TAG, "All " + i + " retries exhausted without session completion — giving up");
            xDSessionWebViewDialog2.resolve(null);
        }
    }

    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        BottomSheetBehavior $this$onCreateDialog_u24lambda_u240;
        BottomSheetDialog bottomSheetDialogOnCreateDialog = super.onCreateDialog(savedInstanceState);
        BottomSheetDialog bottomSheetDialog = bottomSheetDialogOnCreateDialog instanceof BottomSheetDialog ? bottomSheetDialogOnCreateDialog : null;
        if (bottomSheetDialog != null && ($this$onCreateDialog_u24lambda_u240 = bottomSheetDialog.getBehavior()) != null) {
            $this$onCreateDialog_u24lambda_u240.setSkipCollapsed(true);
            $this$onCreateDialog_u24lambda_u240.setState(3);
        }
        return bottomSheetDialogOnCreateDialog;
    }

    public void onStart() {
        ViewGroup.LayoutParams layoutParams;
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setLayout(-1, -1);
        }
        Dialog dialog2 = getDialog();
        View bottomSheet = dialog2 != null ? dialog2.findViewById(R.id.design_bottom_sheet) : null;
        if (bottomSheet != null && (layoutParams = bottomSheet.getLayoutParams()) != null) {
            layoutParams.height = -1;
        }
        if (bottomSheet != null) {
            bottomSheet.requestLayout();
        }
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int screenH = requireContext().getResources().getDisplayMetrics().heightPixels;
        int webViewH = (int) (((double) screenH) * 0.7d);
        LinearLayout root = new LinearLayout(requireContext());
        root.setOrientation(1);
        root.setPadding(32, 24, 32, 24);
        root.setBackgroundColor(Color.parseColor("#1A1A2E"));
        root.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        TextView $this$onCreateView_u24lambda_u241 = new TextView(requireContext());
        $this$onCreateView_u24lambda_u241.setText("🔓 XD Movies – Bypass");
        $this$onCreateView_u24lambda_u241.setTextSize(18.0f);
        $this$onCreateView_u24lambda_u241.setTextColor(-1);
        $this$onCreateView_u24lambda_u241.setPadding(0, 0, 0, 8);
        root.addView($this$onCreateView_u24lambda_u241);
        TextView $this$onCreateView_u24lambda_u242 = new TextView(requireContext());
        $this$onCreateView_u24lambda_u242.setText("Loading Turnstile widget…");
        $this$onCreateView_u24lambda_u242.setTextSize(13.0f);
        $this$onCreateView_u24lambda_u242.setTextColor(Color.parseColor("#A0A0B0"));
        $this$onCreateView_u24lambda_u242.setPadding(0, 0, 0, 4);
        this.statusText = $this$onCreateView_u24lambda_u242;
        root.addView(this.statusText);
        ProgressBar $this$onCreateView_u24lambda_u243 = new ProgressBar(requireContext(), null, android.R.attr.progressBarStyleHorizontal);
        $this$onCreateView_u24lambda_u243.setIndeterminate(true);
        LinearLayout.LayoutParams it = new LinearLayout.LayoutParams(-1, -2);
        it.bottomMargin = 12;
        $this$onCreateView_u24lambda_u243.setLayoutParams(it);
        this.progressBar = $this$onCreateView_u24lambda_u243;
        root.addView(this.progressBar);
        final FrameLayout wvContainer = new FrameLayout(requireContext());
        wvContainer.setLayoutParams(new LinearLayout.LayoutParams(-1, webViewH));
        this.webView = buildWebView();
        wvContainer.addView(this.webView, new FrameLayout.LayoutParams(-1, -1));
        final View cursorView = new View(requireContext());
        cursorView.setLayoutParams(new FrameLayout.LayoutParams(24, 24));
        GradientDrawable $this$onCreateView_u24lambda_u245_u240 = new GradientDrawable();
        $this$onCreateView_u24lambda_u245_u240.setShape(1);
        $this$onCreateView_u24lambda_u245_u240.setColor(-65536);
        $this$onCreateView_u24lambda_u245_u240.setStroke(4, -1);
        cursorView.setBackground($this$onCreateView_u24lambda_u245_u240);
        cursorView.setElevation(100.0f);
        wvContainer.addView(cursorView);
        final Ref.FloatRef cursorX = new Ref.FloatRef();
        final Ref.FloatRef cursorY = new Ref.FloatRef();
        cursorView.post(new Runnable() { // from class: com.phisher98.XDSessionWebViewDialog$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                XDSessionWebViewDialog.onCreateView$lambda$6(cursorX, cursorY, wvContainer, cursorView);
            }
        });
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.phisher98.XDSessionWebViewDialog$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    return XDSessionWebViewDialog.onCreateView$lambda$7(this.f$0, cursorY, cursorX, cursorView, dialogInterface, i, keyEvent);
                }
            });
        }
        root.addView(wvContainer);
        return root;
    }

    static final void onCreateView$lambda$6(Ref.FloatRef $cursorX, Ref.FloatRef $cursorY, FrameLayout $wvContainer, View $cursorView) {
        if ($cursorX.element == 0.0f) {
            if (($cursorY.element == 0.0f) && $wvContainer.getWidth() > 0) {
                $cursorX.element = $wvContainer.getWidth() / 2.0f;
                $cursorY.element = $wvContainer.getHeight() / 2.0f;
                $cursorView.setTranslationX($cursorX.element);
                $cursorView.setTranslationY($cursorY.element);
            }
        }
    }

    static final boolean onCreateView$lambda$7(XDSessionWebViewDialog this$0, Ref.FloatRef $cursorY, Ref.FloatRef $cursorX, View $cursorView, DialogInterface dialogInterface, int keyCode, KeyEvent event) {
        WebView v = this$0.webView;
        boolean z = false;
        if (v == null) {
            return false;
        }
        if (event.getAction() == 0) {
            switch (keyCode) {
                case 19:
                    $cursorY.element = RangesKt.coerceAtLeast($cursorY.element - 50.0f, 0.0f);
                    if ($cursorY.element <= 10.0f) {
                        v.scrollBy(0, -50);
                    }
                    z = true;
                    break;
                case 20:
                    $cursorY.element = RangesKt.coerceAtMost($cursorY.element + 50.0f, v.getHeight() - 24.0f);
                    if ($cursorY.element >= v.getHeight() - 34.0f) {
                        v.scrollBy(0, 50);
                    }
                    z = true;
                    break;
                case 21:
                    $cursorX.element = RangesKt.coerceAtLeast($cursorX.element - 50.0f, 0.0f);
                    z = true;
                    break;
                case 22:
                    $cursorX.element = RangesKt.coerceAtMost($cursorX.element + 50.0f, v.getWidth() - 24.0f);
                    z = true;
                    break;
                case 23:
                case 66:
                case 160:
                    long time = SystemClock.uptimeMillis();
                    MotionEvent down = MotionEvent.obtain(time, time, 0, $cursorX.element + 12.0f, $cursorY.element + 12.0f, 0);
                    MotionEvent up = MotionEvent.obtain(time, 100 + time, 1, $cursorX.element + 12.0f, $cursorY.element + 12.0f, 0);
                    v.dispatchTouchEvent(down);
                    v.dispatchTouchEvent(up);
                    down.recycle();
                    up.recycle();
                    z = true;
                    break;
            }
            boolean handled = z;
            if (!handled) {
                return z;
            }
            $cursorView.setTranslationX($cursorX.element);
            $cursorView.setTranslationY($cursorY.element);
            return z;
        }
        if (event.getAction() != 1) {
            return false;
        }
        switch (keyCode) {
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 66:
            case 160:
                return true;
            default:
                return false;
        }
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CookieManager $this$onViewCreated_u24lambda_u240 = CookieManager.getInstance();
        $this$onViewCreated_u24lambda_u240.setAcceptCookie(true);
        $this$onViewCreated_u24lambda_u240.setAcceptThirdPartyCookies(this.webView, true);
        if (this.sessionId.length() > 0) {
            $this$onViewCreated_u24lambda_u240.setCookie(this.baseUrl, "sid=" + this.sessionId + "; path=/");
        }
        $this$onViewCreated_u24lambda_u240.flush();
        final String customHtml = StringsKt.trimIndent("\n            <!DOCTYPE html>\n            <html lang=\"en\">\n            <head>\n              <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n              <script src=\"https://challenges.cloudflare.com/turnstile/v0/api.js\" async defer></script>\n              <style>\n                body { background-color: #1A1A2E; display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; }\n              </style>\n            </head>\n            <body>\n              <div class=\"cf-turnstile\" data-sitekey=\"0x4AAAAAACwMJhFoINTv6AGb\" data-callback=\"onTurnstileSuccess\" data-theme=\"dark\"></div>\n              <script>\n                function onTurnstileSuccess(token) {\n                  try { AndroidBridge.onTurnstileToken(token, \"" + this.fingerprint + "\"); } catch(e) {}\n                }\n              </script>\n            </body>\n            </html>\n        ");
        updateStatus("Waiting 5s before loading Turnstile...");
        this.handler.postDelayed(new Runnable() { // from class: com.phisher98.XDSessionWebViewDialog$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                XDSessionWebViewDialog.onViewCreated$lambda$1(this.f$0, customHtml);
            }
        }, 5000L);
        this.handler.postDelayed(this.timeoutRunnable, POLL_INTERVAL_MS);
    }

    static final void onViewCreated$lambda$1(XDSessionWebViewDialog this$0, String $customHtml) {
        if (!this$0.resolved) {
            this$0.updateStatus("Loading bypass widget...");
            WebView webView = this$0.webView;
            if (webView != null) {
                webView.loadDataWithBaseURL(this$0.baseUrl + '/', $customHtml, "text/html", "UTF-8", null);
            }
            WebView webView2 = this$0.webView;
            if (webView2 != null) {
                webView2.requestFocus();
            }
            WebView webView3 = this$0.webView;
            if (webView3 != null) {
                webView3.onResume();
            }
        }
    }

    public void onResume() {
        super.onResume();
        WebView webView = this.webView;
        if (webView != null) {
            webView.onResume();
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "JavascriptInterface"})
    private final WebView buildWebView() {
        WebView wv = new WebView(requireContext());
        wv.setFocusable(true);
        wv.setFocusableInTouchMode(true);
        wv.requestFocus();
        WebSettings $this$buildWebView_u24lambda_u241 = wv.getSettings();
        $this$buildWebView_u24lambda_u241.setJavaScriptEnabled(true);
        $this$buildWebView_u24lambda_u241.setDomStorageEnabled(true);
        $this$buildWebView_u24lambda_u241.setDatabaseEnabled(true);
        $this$buildWebView_u24lambda_u241.setMixedContentMode(0);
        wv.addJavascriptInterface(new AndroidBridge(), "AndroidBridge");
        wv.setWebChromeClient(new WebChromeClient() { // from class: com.phisher98.XDSessionWebViewDialog.buildWebView.2
        });
        return wv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateStatus(final String msg) {
        this.handler.post(new Runnable() { // from class: com.phisher98.XDSessionWebViewDialog$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                XDSessionWebViewDialog.updateStatus$lambda$0(this.f$0, msg);
            }
        });
    }

    static final void updateStatus$lambda$0(XDSessionWebViewDialog this$0, String $msg) {
        TextView textView;
        if (this$0.resolved || (textView = this$0.statusText) == null) {
            return;
        }
        textView.setText($msg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resolve(final String url) {
        if (this.resolved) {
            return;
        }
        this.resolved = true;
        this.handler.removeCallbacks(this.timeoutRunnable);
        this.handler.post(new Runnable() { // from class: com.phisher98.XDSessionWebViewDialog$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                XDSessionWebViewDialog.resolve$lambda$0(this.f$0, url);
            }
        });
    }

    static final void resolve$lambda$0(XDSessionWebViewDialog this$0, String $url) {
        ProgressBar progressBar = this$0.progressBar;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        this$0.updateStatus("Done.");
        try {
            Result.Companion companion = Result.Companion;
            this$0.dismissAllowingStateLoss();
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
        this$0.onResult.invoke($url);
    }
}
