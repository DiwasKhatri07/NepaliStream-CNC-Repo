package com.phisher98;

import com.lagradost.api.Log;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Semaphore;

/* JADX INFO: Add missing generic type declarations: [B] */
/* JADX INFO: compiled from: StreamPlayUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "B", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 176)
@DebugMetadata(c = "com.phisher98.StreamPlayUtilsKt$safeAmap$2$1$1$1", f = "StreamPlayUtils.kt", i = {0, 1}, l = {2266, 1891}, m = "invokeSuspend", n = {"$this$withPermit$iv", "$this$withPermit$iv"}, nl = {2267, 1892}, s = {"L$0", "L$0"}, v = 2)
@SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreKt\n*L\n1#1,2265:1\n81#2,6:2266\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n*L\n1889#1:2266,6\n*E\n"})
public final class StreamPlayUtilsKt$safeAmap$2$1$1$1<B> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super B>, Object> {

    /* JADX INFO: renamed from: $f */
    final /* synthetic */ Function2<A, Continuation<? super B>, Object> f51$f;
    final /* synthetic */ A $item;
    final /* synthetic */ Semaphore $semaphore;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StreamPlayUtilsKt$safeAmap$2$1$1$1(Semaphore semaphore, Function2<? super A, ? super Continuation<? super B>, ? extends Object> function2, A a, Continuation<? super StreamPlayUtilsKt$safeAmap$2$1$1$1> continuation) {
        super(2, continuation);
        this.$semaphore = semaphore;
        this.f51$f = function2;
        this.$item = a;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StreamPlayUtilsKt$safeAmap$2$1$1$1<>(this.$semaphore, this.f51$f, this.$item, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super B> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0065 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:22:0x0066  */
    public final Object invokeSuspend(Object $result) throws Throwable {
        Function2 function2;
        Object obj;
        Semaphore $this$withPermit$iv;
        Semaphore $this$withPermit$iv2;
        Throwable th;
        Semaphore $this$withPermit$iv3;
        Exception e;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        Object objInvoke = null;
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Semaphore $this$withPermit$iv4 = this.$semaphore;
                function2 = this.f51$f;
                obj = this.$item;
                this.L$0 = $this$withPermit$iv4;
                this.L$1 = function2;
                this.L$2 = obj;
                this.label = 1;
                if ($this$withPermit$iv4.acquire((Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $this$withPermit$iv = $this$withPermit$iv4;
                $this$withPermit$iv2 = null;
                try {
                    this.L$0 = $this$withPermit$iv;
                    this.L$1 = obj;
                    this.L$2 = null;
                    this.label = 2;
                    objInvoke = function2.invoke(obj, this);
                    if (objInvoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $this$withPermit$iv3 = $this$withPermit$iv;
                    $this$withPermit$iv3.release();
                    return objInvoke;
                } catch (Exception e2) {
                    $this$withPermit$iv3 = $this$withPermit$iv;
                    e = e2;
                    Log.INSTANCE.e("safeMap", "Request failed for " + obj + ' ' + e);
                } catch (Throwable th2) {
                    th = th2;
                    $this$withPermit$iv3 = $this$withPermit$iv;
                    $this$withPermit$iv3.release();
                    throw th;
                }
                break;
                break;
            case 1:
                $this$withPermit$iv2 = null;
                obj = this.L$2;
                function2 = (Function2) this.L$1;
                $this$withPermit$iv = (Semaphore) this.L$0;
                ResultKt.throwOnFailure($result);
                this.L$0 = $this$withPermit$iv;
                this.L$1 = obj;
                this.L$2 = null;
                this.label = 2;
                objInvoke = function2.invoke(obj, this);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $this$withPermit$iv3 = $this$withPermit$iv;
                $this$withPermit$iv3.release();
                return objInvoke;
            case 2:
                obj = this.L$1;
                $this$withPermit$iv3 = (Semaphore) this.L$0;
                try {
                    try {
                        ResultKt.throwOnFailure($result);
                        objInvoke = $result;
                    } catch (Exception e3) {
                        e = e3;
                        Log.INSTANCE.e("safeMap", "Request failed for " + obj + ' ' + e);
                        break;
                    }
                    $this$withPermit$iv3.release();
                    return objInvoke;
                } catch (Throwable th3) {
                    th = th3;
                    $this$withPermit$iv3.release();
                    throw th;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object invokeSuspend$$forInline(Object $result) {
        Semaphore $this$withPermit$iv = this.$semaphore;
        Function2<A, Continuation<? super B>, Object> function2 = this.f51$f;
        Object obj = this.$item;
        $this$withPermit$iv.acquire((Continuation) this);
        Object objInvoke = null;
        try {
            try {
                objInvoke = function2.invoke(obj, (Object) null);
            } catch (Exception e) {
                Log.INSTANCE.e("safeMap", "Request failed for " + obj + ' ' + e);
            }
            return objInvoke;
        } finally {
            $this$withPermit$iv.release();
        }
    }
}
