package com.Cinemacity;

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
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.lagradost.api.Log;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CinemacityLoginDialog.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Cinemacity/classes.dex */
@Metadata(d1 = {"\u0000\u0081\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0017\u0018\u0000 32\u00020\u0001:\u00013B.\u0012%\b\u0002\u0010\u0002\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\bH\u0016J$\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\"2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010)\u001a\u00020\fH\u0003b\u0010\b*\u0012\f\b+\u0012\b\b\fJ\u0004\b\b(,J\u0010\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020\u001bH\u0002J\u0010\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u000201H\u0016J\b\u00102\u001a\u00020\bH\u0016R+\u0010\u0002\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018¨\u00064"}, d2 = {"Lcom/Cinemacity/CinemacityLoginDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "onFinished", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "webView", "Landroid/webkit/WebView;", "statusText", "Landroid/widget/TextView;", "progressBar", "Landroid/widget/ProgressBar;", "handler", "Landroid/os/Handler;", "loginSaved", "pollElapsedMs", "", "loginPollRunnable", "com/Cinemacity/CinemacityLoginDialog$loginPollRunnable$1", "Lcom/Cinemacity/CinemacityLoginDialog$loginPollRunnable$1;", "saveLoginAndFetchHash", "cookieStr", "", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "buildWebView", "Landroid/annotation/SuppressLint;", "value", "SetJavaScriptEnabled", "updateStatus", "msg", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onDestroyView", "Companion", "Cinemacity"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCinemacityLoginDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CinemacityLoginDialog.kt\ncom/Cinemacity/CinemacityLoginDialog\n+ 2 Color.kt\nandroidx/core/graphics/ColorKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,426:1\n432#2:427\n432#2:428\n432#2:429\n432#2:431\n432#2:432\n1#3:430\n*S KotlinDebug\n*F\n+ 1 CinemacityLoginDialog.kt\ncom/Cinemacity/CinemacityLoginDialog\n*L\n194#1:427\n211#1:428\n218#1:429\n403#1:431\n406#1:432\n*E\n"})
public final class CinemacityLoginDialog extends BottomSheetDialogFragment {

    @NotNull
    private static final String BOOT_URL = "https://cinemacity.cc/engine/ajax/controller.php?mod=ccdeviceguard&action=boot";

    @NotNull
    private static final String HOST = "https://cinemacity.cc";

    @NotNull
    private static final String LOGIN_URL = "https://cinemacity.cc/#modal";
    private static final long POLL_INTERVAL_MS = 2000;
    private static final long POLL_TIMEOUT_MS = 300000;

    @NotNull
    private static final String TAG = "Cinemacity_LoginDialog";

    @NotNull
    private final Handler handler;

    @NotNull
    private final CinemacityLoginDialog$loginPollRunnable$1 loginPollRunnable;
    private boolean loginSaved;

    @Nullable
    private final Function1<Boolean, Unit> onFinished;
    private long pollElapsedMs;

    @Nullable
    private ProgressBar progressBar;

    @Nullable
    private TextView statusText;

    @Nullable
    private WebView webView;

    /* JADX WARN: Illegal instructions before constructor call */
    public CinemacityLoginDialog() {
        Function1 function1 = null;
        this(function1, 1, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.Cinemacity.CinemacityLoginDialog$loginPollRunnable$1] */
    public CinemacityLoginDialog(@Nullable Function1<? super Boolean, Unit> function1) {
        this.onFinished = function1;
        this.handler = new Handler(Looper.getMainLooper());
        this.loginPollRunnable = new Runnable() { // from class: com.Cinemacity.CinemacityLoginDialog$loginPollRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                if (this.this$0.loginSaved || !this.this$0.isAdded()) {
                    return;
                }
                CookieManager.getInstance().flush();
                String cookieStr = CookieManager.getInstance().getCookie("https://cinemacity.cc");
                if (cookieStr == null) {
                    cookieStr = "";
                }
                Log.INSTANCE.d("Cinemacity_LoginDialog", "Poll [" + this.this$0.pollElapsedMs + "ms] cookies → " + cookieStr);
                if (!StringsKt.contains$default(cookieStr, "dle_user_id=", false, 2, (Object) null) || StringsKt.contains$default(cookieStr, "dle_user_id=0", false, 2, (Object) null) || StringsKt.contains$default(cookieStr, "dle_user_id=; ", false, 2, (Object) null)) {
                    long j = this.this$0.pollElapsedMs;
                    CinemacityLoginDialog cinemacityLoginDialog = this.this$0;
                    if (j >= 300000) {
                        cinemacityLoginDialog.updateStatus("⏱️ Timed out. Please try logging in again.");
                        return;
                    }
                    cinemacityLoginDialog.pollElapsedMs = this.this$0.pollElapsedMs + 2000;
                    this.this$0.updateStatus("⏳ Waiting for login… (" + (this.this$0.pollElapsedMs / 1000) + "s)");
                    this.this$0.handler.postDelayed(this, 2000L);
                    return;
                }
                this.this$0.saveLoginAndFetchHash(cookieStr);
            }
        };
    }

    public /* synthetic */ CinemacityLoginDialog(Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void saveLoginAndFetchHash(String cookieStr) {
        if (this.loginSaved) {
            return;
        }
        this.loginSaved = true;
        this.handler.removeCallbacks(this.loginPollRunnable);
        CinemacityPlugin.INSTANCE.setLoginCookies(cookieStr);
        Log.INSTANCE.d(TAG, "✅ Login cookies saved: " + cookieStr);
        updateStatus("✅ Logged in! Fetching user hash…");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new C00111(cookieStr, this, null), 3, (Object) null);
    }

    /* JADX INFO: renamed from: com.Cinemacity.CinemacityLoginDialog$saveLoginAndFetchHash$1 */
    /* JADX INFO: compiled from: CinemacityLoginDialog.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Cinemacity.CinemacityLoginDialog$saveLoginAndFetchHash$1", f = "CinemacityLoginDialog.kt", i = {0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3}, l = {107, 120, 131, 143}, m = "invokeSuspend", n = {"$this$launch", "$this$invokeSuspend_u24lambda_u240", "$this$launch", "$this$invokeSuspend_u24lambda_u240", "json", "response", "hash", "$this$launch", "$this$invokeSuspend_u24lambda_u240", "json", "response", "hash", "$this$launch", "e"}, nl = {115, 130, 140, 152}, s = {"L$0", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$2"}, v = 2)
    @SourceDebugExtension({"SMAP\nCinemacityLoginDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CinemacityLoginDialog.kt\ncom/Cinemacity/CinemacityLoginDialog$saveLoginAndFetchHash$1\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,426:1\n93#2,2:427\n63#2:429\n64#2,15:431\n95#2,2:448\n1#3:430\n50#4:446\n43#4:447\n*S KotlinDebug\n*F\n+ 1 CinemacityLoginDialog.kt\ncom/Cinemacity/CinemacityLoginDialog$saveLoginAndFetchHash$1\n*L\n115#1:427,2\n115#1:429\n115#1:431,15\n115#1:448,2\n115#1:430\n115#1:446\n115#1:447\n*E\n"})
    static final class C00111 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $cookieStr;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        final /* synthetic */ CinemacityLoginDialog this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00111(String str, CinemacityLoginDialog cinemacityLoginDialog, Continuation<? super C00111> continuation) {
            super(2, continuation);
            this.$cookieStr = str;
            this.this$0 = cinemacityLoginDialog;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00111 = new C00111(this.$cookieStr, this.this$0, continuation);
            c00111.L$0 = obj;
            return c00111;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:107:0x02d7  */
        /* JADX WARN: Code duplicated, block: B:109:0x0319 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:110:0x031a  */
        /* JADX WARN: Code duplicated, block: B:115:0x0161 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:132:0x019c A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:29:0x0114  */
        /* JADX WARN: Code duplicated, block: B:30:0x0117  */
        /* JADX WARN: Code duplicated, block: B:37:0x015d  */
        /* JADX WARN: Code duplicated, block: B:49:0x0195  */
        /* JADX WARN: Code duplicated, block: B:59:0x01b1 A[Catch: Exception -> 0x01ca, all -> 0x02b3, TRY_LEAVE, TryCatch #2 {all -> 0x02b3, blocks: (B:26:0x0106, B:68:0x01d1, B:70:0x01d6, B:72:0x01de, B:74:0x01e2, B:76:0x01e6, B:78:0x01ec, B:82:0x01f6, B:35:0x0157, B:47:0x018f, B:50:0x0196, B:59:0x01b1, B:58:0x01ab, B:46:0x0185, B:34:0x014d), top: B:117:0x0106 }] */
        /* JADX WARN: Code duplicated, block: B:70:0x01d6 A[Catch: all -> 0x02b3, TryCatch #2 {all -> 0x02b3, blocks: (B:26:0x0106, B:68:0x01d1, B:70:0x01d6, B:72:0x01de, B:74:0x01e2, B:76:0x01e6, B:78:0x01ec, B:82:0x01f6, B:35:0x0157, B:47:0x018f, B:50:0x0196, B:59:0x01b1, B:58:0x01ab, B:46:0x0185, B:34:0x014d), top: B:117:0x0106 }] */
        /* JADX WARN: Code duplicated, block: B:71:0x01dd  */
        /* JADX WARN: Code duplicated, block: B:74:0x01e2 A[Catch: all -> 0x02b3, TryCatch #2 {all -> 0x02b3, blocks: (B:26:0x0106, B:68:0x01d1, B:70:0x01d6, B:72:0x01de, B:74:0x01e2, B:76:0x01e6, B:78:0x01ec, B:82:0x01f6, B:35:0x0157, B:47:0x018f, B:50:0x0196, B:59:0x01b1, B:58:0x01ab, B:46:0x0185, B:34:0x014d), top: B:117:0x0106 }] */
        /* JADX WARN: Code duplicated, block: B:75:0x01e5  */
        /* JADX WARN: Code duplicated, block: B:78:0x01ec A[Catch: all -> 0x02b3, TryCatch #2 {all -> 0x02b3, blocks: (B:26:0x0106, B:68:0x01d1, B:70:0x01d6, B:72:0x01de, B:74:0x01e2, B:76:0x01e6, B:78:0x01ec, B:82:0x01f6, B:35:0x0157, B:47:0x018f, B:50:0x0196, B:59:0x01b1, B:58:0x01ab, B:46:0x0185, B:34:0x014d), top: B:117:0x0106 }] */
        /* JADX WARN: Code duplicated, block: B:80:0x01f2  */
        /* JADX WARN: Code duplicated, block: B:82:0x01f6 A[Catch: all -> 0x02b3, TRY_LEAVE, TryCatch #2 {all -> 0x02b3, blocks: (B:26:0x0106, B:68:0x01d1, B:70:0x01d6, B:72:0x01de, B:74:0x01e2, B:76:0x01e6, B:78:0x01ec, B:82:0x01f6, B:35:0x0157, B:47:0x018f, B:50:0x0196, B:59:0x01b1, B:58:0x01ab, B:46:0x0185, B:34:0x014d), top: B:117:0x0106 }] */
        /* JADX WARN: Code duplicated, block: B:86:0x024a A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:90:0x0251 A[Catch: all -> 0x024e, TryCatch #10 {all -> 0x024e, blocks: (B:93:0x02ab, B:94:0x02ad, B:87:0x024b, B:84:0x0212, B:90:0x0251), top: B:114:0x0016 }] */
        /* JADX WARN: Code duplicated, block: B:92:0x02aa A[RETURN] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [com.Cinemacity.CinemacityLoginDialog$saveLoginAndFetchHash$1, kotlin.coroutines.Continuation] */
        /* JADX WARN: Type inference failed for: r1v1 */
        /* JADX WARN: Type inference failed for: r1v10 */
        /* JADX WARN: Type inference failed for: r1v11 */
        /* JADX WARN: Type inference failed for: r1v12 */
        /* JADX WARN: Type inference failed for: r1v13 */
        /* JADX WARN: Type inference failed for: r1v14 */
        /* JADX WARN: Type inference failed for: r1v15 */
        /* JADX WARN: Type inference failed for: r1v16 */
        /* JADX WARN: Type inference failed for: r1v17 */
        /* JADX WARN: Type inference failed for: r1v18 */
        /* JADX WARN: Type inference failed for: r1v19 */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v20 */
        /* JADX WARN: Type inference failed for: r1v21 */
        /* JADX WARN: Type inference failed for: r1v22 */
        /* JADX WARN: Type inference failed for: r1v23 */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v5 */
        /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r1v8, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v9 */
        /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r2v1 */
        /* JADX WARN: Type inference failed for: r2v10, types: [com.Cinemacity.CinemacityLoginDialog$saveLoginAndFetchHash$1, kotlin.coroutines.Continuation] */
        /* JADX WARN: Type inference failed for: r2v11 */
        /* JADX WARN: Type inference failed for: r2v12 */
        /* JADX WARN: Type inference failed for: r2v13 */
        /* JADX WARN: Type inference failed for: r2v14 */
        /* JADX WARN: Type inference failed for: r2v15 */
        /* JADX WARN: Type inference failed for: r2v16 */
        /* JADX WARN: Type inference failed for: r2v19 */
        /* JADX WARN: Type inference failed for: r2v2 */
        /* JADX WARN: Type inference failed for: r2v20 */
        /* JADX WARN: Type inference failed for: r2v21 */
        /* JADX WARN: Type inference failed for: r2v22 */
        /* JADX WARN: Type inference failed for: r2v23 */
        /* JADX WARN: Type inference failed for: r2v24 */
        /* JADX WARN: Type inference failed for: r2v25 */
        /* JADX WARN: Type inference failed for: r2v26 */
        /* JADX WARN: Type inference failed for: r2v3 */
        /* JADX WARN: Type inference failed for: r2v4, types: [com.Cinemacity.CinemacityLoginDialog$saveLoginAndFetchHash$1, kotlin.coroutines.Continuation] */
        /* JADX WARN: Type inference failed for: r2v5 */
        /* JADX WARN: Type inference failed for: r2v7 */
        /* JADX WARN: Type inference failed for: r2v8 */
        /* JADX WARN: Type inference failed for: r2v9 */
        public final Object invokeSuspend(Object obj) {
            ?? r2;
            ?? r1;
            String str;
            Object obj2;
            ?? r3;
            ?? r4;
            CinemacityLoginDialog cinemacityLoginDialog;
            Throwable th;
            CoroutineContext main;
            CinemacityLoginDialog$saveLoginAndFetchHash$1$2$1 cinemacityLoginDialog$saveLoginAndFetchHash$1$2$1;
            ?? r5;
            String str2;
            ?? r6;
            Object obj3;
            CoroutineScope coroutineScope;
            CinemacityLoginDialog cinemacityLoginDialog2;
            NiceResponse niceResponse;
            String text;
            Object obj4;
            Object obj5;
            Map map;
            Object obj6;
            String str3;
            String str4;
            String str5;
            Object objWithContext;
            Object objWithContext2;
            ?? r7;
            ?? r8;
            Boolean bool;
            ?? r9;
            ?? r10;
            ?? r11 = this;
            CoroutineScope coroutineScope2 = (CoroutineScope) r11.L$0;
            ?? coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                try {
                    switch (r11.label) {
                        case 0:
                            ResultKt.throwOnFailure(obj);
                            String str6 = r11.$cookieStr;
                            CinemacityLoginDialog cinemacityLoginDialog3 = r11.this$0;
                            Result.Companion companion = Result.Companion;
                            try {
                                Requests app = MainActivityKt.getApp();
                                Map mapMapOf = MapsKt.mapOf(new Pair[]{TuplesKt.to("X-Requested-With", "XMLHttpRequest"), TuplesKt.to("Referer", "https://cinemacity.cc/"), TuplesKt.to("Cookie", str6)});
                                r11.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope2);
                                r11.L$1 = cinemacityLoginDialog3;
                                r11.L$2 = SpillingKt.nullOutSpilledVariable(coroutineScope2);
                                r11.label = 1;
                                r5 = coroutine_suspended;
                                str2 = CinemacityLoginDialog.TAG;
                                try {
                                    obj3 = Requests.get$default(app, CinemacityLoginDialog.BOOT_URL, mapMapOf, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) r11, 4092, (Object) null);
                                    r6 = r11;
                                    if (obj3 == r5) {
                                        return r5;
                                    }
                                    coroutineScope = coroutineScope2;
                                    cinemacityLoginDialog2 = cinemacityLoginDialog3;
                                    r5 = r5;
                                    try {
                                        niceResponse = (NiceResponse) obj3;
                                        AppUtils appUtils = AppUtils.INSTANCE;
                                        text = niceResponse.getText();
                                        if (text != null) {
                                            obj5 = null;
                                        } else {
                                            try {
                                                Result.Companion companion2 = Result.Companion;
                                                KType kTypeTypeOf = Reflection.typeOf(Map.class, KTypeProjection.Companion.invariant(Reflection.typeOf(String.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Object.class)));
                                                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                                obj4 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                                                break;
                                            } catch (Throwable th2) {
                                                try {
                                                    Result.Companion companion3 = Result.Companion;
                                                    obj4 = Result.constructor-impl(ResultKt.createFailure(th2));
                                                } catch (Exception e) {
                                                    obj5 = null;
                                                    map = (Map) obj5;
                                                    if (map != null) {
                                                        obj6 = map.get("user_hash");
                                                    } else {
                                                        obj6 = null;
                                                    }
                                                    if (obj6 instanceof String) {
                                                        str3 = (String) obj6;
                                                    } else {
                                                        str3 = null;
                                                    }
                                                    str4 = str3;
                                                    str5 = str4;
                                                    if (!(str5 != null || StringsKt.isBlank(str5))) {
                                                        str = str2;
                                                        Log.INSTANCE.d(str, "⚠️ boot response had no user_hash: " + StringsKt.take(niceResponse.getText(), 300));
                                                        CoroutineContext main2 = Dispatchers.getMain();
                                                        CinemacityLoginDialog$saveLoginAndFetchHash$1$1$2 cinemacityLoginDialog$saveLoginAndFetchHash$1$1$2 = new CinemacityLoginDialog$saveLoginAndFetchHash$1$1$2(cinemacityLoginDialog2, null);
                                                        r6.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope2);
                                                        r6.L$1 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                                                        r6.L$2 = SpillingKt.nullOutSpilledVariable(map);
                                                        r6.L$3 = SpillingKt.nullOutSpilledVariable(niceResponse);
                                                        r6.L$4 = SpillingKt.nullOutSpilledVariable(str4);
                                                        r6.label = 3;
                                                        objWithContext = BuildersKt.withContext(main2, cinemacityLoginDialog$saveLoginAndFetchHash$1$1$2, (Continuation) r6);
                                                        if (objWithContext == r5) {
                                                            r10 = r5;
                                                            r9 = r6;
                                                            return r5;
                                                        }
                                                        r10 = r5;
                                                        r9 = r6;
                                                        bool = (Boolean) objWithContext;
                                                        r11 = r10;
                                                        coroutine_suspended = r9;
                                                        obj2 = Result.constructor-impl(bool);
                                                        r4 = r11;
                                                        r3 = coroutine_suspended;
                                                        break;
                                                    } else {
                                                        CinemacityPlugin.INSTANCE.setUserHash(str4);
                                                        str = str2;
                                                        Log.INSTANCE.d(str, "✅ user_hash saved: " + str4);
                                                        CoroutineContext main3 = Dispatchers.getMain();
                                                        CinemacityLoginDialog$saveLoginAndFetchHash$1$1$1 cinemacityLoginDialog$saveLoginAndFetchHash$1$1$1 = new CinemacityLoginDialog$saveLoginAndFetchHash$1$1$1(cinemacityLoginDialog2, null);
                                                        r6.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope2);
                                                        r6.L$1 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                                                        r6.L$2 = SpillingKt.nullOutSpilledVariable(map);
                                                        r6.L$3 = SpillingKt.nullOutSpilledVariable(niceResponse);
                                                        r6.L$4 = SpillingKt.nullOutSpilledVariable(str4);
                                                        r6.label = 2;
                                                        objWithContext2 = BuildersKt.withContext(main3, cinemacityLoginDialog$saveLoginAndFetchHash$1$1$1, (Continuation) r6);
                                                        r8 = r5;
                                                        r7 = r6;
                                                        if (objWithContext2 == r5) {
                                                            return r5;
                                                        }
                                                        bool = (Boolean) objWithContext2;
                                                        r11 = r8;
                                                        coroutine_suspended = r7;
                                                        obj2 = Result.constructor-impl(bool);
                                                        r4 = r11;
                                                        r3 = coroutine_suspended;
                                                        break;
                                                    }
                                                    cinemacityLoginDialog = r3.this$0;
                                                    th = Result.exceptionOrNull-impl(obj2);
                                                    if (th != null) {
                                                        Log.INSTANCE.d(str, "❌ boot fetch failed: " + th);
                                                        main = Dispatchers.getMain();
                                                        cinemacityLoginDialog$saveLoginAndFetchHash$1$2$1 = new CinemacityLoginDialog$saveLoginAndFetchHash$1$2$1(cinemacityLoginDialog, null);
                                                        r3.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope2);
                                                        r3.L$1 = obj2;
                                                        r3.L$2 = SpillingKt.nullOutSpilledVariable(th);
                                                        r3.L$3 = null;
                                                        r3.L$4 = null;
                                                        r3.label = 4;
                                                        if (BuildersKt.withContext(main, cinemacityLoginDialog$saveLoginAndFetchHash$1$2$1, (Continuation) r3) == r4) {
                                                            return r4;
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }
                                            if (Result.exceptionOrNull-impl(obj4) == null) {
                                                try {
                                                    Result.Companion companion4 = Result.Companion;
                                                    try {
                                                        obj4 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Map.class), (List) null, 2, (Object) null));
                                                        break;
                                                    } catch (Throwable th3) {
                                                        th = th3;
                                                        try {
                                                            Result.Companion companion5 = Result.Companion;
                                                            obj4 = Result.constructor-impl(ResultKt.createFailure(th));
                                                        } catch (Exception e2) {
                                                            obj5 = null;
                                                        }
                                                    }
                                                } catch (Throwable th4) {
                                                    th = th4;
                                                }
                                            }
                                            if (Result.isFailure-impl(obj4)) {
                                                obj4 = null;
                                            }
                                            DeserializationStrategy deserializationStrategy = (KSerializer) obj4;
                                            if (deserializationStrategy != null) {
                                                try {
                                                } catch (SerializationException e3) {
                                                    ArchComponentExtKt.logError(e3);
                                                } catch (Throwable th5) {
                                                }
                                            }
                                            obj5 = objDecodeFromString;
                                        }
                                        map = (Map) obj5;
                                        if (map != null) {
                                            obj6 = map.get("user_hash");
                                        } else {
                                            obj6 = null;
                                        }
                                        if (obj6 instanceof String) {
                                            str3 = (String) obj6;
                                        } else {
                                            str3 = null;
                                        }
                                        str4 = str3;
                                        str5 = str4;
                                        if (!(str5 != null || StringsKt.isBlank(str5))) {
                                            str = str2;
                                            Log.INSTANCE.d(str, "⚠️ boot response had no user_hash: " + StringsKt.take(niceResponse.getText(), 300));
                                            CoroutineContext main4 = Dispatchers.getMain();
                                            CinemacityLoginDialog$saveLoginAndFetchHash$1$1$2 cinemacityLoginDialog$saveLoginAndFetchHash$1$1$3 = new CinemacityLoginDialog$saveLoginAndFetchHash$1$1$2(cinemacityLoginDialog2, null);
                                            r6.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope2);
                                            r6.L$1 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                                            r6.L$2 = SpillingKt.nullOutSpilledVariable(map);
                                            r6.L$3 = SpillingKt.nullOutSpilledVariable(niceResponse);
                                            r6.L$4 = SpillingKt.nullOutSpilledVariable(str4);
                                            r6.label = 3;
                                            objWithContext = BuildersKt.withContext(main4, cinemacityLoginDialog$saveLoginAndFetchHash$1$1$3, (Continuation) r6);
                                            if (objWithContext == r5) {
                                                r10 = r5;
                                                r9 = r6;
                                                return r5;
                                            }
                                            r10 = r5;
                                            r9 = r6;
                                            bool = (Boolean) objWithContext;
                                            r11 = r10;
                                            coroutine_suspended = r9;
                                            obj2 = Result.constructor-impl(bool);
                                            r4 = r11;
                                            r3 = coroutine_suspended;
                                        } else {
                                            CinemacityPlugin.INSTANCE.setUserHash(str4);
                                            str = str2;
                                            Log.INSTANCE.d(str, "✅ user_hash saved: " + str4);
                                            CoroutineContext main5 = Dispatchers.getMain();
                                            CinemacityLoginDialog$saveLoginAndFetchHash$1$1$1 cinemacityLoginDialog$saveLoginAndFetchHash$1$1$4 = new CinemacityLoginDialog$saveLoginAndFetchHash$1$1$1(cinemacityLoginDialog2, null);
                                            r6.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope2);
                                            r6.L$1 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                                            r6.L$2 = SpillingKt.nullOutSpilledVariable(map);
                                            r6.L$3 = SpillingKt.nullOutSpilledVariable(niceResponse);
                                            r6.L$4 = SpillingKt.nullOutSpilledVariable(str4);
                                            r6.label = 2;
                                            objWithContext2 = BuildersKt.withContext(main5, cinemacityLoginDialog$saveLoginAndFetchHash$1$1$4, (Continuation) r6);
                                            r8 = r5;
                                            r7 = r6;
                                            if (objWithContext2 == r5) {
                                                return r5;
                                            }
                                            bool = (Boolean) objWithContext2;
                                            r11 = r8;
                                            coroutine_suspended = r7;
                                            obj2 = Result.constructor-impl(bool);
                                            r4 = r11;
                                            r3 = coroutine_suspended;
                                        }
                                        break;
                                    } catch (Throwable th6) {
                                        th = th6;
                                        str = str2;
                                        r1 = r5;
                                        r2 = r6;
                                        Result.Companion companion6 = Result.Companion;
                                        obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                                        r4 = r1;
                                        r3 = r2;
                                    }
                                    cinemacityLoginDialog = r3.this$0;
                                    th = Result.exceptionOrNull-impl(obj2);
                                    if (th != null) {
                                        Log.INSTANCE.d(str, "❌ boot fetch failed: " + th);
                                        main = Dispatchers.getMain();
                                        cinemacityLoginDialog$saveLoginAndFetchHash$1$2$1 = new CinemacityLoginDialog$saveLoginAndFetchHash$1$2$1(cinemacityLoginDialog, null);
                                        r3.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope2);
                                        r3.L$1 = obj2;
                                        r3.L$2 = SpillingKt.nullOutSpilledVariable(th);
                                        r3.L$3 = null;
                                        r3.L$4 = null;
                                        r3.label = 4;
                                        if (BuildersKt.withContext(main, cinemacityLoginDialog$saveLoginAndFetchHash$1$2$1, (Continuation) r3) == r4) {
                                            return r4;
                                        }
                                    }
                                    return Unit.INSTANCE;
                                } catch (Throwable th7) {
                                    th = th7;
                                    r6 = r11;
                                    str = str2;
                                    r1 = r5;
                                    r2 = r6;
                                    Result.Companion companion7 = Result.Companion;
                                    obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                                    r4 = r1;
                                    r3 = r2;
                                    cinemacityLoginDialog = r3.this$0;
                                    th = Result.exceptionOrNull-impl(obj2);
                                    if (th != null) {
                                        Log.INSTANCE.d(str, "❌ boot fetch failed: " + th);
                                        main = Dispatchers.getMain();
                                        cinemacityLoginDialog$saveLoginAndFetchHash$1$2$1 = new CinemacityLoginDialog$saveLoginAndFetchHash$1$2$1(cinemacityLoginDialog, null);
                                        r3.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope2);
                                        r3.L$1 = obj2;
                                        r3.L$2 = SpillingKt.nullOutSpilledVariable(th);
                                        r3.L$3 = null;
                                        r3.L$4 = null;
                                        r3.label = 4;
                                        if (BuildersKt.withContext(main, cinemacityLoginDialog$saveLoginAndFetchHash$1$2$1, (Continuation) r3) == r4) {
                                            return r4;
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                            } catch (Throwable th8) {
                                th = th8;
                                r2 = r11;
                                str = CinemacityLoginDialog.TAG;
                                r1 = coroutine_suspended;
                                Result.Companion companion8 = Result.Companion;
                                obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                                r4 = r1;
                                r3 = r2;
                            }
                            break;
                        case 1:
                            coroutineScope = (CoroutineScope) r11.L$2;
                            cinemacityLoginDialog2 = (CinemacityLoginDialog) r11.L$1;
                            ResultKt.throwOnFailure(obj);
                            r6 = r11;
                            r5 = coroutine_suspended;
                            str2 = CinemacityLoginDialog.TAG;
                            obj3 = obj;
                            niceResponse = (NiceResponse) obj3;
                            AppUtils appUtils2 = AppUtils.INSTANCE;
                            text = niceResponse.getText();
                            if (text != null) {
                                Result.Companion companion9 = Result.Companion;
                                KType kTypeTypeOf2 = Reflection.typeOf(Map.class, KTypeProjection.Companion.invariant(Reflection.typeOf(String.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Object.class)));
                                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                obj4 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                                if (Result.exceptionOrNull-impl(obj4) == null) {
                                    Result.Companion companion10 = Result.Companion;
                                    obj4 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Map.class), (List) null, 2, (Object) null));
                                    break;
                                }
                                if (Result.isFailure-impl(obj4)) {
                                    obj4 = null;
                                }
                                DeserializationStrategy deserializationStrategy2 = (KSerializer) obj4;
                                Object objDecodeFromString = deserializationStrategy2 != null ? MainAPIKt.getJson().decodeFromString(deserializationStrategy2, text) : MainAPIKt.getMapper().readValue(text, new TypeReference<Map<String, ? extends Object>>() { // from class: com.Cinemacity.CinemacityLoginDialog$saveLoginAndFetchHash$1$invokeSuspend$lambda$0$$inlined$tryParseJson$1
                                });
                                obj5 = objDecodeFromString;
                                break;
                            } else {
                                obj5 = null;
                            }
                            map = (Map) obj5;
                            if (map != null) {
                                obj6 = map.get("user_hash");
                            } else {
                                obj6 = null;
                            }
                            if (obj6 instanceof String) {
                                str3 = (String) obj6;
                            } else {
                                str3 = null;
                            }
                            str4 = str3;
                            str5 = str4;
                            if (!(str5 != null || StringsKt.isBlank(str5))) {
                                CinemacityPlugin.INSTANCE.setUserHash(str4);
                                str = str2;
                                Log.INSTANCE.d(str, "✅ user_hash saved: " + str4);
                                CoroutineContext main6 = Dispatchers.getMain();
                                CinemacityLoginDialog$saveLoginAndFetchHash$1$1$1 cinemacityLoginDialog$saveLoginAndFetchHash$1$1$5 = new CinemacityLoginDialog$saveLoginAndFetchHash$1$1$1(cinemacityLoginDialog2, null);
                                r6.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope2);
                                r6.L$1 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                                r6.L$2 = SpillingKt.nullOutSpilledVariable(map);
                                r6.L$3 = SpillingKt.nullOutSpilledVariable(niceResponse);
                                r6.L$4 = SpillingKt.nullOutSpilledVariable(str4);
                                r6.label = 2;
                                objWithContext2 = BuildersKt.withContext(main6, cinemacityLoginDialog$saveLoginAndFetchHash$1$1$5, (Continuation) r6);
                                r8 = r5;
                                r7 = r6;
                                if (objWithContext2 == r5) {
                                    return r5;
                                }
                                bool = (Boolean) objWithContext2;
                                r11 = r8;
                                coroutine_suspended = r7;
                                obj2 = Result.constructor-impl(bool);
                                r4 = r11;
                                r3 = coroutine_suspended;
                                break;
                            } else {
                                str = str2;
                                Log.INSTANCE.d(str, "⚠️ boot response had no user_hash: " + StringsKt.take(niceResponse.getText(), 300));
                                CoroutineContext main7 = Dispatchers.getMain();
                                CinemacityLoginDialog$saveLoginAndFetchHash$1$1$2 cinemacityLoginDialog$saveLoginAndFetchHash$1$1$6 = new CinemacityLoginDialog$saveLoginAndFetchHash$1$1$2(cinemacityLoginDialog2, null);
                                r6.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope2);
                                r6.L$1 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                                r6.L$2 = SpillingKt.nullOutSpilledVariable(map);
                                r6.L$3 = SpillingKt.nullOutSpilledVariable(niceResponse);
                                r6.L$4 = SpillingKt.nullOutSpilledVariable(str4);
                                r6.label = 3;
                                objWithContext = BuildersKt.withContext(main7, cinemacityLoginDialog$saveLoginAndFetchHash$1$1$6, (Continuation) r6);
                                if (objWithContext == r5) {
                                    r10 = r5;
                                    r9 = r6;
                                    return r5;
                                }
                                r10 = r5;
                                r9 = r6;
                                bool = (Boolean) objWithContext;
                                r11 = r10;
                                coroutine_suspended = r9;
                                obj2 = Result.constructor-impl(bool);
                                r4 = r11;
                                r3 = coroutine_suspended;
                                break;
                            }
                            cinemacityLoginDialog = r3.this$0;
                            th = Result.exceptionOrNull-impl(obj2);
                            if (th != null) {
                                Log.INSTANCE.d(str, "❌ boot fetch failed: " + th);
                                main = Dispatchers.getMain();
                                cinemacityLoginDialog$saveLoginAndFetchHash$1$2$1 = new CinemacityLoginDialog$saveLoginAndFetchHash$1$2$1(cinemacityLoginDialog, null);
                                r3.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope2);
                                r3.L$1 = obj2;
                                r3.L$2 = SpillingKt.nullOutSpilledVariable(th);
                                r3.L$3 = null;
                                r3.L$4 = null;
                                r3.label = 4;
                                if (BuildersKt.withContext(main, cinemacityLoginDialog$saveLoginAndFetchHash$1$2$1, (Continuation) r3) == r4) {
                                    return r4;
                                }
                            }
                            return Unit.INSTANCE;
                        case 2:
                            ResultKt.throwOnFailure(obj);
                            r7 = r11;
                            r8 = coroutine_suspended;
                            str = CinemacityLoginDialog.TAG;
                            objWithContext2 = obj;
                            bool = (Boolean) objWithContext2;
                            r11 = r8;
                            coroutine_suspended = r7;
                            obj2 = Result.constructor-impl(bool);
                            r4 = r11;
                            r3 = coroutine_suspended;
                            cinemacityLoginDialog = r3.this$0;
                            th = Result.exceptionOrNull-impl(obj2);
                            if (th != null) {
                                Log.INSTANCE.d(str, "❌ boot fetch failed: " + th);
                                main = Dispatchers.getMain();
                                cinemacityLoginDialog$saveLoginAndFetchHash$1$2$1 = new CinemacityLoginDialog$saveLoginAndFetchHash$1$2$1(cinemacityLoginDialog, null);
                                r3.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope2);
                                r3.L$1 = obj2;
                                r3.L$2 = SpillingKt.nullOutSpilledVariable(th);
                                r3.L$3 = null;
                                r3.L$4 = null;
                                r3.label = 4;
                                if (BuildersKt.withContext(main, cinemacityLoginDialog$saveLoginAndFetchHash$1$2$1, (Continuation) r3) == r4) {
                                    return r4;
                                }
                            }
                            return Unit.INSTANCE;
                        case 3:
                            ResultKt.throwOnFailure(obj);
                            r9 = r11;
                            r10 = coroutine_suspended;
                            str = CinemacityLoginDialog.TAG;
                            objWithContext = obj;
                            r10 = r5;
                            r9 = r6;
                            bool = (Boolean) objWithContext;
                            r11 = r10;
                            coroutine_suspended = r9;
                            obj2 = Result.constructor-impl(bool);
                            r4 = r11;
                            r3 = coroutine_suspended;
                            cinemacityLoginDialog = r3.this$0;
                            th = Result.exceptionOrNull-impl(obj2);
                            if (th != null) {
                                Log.INSTANCE.d(str, "❌ boot fetch failed: " + th);
                                main = Dispatchers.getMain();
                                cinemacityLoginDialog$saveLoginAndFetchHash$1$2$1 = new CinemacityLoginDialog$saveLoginAndFetchHash$1$2$1(cinemacityLoginDialog, null);
                                r3.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope2);
                                r3.L$1 = obj2;
                                r3.L$2 = SpillingKt.nullOutSpilledVariable(th);
                                r3.L$3 = null;
                                r3.L$4 = null;
                                r3.label = 4;
                                if (BuildersKt.withContext(main, cinemacityLoginDialog$saveLoginAndFetchHash$1$2$1, (Continuation) r3) == r4) {
                                    return r4;
                                }
                            }
                            return Unit.INSTANCE;
                        case 4:
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } catch (Throwable th9) {
                    th = th9;
                    r2 = r11;
                    r1 = coroutine_suspended;
                    str = CinemacityLoginDialog.TAG;
                }
            } catch (Throwable th10) {
                th = th10;
                r1 = r11;
                r2 = coroutine_suspended;
            }
        }
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
        LinearLayout root = new LinearLayout(requireContext());
        root.setOrientation(1);
        root.setPadding(32, 24, 32, 24);
        root.setBackgroundColor(Color.parseColor("#1A1A2E"));
        root.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        TextView $this$onCreateView_u24lambda_u241 = new TextView(requireContext());
        $this$onCreateView_u24lambda_u241.setText("🔐 CinemaCity – Login");
        $this$onCreateView_u24lambda_u241.setTextSize(18.0f);
        $this$onCreateView_u24lambda_u241.setTextColor(-1);
        $this$onCreateView_u24lambda_u241.setPadding(0, 0, 0, 6);
        root.addView($this$onCreateView_u24lambda_u241);
        TextView $this$onCreateView_u24lambda_u242 = new TextView(requireContext());
        $this$onCreateView_u24lambda_u242.setText("Log in with your CinemaCity account. The dialog will close automatically once done.");
        $this$onCreateView_u24lambda_u242.setTextSize(11.0f);
        $this$onCreateView_u24lambda_u242.setTextColor(Color.parseColor("#707080"));
        $this$onCreateView_u24lambda_u242.setPadding(0, 0, 0, 10);
        root.addView($this$onCreateView_u24lambda_u242);
        TextView $this$onCreateView_u24lambda_u243 = new TextView(requireContext());
        $this$onCreateView_u24lambda_u243.setText("Loading login page…");
        $this$onCreateView_u24lambda_u243.setTextSize(13.0f);
        $this$onCreateView_u24lambda_u243.setTextColor(Color.parseColor("#A0A0B0"));
        $this$onCreateView_u24lambda_u243.setPadding(0, 0, 0, 4);
        this.statusText = $this$onCreateView_u24lambda_u243;
        root.addView(this.statusText);
        ProgressBar $this$onCreateView_u24lambda_u244 = new ProgressBar(requireContext(), null, android.R.attr.progressBarStyleHorizontal);
        $this$onCreateView_u24lambda_u244.setIndeterminate(true);
        LinearLayout.LayoutParams it = new LinearLayout.LayoutParams(-1, -2);
        it.bottomMargin = 10;
        $this$onCreateView_u24lambda_u244.setLayoutParams(it);
        this.progressBar = $this$onCreateView_u24lambda_u244;
        root.addView(this.progressBar);
        final FrameLayout wvContainer = new FrameLayout(requireContext());
        wvContainer.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        this.webView = buildWebView();
        WebView webView = this.webView;
        if (webView != null) {
            webView.setOnTouchListener(new View.OnTouchListener() { // from class: com.Cinemacity.CinemacityLoginDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return CinemacityLoginDialog.onCreateView$lambda$6(view, motionEvent);
                }
            });
        }
        wvContainer.addView(this.webView, new FrameLayout.LayoutParams(-1, -1));
        final View cursorView = new View(requireContext());
        cursorView.setLayoutParams(new FrameLayout.LayoutParams(24, 24));
        GradientDrawable $this$onCreateView_u24lambda_u247_u240 = new GradientDrawable();
        $this$onCreateView_u24lambda_u247_u240.setShape(1);
        $this$onCreateView_u24lambda_u247_u240.setColor(-65536);
        $this$onCreateView_u24lambda_u247_u240.setStroke(4, -1);
        cursorView.setBackground($this$onCreateView_u24lambda_u247_u240);
        cursorView.setElevation(100.0f);
        wvContainer.addView(cursorView);
        final Ref.FloatRef cursorX = new Ref.FloatRef();
        final Ref.FloatRef cursorY = new Ref.FloatRef();
        cursorView.post(new Runnable() { // from class: com.Cinemacity.CinemacityLoginDialog$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                CinemacityLoginDialog.onCreateView$lambda$8(cursorX, wvContainer, cursorY, cursorView);
            }
        });
        wvContainer.setFocusable(true);
        wvContainer.setFocusableInTouchMode(true);
        wvContainer.requestFocus();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.Cinemacity.CinemacityLoginDialog$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    return CinemacityLoginDialog.onCreateView$lambda$9(this.f$0, cursorY, cursorX, cursorView, dialogInterface, i, keyEvent);
                }
            });
        }
        root.addView(wvContainer);
        return root;
    }

    static final boolean onCreateView$lambda$6(View v, MotionEvent event) {
        v.getParent().requestDisallowInterceptTouchEvent(true);
        return false;
    }

    static final void onCreateView$lambda$8(Ref.FloatRef $cursorX, FrameLayout $wvContainer, Ref.FloatRef $cursorY, View $cursorView) {
        if (($cursorX.element == 0.0f) && $wvContainer.getWidth() > 0) {
            $cursorX.element = $wvContainer.getWidth() / 2.0f;
            $cursorY.element = $wvContainer.getHeight() / 2.0f;
            $cursorView.setTranslationX($cursorX.element);
            $cursorView.setTranslationY($cursorY.element);
        }
    }

    static final boolean onCreateView$lambda$9(CinemacityLoginDialog this$0, Ref.FloatRef $cursorY, Ref.FloatRef $cursorX, View $cursorView, DialogInterface dialogInterface, int keyCode, KeyEvent event) {
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
                    v.evaluateJavascript("window.scrollBy(0, -50);", null);
                }
                z = true;
                break;
            case 20:
                $cursorY.element = RangesKt.coerceAtMost($cursorY.element + 50.0f, v.getHeight() - 24.0f);
                if ($cursorY.element >= v.getHeight() - 34.0f) {
                    v.scrollBy(0, 50);
                    v.evaluateJavascript("window.scrollBy(0, 50);", null);
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
                MotionEvent up = MotionEvent.obtain(t, t + 100, 1, $cursorX.element + 12.0f, $cursorY.element + 12.0f, 0);
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

    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CookieManager cm = CookieManager.getInstance();
        cm.setAcceptCookie(true);
        cm.setAcceptThirdPartyCookies(this.webView, true);
        WebView webView = this.webView;
        if (webView != null) {
            webView.loadUrl(LOGIN_URL);
        }
        WebView webView2 = this.webView;
        if (webView2 != null) {
            webView2.setWebViewClient(new WebViewClient() { // from class: com.Cinemacity.CinemacityLoginDialog.onViewCreated.1
                @Override // android.webkit.WebViewClient
                public boolean shouldOverrideUrlLoading(WebView view2, WebResourceRequest request) {
                    return false;
                }

                @Override // android.webkit.WebViewClient
                public void onPageFinished(WebView view2, String url) {
                    super.onPageFinished(view2, url);
                    if (CinemacityLoginDialog.this.loginSaved) {
                        return;
                    }
                    if (view2 != null) {
                        view2.evaluateJavascript("(function() {\n                        var modal = document.getElementById('modal');\n                        if (modal) {\n                            modal.style.display = 'block';\n                            modal.style.position = 'absolute';\n                            modal.style.top = '10px';\n                            modal.style.transform = 'none';\n                            modal.style.marginBottom = '50px';\n                        }\n                        var overlay = document.querySelector('.e-overlay');\n                        if (overlay) overlay.classList.add('active');\n                        var nameInput = document.getElementById('modal_login_name');\n                        if (nameInput) nameInput.focus();\n                    })();", null);
                    }
                    CookieManager.getInstance().flush();
                    String cookieStr = CookieManager.getInstance().getCookie(CinemacityLoginDialog.HOST);
                    if (cookieStr == null) {
                        cookieStr = "";
                    }
                    if (!StringsKt.contains$default(cookieStr, "dle_user_id=", false, 2, (Object) null) || StringsKt.contains$default(cookieStr, "dle_user_id=0", false, 2, (Object) null) || StringsKt.contains$default(cookieStr, "dle_user_id=; ", false, 2, (Object) null)) {
                        CinemacityLoginDialog.this.updateStatus("🔑 Enter your CinemaCity username & password…");
                    } else {
                        CinemacityLoginDialog.this.handler.removeCallbacks(CinemacityLoginDialog.this.loginPollRunnable);
                        CinemacityLoginDialog.this.saveLoginAndFetchHash(cookieStr);
                    }
                }
            });
        }
        this.handler.postDelayed(this.loginPollRunnable, POLL_INTERVAL_MS);
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
        $this$buildWebView_u24lambda_u241.setUseWideViewPort(true);
        $this$buildWebView_u24lambda_u241.setLoadWithOverviewMode(true);
        $this$buildWebView_u24lambda_u241.setBuiltInZoomControls(true);
        $this$buildWebView_u24lambda_u241.setDisplayZoomControls(false);
        String userAgentString = $this$buildWebView_u24lambda_u241.getUserAgentString();
        if (userAgentString == null) {
            userAgentString = "";
        }
        String ua = userAgentString;
        $this$buildWebView_u24lambda_u241.setUserAgentString(StringsKt.replace$default(StringsKt.replace$default(ua, "; wv", "", false, 4, (Object) null), "Android TV", "Android", false, 4, (Object) null));
        $this$buildWebView_u24lambda_u241.setMixedContentMode(0);
        $this$buildWebView_u24lambda_u241.setAllowContentAccess(true);
        $this$buildWebView_u24lambda_u241.setAllowFileAccess(true);
        $this$buildWebView_u24lambda_u241.setLoadsImagesAutomatically(true);
        wv.setWebChromeClient(new WebChromeClient() { // from class: com.Cinemacity.CinemacityLoginDialog.buildWebView.2
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (!CinemacityLoginDialog.this.loginSaved) {
                    CinemacityLoginDialog.this.updateStatus("Loading… " + newProgress + '%');
                }
            }
        });
        return wv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateStatus(final String msg) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.Cinemacity.CinemacityLoginDialog$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    CinemacityLoginDialog.updateStatus$lambda$0(this.f$0, msg);
                }
            });
        }
    }

    static final void updateStatus$lambda$0(CinemacityLoginDialog this$0, String $msg) {
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

    public void onDismiss(@NotNull DialogInterface dialog) {
        super.onDismiss(dialog);
        if (!this.loginSaved) {
            this.handler.removeCallbacks(this.loginPollRunnable);
            Function1<Boolean, Unit> function1 = this.onFinished;
            if (function1 != null) {
                function1.invoke(false);
            }
        }
    }

    public void onDestroyView() {
        this.handler.removeCallbacks(this.loginPollRunnable);
        WebView $this$onDestroyView_u24lambda_u240 = this.webView;
        if ($this$onDestroyView_u24lambda_u240 != null) {
            $this$onDestroyView_u24lambda_u240.stopLoading();
            $this$onDestroyView_u24lambda_u240.destroy();
        }
        this.webView = null;
        super.onDestroyView();
    }
}
