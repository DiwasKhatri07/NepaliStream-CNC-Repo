package com.cncverse;

import com.lagradost.cloudstream3.utils.ExtractorLink;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: MoviezwapProvider.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/MoviezwapProvider/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.cncverse.MoviezwapProvider$loadLinks$3$1", f = "MoviezwapProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
final class MoviezwapProvider$loadLinks$3$1 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $quality;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MoviezwapProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MoviezwapProvider$loadLinks$3$1(int i, MoviezwapProvider moviezwapProvider, Continuation<? super MoviezwapProvider$loadLinks$3$1> continuation) {
        super(2, continuation);
        this.$quality = i;
        this.this$0 = moviezwapProvider;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> moviezwapProvider$loadLinks$3$1 = new MoviezwapProvider$loadLinks$3$1(this.$quality, this.this$0, continuation);
        moviezwapProvider$loadLinks$3$1.L$0 = obj;
        return moviezwapProvider$loadLinks$3$1;
    }

    public final Object invoke(ExtractorLink extractorLink, Continuation<? super Unit> continuation) {
        return create(extractorLink, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        ExtractorLink $this$newExtractorLink = (ExtractorLink) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                $this$newExtractorLink.setQuality(this.$quality);
                $this$newExtractorLink.setReferer(this.this$0.getMainUrl());
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
