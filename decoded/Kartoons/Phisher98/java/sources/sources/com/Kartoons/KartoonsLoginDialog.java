package com.Kartoons;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.CookieManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.lagradost.cloudstream3.CommonActivity;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SettingsFragment.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Kartoons/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\"\u0010\u0016\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0003b\u0010\b\u0017\u0012\f\b\u0018\u0012\b\b\fJ\u0004\b\b(\u0019J\b\u0010\u001a\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/Kartoons/KartoonsLoginDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "sharedPref", "Landroid/content/SharedPreferences;", "onFinished", "Lkotlin/Function0;", "", "<init>", "(Landroid/content/SharedPreferences;Lkotlin/jvm/functions/Function0;)V", "webView", "Landroid/webkit/WebView;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "setupWebView", "Landroid/annotation/SuppressLint;", "value", "SetJavaScriptEnabled", "onDestroyView", "Kartoons"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSettingsFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SettingsFragment.kt\ncom/Kartoons/KartoonsLoginDialog\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,460:1\n1#2:461\n*E\n"})
public final class KartoonsLoginDialog extends BottomSheetDialogFragment {

    @NotNull
    private final Function0<Unit> onFinished;

    @NotNull
    private final SharedPreferences sharedPref;

    @Nullable
    private WebView webView;

    public KartoonsLoginDialog(@NotNull SharedPreferences sharedPref, @NotNull Function0<Unit> function0) {
        this.sharedPref = sharedPref;
        this.onFinished = function0;
    }

    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        BottomSheetBehavior $this$onCreateDialog_u24lambda_u241;
        BottomSheetDialog bottomSheetDialogOnCreateDialog = super.onCreateDialog(savedInstanceState);
        Window $this$onCreateDialog_u24lambda_u240 = bottomSheetDialogOnCreateDialog.getWindow();
        if ($this$onCreateDialog_u24lambda_u240 != null) {
            $this$onCreateDialog_u24lambda_u240.clearFlags(32);
            $this$onCreateDialog_u24lambda_u240.setDimAmount(0.5f);
        }
        BottomSheetDialog bottomSheetDialog = bottomSheetDialogOnCreateDialog instanceof BottomSheetDialog ? bottomSheetDialogOnCreateDialog : null;
        if (bottomSheetDialog != null && ($this$onCreateDialog_u24lambda_u241 = bottomSheetDialog.getBehavior()) != null) {
            $this$onCreateDialog_u24lambda_u241.setState(3);
            $this$onCreateDialog_u24lambda_u241.setSkipCollapsed(true);
            $this$onCreateDialog_u24lambda_u241.setPeekHeight(-1);
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
        int webViewHeight = (int) (((double) screenH) * 0.9d);
        LinearLayout root = new LinearLayout(requireContext());
        root.setOrientation(1);
        root.setPadding(16, 24, 16, 24);
        root.setBackgroundColor(Color.parseColor("#1A1A2E"));
        root.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        TextView $this$onCreateView_u24lambda_u241 = new TextView(requireContext());
        $this$onCreateView_u24lambda_u241.setText("🔐 Kartoons – Login");
        $this$onCreateView_u24lambda_u241.setTextSize(18.0f);
        $this$onCreateView_u24lambda_u241.setTextColor(-1);
        $this$onCreateView_u24lambda_u241.setPadding(0, 0, 0, 10);
        root.addView($this$onCreateView_u24lambda_u241);
        final FrameLayout wvContainer = new FrameLayout(requireContext());
        wvContainer.setLayoutParams(new LinearLayout.LayoutParams(-1, webViewHeight));
        WebView $this$onCreateView_u24lambda_u243 = new WebView(requireContext());
        $this$onCreateView_u24lambda_u243.setFocusable(true);
        $this$onCreateView_u24lambda_u243.setFocusableInTouchMode(true);
        $this$onCreateView_u24lambda_u243.requestFocus();
        this.webView = $this$onCreateView_u24lambda_u243;
        wvContainer.addView(this.webView, new FrameLayout.LayoutParams(-1, -1));
        final View cursorView = new View(requireContext());
        cursorView.setLayoutParams(new FrameLayout.LayoutParams(24, 24));
        GradientDrawable $this$onCreateView_u24lambda_u244_u240 = new GradientDrawable();
        $this$onCreateView_u24lambda_u244_u240.setShape(1);
        $this$onCreateView_u24lambda_u244_u240.setColor(-65536);
        $this$onCreateView_u24lambda_u244_u240.setStroke(4, -1);
        cursorView.setBackground($this$onCreateView_u24lambda_u244_u240);
        cursorView.setElevation(100.0f);
        wvContainer.addView(cursorView);
        final Ref.FloatRef cursorX = new Ref.FloatRef();
        final Ref.FloatRef cursorY = new Ref.FloatRef();
        cursorView.post(new Runnable() { // from class: com.Kartoons.KartoonsLoginDialog$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                KartoonsLoginDialog.onCreateView$lambda$5(cursorX, wvContainer, cursorY, cursorView);
            }
        });
        wvContainer.setFocusable(true);
        wvContainer.setFocusableInTouchMode(true);
        wvContainer.requestFocus();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.Kartoons.KartoonsLoginDialog$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    return KartoonsLoginDialog.onCreateView$lambda$6(this.f$0, cursorY, cursorX, cursorView, dialogInterface, i, keyEvent);
                }
            });
        }
        root.addView(wvContainer);
        WebView webView = this.webView;
        Intrinsics.checkNotNull(webView);
        setupWebView(webView);
        WebView webView2 = this.webView;
        if (webView2 != null) {
            webView2.loadUrl("https://kartoons.me/");
        }
        return root;
    }

    static final void onCreateView$lambda$5(Ref.FloatRef $cursorX, FrameLayout $wvContainer, Ref.FloatRef $cursorY, View $cursorView) {
        if (($cursorX.element == 0.0f) && $wvContainer.getWidth() > 0) {
            $cursorX.element = $wvContainer.getWidth() / 2.0f;
            $cursorY.element = $wvContainer.getHeight() / 2.0f;
            $cursorView.setTranslationX($cursorX.element);
            $cursorView.setTranslationY($cursorY.element);
        }
    }

    static final boolean onCreateView$lambda$6(KartoonsLoginDialog this$0, Ref.FloatRef $cursorY, Ref.FloatRef $cursorX, View $cursorView, DialogInterface dialogInterface, int keyCode, KeyEvent event) {
        WebView v = this$0.webView;
        boolean z = false;
        if (v == null) {
            return false;
        }
        if (event.getAction() != 0) {
            if (event.getAction() == 1) {
                return CollectionsKt.listOf(new Integer[]{19, 20, 21, 22, 23, 66, 160}).contains(Integer.valueOf(keyCode));
            }
            return false;
        }
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
                long t = SystemClock.uptimeMillis();
                MotionEvent down = MotionEvent.obtain(t, t, 0, $cursorX.element + 12.0f, $cursorY.element + 12.0f, 0);
                MotionEvent up = MotionEvent.obtain(t, 100 + t, 1, $cursorX.element + 12.0f, $cursorY.element + 12.0f, 0);
                v.dispatchTouchEvent(down);
                v.dispatchTouchEvent(up);
                down.recycle();
                up.recycle();
                z = true;
                break;
        }
        boolean it = z;
        if (!it) {
            return z;
        }
        $cursorView.setTranslationX($cursorX.element);
        $cursorView.setTranslationY($cursorY.element);
        return z;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private final void setupWebView(WebView webView) {
        CookieManager.getInstance().setAcceptCookie(true);
        CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true);
        WebSettings $this$setupWebView_u24lambda_u240 = webView.getSettings();
        $this$setupWebView_u24lambda_u240.setJavaScriptEnabled(true);
        $this$setupWebView_u24lambda_u240.setDomStorageEnabled(true);
        $this$setupWebView_u24lambda_u240.setUseWideViewPort(true);
        $this$setupWebView_u24lambda_u240.setLoadWithOverviewMode(true);
        $this$setupWebView_u24lambda_u240.setBuiltInZoomControls(true);
        $this$setupWebView_u24lambda_u240.setDisplayZoomControls(false);
        $this$setupWebView_u24lambda_u240.setMixedContentMode(0);
        $this$setupWebView_u24lambda_u240.setAllowContentAccess(true);
        $this$setupWebView_u24lambda_u240.setAllowFileAccess(true);
        $this$setupWebView_u24lambda_u240.setLoadsImagesAutomatically(true);
        webView.setWebViewClient(new C00122());
    }

    /* JADX INFO: renamed from: com.Kartoons.KartoonsLoginDialog$setupWebView$2 */
    /* JADX INFO: compiled from: SettingsFragment.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/Kartoons/KartoonsLoginDialog$setupWebView$2", "Landroid/webkit/WebViewClient;", "shouldInterceptRequest", "Landroid/webkit/WebResourceResponse;", "view", "Landroid/webkit/WebView;", "request", "Landroid/webkit/WebResourceRequest;", "Kartoons"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nSettingsFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SettingsFragment.kt\ncom/Kartoons/KartoonsLoginDialog$setupWebView$2\n+ 2 SharedPreferences.kt\nandroidx/core/content/SharedPreferencesKt\n*L\n1#1,460:1\n40#2,11:461\n*S KotlinDebug\n*F\n+ 1 SettingsFragment.kt\ncom/Kartoons/KartoonsLoginDialog$setupWebView$2\n*L\n442#1:461,11\n*E\n"})
    public static final class C00122 extends WebViewClient {
        C00122() {
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
            if (request != null) {
                Map<String, String> requestHeaders = request.getRequestHeaders();
                String auth = requestHeaders.get("Authorization");
                if (auth == null) {
                    auth = requestHeaders.get("authorization");
                }
                String str = auth;
                if (!(str == null || str.length() == 0)) {
                    KartoonsPlugin.INSTANCE.setAuthToken(auth);
                    SharedPreferences $this$edit$iv = KartoonsLoginDialog.this.sharedPref;
                    SharedPreferences.Editor editor$iv = $this$edit$iv.edit();
                    Intrinsics.checkExpressionValueIsNotNull(editor$iv, "editor");
                    editor$iv.putString("auth_token", auth);
                    editor$iv.apply();
                    FragmentActivity activity = KartoonsLoginDialog.this.getActivity();
                    if (activity != null) {
                        final KartoonsLoginDialog kartoonsLoginDialog = KartoonsLoginDialog.this;
                        activity.runOnUiThread(new Runnable() { // from class: com.Kartoons.KartoonsLoginDialog$setupWebView$2$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                KartoonsLoginDialog.C00122.shouldInterceptRequest$lambda$1(kartoonsLoginDialog);
                            }
                        });
                    }
                }
            }
            return super.shouldInterceptRequest(view, request);
        }

        static final void shouldInterceptRequest$lambda$1(KartoonsLoginDialog this$0) {
            CommonActivity.showToast$default(CommonActivity.INSTANCE, "Auth token captured", (Integer) null, 2, (Object) null);
            this$0.onFinished.invoke();
            this$0.dismissAllowingStateLoss();
        }
    }

    public void onDestroyView() {
        WebView $this$onDestroyView_u24lambda_u240 = this.webView;
        if ($this$onDestroyView_u24lambda_u240 != null) {
            $this$onDestroyView_u24lambda_u240.stopLoading();
            $this$onDestroyView_u24lambda_u240.destroy();
        }
        this.webView = null;
        super.onDestroyView();
    }
}
