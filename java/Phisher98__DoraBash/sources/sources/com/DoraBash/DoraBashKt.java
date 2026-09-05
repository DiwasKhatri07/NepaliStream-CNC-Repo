package com.DoraBash;

import androidx.appcompat.app.AppCompatActivity;
import com.lagradost.cloudstream3.CommonActivity;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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

/* JADX INFO: compiled from: DoraBash.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/DoraBash/classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"showDoraBashCFBypassDialogAndWait", "", "url", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "DoraBash"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class DoraBashKt {

    /* JADX INFO: renamed from: com.DoraBash.DoraBashKt$showDoraBashCFBypassDialogAndWait$2 */
    /* JADX INFO: compiled from: DoraBash.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.DoraBash.DoraBashKt$showDoraBashCFBypassDialogAndWait$2", f = "DoraBash.kt", i = {0}, l = {343}, m = "invokeSuspend", n = {"$this$withContext"}, nl = {343}, s = {"L$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nDoraBash.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DoraBash.kt\ncom/DoraBash/DoraBashKt$showDoraBashCFBypassDialogAndWait$2\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,342:1\n433#2,9:343\n442#2:353\n1#3:352\n*S KotlinDebug\n*F\n+ 1 DoraBash.kt\ncom/DoraBash/DoraBashKt$showDoraBashCFBypassDialogAndWait$2\n*L\n66#1:343,9\n66#1:353\n*E\n"})
    static final class C00172 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ String $url;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00172(String str, Continuation<? super C00172> continuation) {
            super(2, continuation);
            this.$url = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00172 = new C00172(this.$url, continuation);
            c00172.L$0 = obj;
            return c00172;
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
                    CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(uCont$iv), 1);
                    cancellableContinuationImpl.initCancellability();
                    final CancellableContinuation cont = cancellableContinuationImpl;
                    AppCompatActivity activity = CommonActivity.INSTANCE.getActivity();
                    AppCompatActivity activity2 = activity instanceof AppCompatActivity ? activity : null;
                    final Ref.BooleanRef resumed = new Ref.BooleanRef();
                    final AppCompatActivity activity3 = activity2;
                    final CloudflareWebViewDialog dialog = new CloudflareWebViewDialog(str, new Function1<Boolean, Unit>() { // from class: com.DoraBash.DoraBashKt$showDoraBashCFBypassDialogAndWait$2$1$dialog$1
                        public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                            invoke(((Boolean) p1).booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean success) {
                            DoraBashKt.C00172.invokeSuspend$lambda$0$safeResume(resumed, cont, success);
                        }
                    }, false, 4, null);
                    cont.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.DoraBash.DoraBashKt$showDoraBashCFBypassDialogAndWait$2$1$1
                        public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                            invoke((Throwable) p1);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Throwable it) {
                            AppCompatActivity appCompatActivity = activity3;
                            if (appCompatActivity != null) {
                                final CoroutineScope coroutineScope = $this$withContext;
                                final CloudflareWebViewDialog cloudflareWebViewDialog = dialog;
                                appCompatActivity.runOnUiThread(new Runnable() { // from class: com.DoraBash.DoraBashKt$showDoraBashCFBypassDialogAndWait$2$1$1.1
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        CoroutineScope coroutineScope2 = coroutineScope;
                                        CloudflareWebViewDialog cloudflareWebViewDialog2 = cloudflareWebViewDialog;
                                        try {
                                            Result.Companion companion = Result.Companion;
                                            cloudflareWebViewDialog2.dismissAllowingStateLoss();
                                            Result.constructor-impl(Unit.INSTANCE);
                                        } catch (Throwable th) {
                                            Result.Companion companion2 = Result.Companion;
                                            Result.constructor-impl(ResultKt.createFailure(th));
                                        }
                                    }
                                });
                            }
                        }
                    });
                    if (activity3 == null) {
                        invokeSuspend$lambda$0$safeResume(resumed, cont, false);
                    } else {
                        dialog.show(activity3.getSupportFragmentManager(), "dorabash_cf_bypass_auto");
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
    public static final Object showDoraBashCFBypassDialogAndWait(@NotNull String url, @NotNull Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(Dispatchers.getMain(), new C00172(url, null), continuation);
    }
}
