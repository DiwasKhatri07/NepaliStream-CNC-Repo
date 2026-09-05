package com.phisher98;

import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.Qualities;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: compiled from: StreamPlayExtractor.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeAnimex$2$1$3", f = "StreamPlayExtractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
@SourceDebugExtension({"SMAP\nStreamPlayExtractor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor$invokeAnimex$2$1$3\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,6034:1\n1#2:6035\n*E\n"})
final class StreamPlayExtractor$invokeAnimex$2$1$3 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $referer;
    final /* synthetic */ StreamPlayExtractor.VideoSource $source;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreamPlayExtractor$invokeAnimex$2$1$3(String str, StreamPlayExtractor.VideoSource videoSource, Continuation<? super StreamPlayExtractor$invokeAnimex$2$1$3> continuation) {
        super(2, continuation);
        this.$referer = str;
        this.$source = videoSource;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> streamPlayExtractor$invokeAnimex$2$1$3 = new StreamPlayExtractor$invokeAnimex$2$1$3(this.$referer, this.$source, continuation);
        streamPlayExtractor$invokeAnimex$2$1$3.L$0 = obj;
        return streamPlayExtractor$invokeAnimex$2$1$3;
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
                $this$newExtractorLink.setReferer(this.$referer);
                Integer numBoxInt = Boxing.boxInt(ExtractorApiKt.getQualityFromName(this.$source.getQuality()));
                int it = numBoxInt.intValue();
                if (!(it != Qualities.Unknown.getValue())) {
                    numBoxInt = null;
                }
                $this$newExtractorLink.setQuality(numBoxInt != null ? numBoxInt.intValue() : Qualities.P1080.getValue());
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
