package com.phisher98;

import com.lagradost.api.Log;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: StreamPlay.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlay$loadLinks$2$executionList$2$1", f = "StreamPlay.kt", i = {0}, l = {744}, m = "invokeSuspend", n = {"$this$invokeSuspend_u24lambda_u240"}, nl = {745}, s = {"L$0"}, v = 2)
final class StreamPlay$loadLinks$2$executionList$2$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ CoroutineScope $$this$coroutineScope;
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $addon;
    final /* synthetic */ AtomicInteger $providersCompleted;
    final /* synthetic */ int $totalProviders;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreamPlay$loadLinks$2$executionList$2$1(CoroutineScope coroutineScope, AtomicInteger atomicInteger, int i, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super StreamPlay$loadLinks$2$executionList$2$1> continuation) {
        super(1, continuation);
        this.$$this$coroutineScope = coroutineScope;
        this.$providersCompleted = atomicInteger;
        this.$totalProviders = i;
        this.$addon = function1;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new StreamPlay$loadLinks$2$executionList$2$1(this.$$this$coroutineScope, this.$providersCompleted, this.$totalProviders, this.$addon, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    CoroutineScope $this$invokeSuspend_u24lambda_u240 = this.$$this$coroutineScope;
                    Function1<Continuation<? super Unit>, Object> function1 = this.$addon;
                    Result.Companion companion = Result.Companion;
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$invokeSuspend_u24lambda_u240);
                    this.label = 1;
                    if (function1.invoke(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
        int completed = this.$providersCompleted.incrementAndGet();
        if (completed % 10 == 0 || completed == this.$totalProviders) {
            Log.INSTANCE.d("StreamPlay", "⏳ Progress: " + completed + '/' + this.$totalProviders + " providers");
        }
        return Unit.INSTANCE;
    }
}
