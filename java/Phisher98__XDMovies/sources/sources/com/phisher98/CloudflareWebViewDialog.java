package com.phisher98;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
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
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CloudflareWebViewDialog.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/XDMovies/classes.dex */
@Metadata(d1 = {"\u0000{\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u001c\u0018\u0000 82\u00020\u0001:\u00018B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u001e\u001a\u00020\u0007H\u0002J\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020\u0007H\u0016J$\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020%2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010,\u001a\u00020\u000bH\u0003b\u0010\b-\u0012\f\b.\u0012\b\b\fJ\u0004\b\b(/J\u0010\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u0003H\u0002J\u0010\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u000204H\u0016J\u0010\u00105\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u0003H\u0002J\b\u00107\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001d¨\u00069"}, d2 = {"Lcom/phisher98/CloudflareWebViewDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "targetUrl", "", "onFinished", "Lkotlin/Function1;", "", "", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "webView", "Landroid/webkit/WebView;", "statusText", "Landroid/widget/TextView;", "progressBar", "Landroid/widget/ProgressBar;", "handler", "Landroid/os/Handler;", "cookiesSaved", "pollElapsedMs", "", "cfClearanceBefore", "targetHost", "getTargetHost", "()Ljava/lang/String;", "targetHost$delegate", "Lkotlin/Lazy;", "cookiePollRunnable", "com/phisher98/CloudflareWebViewDialog$cookiePollRunnable$1", "Lcom/phisher98/CloudflareWebViewDialog$cookiePollRunnable$1;", "scheduleNextPoll", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "buildWebView", "Landroid/annotation/SuppressLint;", "value", "SetJavaScriptEnabled", "saveCookiesAndDismiss", "cookieStr", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "updateStatus", "msg", "onDestroyView", "Companion", "XDMovies"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCloudflareWebViewDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CloudflareWebViewDialog.kt\ncom/phisher98/CloudflareWebViewDialog\n+ 2 Color.kt\nandroidx/core/graphics/ColorKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,516:1\n432#2:517\n432#2:518\n1#3:519\n1739#4:520\n1814#4,3:521\n296#4,2:524\n*S KotlinDebug\n*F\n+ 1 CloudflareWebViewDialog.kt\ncom/phisher98/CloudflareWebViewDialog\n*L\n189#1:517\n208#1:518\n348#1:520\n348#1:521,3\n349#1:524,2\n*E\n"})
public final class CloudflareWebViewDialog extends BottomSheetDialogFragment {
    private static final long ARTICLE_CLICK_DELAY_MS = 3000;
    private static final long POLL_INTERVAL_MS = 2000;
    private static final long POLL_TIMEOUT_MS = 120000;

    @NotNull
    private static final String TAG = "XDMovies_CFWebViewDialog";
    private static volatile boolean isShowing;

    @Nullable
    private String cfClearanceBefore;

    @NotNull
    private final CloudflareWebViewDialog$cookiePollRunnable$1 cookiePollRunnable;
    private boolean cookiesSaved;

    @NotNull
    private final Handler handler;

    @Nullable
    private final Function1<Boolean, Unit> onFinished;
    private long pollElapsedMs;

    @Nullable
    private ProgressBar progressBar;

    @Nullable
    private TextView statusText;

    /* JADX INFO: renamed from: targetHost$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy targetHost;

    @NotNull
    private final String targetUrl;

    @Nullable
    private WebView webView;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final List<String> CHALLENGE_TITLES = CollectionsKt.listOf(new String[]{"just a moment", "just a moment...", "checking your browser", "attention required", "ddos-guard", "one more step"});

    @NotNull
    private static final String ARTICLE_CLICK_JS = "(function() {\n    var links = Array.from(document.querySelectorAll('a[href]'));\n    var article = links.find(function(a) {\n        return /\\/(movies|series)\\//i.test(a.href);\n    });\n    if (article) { article.click(); return article.href; }\n    return null;\n})()";

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.phisher98.CloudflareWebViewDialog$cookiePollRunnable$1] */
    public CloudflareWebViewDialog(@NotNull String targetUrl, @Nullable Function1<? super Boolean, Unit> function1) {
        this.targetUrl = targetUrl;
        this.onFinished = function1;
        this.handler = new Handler(Looper.getMainLooper());
        this.targetHost = LazyKt.lazy(new Function0() { // from class: com.phisher98.CloudflareWebViewDialog$$ExternalSyntheticLambda0
            public final Object invoke() {
                return CloudflareWebViewDialog.targetHost_delegate$lambda$0(this.f$0);
            }
        });
        this.cookiePollRunnable = new Runnable() { // from class: com.phisher98.CloudflareWebViewDialog$cookiePollRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                Object element$iv;
                String strRemovePrefix;
                String it;
                if (this.this$0.cookiesSaved || !this.this$0.isAdded()) {
                    return;
                }
                CookieManager.getInstance().flush();
                String cookieStr = CookieManager.getInstance().getCookie(this.this$0.getTargetHost());
                if (cookieStr == null) {
                    cookieStr = "";
                }
                Log.INSTANCE.d("XDMovies_CFWebViewDialog", "Poll [" + this.this$0.pollElapsedMs + "ms] cookies for " + this.this$0.getTargetHost() + " → " + StringsKt.take(cookieStr, 120));
                Iterable $this$map$iv = StringsKt.split$default(cookieStr, new String[]{";"}, false, 0, 6, (Object) null);
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    String it2 = (String) item$iv$iv;
                    destination$iv$iv.add(StringsKt.trim(it2).toString());
                }
                Iterable $this$firstOrNull$iv = (List) destination$iv$iv;
                Iterator it3 = $this$firstOrNull$iv.iterator();
                do {
                    if (!it3.hasNext()) {
                        element$iv = null;
                        break;
                    } else {
                        element$iv = it3.next();
                        it = (String) element$iv;
                    }
                } while (!StringsKt.startsWith$default(it, "cf_clearance=", false, 2, (Object) null));
                String str = (String) element$iv;
                String currentClearance = (str == null || (strRemovePrefix = StringsKt.removePrefix(str, "cf_clearance=")) == null) ? null : StringsKt.trim(strRemovePrefix).toString();
                if (currentClearance != null && !Intrinsics.areEqual(currentClearance, this.this$0.cfClearanceBefore)) {
                    Log.INSTANCE.d("XDMovies_CFWebViewDialog", "✅ Fresh cf_clearance detected!");
                    this.this$0.saveCookiesAndDismiss(cookieStr);
                    return;
                }
                if (currentClearance != null && Intrinsics.areEqual(currentClearance, this.this$0.cfClearanceBefore)) {
                    Log.INSTANCE.d("XDMovies_CFWebViewDialog", "⏳ cf_clearance unchanged, still waiting…");
                    this.this$0.scheduleNextPoll();
                    return;
                }
                if (StringsKt.contains$default(cookieStr, "__ddg2_", false, 2, (Object) null) || StringsKt.contains$default(cookieStr, "__ddg1_", false, 2, (Object) null)) {
                    long j = this.this$0.pollElapsedMs;
                    CloudflareWebViewDialog cloudflareWebViewDialog = this.this$0;
                    if (j >= 60000) {
                        cloudflareWebViewDialog.saveCookiesAndDismiss(cookieStr);
                        return;
                    } else {
                        cloudflareWebViewDialog.scheduleNextPoll();
                        return;
                    }
                }
                long j2 = this.this$0.pollElapsedMs;
                CloudflareWebViewDialog cloudflareWebViewDialog2 = this.this$0;
                if (j2 >= 120000) {
                    cloudflareWebViewDialog2.updateStatus("⏱️ Timed out. Try solving the CAPTCHA then tap Bypass again.");
                } else {
                    cloudflareWebViewDialog2.scheduleNextPoll();
                }
            }
        };
    }

    public /* synthetic */ CloudflareWebViewDialog(String str, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : function1);
    }

    /* JADX INFO: compiled from: CloudflareWebViewDialog.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/phisher98/CloudflareWebViewDialog$Companion;", "", "<init>", "()V", "TAG", "", "POLL_INTERVAL_MS", "", "POLL_TIMEOUT_MS", "ARTICLE_CLICK_DELAY_MS", "isShowing", "", "()Z", "setShowing", "(Z)V", "CHALLENGE_TITLES", "", "isChallengeTitle", "title", "ARTICLE_CLICK_JS", "getARTICLE_CLICK_JS", "()Ljava/lang/String;", "XDMovies"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nCloudflareWebViewDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CloudflareWebViewDialog.kt\ncom/phisher98/CloudflareWebViewDialog$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,516:1\n1960#2,3:517\n*S KotlinDebug\n*F\n+ 1 CloudflareWebViewDialog.kt\ncom/phisher98/CloudflareWebViewDialog$Companion\n*L\n62#1:517,3\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isShowing() {
            return CloudflareWebViewDialog.isShowing;
        }

        public final void setShowing(boolean z) {
            CloudflareWebViewDialog.isShowing = z;
        }

        public final boolean isChallengeTitle(@NotNull String title) {
            Iterable $this$any$iv = CloudflareWebViewDialog.CHALLENGE_TITLES;
            if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
                return false;
            }
            for (Object element$iv : $this$any$iv) {
                String it = (String) element$iv;
                String lowerCase = title.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (StringsKt.contains$default(lowerCase, it, false, 2, (Object) null)) {
                    return true;
                }
            }
            return false;
        }

        @NotNull
        public final String getARTICLE_CLICK_JS() {
            return CloudflareWebViewDialog.ARTICLE_CLICK_JS;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getTargetHost() {
        return (String) this.targetHost.getValue();
    }

    static final String targetHost_delegate$lambda$0(CloudflareWebViewDialog this$0) {
        try {
            Uri uri = Uri.parse(this$0.targetUrl);
            return uri.getScheme() + "://" + uri.getHost();
        } catch (Exception e) {
            return this$0.targetUrl;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void scheduleNextPoll() {
        this.pollElapsedMs += POLL_INTERVAL_MS;
        updateStatus("⏳ Waiting for cookies… (" + (this.pollElapsedMs / 1000) + "s)");
        this.handler.postDelayed(this.cookiePollRunnable, POLL_INTERVAL_MS);
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
        int webViewHeight = (int) (((double) screenH) * 0.7d);
        LinearLayout root = new LinearLayout(requireContext());
        root.setOrientation(1);
        root.setPadding(32, 24, 32, 24);
        root.setBackgroundColor(Color.parseColor("#1A1A2E"));
        root.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        TextView $this$onCreateView_u24lambda_u241 = new TextView(requireContext());
        $this$onCreateView_u24lambda_u241.setText("🛡️ XD Movies – Cloudflare Bypass");
        $this$onCreateView_u24lambda_u241.setTextSize(18.0f);
        $this$onCreateView_u24lambda_u241.setTextColor(-1);
        $this$onCreateView_u24lambda_u241.setPadding(0, 0, 0, 8);
        root.addView($this$onCreateView_u24lambda_u241);
        TextView $this$onCreateView_u24lambda_u242 = new TextView(requireContext());
        $this$onCreateView_u24lambda_u242.setText("Loading challenge page…");
        $this$onCreateView_u24lambda_u242.setTextSize(13.0f);
        $this$onCreateView_u24lambda_u242.setTextColor(Color.parseColor("#A0A0B0"));
        $this$onCreateView_u24lambda_u242.setPadding(0, 0, 0, 4);
        this.statusText = $this$onCreateView_u24lambda_u242;
        root.addView(this.statusText);
        TextView $this$onCreateView_u24lambda_u243 = new TextView(requireContext());
        $this$onCreateView_u24lambda_u243.setText("Solve any CAPTCHA shown below. The dialog will close automatically once done.");
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
        wvContainer.setLayoutParams(new LinearLayout.LayoutParams(-1, webViewHeight));
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
        cursorView.post(new Runnable() { // from class: com.phisher98.CloudflareWebViewDialog$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                CloudflareWebViewDialog.onCreateView$lambda$7(cursorX, cursorY, wvContainer, cursorView);
            }
        });
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.phisher98.CloudflareWebViewDialog$$ExternalSyntheticLambda3
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    return CloudflareWebViewDialog.onCreateView$lambda$8(this.f$0, cursorY, cursorX, cursorView, dialogInterface, i, keyEvent);
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

    static final boolean onCreateView$lambda$8(CloudflareWebViewDialog this$0, Ref.FloatRef $cursorY, Ref.FloatRef $cursorX, View $cursorView, DialogInterface dialogInterface, int keyCode, KeyEvent event) {
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
        String string;
        Object element$iv;
        String strRemovePrefix;
        String it;
        super.onViewCreated(view, savedInstanceState);
        isShowing = true;
        CookieManager $this$onViewCreated_u24lambda_u240 = CookieManager.getInstance();
        $this$onViewCreated_u24lambda_u240.setAcceptCookie(true);
        $this$onViewCreated_u24lambda_u240.setAcceptThirdPartyCookies(this.webView, true);
        $this$onViewCreated_u24lambda_u240.flush();
        String existingCookies = CookieManager.getInstance().getCookie(getTargetHost());
        if (existingCookies == null) {
            existingCookies = "";
        }
        Iterable $this$map$iv = StringsKt.split$default(existingCookies, new String[]{";"}, false, 0, 6, (Object) null);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            String it2 = (String) item$iv$iv;
            destination$iv$iv.add(StringsKt.trim(it2).toString());
        }
        Iterable $this$firstOrNull$iv = (List) destination$iv$iv;
        Iterator it3 = $this$firstOrNull$iv.iterator();
        do {
            string = null;
            if (!it3.hasNext()) {
                element$iv = null;
                break;
            } else {
                element$iv = it3.next();
                it = (String) element$iv;
            }
        } while (!StringsKt.startsWith$default(it, "cf_clearance=", false, 2, (Object) null));
        String str = (String) element$iv;
        if (str != null && (strRemovePrefix = StringsKt.removePrefix(str, "cf_clearance=")) != null) {
            string = StringsKt.trim(strRemovePrefix).toString();
        }
        this.cfClearanceBefore = string;
        WebView webView = this.webView;
        if (webView != null) {
            webView.loadUrl(this.targetUrl);
        }
        this.handler.postDelayed(new Runnable() { // from class: com.phisher98.CloudflareWebViewDialog$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                CloudflareWebViewDialog.onViewCreated$lambda$3(this.f$0);
            }
        }, ARTICLE_CLICK_DELAY_MS);
        this.handler.postDelayed(this.cookiePollRunnable, POLL_INTERVAL_MS);
    }

    static final void onViewCreated$lambda$3(final CloudflareWebViewDialog this$0) {
        if (!this$0.cookiesSaved && this$0.isAdded()) {
            this$0.updateStatus("🔗 Opening an article to trigger CF challenge…");
            WebView webView = this$0.webView;
            if (webView != null) {
                webView.evaluateJavascript(ARTICLE_CLICK_JS, new ValueCallback() { // from class: com.phisher98.CloudflareWebViewDialog$$ExternalSyntheticLambda5
                    @Override // android.webkit.ValueCallback
                    public final void onReceiveValue(Object obj) {
                        CloudflareWebViewDialog.onViewCreated$lambda$3$0(this.f$0, (String) obj);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$3$0(CloudflareWebViewDialog this$0, String href) {
        if (href == null || Intrinsics.areEqual(href, "null")) {
            this$0.updateStatus("⏳ Waiting for page content to load…");
        } else {
            Log.INSTANCE.d(TAG, "Auto-clicked article: " + href);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private final WebView buildWebView() {
        WebView wv = new WebView(requireContext());
        wv.setFocusable(true);
        wv.setFocusableInTouchMode(true);
        wv.requestFocus();
        WebSettings $this$buildWebView_u24lambda_u241 = wv.getSettings();
        $this$buildWebView_u24lambda_u241.setJavaScriptEnabled(true);
        $this$buildWebView_u24lambda_u241.setDomStorageEnabled(true);
        String userAgentString = $this$buildWebView_u24lambda_u241.getUserAgentString();
        if (userAgentString == null) {
            userAgentString = "";
        }
        String originalUa = userAgentString;
        $this$buildWebView_u24lambda_u241.setUserAgentString(StringsKt.replace$default(StringsKt.replace$default(originalUa, "; wv", "", false, 4, (Object) null), "Android TV", "Android", false, 4, (Object) null));
        $this$buildWebView_u24lambda_u241.setMixedContentMode(0);
        $this$buildWebView_u24lambda_u241.setAllowContentAccess(true);
        $this$buildWebView_u24lambda_u241.setAllowFileAccess(true);
        $this$buildWebView_u24lambda_u241.setLoadsImagesAutomatically(true);
        wv.setWebChromeClient(new WebChromeClient() { // from class: com.phisher98.CloudflareWebViewDialog.buildWebView.2
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (!CloudflareWebViewDialog.this.cookiesSaved) {
                    CloudflareWebViewDialog.this.updateStatus("Loading… " + newProgress + '%');
                }
            }
        });
        wv.setWebViewClient(new WebViewClient() { // from class: com.phisher98.CloudflareWebViewDialog.buildWebView.3
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return false;
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView view, String url) {
                String title;
                Object obj;
                super.onPageFinished(view, url);
                if (CloudflareWebViewDialog.this.cookiesSaved) {
                    return;
                }
                String cookiesFromUrl = "";
                if (view == null || (title = view.getTitle()) == null) {
                    title = "";
                }
                Log.INSTANCE.d(CloudflareWebViewDialog.TAG, "onPageFinished  title='" + title + "'  url=" + url);
                boolean zIsChallengeTitle = CloudflareWebViewDialog.INSTANCE.isChallengeTitle(title);
                CloudflareWebViewDialog cloudflareWebViewDialog = CloudflareWebViewDialog.this;
                if (zIsChallengeTitle) {
                    cloudflareWebViewDialog.updateStatus("🔄 Challenge active – solve the CAPTCHA above");
                    return;
                }
                cloudflareWebViewDialog.updateStatus("✏️ Page loaded – checking cookies…");
                CookieManager.getInstance().flush();
                String cookiesFromTarget = CookieManager.getInstance().getCookie(CloudflareWebViewDialog.this.getTargetHost());
                if (cookiesFromTarget == null) {
                    cookiesFromTarget = "";
                }
                String bestCookies = null;
                if (url != null) {
                    try {
                        Result.Companion companion = Result.Companion;
                        C00013 c00013 = this;
                        Uri uri = Uri.parse(url);
                        obj = Result.constructor-impl(CookieManager.getInstance().getCookie(uri.getScheme() + "://" + uri.getHost()));
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                    }
                    if (Result.isFailure-impl(obj)) {
                        obj = null;
                    }
                    String str = (String) obj;
                    if (str != null) {
                        cookiesFromUrl = str;
                    }
                }
                if (StringsKt.contains$default(cookiesFromTarget, "cf_clearance", false, 2, (Object) null)) {
                    bestCookies = cookiesFromTarget;
                } else if (StringsKt.contains$default(cookiesFromUrl, "cf_clearance", false, 2, (Object) null)) {
                    bestCookies = cookiesFromUrl;
                }
                if (bestCookies != null) {
                    CloudflareWebViewDialog.this.handler.removeCallbacks(CloudflareWebViewDialog.this.cookiePollRunnable);
                    CloudflareWebViewDialog.this.saveCookiesAndDismiss(bestCookies);
                }
            }
        });
        return wv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void saveCookiesAndDismiss(String cookieStr) {
        WebSettings settings;
        String ua;
        if (this.cookiesSaved) {
            return;
        }
        this.cookiesSaved = true;
        this.handler.removeCallbacks(this.cookiePollRunnable);
        XDMoviesProvider.INSTANCE.setCfCookies(cookieStr);
        XDMoviesProvider.INSTANCE.setCfCookieHost(getTargetHost());
        WebView webView = this.webView;
        if (webView != null && (settings = webView.getSettings()) != null && (ua = settings.getUserAgentString()) != null) {
            XDMoviesProvider.INSTANCE.setCfUserAgent(ua);
        }
        Log.INSTANCE.d(TAG, "✅ Saved cookies: " + cookieStr);
        updateStatus("✅ Done! Cookies saved.");
        WebView webView2 = this.webView;
        if (webView2 != null) {
            webView2.postDelayed(new Runnable() { // from class: com.phisher98.CloudflareWebViewDialog$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    CloudflareWebViewDialog.saveCookiesAndDismiss$lambda$1(this.f$0);
                }
            }, 1500L);
        }
    }

    static final void saveCookiesAndDismiss$lambda$1(CloudflareWebViewDialog this$0) {
        if (this$0.isAdded()) {
            Function1<Boolean, Unit> function1 = this$0.onFinished;
            if (function1 != null) {
                function1.invoke(true);
            }
            this$0.dismissAllowingStateLoss();
        }
    }

    public void onDismiss(@NotNull DialogInterface dialog) {
        super.onDismiss(dialog);
        isShowing = false;
        if (!this.cookiesSaved) {
            this.handler.removeCallbacks(this.cookiePollRunnable);
            Function1<Boolean, Unit> function1 = this.onFinished;
            if (function1 != null) {
                function1.invoke(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateStatus(final String msg) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.phisher98.CloudflareWebViewDialog$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    CloudflareWebViewDialog.updateStatus$lambda$0(this.f$0, msg);
                }
            });
        }
    }

    static final void updateStatus$lambda$0(CloudflareWebViewDialog this$0, String $msg) {
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
        this.handler.removeCallbacks(this.cookiePollRunnable);
        WebView $this$onDestroyView_u24lambda_u240 = this.webView;
        if ($this$onDestroyView_u24lambda_u240 != null) {
            $this$onDestroyView_u24lambda_u240.stopLoading();
            $this$onDestroyView_u24lambda_u240.destroy();
        }
        this.webView = null;
        super.onDestroyView();
    }
}
