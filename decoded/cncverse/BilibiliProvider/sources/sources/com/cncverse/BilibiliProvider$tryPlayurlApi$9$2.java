package com.cncverse;

import com.lagradost.cloudstream3.AudioFile;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: BilibiliProvider.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/BilibiliProvider/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.cncverse.BilibiliProvider$tryPlayurlApi$9$2", f = "BilibiliProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
final class BilibiliProvider$tryPlayurlApi$9$2 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<AudioFile> $altAudioTracks;
    final /* synthetic */ Map<String, String> $altStreamHeaders;
    final /* synthetic */ int $qualityValue;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BilibiliProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BilibiliProvider$tryPlayurlApi$9$2(int i, BilibiliProvider bilibiliProvider, Map<String, String> map, List<AudioFile> list, Continuation<? super BilibiliProvider$tryPlayurlApi$9$2> continuation) {
        super(2, continuation);
        this.$qualityValue = i;
        this.this$0 = bilibiliProvider;
        this.$altStreamHeaders = map;
        this.$altAudioTracks = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> bilibiliProvider$tryPlayurlApi$9$2 = new BilibiliProvider$tryPlayurlApi$9$2(this.$qualityValue, this.this$0, this.$altStreamHeaders, this.$altAudioTracks, continuation);
        bilibiliProvider$tryPlayurlApi$9$2.L$0 = obj;
        return bilibiliProvider$tryPlayurlApi$9$2;
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
                $this$newExtractorLink.setQuality(this.$qualityValue);
                $this$newExtractorLink.setReferer(this.this$0.getMainUrl());
                $this$newExtractorLink.setHeaders(this.$altStreamHeaders);
                $this$newExtractorLink.setAudioTracks(this.$altAudioTracks);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
