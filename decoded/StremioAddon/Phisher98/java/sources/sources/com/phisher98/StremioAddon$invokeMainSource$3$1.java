package com.phisher98;

import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: StremioAddon.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StremioAddon/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "stream", "Lcom/phisher98/StremioAddon$Stream;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StremioAddon$invokeMainSource$3$1", f = "StremioAddon.kt", i = {0}, l = {305}, m = "invokeSuspend", n = {"stream"}, nl = {306}, s = {"L$0"}, v = 2)
final class StremioAddon$invokeMainSource$3$1 extends SuspendLambda implements Function2<StremioAddon.Stream, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
    final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StremioAddon$invokeMainSource$3$1(Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super StremioAddon$invokeMainSource$3$1> continuation) {
        super(2, continuation);
        this.$subtitleCallback = function1;
        this.$callback = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> stremioAddon$invokeMainSource$3$1 = new StremioAddon$invokeMainSource$3$1(this.$subtitleCallback, this.$callback, continuation);
        stremioAddon$invokeMainSource$3$1.L$0 = obj;
        return stremioAddon$invokeMainSource$3$1;
    }

    public final Object invoke(StremioAddon.Stream stream, Continuation<? super Unit> continuation) {
        return create(stream, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        StremioAddon.Stream stream = (StremioAddon.Stream) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.L$0 = SpillingKt.nullOutSpilledVariable(stream);
                this.label = 1;
                if (stream.runCallback(this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
