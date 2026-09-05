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
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: compiled from: UltimaPlugin.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Ultima/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.UltimaPlugin$startSseListener$1$1$onResponse$3", f = "UltimaPlugin.kt", i = {}, l = {513}, m = "invokeSuspend", n = {}, nl = {514}, s = {}, v = 2)
final class UltimaPlugin$startSseListener$1$1$onResponse$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $appContext;
    final /* synthetic */ long $backoffMs;
    int label;
    final /* synthetic */ UltimaPlugin this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UltimaPlugin$startSseListener$1$1$onResponse$3(long j, UltimaPlugin ultimaPlugin, Context context, Continuation<? super UltimaPlugin$startSseListener$1$1$onResponse$3> continuation) {
        super(2, continuation);
        this.$backoffMs = j;
        this.this$0 = ultimaPlugin;
        this.$appContext = context;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UltimaPlugin$startSseListener$1$1$onResponse$3(this.$backoffMs, this.this$0, this.$appContext, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Duration.Companion companion = Duration.Companion;
                this.label = 1;
                if (DelayKt.delay-VtjQ1oo(DurationKt.toDuration(this.$backoffMs, DurationUnit.MILLISECONDS), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        UltimaPlugin.startSseListener$default(this.this$0, this.$appContext, false, 2, null);
        return Unit.INSTANCE;
    }
}
