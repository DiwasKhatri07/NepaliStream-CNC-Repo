package com.phisher98;

import com.lagradost.cloudstream3.utils.ExtractorLink;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: StreamPlayExtractor.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokePeachify$2$2", f = "StreamPlayExtractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
final class StreamPlayExtractor$invokePeachify$2$2 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $finalOrigin;
    final /* synthetic */ String $finalReferer;
    final /* synthetic */ String $finalUA;
    final /* synthetic */ int $quality;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreamPlayExtractor$invokePeachify$2$2(String str, String str2, String str3, int i, Continuation<? super StreamPlayExtractor$invokePeachify$2$2> continuation) {
        super(2, continuation);
        this.$finalOrigin = str;
        this.$finalReferer = str2;
        this.$finalUA = str3;
        this.$quality = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> streamPlayExtractor$invokePeachify$2$2 = new StreamPlayExtractor$invokePeachify$2$2(this.$finalOrigin, this.$finalReferer, this.$finalUA, this.$quality, continuation);
        streamPlayExtractor$invokePeachify$2$2.L$0 = obj;
        return streamPlayExtractor$invokePeachify$2$2;
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
                $this$newExtractorLink.setHeaders(MapsKt.mapOf(new Pair[]{TuplesKt.to("Origin", this.$finalOrigin), TuplesKt.to("Referer", this.$finalReferer), TuplesKt.to("User-Agent", this.$finalUA)}));
                $this$newExtractorLink.setQuality(this.$quality);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
