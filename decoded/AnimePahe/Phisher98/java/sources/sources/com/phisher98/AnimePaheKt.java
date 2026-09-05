package com.phisher98;

import androidx.appcompat.app.AppCompatActivity;
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

/* JADX INFO: compiled from: AnimePahe.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/AnimePahe/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"showCFBypassDialogAndWait", "", "url", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "AnimePahe"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class AnimePaheKt {

    /* JADX INFO: renamed from: com.phisher98.AnimePaheKt$showCFBypassDialogAndWait$2 */
    /* JADX INFO: compiled from: AnimePahe.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.AnimePaheKt$showCFBypassDialogAndWait$2", f = "AnimePahe.kt", i = {0}, l = {544}, m = "invokeSuspend", n = {"$this$withContext"}, nl = {544}, s = {"L$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nAnimePahe.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnimePahe.kt\ncom/phisher98/AnimePaheKt$showCFBypassDialogAndWait$2\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,543:1\n433#2,10:544\n*S KotlinDebug\n*F\n+ 1 AnimePahe.kt\ncom/phisher98/AnimePaheKt$showCFBypassDialogAndWait$2\n*L\n52#1:544,10\n*E\n"})
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
                        final CloudflareWebViewDialog dialog = new CloudflareWebViewDialog(str, new Function1<Boolean, Unit>() { // from class: com.phisher98.AnimePaheKt$showCFBypassDialogAndWait$2$1$dialog$1
                            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                                invoke(((Boolean) p1).booleanValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(boolean success) {
                                AnimePaheKt.C00082.invokeSuspend$lambda$0$safeResume(resumed, continuation, success);
                            }
                        }, false, 4, null);
                        continuation.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.phisher98.AnimePaheKt$showCFBypassDialogAndWait$2$1$1
                            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                                invoke((Throwable) p1);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Throwable it) {
                                AppCompatActivity appCompatActivity = activity2;
                                final CoroutineScope coroutineScope = $this$withContext;
                                final CloudflareWebViewDialog cloudflareWebViewDialog = dialog;
                                appCompatActivity.runOnUiThread(new Runnable() { // from class: com.phisher98.AnimePaheKt$showCFBypassDialogAndWait$2$1$1.1
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
}
