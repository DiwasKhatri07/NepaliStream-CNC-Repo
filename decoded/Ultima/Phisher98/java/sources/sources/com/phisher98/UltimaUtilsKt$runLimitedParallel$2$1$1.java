package com.phisher98;

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

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: UltimaUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Ultima/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.UltimaUtilsKt$runLimitedParallel$2$1$1", f = "UltimaUtils.kt", i = {0, 1}, l = {230, 185}, m = "invokeSuspend", n = {"$this$withPermit$iv", "$this$withPermit$iv"}, nl = {231, 232}, s = {"L$0", "L$0"}, v = 2)
@SourceDebugExtension({"SMAP\nUltimaUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UltimaUtils.kt\ncom/phisher98/UltimaUtilsKt$runLimitedParallel$2$1$1\n+ 2 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreKt\n*L\n1#1,229:1\n81#2,6:230\n*S KotlinDebug\n*F\n+ 1 UltimaUtils.kt\ncom/phisher98/UltimaUtilsKt$runLimitedParallel$2$1$1\n*L\n185#1:230,6\n*E\n"})
final class UltimaUtilsKt$runLimitedParallel$2$1$1<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
    final /* synthetic */ Function1<Continuation<? super T>, Object> $block;
    final /* synthetic */ Semaphore $semaphore;
    Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UltimaUtilsKt$runLimitedParallel$2$1$1(Semaphore semaphore, Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super UltimaUtilsKt$runLimitedParallel$2$1$1> continuation) {
        super(2, continuation);
        this.$semaphore = semaphore;
        this.$block = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UltimaUtilsKt$runLimitedParallel$2$1$1<>(this.$semaphore, this.$block, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0058 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x0059  */
    public final Object invokeSuspend(Object $result) throws Throwable {
        Function1<Continuation<? super T>, Object> function1;
        Semaphore $this$withPermit$iv;
        Semaphore $this$withPermit$iv2;
        Throwable th;
        Semaphore $this$withPermit$iv3;
        Object objInvoke;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Semaphore $this$withPermit$iv4 = this.$semaphore;
                function1 = this.$block;
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
                    objInvoke = function1.invoke(this);
                    if (objInvoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $this$withPermit$iv.release();
                    return objInvoke;
                } catch (Throwable th2) {
                    th = th2;
                    $this$withPermit$iv3 = $this$withPermit$iv;
                    $this$withPermit$iv3.release();
                    throw th;
                }
            case 1:
                $this$withPermit$iv2 = null;
                function1 = (Function1) this.L$1;
                $this$withPermit$iv = (Semaphore) this.L$0;
                ResultKt.throwOnFailure($result);
                this.L$0 = $this$withPermit$iv;
                this.L$1 = null;
                this.label = 2;
                objInvoke = function1.invoke(this);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $this$withPermit$iv.release();
                return objInvoke;
            case 2:
                $this$withPermit$iv3 = (Semaphore) this.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    $this$withPermit$iv = $this$withPermit$iv3;
                    objInvoke = $result;
                    $this$withPermit$iv.release();
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
}
