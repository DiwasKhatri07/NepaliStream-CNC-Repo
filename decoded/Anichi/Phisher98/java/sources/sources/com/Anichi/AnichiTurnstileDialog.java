package com.Anichi;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
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
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.lagradost.api.Log;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AnichiTurnstileDialog.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Anichi/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 /2\u00020\u0001:\u0002/0B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0006H\u0016J$\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u001c2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010#\u001a\u00020\nH\u0003b\u0010\b$\u0012\f\b%\u0012\b\b\fJ\u0004\b\b(&J\u0010\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0003H\u0002J\u0010\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0003H\u0002J\b\u0010.\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0004\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/Anichi/AnichiTurnstileDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "targetUrl", "", "onFinished", "Lkotlin/Function1;", "", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "webView", "Landroid/webkit/WebView;", "statusText", "Landroid/widget/TextView;", "progressBar", "Landroid/widget/ProgressBar;", "handler", "Landroid/os/Handler;", "responseSaved", "", "interceptorJs", "timeoutRunnable", "Ljava/lang/Runnable;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "buildWebView", "Landroid/annotation/SuppressLint;", "value", "SetJavaScriptEnabled", "saveResponseAndDismiss", "body", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "updateStatus", "msg", "onDestroyView", "Companion", "ApiResponseBridge", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAnichiTurnstileDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnichiTurnstileDialog.kt\ncom/Anichi/AnichiTurnstileDialog\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,470:1\n1#2:471\n*E\n"})
public final class AnichiTurnstileDialog extends BottomSheetDialogFragment {

    @NotNull
    private static final String TAG = "AnichiTurnstileDialog";
    private static final long TIMEOUT_MS = 180000;

    @NotNull
    private final Handler handler;

    @NotNull
    private final String interceptorJs;

    @Nullable
    private final Function1<String, Unit> onFinished;

    @Nullable
    private ProgressBar progressBar;
    private volatile boolean responseSaved;

    @Nullable
    private TextView statusText;

    @NotNull
    private final String targetUrl;

    @NotNull
    private final Runnable timeoutRunnable;

    @Nullable
    private WebView webView;

    /* JADX WARN: Multi-variable type inference failed */
    public AnichiTurnstileDialog(@NotNull String targetUrl, @Nullable Function1<? super String, Unit> function1) {
        this.targetUrl = targetUrl;
        this.onFinished = function1;
        this.handler = new Handler(Looper.getMainLooper());
        this.interceptorJs = "(function() {\n    if (window.__anichiHooked) return;\n    window.__anichiHooked = true;\n\n    // ── crypto.subtle hooks — capture decrypted episode data and AES key ──\n    if (window.crypto && window.crypto.subtle) {\n        // Hook importKey: capture raw AES-GCM key bytes sent to Android\n        var _origImportKey = window.crypto.subtle.importKey.bind(window.crypto.subtle);\n        window.crypto.subtle.importKey = function(format, keyData, algorithm, extractable, usages) {\n            try {\n                if (format === 'raw' && algorithm && algorithm.name === 'AES-GCM') {\n                    var bytes = new Uint8Array(keyData instanceof ArrayBuffer ? keyData : keyData.buffer || keyData);\n                    var hex = Array.from(bytes).map(function(b) { return b.toString(16).padStart(2,'0'); }).join('');\n                    if (window.AnichiApiBridge) window.AnichiApiBridge.onCryptoKey(hex);\n                }\n            } catch(e) {}\n            return _origImportKey(format, keyData, algorithm, extractable, usages);\n        };\n\n        // Hook decrypt: capture the plaintext sourceUrls JSON directly\n        var _origDecrypt = window.crypto.subtle.decrypt.bind(window.crypto.subtle);\n        window.crypto.subtle.decrypt = function(algorithm, key, data) {\n            return _origDecrypt(algorithm, key, data).then(function(result) {\n                try {\n                    var text = new TextDecoder().decode(result);\n                    if (window.AnichiApiBridge &&\n                        (text.indexOf('\"sourceUrls\"') !== -1 || text.indexOf('sourceUrls') !== -1)) {\n                        window.AnichiApiBridge.onApiResponse(text);\n                    }\n                } catch(e) {}\n                return result;\n            });\n        };\n    }\n\n    // ── Fetch interceptor (encrypted wrapper fallback) ────────────────────\n    var _origFetch = window.fetch;\n    window.fetch = function() {\n        var args = Array.prototype.slice.call(arguments);\n        var req  = args[0];\n        var url  = (typeof req === 'string') ? req : (req ? req.url : '');\n        return _origFetch.apply(this, args).then(function(resp) {\n            if (!url) return resp;\n            resp.clone().text().then(function(body) {\n                if (window.AnichiApiBridge && (body.indexOf('tobeparsed') !== -1 || body.indexOf('\\\"sourceUrls\\\"') !== -1)) {\n                    window.AnichiApiBridge.onApiResponse(body);\n                }\n            }).catch(function(e) {});\n            return resp;\n        });\n    };\n\n    // ── XHR interceptor (encrypted wrapper fallback) ──────────────────────\n    var _origOpen = XMLHttpRequest.prototype.open;\n    var _origSend = XMLHttpRequest.prototype.send;\n\n    XMLHttpRequest.prototype.open = function(method, url) {\n        this._capturedUrl = url;\n        _origOpen.apply(this, arguments);\n    };\n\n    XMLHttpRequest.prototype.send = function() {\n        var self = this;\n        this.addEventListener('load', function() {\n            if (self._capturedUrl && window.AnichiApiBridge) {\n                var body = self.responseText || '';\n                if (body.indexOf('tobeparsed') !== -1 || body.indexOf('\\\"sourceUrls\\\"') !== -1) {\n                    window.AnichiApiBridge.onApiResponse(body);\n                }\n            }\n        });\n        _origSend.apply(this, arguments);\n    };\n})();";
        this.timeoutRunnable = new Runnable() { // from class: com.Anichi.AnichiTurnstileDialog$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                AnichiTurnstileDialog.timeoutRunnable$lambda$0(this.f$0);
            }
        };
    }

    public /* synthetic */ AnichiTurnstileDialog(String str, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : function1);
    }

    /* JADX INFO: compiled from: AnichiTurnstileDialog.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007b\u0002\b\bJ\u0014\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0007H\u0007b\u0002\b\b¨\u0006\u000b"}, d2 = {"Lcom/Anichi/AnichiTurnstileDialog$ApiResponseBridge;", "", "<init>", "(Lcom/Anichi/AnichiTurnstileDialog;)V", "onApiResponse", "", "body", "", "Landroid/webkit/JavascriptInterface;", "onCryptoKey", "keyHex", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public final class ApiResponseBridge {
        public ApiResponseBridge() {
        }

        @JavascriptInterface
        public final void onApiResponse(@NotNull final String body) {
            if (AnichiTurnstileDialog.this.responseSaved) {
                return;
            }
            if (StringsKt.contains$default(body, "tobeparsed", false, 2, (Object) null) || StringsKt.contains$default(body, "\"sourceUrls\"", false, 2, (Object) null)) {
                Log.INSTANCE.d(AnichiTurnstileDialog.TAG, "✅ API response intercepted from WebView (" + body.length() + " bytes)");
                Handler handler = AnichiTurnstileDialog.this.handler;
                final AnichiTurnstileDialog anichiTurnstileDialog = AnichiTurnstileDialog.this;
                handler.post(new Runnable() { // from class: com.Anichi.AnichiTurnstileDialog$ApiResponseBridge$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        anichiTurnstileDialog.saveResponseAndDismiss(body);
                    }
                });
            }
        }

        @JavascriptInterface
        public final void onCryptoKey(@NotNull String keyHex) {
            if (keyHex.length() < 64) {
                return;
            }
            Log.INSTANCE.d(AnichiTurnstileDialog.TAG, "🔑 AES key captured from WebView (" + (keyHex.length() / 2) + " bytes)");
            try {
                int length = keyHex.length() / 2;
                byte[] bArr = new byte[length];
                for (int i = 0; i < length; i++) {
                    int i2 = i * 2;
                    String strSubstring = keyHex.substring(i2, i2 + 2);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    bArr[i] = (byte) Integer.parseInt(strSubstring, CharsKt.checkRadix(16));
                }
                AnichiUtilsKt.setCapturedAesKeyFromWebView(bArr);
            } catch (Exception e) {
                Log.INSTANCE.e(AnichiTurnstileDialog.TAG, "onCryptoKey parse error: " + e.getMessage());
            }
        }
    }

    static final void timeoutRunnable$lambda$0(final AnichiTurnstileDialog this$0) {
        if (this$0.responseSaved || !this$0.isAdded()) {
            return;
        }
        this$0.updateStatus("⏱️ Timed out — no API response intercepted.");
        this$0.handler.postDelayed(new Runnable() { // from class: com.Anichi.AnichiTurnstileDialog$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                AnichiTurnstileDialog.timeoutRunnable$lambda$0$0(this.f$0);
            }
        }, 1500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void timeoutRunnable$lambda$0$0(AnichiTurnstileDialog this$0) {
        if (this$0.isAdded() && !this$0.responseSaved) {
            Function1<String, Unit> function1 = this$0.onFinished;
            if (function1 != null) {
                function1.invoke((Object) null);
            }
            this$0.dismissAllowingStateLoss();
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
        View sheet = dialog2 != null ? dialog2.findViewById(R.id.design_bottom_sheet) : null;
        if (sheet != null && (layoutParams = sheet.getLayoutParams()) != null) {
            layoutParams.height = -1;
        }
        if (sheet != null) {
            sheet.requestLayout();
        }
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int screenH = requireContext().getResources().getDisplayMetrics().heightPixels;
        int wvHeight = (int) (((double) screenH) * 0.82d);
        LinearLayout root = new LinearLayout(requireContext());
        root.setOrientation(1);
        root.setPadding(32, 24, 32, 24);
        root.setBackgroundColor(Color.parseColor("#1A1A2E"));
        root.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        TextView $this$onCreateView_u24lambda_u241 = new TextView(requireContext());
        $this$onCreateView_u24lambda_u241.setText("🛡️ Anichi Security Check");
        $this$onCreateView_u24lambda_u241.setTextSize(18.0f);
        $this$onCreateView_u24lambda_u241.setTextColor(-1);
        $this$onCreateView_u24lambda_u241.setPadding(0, 0, 0, 8);
        root.addView($this$onCreateView_u24lambda_u241);
        TextView $this$onCreateView_u24lambda_u242 = new TextView(requireContext());
        $this$onCreateView_u24lambda_u242.setText("Loading episode page…");
        $this$onCreateView_u24lambda_u242.setTextSize(13.0f);
        $this$onCreateView_u24lambda_u242.setTextColor(Color.parseColor("#A0A0B0"));
        $this$onCreateView_u24lambda_u242.setPadding(0, 0, 0, 4);
        this.statusText = $this$onCreateView_u24lambda_u242;
        root.addView(this.statusText);
        TextView $this$onCreateView_u24lambda_u243 = new TextView(requireContext());
        $this$onCreateView_u24lambda_u243.setText("Solve the security check if prompted. Dialog closes automatically once the episode loads.");
        $this$onCreateView_u24lambda_u243.setTextSize(11.0f);
        $this$onCreateView_u24lambda_u243.setTextColor(Color.parseColor("#707080"));
        $this$onCreateView_u24lambda_u243.setPadding(0, 0, 0, 12);
        root.addView($this$onCreateView_u24lambda_u243);
        ProgressBar $this$onCreateView_u24lambda_u244 = new ProgressBar(requireContext(), null, android.R.attr.progressBarStyleHorizontal);
        $this$onCreateView_u24lambda_u244.setIndeterminate(true);
        LinearLayout.LayoutParams it = new LinearLayout.LayoutParams(-1, -2);
        it.bottomMargin = 12;
        $this$onCreateView_u24lambda_u244.setLayoutParams(it);
        this.progressBar = $this$onCreateView_u24lambda_u244;
        root.addView(this.progressBar);
        final FrameLayout wvContainer = new FrameLayout(requireContext());
        wvContainer.setLayoutParams(new LinearLayout.LayoutParams(-1, wvHeight));
        this.webView = buildWebView();
        wvContainer.addView(this.webView, new FrameLayout.LayoutParams(-1, -1));
        final View cursorView = new View(requireContext());
        cursorView.setLayoutParams(new FrameLayout.LayoutParams(24, 24));
        GradientDrawable $this$onCreateView_u24lambda_u246_u240 = new GradientDrawable();
        $this$onCreateView_u24lambda_u246_u240.setShape(1);
        $this$onCreateView_u24lambda_u246_u240.setColor(-65536);
        $this$onCreateView_u24lambda_u246_u240.setStroke(4, -1);
        cursorView.setBackground($this$onCreateView_u24lambda_u246_u240);
        cursorView.setElevation(100.0f);
        wvContainer.addView(cursorView);
        final Ref.FloatRef cursorX = new Ref.FloatRef();
        final Ref.FloatRef cursorY = new Ref.FloatRef();
        cursorView.post(new Runnable() { // from class: com.Anichi.AnichiTurnstileDialog$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                AnichiTurnstileDialog.onCreateView$lambda$7(cursorX, cursorY, wvContainer, cursorView);
            }
        });
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.Anichi.AnichiTurnstileDialog$$ExternalSyntheticLambda5
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    return AnichiTurnstileDialog.onCreateView$lambda$8(this.f$0, cursorY, cursorX, cursorView, dialogInterface, i, keyEvent);
                }
            });
        }
        root.addView(wvContainer);
        return root;
    }

    static final void onCreateView$lambda$7(Ref.FloatRef $cursorX, Ref.FloatRef $cursorY, FrameLayout $wvContainer, View $cursorView) {
        if ($cursorX.element == 0.0f) {
            if (($cursorY.element == 0.0f) && $wvContainer.getWidth() > 0) {
                $cursorX.element = $wvContainer.getWidth() / 2.0f;
                $cursorY.element = $wvContainer.getHeight() / 2.0f;
                $cursorView.setTranslationX($cursorX.element);
                $cursorView.setTranslationY($cursorY.element);
            }
        }
    }

    static final boolean onCreateView$lambda$8(AnichiTurnstileDialog this$0, Ref.FloatRef $cursorY, Ref.FloatRef $cursorX, View $cursorView, DialogInterface dialogInterface, int keyCode, KeyEvent event) {
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
        $this$onViewCreated_u24lambda_u240.flush();
        WebView webView = this.webView;
        if (webView != null) {
            webView.loadUrl(this.targetUrl);
        }
        this.handler.postDelayed(this.timeoutRunnable, TIMEOUT_MS);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private final WebView buildWebView() {
        WebView wv = new WebView(requireContext());
        wv.setFocusable(true);
        wv.setFocusableInTouchMode(true);
        wv.requestFocus();
        WebSettings $this$buildWebView_u24lambda_u240 = wv.getSettings();
        $this$buildWebView_u24lambda_u240.setJavaScriptEnabled(true);
        $this$buildWebView_u24lambda_u240.setDomStorageEnabled(true);
        $this$buildWebView_u24lambda_u240.setMixedContentMode(0);
        $this$buildWebView_u24lambda_u240.setAllowContentAccess(true);
        $this$buildWebView_u24lambda_u240.setAllowFileAccess(true);
        $this$buildWebView_u24lambda_u240.setLoadsImagesAutomatically(true);
        wv.addJavascriptInterface(new ApiResponseBridge(), "AnichiApiBridge");
        wv.setWebChromeClient(new WebChromeClient() { // from class: com.Anichi.AnichiTurnstileDialog.buildWebView.2
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView view, int newProgress) {
                if (!AnichiTurnstileDialog.this.responseSaved) {
                    AnichiTurnstileDialog.this.updateStatus("Loading… " + newProgress + '%');
                }
            }
        });
        wv.setWebViewClient(new WebViewClient() { // from class: com.Anichi.AnichiTurnstileDialog.buildWebView.3
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return false;
            }

            @Override // android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
                return super.shouldInterceptRequest(view, request);
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                if (view != null) {
                    view.evaluateJavascript(AnichiTurnstileDialog.this.interceptorJs, null);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                if (AnichiTurnstileDialog.this.responseSaved) {
                    return;
                }
                if (view != null) {
                    view.evaluateJavascript(AnichiTurnstileDialog.this.interceptorJs, null);
                }
                AnichiTurnstileDialog.this.updateStatus("✏️ Page ready — waiting for episode API call…");
            }
        });
        return wv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void saveResponseAndDismiss(final String body) {
        if (this.responseSaved) {
            return;
        }
        this.responseSaved = true;
        this.handler.removeCallbacks(this.timeoutRunnable);
        updateStatus("✅ Response captured!");
        WebView webView = this.webView;
        if (webView != null) {
            webView.postDelayed(new Runnable() { // from class: com.Anichi.AnichiTurnstileDialog$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    AnichiTurnstileDialog.saveResponseAndDismiss$lambda$0(this.f$0, body);
                }
            }, 800L);
        }
    }

    static final void saveResponseAndDismiss$lambda$0(AnichiTurnstileDialog this$0, String $body) {
        if (this$0.isAdded()) {
            Function1<String, Unit> function1 = this$0.onFinished;
            if (function1 != null) {
                function1.invoke($body);
            }
            this$0.dismissAllowingStateLoss();
        }
    }

    public void onDismiss(@NotNull DialogInterface dialog) {
        super.onDismiss(dialog);
        if (!this.responseSaved) {
            this.handler.removeCallbacks(this.timeoutRunnable);
            Function1<String, Unit> function1 = this.onFinished;
            if (function1 != null) {
                function1.invoke((Object) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateStatus(final String msg) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.Anichi.AnichiTurnstileDialog$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    AnichiTurnstileDialog.updateStatus$lambda$0(this.f$0, msg);
                }
            });
        }
    }

    static final void updateStatus$lambda$0(AnichiTurnstileDialog this$0, String $msg) {
        TextView textView = this$0.statusText;
        if (textView != null) {
            textView.setText($msg);
        }
        if (StringsKt.startsWith$default($msg, "✅", false, 2, (Object) null)) {
            ProgressBar progressBar = this$0.progressBar;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            TextView textView2 = this$0.statusText;
            if (textView2 != null) {
                textView2.setTextColor(Color.parseColor("#4CAF50"));
                return;
            }
            return;
        }
        ProgressBar progressBar2 = this$0.progressBar;
        if (progressBar2 != null) {
            progressBar2.setVisibility(0);
        }
        TextView textView3 = this$0.statusText;
        if (textView3 != null) {
            textView3.setTextColor(Color.parseColor("#A0A0B0"));
        }
    }

    public void onDestroyView() {
        this.handler.removeCallbacks(this.timeoutRunnable);
        WebView $this$onDestroyView_u24lambda_u240 = this.webView;
        if ($this$onDestroyView_u24lambda_u240 != null) {
            $this$onDestroyView_u24lambda_u240.stopLoading();
            $this$onDestroyView_u24lambda_u240.destroy();
        }
        this.webView = null;
        super.onDestroyView();
    }
}
