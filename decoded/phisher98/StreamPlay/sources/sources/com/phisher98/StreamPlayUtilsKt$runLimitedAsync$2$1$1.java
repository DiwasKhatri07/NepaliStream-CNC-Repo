package com.phisher98;

import com.lagradost.api.Log;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Semaphore;

/* JADX INFO: compiled from: StreamPlayUtils.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlayUtilsKt$runLimitedAsync$2$1$1", f = "StreamPlayUtils.kt", i = {0, 1}, l = {2266, 1279}, m = "invokeSuspend", n = {"$this$withPermit$iv", "$this$withPermit$iv"}, nl = {2267, 1280}, s = {"L$0", "L$0"}, v = 2)
@SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$runLimitedAsync$2$1$1\n+ 2 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreKt\n*L\n1#1,2265:1\n81#2,6:2266\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$runLimitedAsync$2$1$1\n*L\n1277#1:2266,6\n*E\n"})
final class StreamPlayUtilsKt$runLimitedAsync$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Semaphore $semaphore;
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $task;
    Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreamPlayUtilsKt$runLimitedAsync$2$1$1(Semaphore semaphore, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super StreamPlayUtilsKt$runLimitedAsync$2$1$1> continuation) {
        super(2, continuation);
        this.$semaphore = semaphore;
        this.$task = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StreamPlayUtilsKt$runLimitedAsync$2$1$1(this.$semaphore, this.$task, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x005a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:22:0x005b  */
    public final Object invokeSuspend(Object $result) throws Throwable {
        Function1<Continuation<? super Unit>, Object> function1;
        Semaphore $this$withPermit$iv;
        Semaphore $this$withPermit$iv2;
        Throwable th;
        Semaphore $this$withPermit$iv3;
        Exception e;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Semaphore $this$withPermit$iv4 = this.$semaphore;
                function1 = this.$task;
                this.L$0 = $this$withPermit$iv4;
                this.L$1 = function1;
                this.label = 1;
                if ($this$withPermit$iv4.acquire((Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $this$withPermit$iv = $this$withPermit$iv4;
                $this$withPermit$iv2 = null;
                try {
                    this.L$0 = $this$withPermit$iv;
                    this.L$1 = null;
                    this.label = 2;
                    if (function1.invoke(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $this$withPermit$iv3 = $this$withPermit$iv;
                    Unit unit = Unit.INSTANCE;
                    $this$withPermit$iv3.release();
                    return Unit.INSTANCE;
                } catch (Exception e2) {
                    $this$withPermit$iv3 = $this$withPermit$iv;
                    e = e2;
                    Log.INSTANCE.e("runLimitedAsync", "Task failed: " + e.getMessage());
                } catch (Throwable th2) {
                    th = th2;
                    $this$withPermit$iv3 = $this$withPermit$iv;
                    $this$withPermit$iv3.release();
                    throw th;
                }
                break;
            case 1:
                $this$withPermit$iv2 = null;
                function1 = (Function1) this.L$1;
                $this$withPermit$iv = (Semaphore) this.L$0;
                ResultKt.throwOnFailure($result);
                this.L$0 = $this$withPermit$iv;
                this.L$1 = null;
                this.label = 2;
                if (function1.invoke(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $this$withPermit$iv3 = $this$withPermit$iv;
                Unit unit2 = Unit.INSTANCE;
                $this$withPermit$iv3.release();
                return Unit.INSTANCE;
            case 2:
                $this$withPermit$iv3 = (Semaphore) this.L$0;
                try {
                    try {
                        ResultKt.throwOnFailure($result);
                        break;
                    } catch (Exception e3) {
                        e = e3;
                        Log.INSTANCE.e("runLimitedAsync", "Task failed: " + e.getMessage());
                    }
                    Unit unit3 = Unit.INSTANCE;
                    $this$withPermit$iv3.release();
                    return Unit.INSTANCE;
                } catch (Throwable th3) {
                    th = th3;
                    $this$withPermit$iv3.release();
                    throw th;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
