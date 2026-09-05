package com.Animexin;

import androidx.appcompat.app.AppCompatActivity;
import com.lagradost.api.Log;
import com.lagradost.cloudstream3.CommonActivity;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Animexin.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Animexin/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0002\u001a\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u001a\u0016\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0002H\u0086@¢\u0006\u0002\u0010\u000b\u001a,\u0010\f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u000f\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"CF_BLOCKER_PHRASES", "", "", "cfBypassMutex", "Lkotlinx/coroutines/sync/Mutex;", "isCloudflareBlocked", "", "response", "Lcom/lagradost/nicehttp/NiceResponse;", "showCFBypassDialogAndWait", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "appGet", "headers", "", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Animexin"}, k = 2, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAnimexin.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Animexin.kt\ncom/Animexin/AnimexinKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,223:1\n1960#2,3:224\n117#3,10:227\n1#4:237\n*S KotlinDebug\n*F\n+ 1 Animexin.kt\ncom/Animexin/AnimexinKt\n*L\n60#1:224,3\n94#1:227,10\n*E\n"})
public final class AnimexinKt {

    @NotNull
    private static final List<String> CF_BLOCKER_PHRASES = CollectionsKt.listOf(new String[]{"just a moment", "checking your browser", "ddos-guard", "attention required", "verify you are human", "cloudflare"});

    @NotNull
    private static final Mutex cfBypassMutex = MutexKt.Mutex$default(false, 1, (Object) null);

    /* JADX INFO: renamed from: com.Animexin.AnimexinKt$appGet$1 */
    /* JADX INFO: compiled from: Animexin.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Animexin.AnimexinKt", f = "Animexin.kt", i = {0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4}, l = {90, 228, 95, 100, 105}, m = "appGet", n = {"url", "headers", "url", "headers", "rawResponse", "recheckPassed", "$this$withLock_u24default$iv", "url", "headers", "rawResponse", "recheckPassed", "$this$withLock_u24default$iv", "url", "headers", "rawResponse", "recheckPassed", "$this$withLock_u24default$iv", "recheck", "url", "headers", "rawResponse", "recheckPassed"}, nl = {91, 229, 96, 102, -1}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3"}, v = 2)
    static final class C00071 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C00071(Continuation<? super C00071> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnimexinKt.appGet(null, null, (Continuation) this);
        }
    }

    public static final boolean isCloudflareBlocked(@NotNull NiceResponse response) {
        if (response.getCode() != 403 && response.getCode() != 503) {
            return false;
        }
        String body = response.getText().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(body, "toLowerCase(...)");
        Iterable $this$any$iv = CF_BLOCKER_PHRASES;
        if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
            return false;
        }
        for (Object element$iv : $this$any$iv) {
            String it = (String) element$iv;
            if (StringsKt.contains$default(body, it, false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: com.Animexin.AnimexinKt$showCFBypassDialogAndWait$2 */
    /* JADX INFO: compiled from: Animexin.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Animexin.AnimexinKt$showCFBypassDialogAndWait$2", f = "Animexin.kt", i = {0}, l = {224}, m = "invokeSuspend", n = {"$this$withContext"}, nl = {224}, s = {"L$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nAnimexin.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Animexin.kt\ncom/Animexin/AnimexinKt$showCFBypassDialogAndWait$2\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,223:1\n433#2,10:224\n*S KotlinDebug\n*F\n+ 1 Animexin.kt\ncom/Animexin/AnimexinKt$showCFBypassDialogAndWait$2\n*L\n65#1:224,10\n*E\n"})
    static final class C00082 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ String $url;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00082(String str, Continuation<? super C00082> continuation) {
            super(2, continuation);
            this.$url = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00082 = new C00082(this.$url, continuation);
            c00082.L$0 = obj;
            return c00082;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            final CoroutineScope $this$withContext = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String str = this.$url;
                    this.L$0 = $this$withContext;
                    this.L$1 = str;
                    this.label = 1;
                    Continuation uCont$iv = (Continuation) this;
                    Continuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(uCont$iv), 1);
                    cancellableContinuationImpl.initCancellability();
                    final Continuation continuation = (CancellableContinuation) cancellableContinuationImpl;
                    AppCompatActivity activity = CommonActivity.INSTANCE.getActivity();
                    final AppCompatActivity activity2 = activity instanceof AppCompatActivity ? activity : null;
                    if (activity2 == null || activity2.isFinishing() || activity2.isDestroyed()) {
                        Result.Companion companion = Result.Companion;
                        continuation.resumeWith(Result.constructor-impl(Boxing.boxBoolean(false)));
                    } else {
                        final Ref.BooleanRef resumed = new Ref.BooleanRef();
                        final CloudflareWebViewDialog dialog = new CloudflareWebViewDialog(str, new Function1<Boolean, Unit>() { // from class: com.Animexin.AnimexinKt$showCFBypassDialogAndWait$2$1$dialog$1
                            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                                invoke(((Boolean) p1).booleanValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(boolean success) {
                                AnimexinKt.C00082.invokeSuspend$lambda$0$safeResume(resumed, continuation, success);
                            }
                        }, false, 4, null);
                        continuation.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.Animexin.AnimexinKt$showCFBypassDialogAndWait$2$1$1
                            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                                invoke((Throwable) p1);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Throwable it) {
                                AppCompatActivity appCompatActivity = activity2;
                                final CoroutineScope coroutineScope = $this$withContext;
                                final CloudflareWebViewDialog cloudflareWebViewDialog = dialog;
                                appCompatActivity.runOnUiThread(new Runnable() { // from class: com.Animexin.AnimexinKt$showCFBypassDialogAndWait$2$1$1.1
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        CoroutineScope coroutineScope2 = coroutineScope;
                                        CloudflareWebViewDialog cloudflareWebViewDialog2 = cloudflareWebViewDialog;
                                        try {
                                            Result.Companion companion2 = Result.Companion;
                                            cloudflareWebViewDialog2.dismiss();
                                            Result.constructor-impl(Unit.INSTANCE);
                                        } catch (Throwable th) {
                                            Result.Companion companion3 = Result.Companion;
                                            Result.constructor-impl(ResultKt.createFailure(th));
                                        }
                                    }
                                });
                            }
                        });
                        dialog.show(activity2.getSupportFragmentManager(), "cf_bypass_auto");
                    }
                    Object result = cancellableContinuationImpl.getResult();
                    if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended((Continuation) this);
                    }
                    if (result == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return result;
                case 1:
                    ResultKt.throwOnFailure($result);
                    return $result;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$0$safeResume(Ref.BooleanRef resumed, CancellableContinuation<? super Boolean> cancellableContinuation, boolean success) {
            if (!resumed.element) {
                resumed.element = true;
                Result.Companion companion = Result.Companion;
                ((Continuation) cancellableContinuation).resumeWith(Result.constructor-impl(Boolean.valueOf(success)));
            }
        }
    }

    @Nullable
    public static final Object showCFBypassDialogAndWait(@NotNull String url, @NotNull Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(Dispatchers.getMain(), new C00082(url, null), continuation);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0117 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:30:0x0118  */
    /* JADX WARN: Code duplicated, block: B:32:0x0138 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:33:0x0139  */
    /* JADX WARN: Code duplicated, block: B:40:0x0188 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:41:0x0189  */
    /* JADX WARN: Code duplicated, block: B:44:0x019f A[Catch: all -> 0x01a2, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x01a2, blocks: (B:44:0x019f, B:50:0x01cf), top: B:75:0x019d }] */
    /* JADX WARN: Code duplicated, block: B:48:0x01a7 A[Catch: all -> 0x0265, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0265, blocks: (B:42:0x0196, B:48:0x01a7), top: B:76:0x0196 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x01cf A[Catch: all -> 0x01a2, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x01a2, blocks: (B:44:0x019f, B:50:0x01cf), top: B:75:0x019d }] */
    /* JADX WARN: Code duplicated, block: B:52:0x01ec A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:58:0x0204  */
    /* JADX WARN: Code duplicated, block: B:60:0x0206  */
    /* JADX WARN: Code duplicated, block: B:62:0x0251 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:63:0x0252  */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    @Nullable
    public static final Object appGet(@NotNull String url, @NotNull Map<String, String> map, @NotNull Continuation<? super NiceResponse> continuation) throws Throwable {
        C00071 c00071;
        Mutex $this$withLock_u24default$iv;
        Object owner$iv;
        Object obj;
        C00071 c00072;
        String url2;
        Map<String, String> map2;
        NiceResponse rawResponse;
        Ref.ObjectRef recheckPassed;
        Mutex $this$withLock_u24default$iv2;
        NiceResponse rawResponse2;
        String url3;
        Ref.ObjectRef recheckPassed2;
        Mutex $this$withLock_u24default$iv3;
        Object owner$iv2;
        int $i$f$withLock;
        Ref.ObjectRef recheckPassed3;
        Mutex $this$withLock_u24default$iv4;
        String url4;
        Object obj2;
        C00071 c00073;
        String url5;
        Map<String, String> map3;
        NiceResponse rawResponse3;
        Ref.ObjectRef recheckPassed4;
        NiceResponse recheck;
        Ref.ObjectRef recheckPassed5;
        NiceResponse rawResponse4;
        String url6;
        NiceResponse it;
        Object obj3;
        if (continuation instanceof C00071) {
            c00071 = (C00071) continuation;
            if ((c00071.label & Integer.MIN_VALUE) != 0) {
                c00071.label -= Integer.MIN_VALUE;
            } else {
                c00071 = new C00071(continuation);
            }
        } else {
            c00071 = new C00071(continuation);
        }
        C00071 c00074 = c00071;
        Object $result = c00074.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (c00074.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Requests app = MainActivityKt.getApp();
                    CFBypassInterceptor cFBypassInterceptor = CFBypassInterceptor.INSTANCE;
                    c00074.L$0 = url;
                    c00074.L$1 = map;
                    c00074.label = 1;
                    obj = Requests.get$default(app, url, map, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, cFBypassInterceptor, false, (ResponseParser) null, c00074, 3580, (Object) null);
                    c00072 = c00074;
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    url2 = url;
                    map2 = map;
                    rawResponse = (NiceResponse) obj;
                    if (!isCloudflareBlocked(rawResponse)) {
                        return rawResponse;
                    }
                    recheckPassed = new Ref.ObjectRef();
                    $this$withLock_u24default$iv2 = cfBypassMutex;
                    c00072.L$0 = url2;
                    c00072.L$1 = map2;
                    c00072.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse);
                    c00072.L$3 = recheckPassed;
                    c00072.L$4 = $this$withLock_u24default$iv2;
                    c00072.label = 2;
                    if ($this$withLock_u24default$iv2.lock((Object) null, c00072) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    rawResponse2 = rawResponse;
                    url3 = url2;
                    recheckPassed2 = recheckPassed;
                    $this$withLock_u24default$iv3 = $this$withLock_u24default$iv2;
                    owner$iv2 = null;
                    $i$f$withLock = 0;
                    try {
                        Requests app2 = MainActivityKt.getApp();
                        CFBypassInterceptor cFBypassInterceptor2 = CFBypassInterceptor.INSTANCE;
                        c00072.L$0 = url3;
                        c00072.L$1 = map2;
                        c00072.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse2);
                        c00072.L$3 = recheckPassed2;
                        c00072.L$4 = $this$withLock_u24default$iv3;
                        c00072.label = 3;
                        recheckPassed3 = recheckPassed2;
                        $this$withLock_u24default$iv4 = $this$withLock_u24default$iv3;
                        C00071 c00075 = c00072;
                        url4 = url3;
                        try {
                            obj2 = Requests.get$default(app2, url4, map2, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, cFBypassInterceptor2, false, (ResponseParser) null, c00075, 3580, (Object) null);
                            c00073 = c00075;
                            if (obj2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            url5 = url4;
                            map3 = map2;
                            owner$iv = owner$iv2;
                            rawResponse3 = rawResponse2;
                            recheckPassed4 = recheckPassed3;
                            $this$withLock_u24default$iv = $this$withLock_u24default$iv4;
                            $result = obj2;
                            try {
                                recheck = (NiceResponse) $result;
                                try {
                                    try {
                                        if (!isCloudflareBlocked(recheck)) {
                                            Log.INSTANCE.d("Animexin", "CF challenge detected on " + url5 + " – showing WebView dialog");
                                            if (AnimexinPlugin.INSTANCE.getCfWebviewEnabled()) {
                                                c00073.L$0 = url5;
                                                c00073.L$1 = map3;
                                                c00073.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse3);
                                                c00073.L$3 = recheckPassed4;
                                                c00073.L$4 = $this$withLock_u24default$iv;
                                                c00073.L$5 = SpillingKt.nullOutSpilledVariable(recheck);
                                                c00073.label = 4;
                                                if (showCFBypassDialogAndWait(url5, c00073) == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                recheckPassed5 = recheckPassed4;
                                                rawResponse4 = rawResponse3;
                                                url6 = url5;
                                            }
                                            Unit unit = Unit.INSTANCE;
                                            $this$withLock_u24default$iv.unlock(owner$iv);
                                            it = (NiceResponse) recheckPassed5.element;
                                            if (it != null) {
                                                return it;
                                            }
                                            Ref.ObjectRef recheckPassed6 = recheckPassed5;
                                            Requests app3 = MainActivityKt.getApp();
                                            CFBypassInterceptor cFBypassInterceptor3 = CFBypassInterceptor.INSTANCE;
                                            c00073.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                                            c00073.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                                            c00073.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse4);
                                            c00073.L$3 = SpillingKt.nullOutSpilledVariable(recheckPassed6);
                                            c00073.L$4 = null;
                                            c00073.L$5 = null;
                                            c00073.label = 5;
                                            obj3 = Requests.get$default(app3, url6, map3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, cFBypassInterceptor3, false, (ResponseParser) null, c00073, 3580, (Object) null);
                                            if (obj3 == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            return obj3;
                                        }
                                        recheckPassed4.element = recheck;
                                        Unit unit2 = Unit.INSTANCE;
                                        $this$withLock_u24default$iv.unlock(owner$iv);
                                        it = (NiceResponse) recheckPassed5.element;
                                        if (it != null) {
                                            return it;
                                        }
                                        Ref.ObjectRef recheckPassed7 = recheckPassed5;
                                        Requests app4 = MainActivityKt.getApp();
                                        CFBypassInterceptor cFBypassInterceptor4 = CFBypassInterceptor.INSTANCE;
                                        c00073.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                                        c00073.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                                        c00073.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse4);
                                        c00073.L$3 = SpillingKt.nullOutSpilledVariable(recheckPassed7);
                                        c00073.L$4 = null;
                                        c00073.L$5 = null;
                                        c00073.label = 5;
                                        obj3 = Requests.get$default(app4, url6, map3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, cFBypassInterceptor4, false, (ResponseParser) null, c00073, 3580, (Object) null);
                                        if (obj3 == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        return obj3;
                                    } catch (Throwable th) {
                                        th = th;
                                        $this$withLock_u24default$iv.unlock(owner$iv);
                                        throw th;
                                    }
                                    recheckPassed5 = recheckPassed4;
                                    rawResponse4 = rawResponse3;
                                    url6 = url5;
                                } catch (Throwable th2) {
                                    th = th2;
                                    $this$withLock_u24default$iv.unlock(owner$iv);
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            owner$iv = owner$iv2;
                            $this$withLock_u24default$iv = $this$withLock_u24default$iv4;
                            $this$withLock_u24default$iv.unlock(owner$iv);
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        owner$iv = owner$iv2;
                        $this$withLock_u24default$iv = $this$withLock_u24default$iv3;
                    }
                    break;
                case 1:
                    map2 = (Map) c00074.L$1;
                    url2 = (String) c00074.L$0;
                    ResultKt.throwOnFailure($result);
                    c00072 = c00074;
                    obj = $result;
                    rawResponse = (NiceResponse) obj;
                    if (!isCloudflareBlocked(rawResponse)) {
                        return rawResponse;
                    }
                    recheckPassed = new Ref.ObjectRef();
                    $this$withLock_u24default$iv2 = cfBypassMutex;
                    c00072.L$0 = url2;
                    c00072.L$1 = map2;
                    c00072.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse);
                    c00072.L$3 = recheckPassed;
                    c00072.L$4 = $this$withLock_u24default$iv2;
                    c00072.label = 2;
                    if ($this$withLock_u24default$iv2.lock((Object) null, c00072) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    rawResponse2 = rawResponse;
                    url3 = url2;
                    recheckPassed2 = recheckPassed;
                    $this$withLock_u24default$iv3 = $this$withLock_u24default$iv2;
                    owner$iv2 = null;
                    $i$f$withLock = 0;
                    Requests app5 = MainActivityKt.getApp();
                    CFBypassInterceptor cFBypassInterceptor5 = CFBypassInterceptor.INSTANCE;
                    c00072.L$0 = url3;
                    c00072.L$1 = map2;
                    c00072.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse2);
                    c00072.L$3 = recheckPassed2;
                    c00072.L$4 = $this$withLock_u24default$iv3;
                    c00072.label = 3;
                    recheckPassed3 = recheckPassed2;
                    $this$withLock_u24default$iv4 = $this$withLock_u24default$iv3;
                    C00071 c00076 = c00072;
                    url4 = url3;
                    obj2 = Requests.get$default(app5, url4, map2, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, cFBypassInterceptor5, false, (ResponseParser) null, c00076, 3580, (Object) null);
                    c00073 = c00076;
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    url5 = url4;
                    map3 = map2;
                    owner$iv = owner$iv2;
                    rawResponse3 = rawResponse2;
                    recheckPassed4 = recheckPassed3;
                    $this$withLock_u24default$iv = $this$withLock_u24default$iv4;
                    $result = obj2;
                    recheck = (NiceResponse) $result;
                    if (!isCloudflareBlocked(recheck)) {
                        Log.INSTANCE.d("Animexin", "CF challenge detected on " + url5 + " – showing WebView dialog");
                        if (AnimexinPlugin.INSTANCE.getCfWebviewEnabled()) {
                            c00073.L$0 = url5;
                            c00073.L$1 = map3;
                            c00073.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse3);
                            c00073.L$3 = recheckPassed4;
                            c00073.L$4 = $this$withLock_u24default$iv;
                            c00073.L$5 = SpillingKt.nullOutSpilledVariable(recheck);
                            c00073.label = 4;
                            if (showCFBypassDialogAndWait(url5, c00073) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            recheckPassed5 = recheckPassed4;
                            rawResponse4 = rawResponse3;
                            url6 = url5;
                        }
                        Unit unit3 = Unit.INSTANCE;
                        $this$withLock_u24default$iv.unlock(owner$iv);
                        it = (NiceResponse) recheckPassed5.element;
                        if (it != null) {
                            return it;
                        }
                        Ref.ObjectRef recheckPassed8 = recheckPassed5;
                        Requests app6 = MainActivityKt.getApp();
                        CFBypassInterceptor cFBypassInterceptor6 = CFBypassInterceptor.INSTANCE;
                        c00073.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                        c00073.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                        c00073.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse4);
                        c00073.L$3 = SpillingKt.nullOutSpilledVariable(recheckPassed8);
                        c00073.L$4 = null;
                        c00073.L$5 = null;
                        c00073.label = 5;
                        obj3 = Requests.get$default(app6, url6, map3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, cFBypassInterceptor6, false, (ResponseParser) null, c00073, 3580, (Object) null);
                        if (obj3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return obj3;
                    }
                    recheckPassed4.element = recheck;
                    recheckPassed5 = recheckPassed4;
                    rawResponse4 = rawResponse3;
                    url6 = url5;
                    Unit unit4 = Unit.INSTANCE;
                    $this$withLock_u24default$iv.unlock(owner$iv);
                    it = (NiceResponse) recheckPassed5.element;
                    if (it != null) {
                        return it;
                    }
                    Ref.ObjectRef recheckPassed9 = recheckPassed5;
                    Requests app7 = MainActivityKt.getApp();
                    CFBypassInterceptor cFBypassInterceptor7 = CFBypassInterceptor.INSTANCE;
                    c00073.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                    c00073.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                    c00073.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse4);
                    c00073.L$3 = SpillingKt.nullOutSpilledVariable(recheckPassed9);
                    c00073.L$4 = null;
                    c00073.L$5 = null;
                    c00073.label = 5;
                    obj3 = Requests.get$default(app7, url6, map3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, cFBypassInterceptor7, false, (ResponseParser) null, c00073, 3580, (Object) null);
                    if (obj3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return obj3;
                case 2:
                    Mutex $this$withLock_u24default$iv5 = (Mutex) c00074.L$4;
                    Ref.ObjectRef recheckPassed10 = (Ref.ObjectRef) c00074.L$3;
                    NiceResponse rawResponse5 = (NiceResponse) c00074.L$2;
                    Map<String, String> map4 = (Map) c00074.L$1;
                    url3 = (String) c00074.L$0;
                    ResultKt.throwOnFailure($result);
                    $i$f$withLock = 0;
                    owner$iv2 = null;
                    recheckPassed2 = recheckPassed10;
                    rawResponse2 = rawResponse5;
                    map2 = map4;
                    c00072 = c00074;
                    $this$withLock_u24default$iv3 = $this$withLock_u24default$iv5;
                    Requests app8 = MainActivityKt.getApp();
                    CFBypassInterceptor cFBypassInterceptor8 = CFBypassInterceptor.INSTANCE;
                    c00072.L$0 = url3;
                    c00072.L$1 = map2;
                    c00072.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse2);
                    c00072.L$3 = recheckPassed2;
                    c00072.L$4 = $this$withLock_u24default$iv3;
                    c00072.label = 3;
                    recheckPassed3 = recheckPassed2;
                    $this$withLock_u24default$iv4 = $this$withLock_u24default$iv3;
                    C00071 c00077 = c00072;
                    url4 = url3;
                    obj2 = Requests.get$default(app8, url4, map2, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, cFBypassInterceptor8, false, (ResponseParser) null, c00077, 3580, (Object) null);
                    c00073 = c00077;
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    url5 = url4;
                    map3 = map2;
                    owner$iv = owner$iv2;
                    rawResponse3 = rawResponse2;
                    recheckPassed4 = recheckPassed3;
                    $this$withLock_u24default$iv = $this$withLock_u24default$iv4;
                    $result = obj2;
                    recheck = (NiceResponse) $result;
                    if (!isCloudflareBlocked(recheck)) {
                        Log.INSTANCE.d("Animexin", "CF challenge detected on " + url5 + " – showing WebView dialog");
                        if (AnimexinPlugin.INSTANCE.getCfWebviewEnabled()) {
                            c00073.L$0 = url5;
                            c00073.L$1 = map3;
                            c00073.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse3);
                            c00073.L$3 = recheckPassed4;
                            c00073.L$4 = $this$withLock_u24default$iv;
                            c00073.L$5 = SpillingKt.nullOutSpilledVariable(recheck);
                            c00073.label = 4;
                            if (showCFBypassDialogAndWait(url5, c00073) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            recheckPassed5 = recheckPassed4;
                            rawResponse4 = rawResponse3;
                            url6 = url5;
                        }
                        Unit unit5 = Unit.INSTANCE;
                        $this$withLock_u24default$iv.unlock(owner$iv);
                        it = (NiceResponse) recheckPassed5.element;
                        if (it != null) {
                            return it;
                        }
                        Ref.ObjectRef recheckPassed11 = recheckPassed5;
                        Requests app9 = MainActivityKt.getApp();
                        CFBypassInterceptor cFBypassInterceptor9 = CFBypassInterceptor.INSTANCE;
                        c00073.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                        c00073.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                        c00073.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse4);
                        c00073.L$3 = SpillingKt.nullOutSpilledVariable(recheckPassed11);
                        c00073.L$4 = null;
                        c00073.L$5 = null;
                        c00073.label = 5;
                        obj3 = Requests.get$default(app9, url6, map3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, cFBypassInterceptor9, false, (ResponseParser) null, c00073, 3580, (Object) null);
                        if (obj3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return obj3;
                    }
                    recheckPassed4.element = recheck;
                    recheckPassed5 = recheckPassed4;
                    rawResponse4 = rawResponse3;
                    url6 = url5;
                    Unit unit6 = Unit.INSTANCE;
                    $this$withLock_u24default$iv.unlock(owner$iv);
                    it = (NiceResponse) recheckPassed5.element;
                    if (it != null) {
                        return it;
                    }
                    Ref.ObjectRef recheckPassed12 = recheckPassed5;
                    Requests app10 = MainActivityKt.getApp();
                    CFBypassInterceptor cFBypassInterceptor10 = CFBypassInterceptor.INSTANCE;
                    c00073.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                    c00073.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                    c00073.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse4);
                    c00073.L$3 = SpillingKt.nullOutSpilledVariable(recheckPassed12);
                    c00073.L$4 = null;
                    c00073.L$5 = null;
                    c00073.label = 5;
                    obj3 = Requests.get$default(app10, url6, map3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, cFBypassInterceptor10, false, (ResponseParser) null, c00073, 3580, (Object) null);
                    if (obj3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return obj3;
                case 3:
                    owner$iv = null;
                    $this$withLock_u24default$iv = (Mutex) c00074.L$4;
                    recheckPassed4 = (Ref.ObjectRef) c00074.L$3;
                    rawResponse3 = (NiceResponse) c00074.L$2;
                    map3 = (Map) c00074.L$1;
                    url5 = (String) c00074.L$0;
                    ResultKt.throwOnFailure($result);
                    c00073 = c00074;
                    recheck = (NiceResponse) $result;
                    if (!isCloudflareBlocked(recheck)) {
                        Log.INSTANCE.d("Animexin", "CF challenge detected on " + url5 + " – showing WebView dialog");
                        if (AnimexinPlugin.INSTANCE.getCfWebviewEnabled()) {
                            c00073.L$0 = url5;
                            c00073.L$1 = map3;
                            c00073.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse3);
                            c00073.L$3 = recheckPassed4;
                            c00073.L$4 = $this$withLock_u24default$iv;
                            c00073.L$5 = SpillingKt.nullOutSpilledVariable(recheck);
                            c00073.label = 4;
                            if (showCFBypassDialogAndWait(url5, c00073) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            recheckPassed5 = recheckPassed4;
                            rawResponse4 = rawResponse3;
                            url6 = url5;
                        }
                        Unit unit7 = Unit.INSTANCE;
                        $this$withLock_u24default$iv.unlock(owner$iv);
                        it = (NiceResponse) recheckPassed5.element;
                        if (it != null) {
                            return it;
                        }
                        Ref.ObjectRef recheckPassed13 = recheckPassed5;
                        Requests app11 = MainActivityKt.getApp();
                        CFBypassInterceptor cFBypassInterceptor11 = CFBypassInterceptor.INSTANCE;
                        c00073.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                        c00073.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                        c00073.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse4);
                        c00073.L$3 = SpillingKt.nullOutSpilledVariable(recheckPassed13);
                        c00073.L$4 = null;
                        c00073.L$5 = null;
                        c00073.label = 5;
                        obj3 = Requests.get$default(app11, url6, map3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, cFBypassInterceptor11, false, (ResponseParser) null, c00073, 3580, (Object) null);
                        if (obj3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return obj3;
                    }
                    recheckPassed4.element = recheck;
                    recheckPassed5 = recheckPassed4;
                    rawResponse4 = rawResponse3;
                    url6 = url5;
                    Unit unit8 = Unit.INSTANCE;
                    $this$withLock_u24default$iv.unlock(owner$iv);
                    it = (NiceResponse) recheckPassed5.element;
                    if (it != null) {
                        return it;
                    }
                    Ref.ObjectRef recheckPassed14 = recheckPassed5;
                    Requests app12 = MainActivityKt.getApp();
                    CFBypassInterceptor cFBypassInterceptor12 = CFBypassInterceptor.INSTANCE;
                    c00073.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                    c00073.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                    c00073.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse4);
                    c00073.L$3 = SpillingKt.nullOutSpilledVariable(recheckPassed14);
                    c00073.L$4 = null;
                    c00073.L$5 = null;
                    c00073.label = 5;
                    obj3 = Requests.get$default(app12, url6, map3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, cFBypassInterceptor12, false, (ResponseParser) null, c00073, 3580, (Object) null);
                    if (obj3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return obj3;
                case 4:
                    owner$iv = null;
                    $this$withLock_u24default$iv = (Mutex) c00074.L$4;
                    recheckPassed4 = (Ref.ObjectRef) c00074.L$3;
                    rawResponse3 = (NiceResponse) c00074.L$2;
                    map3 = (Map) c00074.L$1;
                    url5 = (String) c00074.L$0;
                    ResultKt.throwOnFailure($result);
                    c00073 = c00074;
                    recheckPassed5 = recheckPassed4;
                    rawResponse4 = rawResponse3;
                    url6 = url5;
                    Unit unit9 = Unit.INSTANCE;
                    $this$withLock_u24default$iv.unlock(owner$iv);
                    it = (NiceResponse) recheckPassed5.element;
                    if (it != null) {
                        return it;
                    }
                    Ref.ObjectRef recheckPassed15 = recheckPassed5;
                    Requests app13 = MainActivityKt.getApp();
                    CFBypassInterceptor cFBypassInterceptor13 = CFBypassInterceptor.INSTANCE;
                    c00073.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                    c00073.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                    c00073.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse4);
                    c00073.L$3 = SpillingKt.nullOutSpilledVariable(recheckPassed15);
                    c00073.L$4 = null;
                    c00073.L$5 = null;
                    c00073.label = 5;
                    obj3 = Requests.get$default(app13, url6, map3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, cFBypassInterceptor13, false, (ResponseParser) null, c00073, 3580, (Object) null);
                    if (obj3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return obj3;
                case 5:
                    ResultKt.throwOnFailure($result);
                    return $result;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static /* synthetic */ Object appGet$default(String str, Map map, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        return appGet(str, map, continuation);
    }
}
