package com.phisher98;

import android.content.Context;
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
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: compiled from: UltimaPlugin.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Ultima/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.UltimaPlugin$scheduleDebouncedPush$runnable$1$1", f = "UltimaPlugin.kt", i = {0, 1}, l = {871, 112}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, nl = {872, 113}, s = {"L$0", "L$0"}, v = 2)
@SourceDebugExtension({"SMAP\nUltimaPlugin.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UltimaPlugin.kt\ncom/phisher98/UltimaPlugin$scheduleDebouncedPush$runnable$1$1\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n*L\n1#1,866:1\n117#2,10:867\n*S KotlinDebug\n*F\n+ 1 UltimaPlugin.kt\ncom/phisher98/UltimaPlugin$scheduleDebouncedPush$runnable$1$1\n*L\n111#1:867,10\n*E\n"})
final class UltimaPlugin$scheduleDebouncedPush$runnable$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $ctx;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ UltimaPlugin this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UltimaPlugin$scheduleDebouncedPush$runnable$1$1(UltimaPlugin ultimaPlugin, Context context, Continuation<? super UltimaPlugin$scheduleDebouncedPush$runnable$1$1> continuation) {
        super(2, continuation);
        this.this$0 = ultimaPlugin;
        this.$ctx = context;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UltimaPlugin$scheduleDebouncedPush$runnable$1$1(this.this$0, this.$ctx, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0067 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x0068  */
    public final Object invokeSuspend(Object $result) throws Throwable {
        UltimaPlugin ultimaPlugin;
        Context context;
        Object owner$iv;
        Mutex $this$withLock_u24default$iv;
        Mutex $this$withLock_u24default$iv2;
        Throwable th;
        Object owner$iv2;
        Mutex $this$withLock_u24default$iv3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Mutex $this$withLock_u24default$iv4 = this.this$0.syncMutex;
                ultimaPlugin = this.this$0;
                context = this.$ctx;
                owner$iv = null;
                this.L$0 = $this$withLock_u24default$iv4;
                this.L$1 = ultimaPlugin;
                this.L$2 = context;
                this.label = 1;
                if ($this$withLock_u24default$iv4.lock((Object) null, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $this$withLock_u24default$iv = $this$withLock_u24default$iv4;
                $this$withLock_u24default$iv2 = null;
                try {
                    this.L$0 = $this$withLock_u24default$iv;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.label = 2;
                    if (ultimaPlugin.mergeAndSyncAllCategories(context, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    owner$iv2 = owner$iv;
                    $this$withLock_u24default$iv3 = $this$withLock_u24default$iv;
                    Unit unit = Unit.INSTANCE;
                    $this$withLock_u24default$iv3.unlock(owner$iv2);
                    return Unit.INSTANCE;
                } catch (Throwable th2) {
                    th = th2;
                    owner$iv2 = owner$iv;
                    $this$withLock_u24default$iv3 = $this$withLock_u24default$iv;
                    $this$withLock_u24default$iv3.unlock(owner$iv2);
                    throw th;
                }
            case 1:
                $this$withLock_u24default$iv2 = null;
                context = (Context) this.L$2;
                ultimaPlugin = (UltimaPlugin) this.L$1;
                owner$iv = null;
                $this$withLock_u24default$iv = (Mutex) this.L$0;
                ResultKt.throwOnFailure($result);
                this.L$0 = $this$withLock_u24default$iv;
                this.L$1 = null;
                this.L$2 = null;
                this.label = 2;
                if (ultimaPlugin.mergeAndSyncAllCategories(context, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                owner$iv2 = owner$iv;
                $this$withLock_u24default$iv3 = $this$withLock_u24default$iv;
                Unit unit2 = Unit.INSTANCE;
                $this$withLock_u24default$iv3.unlock(owner$iv2);
                return Unit.INSTANCE;
            case 2:
                owner$iv2 = null;
                $this$withLock_u24default$iv3 = (Mutex) this.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    Unit unit3 = Unit.INSTANCE;
                    $this$withLock_u24default$iv3.unlock(owner$iv2);
                    return Unit.INSTANCE;
                } catch (Throwable th3) {
                    th = th3;
                    $this$withLock_u24default$iv3.unlock(owner$iv2);
                    throw th;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
