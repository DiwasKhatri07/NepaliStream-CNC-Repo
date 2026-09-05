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

/* JADX INFO: compiled from: DoFlixProvider.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/DoFlixProvider/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.cncverse.DoFlixProvider$loadLinks$4$1", f = "DoFlixProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
final class DoFlixProvider$loadLinks$4$1 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
    final /* synthetic */ DoFlixProvider.StreamLink $link;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DoFlixProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DoFlixProvider$loadLinks$4$1(DoFlixProvider doFlixProvider, DoFlixProvider.StreamLink streamLink, Continuation<? super DoFlixProvider$loadLinks$4$1> continuation) {
        super(2, continuation);
        this.this$0 = doFlixProvider;
        this.$link = streamLink;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> doFlixProvider$loadLinks$4$1 = new DoFlixProvider$loadLinks$4$1(this.this$0, this.$link, continuation);
        doFlixProvider$loadLinks$4$1.L$0 = obj;
        return doFlixProvider$loadLinks$4$1;
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
                $this$newExtractorLink.setReferer("https://molop.art/");
                $this$newExtractorLink.setQuality(this.this$0.getQualityValue(this.$link.getQuality()));
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
