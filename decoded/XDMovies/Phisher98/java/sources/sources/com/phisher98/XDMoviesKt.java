package com.phisher98;

import androidx.appcompat.app.AppCompatActivity;
import com.lagradost.api.Log;
import com.lagradost.cloudstream3.CommonActivity;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: XDMovies.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/XDMovies/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010\u0004\u001a(\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"showXDMoviesCFBypassDialogAndWait", "", "url", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showXDSessionDialogAndWait", "baseUrl", "sessionId", "fingerprint", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "XDMovies"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class XDMoviesKt {

    /* JADX INFO: renamed from: com.phisher98.XDMoviesKt$showXDMoviesCFBypassDialogAndWait$2 */
    /* JADX INFO: compiled from: XDMovies.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.XDMoviesKt$showXDMoviesCFBypassDialogAndWait$2", f = "XDMovies.kt", i = {0}, l = {539}, m = "invokeSuspend", n = {"$this$withContext"}, nl = {539}, s = {"L$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nXDMovies.kt\nKotlin\n*S Kotlin\n*F\n+ 1 XDMovies.kt\ncom/phisher98/XDMoviesKt$showXDMoviesCFBypassDialogAndWait$2\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,538:1\n433#2,10:539\n*S KotlinDebug\n*F\n+ 1 XDMovies.kt\ncom/phisher98/XDMoviesKt$showXDMoviesCFBypassDialogAndWait$2\n*L\n92#1:539,10\n*E\n"})
    static final class C00152 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ String $url;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00152(String str, Continuation<? super C00152> continuation) {
            super(2, continuation);
            this.$url = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00152 = new C00152(this.$url, continuation);
            c00152.L$0 = obj;
            return c00152;
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
                        Log.INSTANCE.e("XDMovies_CFBypass", "No activity available to show CF dialog (TV?) — clearing stale cookies");
                        XDMoviesProvider.INSTANCE.setCfCookies("");
                        XDMoviesProvider.INSTANCE.setCfUserAgent("");
                        Result.Companion companion = Result.Companion;
                        continuation.resumeWith(Result.constructor-impl(Boxing.boxBoolean(false)));
                    } else {
                        final Ref.BooleanRef resumed = new Ref.BooleanRef();
                        final CloudflareWebViewDialog dialog = new CloudflareWebViewDialog(str, new Function1<Boolean, Unit>() { // from class: com.phisher98.XDMoviesKt$showXDMoviesCFBypassDialogAndWait$2$1$dialog$1
                            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                                invoke(((Boolean) p1).booleanValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(boolean success) {
                                XDMoviesKt.C00152.invokeSuspend$lambda$0$safeResume(resumed, continuation, success);
                            }
                        });
                        continuation.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.phisher98.XDMoviesKt$showXDMoviesCFBypassDialogAndWait$2$1$1
                            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                                invoke((Throwable) p1);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Throwable it) {
                                AppCompatActivity appCompatActivity = activity2;
                                final CoroutineScope coroutineScope = $this$withContext;
                                final CloudflareWebViewDialog cloudflareWebViewDialog = dialog;
                                appCompatActivity.runOnUiThread(new Runnable() { // from class: com.phisher98.XDMoviesKt$showXDMoviesCFBypassDialogAndWait$2$1$1.1
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        CoroutineScope coroutineScope2 = coroutineScope;
                                        CloudflareWebViewDialog cloudflareWebViewDialog2 = cloudflareWebViewDialog;
                                        try {
                                            Result.Companion companion2 = Result.Companion;
                                            cloudflareWebViewDialog2.dismissAllowingStateLoss();
                                            Result.constructor-impl(Unit.INSTANCE);
                                        } catch (Throwable th) {
                                            Result.Companion companion3 = Result.Companion;
                                            Result.constructor-impl(ResultKt.createFailure(th));
                                        }
                                    }
                                });
                            }
                        });
                        dialog.show(activity2.getSupportFragmentManager(), "xdmovies_cf_bypass_auto");
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
    public static final Object showXDMoviesCFBypassDialogAndWait(@NotNull String url, @NotNull Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(Dispatchers.getMain(), new C00152(url, null), continuation);
    }

    /* JADX INFO: renamed from: com.phisher98.XDMoviesKt$showXDSessionDialogAndWait$2 */
    /* JADX INFO: compiled from: XDMovies.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.XDMoviesKt$showXDSessionDialogAndWait$2", f = "XDMovies.kt", i = {0}, l = {539}, m = "invokeSuspend", n = {"$this$withContext"}, nl = {539}, s = {"L$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nXDMovies.kt\nKotlin\n*S Kotlin\n*F\n+ 1 XDMovies.kt\ncom/phisher98/XDMoviesKt$showXDSessionDialogAndWait$2\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,538:1\n433#2,10:539\n*S KotlinDebug\n*F\n+ 1 XDMovies.kt\ncom/phisher98/XDMoviesKt$showXDSessionDialogAndWait$2\n*L\n120#1:539,10\n*E\n"})
    static final class C00172 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ String $baseUrl;
        final /* synthetic */ String $fingerprint;
        final /* synthetic */ String $sessionId;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00172(String str, String str2, String str3, Continuation<? super C00172> continuation) {
            super(2, continuation);
            this.$baseUrl = str;
            this.$sessionId = str2;
            this.$fingerprint = str3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00172 = new C00172(this.$baseUrl, this.$sessionId, this.$fingerprint, continuation);
            c00172.L$0 = obj;
            return c00172;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            final CoroutineScope $this$withContext = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String str = this.$baseUrl;
                    String str2 = this.$sessionId;
                    String str3 = this.$fingerprint;
                    this.L$0 = $this$withContext;
                    this.L$1 = str;
                    this.L$2 = str2;
                    this.L$3 = str3;
                    this.label = 1;
                    Continuation uCont$iv = (Continuation) this;
                    Continuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(uCont$iv), 1);
                    cancellableContinuationImpl.initCancellability();
                    final Continuation continuation = (CancellableContinuation) cancellableContinuationImpl;
                    AppCompatActivity activity = CommonActivity.INSTANCE.getActivity();
                    final AppCompatActivity activity2 = activity instanceof AppCompatActivity ? activity : null;
                    if (activity2 == null || activity2.isFinishing() || activity2.isDestroyed()) {
                        Log.INSTANCE.e("XDSession", "No activity available to show session bypass dialog (TV?) — clearing stale cookies");
                        XDMoviesProvider.INSTANCE.setCfCookies("");
                        XDMoviesProvider.INSTANCE.setCfUserAgent("");
                        Result.Companion companion = Result.Companion;
                        continuation.resumeWith(Result.constructor-impl((Object) null));
                    } else {
                        final Ref.BooleanRef resumed = new Ref.BooleanRef();
                        final XDSessionWebViewDialog dialog = new XDSessionWebViewDialog(str, str2, str3, new Function1<String, Unit>() { // from class: com.phisher98.XDMoviesKt$showXDSessionDialogAndWait$2$1$dialog$1
                            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                                invoke((String) p1);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(String url) {
                                XDMoviesKt.C00172.invokeSuspend$lambda$0$safeResume(resumed, continuation, url);
                            }
                        });
                        continuation.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.phisher98.XDMoviesKt$showXDSessionDialogAndWait$2$1$1
                            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                                invoke((Throwable) p1);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Throwable it) {
                                AppCompatActivity appCompatActivity = activity2;
                                final CoroutineScope coroutineScope = $this$withContext;
                                final XDSessionWebViewDialog xDSessionWebViewDialog = dialog;
                                appCompatActivity.runOnUiThread(new Runnable() { // from class: com.phisher98.XDMoviesKt$showXDSessionDialogAndWait$2$1$1.1
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        CoroutineScope coroutineScope2 = coroutineScope;
                                        XDSessionWebViewDialog xDSessionWebViewDialog2 = xDSessionWebViewDialog;
                                        try {
                                            Result.Companion companion2 = Result.Companion;
                                            xDSessionWebViewDialog2.dismissAllowingStateLoss();
                                            Result.constructor-impl(Unit.INSTANCE);
                                        } catch (Throwable th) {
                                            Result.Companion companion3 = Result.Companion;
                                            Result.constructor-impl(ResultKt.createFailure(th));
                                        }
                                    }
                                });
                            }
                        });
                        dialog.show(activity2.getSupportFragmentManager(), "xdmovies_session_bypass");
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
        public static final void invokeSuspend$lambda$0$safeResume(Ref.BooleanRef resumed, CancellableContinuation<? super String> cancellableContinuation, String result) {
            if (!resumed.element) {
                resumed.element = true;
                Result.Companion companion = Result.Companion;
                ((Continuation) cancellableContinuation).resumeWith(Result.constructor-impl(result));
            }
        }
    }

    @Nullable
    public static final Object showXDSessionDialogAndWait(@NotNull String baseUrl, @NotNull String sessionId, @NotNull String fingerprint, @NotNull Continuation<? super String> continuation) {
        return BuildersKt.withContext(Dispatchers.getMain(), new C00172(baseUrl, sessionId, fingerprint, null), continuation);
    }
}
