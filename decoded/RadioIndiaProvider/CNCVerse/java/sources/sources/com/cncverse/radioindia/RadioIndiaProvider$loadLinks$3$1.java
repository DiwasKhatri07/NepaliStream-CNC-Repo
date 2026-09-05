package com.cncverse.radioindia;

import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.Qualities;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: RadioIndiaProvider.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/RadioIndiaProvider/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.cncverse.radioindia.RadioIndiaProvider$loadLinks$3$1", f = "RadioIndiaProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
final class RadioIndiaProvider$loadLinks$3$1 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ RadioIndiaProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RadioIndiaProvider$loadLinks$3$1(RadioIndiaProvider radioIndiaProvider, Continuation<? super RadioIndiaProvider$loadLinks$3$1> continuation) {
        super(2, continuation);
        this.this$0 = radioIndiaProvider;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> radioIndiaProvider$loadLinks$3$1 = new RadioIndiaProvider$loadLinks$3$1(this.this$0, continuation);
        radioIndiaProvider$loadLinks$3$1.L$0 = obj;
        return radioIndiaProvider$loadLinks$3$1;
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
                $this$newExtractorLink.setReferer(this.this$0.getMainUrl());
                $this$newExtractorLink.setQuality(Qualities.Unknown.getValue());
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
